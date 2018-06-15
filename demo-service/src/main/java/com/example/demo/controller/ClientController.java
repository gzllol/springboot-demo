package com.example.demo.controller;

import com.example.demo.client.TestClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2018/5/4
 * Time: 上午10:16
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class ClientController {

    protected final static Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    TestClient testClient;

    @RequestMapping("/test")
    String test() {
        try {
            String result = testClient.test();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("", e);
        }
        return "";
    }


    public static String md5(String input)
    {
        if (StringUtils.isEmpty(input))
        {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes());
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            logger.error("error", e);
        }
        return "";
    }

    public static void main(String[] args) {
        String tk = "83694FA6FB93F51CE283498B5778C67D166D3B5926D1999DCC58C15F1E713C71B3D26E100BE3BFF93D18572FB0B875B2C0D7CC5AB7CCC8B02FAAAF4FB851DC9C|2ECD50728F2158C0D877E5F940D25BE864721B89F9B95FBF35C7EA4C41BDB2F59B68D3D580116B17C7E9B07ED9E8986F";
        String input = "uid=230821570623&tk=" + tk + "&123456789";
        System.out.println(md5(input));

    }

}
