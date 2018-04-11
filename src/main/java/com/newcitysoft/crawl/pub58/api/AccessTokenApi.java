/**
 * Copyright (c) 2011-2014, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.newcitysoft.crawl.pub58.api;

import com.jfinal.kit.PropKit;
import com.newcitysoft.crawl.pub58.util.HttpClientUtil;
import com.newcitysoft.crawl.pub58.util.MD5Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 认证并获取 access_token API
 * http://mp.weixin.qq.com/wiki/index.php?title=%E8%8E%B7%E5%8F%96access_token
 *
 * AccessToken默认存储于内存中，可设置存储于redis或者实现IAccessTokenCache到数据库中实现分布式可用
 *
 * 具体配置：
 * <pre>
 * ApiConfigKit.setAccessTokenCache(new RedisAccessTokenCache());
 * </pre>
 */
public class AccessTokenApi {
//    http://openapi.58.com/oauth2/authorize?client_id=54780546737665&redirect_uri=http://140.143.210.205/auth&response_type=code

    private static String accessTokenUrl = "http://openapi.58.com/oauth2/access_token";

    public static ApiResult getAccessToken(String code) throws Exception {

        Map<String, String> dataMap = ApiConfigKit.postUrlBase();
        dataMap.put("code", code);
        dataMap.put("grant_type", "authorization_code");

        String jsonResult = HttpClientUtil.doPost(accessTokenUrl, dataMap);
        return new ApiResult(jsonResult);
    }


    private static final String refreshTokenUrl = "http://openapi.58.com/oauth2/refresh_token";

    public static ApiResult refreshToken(String accessToken, String refreshToken, String userId) throws Exception {
        Map<String, String> dataMap = ApiConfigKit.postUrlBase();

        dataMap.put("access_token", accessToken);
        dataMap.put("refresh_token", refreshToken);
        dataMap.put("grant_type", "refresh_token");
        dataMap.put("58user_id", userId);

        String jsonResult = HttpClientUtil.doPost(refreshTokenUrl, dataMap);
        return new ApiResult(jsonResult);
    }

    public static void main(String[] args) throws Exception {
        ApiResult apiResult = getAccessToken("58d850583bb7cc08acfcc15c2bd57");
        System.out.println(apiResult.getJson());

        TimeUnit.SECONDS.sleep(10);
        ApiResult apiResult1 = refreshToken(apiResult.get("access_token"), apiResult.get("refresh_token"), apiResult.get("uid"));
        System.out.println(apiResult1.getJson());
    }
}