package com.newcitysoft.crawl.pub58.api;

import com.jfinal.kit.PropKit;
import com.newcitysoft.crawl.pub58.util.MD5Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/11 18:49
 */
public class ApiConfigKit {
    public static Map<String, String> postBase() {
        Map<String, String> dataMap = new HashMap<>();
        PropKit.use("config.properties");
        String timeSign = String.valueOf(System.currentTimeMillis());
        dataMap.put("time_sign", timeSign);
        dataMap.put("client_id", String.valueOf(PropKit.getLong("client_id")));
        dataMap.put("client_secret", MD5Utils.md5(PropKit.get("client_secret") + "openapi.58.com" + timeSign));

        return dataMap;
    }

    public static Map<String, String> postUrlBase() {
        Map<String, String> dataMap = postBase();
        dataMap.put("redirect_uri", PropKit.get("redirect_uri"));
        return dataMap;
    }

}
