package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		try {
			String result = post("http://127.0.0.1:8080/hello", "5412", false);
			System.out.println("result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String post(String url, String post_str, boolean isProxy) throws Exception {
		HttpURLConnection urlCon = null;
		OutputStream out = null;
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();

		try {
			URL url1 = new URL((URL)null, url);
			if(isProxy) {
				InetSocketAddress line = new InetSocketAddress("127.0.0.1", 8080);
				Proxy proxy = new Proxy(Proxy.Type.HTTP, line);
				urlCon = (HttpURLConnection)url1.openConnection(proxy);
			} else {
				urlCon = (HttpURLConnection)url1.openConnection();
			}

			urlCon.setConnectTimeout(1000);
			urlCon.setReadTimeout(1000);
			urlCon.setDoInput(true);
			urlCon.setDoOutput(true);
			urlCon.setRequestMethod("GET");
			urlCon.setRequestProperty("Content-Length", String.valueOf(post_str.getBytes().length));
			urlCon.setUseCaches(false);
			out = urlCon.getOutputStream();
			out.write(post_str.getBytes("UTF-8"));
			out.flush();
			urlCon.getOutputStream().close();
			in = new BufferedReader(new InputStreamReader(urlCon.getInputStream(), "utf-8"));

			String line1;
			while((line1 = in.readLine()) != null) {
				sb.append(line1);
			}
		} finally {
			if(out != null) {
				out.close();
			}

			if(in != null) {
				in.close();
			}

			if(urlCon != null) {
				urlCon.disconnect();
			}

		}

		return sb.toString();
	}


	@Test
	public void test2() {


	}


}
