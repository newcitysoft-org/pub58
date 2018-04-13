package com.renren.pub58.api.serviceImpl;

import com.google.gson.Gson;
import com.renren.pub58.api.constant.Constants;
import com.renren.pub58.api.pojo.Token;
import com.renren.pub58.api.service.AuthorizeService;
import com.renren.pub58.api.util.CommonRequest;
import com.renren.pub58.api.util.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @ClassName: AuthorizeImpl
 * @Description: TODO
 * @author: helong
 * @date: 2016年3月15日 下午5:20:59
 */
public class AuthorizeImpl implements AuthorizeService {

	/**
	 * 获取临时授权令牌
	 * 有可能是null或者空 ""
	 *
	 * @see AuthorizeService#getTempToken()
	 * @return
	 */
	@Override
	public String getTempToken() {

		String uri = "authorize?client_id=" + Constants.CLIENT_ID + "&redirect_uri=" + Constants.REDIRECT_URI + "auto&response_type=code";

		String request4Redirect = CommonRequest.request4Redirect(uri, null, HttpMethod.GET, String.class);

		if (request4Redirect != null) {
			return StringUtil.getUrlParamByParamName(request4Redirect, "code");
		}

		return null;
	}

	/**
	 * 获取授权用户的信息 第一次获取token的时候
	 * @see com.renren.pub58.api.service.AuthorizeService#getToken(String)
	 * @param code
	 * @return
	 */
	@Override
	public Token getToken(String code) {

		String uri = "access_token";

		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();
		mvm.add("code", code);
		mvm.add("grant_type", "authorization_code");
		mvm.add("redirect_uri", Constants.REDIRECT_URI);
		mvm.add("time_sign", String.valueOf(System.currentTimeMillis()));
		mvm.add("client_id", String.valueOf(Constants.CLIENT_ID));
		mvm.add("client_secret", Constants.getClientSecretMD5());

		String response = (String) CommonRequest.request(uri, null, mvm, HttpMethod.POST, String.class);
		Gson gson = new Gson();
		Token token = gson.fromJson(response, Token.class);

		return token;
	}

	/**
	 * 刷新token
	 * @see com.renren.pub58.api.service.AuthorizeService#refreshToken(Token)
	 * @param token
	 * @return
	 */
	@Override
	public Token refreshToken(Token token) {

		String uri = "refresh_token";

		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();
		mvm.add("access_token", token.getAccess_token());
		mvm.add("refresh_token", token.getRefresh_token());
		mvm.add("grant_type", "refresh_token");
		mvm.add("redirect_uri", Constants.REDIRECT_URI);

		String time_sign = String.valueOf(System.currentTimeMillis());

		mvm.add("time_sign", time_sign);
		mvm.add("client_id", String.valueOf(Constants.CLIENT_ID));
		mvm.add("client_secret", DigestUtils.md5Hex(Constants.CLIENT_SECRET + "openapi.58.com" + time_sign));
		mvm.add("58user_id", token.getUid());

		String response = (String) CommonRequest.request(uri, null, mvm, HttpMethod.POST, String.class);
		Gson gson = new Gson();
		Token refreshToken = gson.fromJson(response, Token.class);
		
		return refreshToken;

	}

	// 13469612888
	// Sj13469612888
	// 某车上token 银川
	// Token{userName='null', password='null', uid='19475933152263', expires_in='364', refresh_token='5876228671f0d56664de508fe25592d1_v1', access_token='ac25d95fba39b21af1a9e26cf4324ca_v1'}

	public static void main(String[] args) {
		AuthorizeService authorizeService = new AuthorizeImpl();
//		System.out.println(authorizeService.getTempToken());
		System.out.println(authorizeService.getToken("d146b6cd3977ddd555898c632a99d37"));


//		Token token = new Token();
//		token.setUserName("15841694657");
//		token.setPassword("axin19930930");
//		token.setUid("52147071000845");
//		token.setRefresh_token("294f8f4ef27ad5254fdffaa411331f4_v1");
//		token.setAccess_token("e19acffddaec63aac6748714be663ef_v1");
//		token.setExpires_in("364");

//		System.out.println(authorizeService.refreshToken(token).toString());

	}
}
