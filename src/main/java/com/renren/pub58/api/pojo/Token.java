/**   
 * 
 * @Title: token.java 
 * @Project: 58gateway-parent
 * @Package: com.zuche.gateway.pojo 
 * @Description: TODO
 * @date: 2016年3月15日 下午7:15:00 
 * @version: V1.0   
 */
package com.renren.pub58.api.pojo;

/**
 * @ClassName: token
 * @Description: TODO
 * @author: helong
 * @date: 2016年3月15日 下午7:15:00
 */
public class Token {

	/* 账户 */
	private String userName;

	/* 密码 */
	private String password;

	/* 58账户ID */
	private String uid;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* AccessToken有效期天数 */
	private String expires_in;

	/* 刷新令牌 */
	private String refresh_token;

	/* 访问令牌 */
	private String access_token;

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the expires_in
	 */
	public String getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in
	 *            the expires_in to set
	 */
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * @return the refresh_token
	 */
	public String getRefresh_token() {
		return refresh_token;
	}

	/**
	 * @param refresh_token
	 *            the refresh_token to set
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	/**
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @param access_token
	 *            the access_token to set
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	@Override
	public String toString() {
		return "Token{" +
				"userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", uid='" + uid + '\'' +
				", expires_in='" + expires_in + '\'' +
				", refresh_token='" + refresh_token + '\'' +
				", access_token='" + access_token + '\'' +
				'}';
	}
}
