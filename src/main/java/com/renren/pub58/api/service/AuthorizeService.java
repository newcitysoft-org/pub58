/**   
 * 
 * @Title: Authorize.java 
 * @Project: 58gateway-parent
 * @Package: com.zuche.gateway.service 
 * @Description: TODO
 * @date: 2016年3月15日 下午1:32:54 
 * @version: V1.0   
 */
package com.renren.pub58.api.service;


import com.renren.pub58.api.pojo.Token;

/**
 * @ClassName: Authorize
 * @Description: 授权接口
 * @author: helong
 * @date: 2016年3月15日 下午1:32:54
 */
public interface AuthorizeService {

	/**
	 *
	 * @Title: getTempToken
	 * @Description: 获取临时授权令牌
	 * @return: String
	 */
	public String getTempToken();

	/**
	 * 
	 * @Title: getToken 
	 * @Description: 获取授权用户的信息
	 * @return
	 * @return: void
	 */
	public Token getToken(String code);
	
	/**
	 * 
	 * @Title: refreshToken 
	 * @Description: 刷新token
	 * @return: void
	 */
	public Token refreshToken(Token token); 

}
