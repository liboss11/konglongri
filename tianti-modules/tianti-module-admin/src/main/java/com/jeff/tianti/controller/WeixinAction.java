package com.jeff.tianti.controller;

import com.alibaba.fastjson.JSONObject;
import com.jeff.tianti.common.dto.AjaxResult;
import com.jeff.tianti.util.WeixinUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Random;

@RestController
@RequestMapping("/api/wx")
public class WeixinAction {
    private static final Logger logger = LoggerFactory.getLogger(WeixinAction.class);
    /* private static final String appId = "wx3b4f0106ccfcb235";
     private static final String secret = "ece4ec2cb026cc9270db7b39789b02ea";*/
    @Value("${wx.appId}")
    private String appId;
    @Value("${wx.secret}")
    private String secret;

    private static final long timeout = 7000 * 1000;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WeixinUtil weixinUtil;


    @RequestMapping("/config")
    public AjaxResult getWXConfigSignature(HttpServletRequest request, HttpServletResponse response,
                                           @RequestParam("url") String url) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        logger.info("原始URL: " + url);
        long timeStampSec = System.currentTimeMillis() / 1000;
        String timestamp = String.format("%010d", timeStampSec);
        String nonceStr = getRandomStr(8);
        String[] urls = url.split("#");
        String newUrl = urls[0];
        logger.info("随机串：" + nonceStr + ", 获取签名URL: " + newUrl);
        JSONObject respJson = new JSONObject();
        String[] signArr = new String[]{"url=" + newUrl, "jsapi_ticket=" + getWXJsapiTicket(), "noncestr=" + nonceStr, "timestamp=" + timestamp};
        Arrays.sort(signArr);
        String signStr = StringUtils.join(signArr, "&");
        String resSign = DigestUtils.sha1Hex(signStr);

        logger.info("返回的签名：" + resSign);
        respJson.put("appId", appId);
        respJson.put("timestamp", timestamp);
        respJson.put("nonceStr", nonceStr);
        respJson.put("signature", resSign);
        logger.info(respJson.toJSONString());
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(true);
        ajaxResult.setData(respJson);

        return ajaxResult;
    }

    private String getWXJsapiTicket() {
        String ticket = weixinUtil.getTicket();
        long ticketTime = weixinUtil.getTicketTime();

        if (StringUtils.isBlank(ticket) || (System.currentTimeMillis() - ticketTime) > timeout) {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + getWXaccessToken() + "&type=jsapi";
            String resp = restTemplate.getForObject(url, String.class);
            JSONObject resJson = JSONObject.parseObject(resp);
            logger.info("获取到ticket：" + resJson.getString("ticket"));
            weixinUtil.setTicket(resJson.getString("ticket"));
            weixinUtil.setTicketTime(System.currentTimeMillis());
            return resJson.getString("ticket");
        }
        return ticket;
    }

    private String getWXaccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + secret;
        String resp = restTemplate.getForObject(url, String.class);
        JSONObject resJson = JSONObject.parseObject(resp);
        logger.info("获取到access_token：" + resJson.getString("access_token"));
        return resJson.getString("access_token");
    }


    public static String getRandomStr(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int randomNum;
        char randomChar;
        Random random = new Random();
        // StringBuffer类型的可以append增加字符
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < length; i++) {
            // 可生成[0,n)之间的整数，获得随机位置
            randomNum = random.nextInt(base.length());
            // 获得随机位置对应的字符
            randomChar = base.charAt(randomNum);
            // 组成一个随机字符串
            str.append(randomChar);
        }
        return str.toString();
    }
}
