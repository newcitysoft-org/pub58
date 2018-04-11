package com.newcitysoft.crawl.pub58.api;

import java.util.Map;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/11 18:47
 */
public class PostServiceApi {

    private static final String sendUrl = "http://openapi.58.com/oauth2/gateway/postservice/send";

    public static ApiResult send(String cate_id, String local_id, String Title, String content, String phone, String email) {
        Map<String, String> dataMap = ApiConfigKit.postBase();

        return null;
    }
}
