/**   
 * 
 * @Title: Constant.java 
 * @Project: 58gateway-parent
 * @Package: com.zuche.gateway.constant 
 * @Description: 存放所有静态参数，如有需要可以提取出.properties配置文件。
 * @date: 2016年3月15日 上午11:31:12 
 * @version: V1.0   
 */
package com.renren.pub58.api.constant;

import org.apache.commons.codec.digest.DigestUtils;

public class Constants {

	/* 58 url 前缀 */
	public static String URI_PREFIX = "http://openapi.58.com/oauth2/";

	/* 58账户ID 每个业务接口在调用的时候都需要传递相应的用户ID，该ID在账号授权后返回，由合作伙伴保存 */
	// public static String USER_ID_58 = "";

	/** 每个合作伙伴与五八确立开放平台合作关系后，由五八内部人员为合作伙伴分配一个ID */
	public static long CLIENT_ID = 54780546737665L;

	/**
	 * 每个合作伙伴与五八确立开放平台合作关系后，由五八内部人员为合作伙伴分配一个密钥，该密钥不能在接口需要md5加密传输。加密方法为md5(
	 * client_secret + “openapi.58.com” + time_sign)
	 */
	public static String CLIENT_SECRET = "5KWeTbSKggUWNpCd7ILo";

	/* 每个业务接口在调用的时候都需要传递相应的用户授权码，该ID在账号授权后返回，由合作伙伴保存 */
	// public static String ACCESS_TOKEN = "";

	/* 刷新令牌 */
	// public static String REFRESH_TOKEN = "";

	/* AccessToken有效期天数 */
	// public static String EXPIRES_IN = "";

	/** 接入时约定授权回跳地址 */
	public static String REDIRECT_URI = "http://140.143.210.205/auth";

	/**
	 * @return the cLIENT_SECRET
	 */
	public static String getClientSecretMD5() {

		String input = CLIENT_SECRET + "openapi.58.com" + System.currentTimeMillis();
		String md5 = DigestUtils.md5Hex(input);
		System.out.println(md5);
		return md5;
	}

}
