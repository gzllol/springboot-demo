import com.google.gson.Gson;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2018/5/10
 * Time: 下午3:21
 * To change this template use File | Settings | File Templates.
 */
public class CalcTest {

    long ONE_DAY = 1000 * 3600 * 24;

    private List<String> recentPeroidList(String peroid, int count, int max) {
        if (peroid == null || peroid.length() != 12 || count < 0 || count > 200 || max < 0) {
            return Collections.EMPTY_LIST;
        }
        String dateStr = peroid.substring(0, 8);
        String indexStr = peroid.substring(8);
        int index = 0;
        try {
            index = Integer.parseInt(indexStr);
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
        int curIndex = index;
        List<String> result = new ArrayList<>(count);
        if (index > count) {
            int firstIndex = index - count;
            while (curIndex > firstIndex) {
                result.add(String.format("%s%04d", dateStr, curIndex--));
            }
        } else {
            while (curIndex > 0) {
                result.add(String.format("%s%04d", dateStr, curIndex--));
            }
            int firstIndex = max - count + index;
            String yesterdayStr = yesterdayStr(dateStr);
            curIndex = max;
            while (curIndex > firstIndex) {
                result.add(String.format("%s%04d", yesterdayStr, curIndex--));
            }
        }
        return result;
    }

    @Test
    public void test1() {
        String today = "20160301";
        System.out.println(yesterdayStr(today));
    }

    @Test
    public void test2() {
        Gson gson = new Gson();
        String peroid = "201805090003";
        System.out.println(gson.toJson(recentPeroidList(peroid, 10, 1600)));
    }

    private String yesterdayStr(String todayStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            Date today = sdf.parse(todayStr);
            today.setTime(today.getTime() - ONE_DAY);
            return sdf.format(today);
        } catch (ParseException e) {
            return "";
        }
    }


    @Test
    public void testIP() throws Exception {
        Gson gson = new Gson();
        System.out.println(gson.toJson(getLocalHostLANAddress()));
    }


    public Set<String> getLocalHostLANAddress() throws Exception {
        Set<String> result = new HashSet<>();
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            result.add(inetAddr.getHostAddress());
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                result.add(candidateAddress.getHostAddress());
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            result.add(jdkSuppliedAddress.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public void testToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long now = System.currentTimeMillis();
        System.out.println("now - " + sdf.format(new Date(now)));
        System.out.println("now - " + now);
        System.out.println("today - " + today(now));
    }

    public long today(long time)
    {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }


    @Test
    public void testDecode() {
        try {
            System.out.println(URLDecoder.decode(URLDecoder.decode("1232%257cabcfe", "utf-8"), "utf-8"));
        } catch (UnsupportedEncodingException e) {


        }
    }


    @Test
    public void testEncode() {
        try {
            System.out.println(URLEncoder.encode("1232%", "utf-8"));
        } catch (UnsupportedEncodingException e) {


        }
    }
}
