package com.newcitysoft.crawl.pub58.controller;

import com.jfinal.core.Controller;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/11 15:42
 */
public class AuthController extends Controller{
    public void index() {
        String code = getPara("code");
        renderJson(code);
    }
}
