/**   
 * 
 * @Title: CommonRequest.java 
 * @Project: 58gateway-parent
 * @Package: com.zuche.gateway.util 
 * @Description: TODO
 * @date: 2016年3月15日 下午1:54:43 
 * @version: V1.0   
 */
package com.renren.pub58.api.util;

import com.renren.pub58.api.constant.Constants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

public class CommonRequest {

	/**
	 * 
	 * @Title: request
	 * @Description: rest通用请求
	 * @param uri
	 * @param mediaType
	 *            如果有图片则,设置为MediaType.MULTIPART_FORM_DATA,否则设置为null
	 * @param mvm
	 *            post请求参数,get可以不写
	 * @param method
	 *            一般是get或post
	 * @param resType
	 * @return
	 * @return: Object
	 */
	@SuppressWarnings(
		{ "unchecked", "rawtypes" })
	public static Object request(String uri, MediaType mediaType, MultiValueMap<String, Object> mvm, HttpMethod method, Class resType) {

		RestTemplate restTemplate = new RestTemplate();

		// 添加自己的formHttpMessageConverter
		MyFormHttpMessageConverter formHttpMessageConverter = new MyFormHttpMessageConverter();
		List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
		messageConverters.remove(4);
		messageConverters.add(formHttpMessageConverter);

		HttpHeaders headers = new HttpHeaders();

		// Content-Type代表发送端（客户端|服务器）发送的实体数据的数据类型。 比如：Content-Type：text/html;
		// 代表发送端发送的数据格式是html。
		if (mediaType != null) {

			headers.set("content-Type", "multipart/form-data;");
		}
		else {
			headers.set("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		}
		// Accept代表发送端（客户端）希望接受的数据类型。 比如：Accept：text/xml; 代表客户端希望接受的数据类型是xml类型
		headers.set("Accept-Charset", "utf-8");
		headers.set("Accept", "application/json; charset=utf-8");// 设置编码

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(mvm, headers);

		ResponseEntity<String> response = restTemplate.exchange(Constants.URI_PREFIX + uri, method, requestEntity, resType);

		MediaType type = response.getHeaders().getContentType();

		return response.getBody();

	}

	/**
	 * 
	 * @Title: request4Redirect
	 * @Description: get请求此方法,取得重定向的地址
	 * @param uri
	 * @param mvm
	 * @param method
	 *            get
	 * @param resType
	 * @return
	 * @return: String
	 */
	@SuppressWarnings(
		{ "unchecked", "rawtypes" })
	public static String request4Redirect(String uri, MultiValueMap<String, Object> mvm, HttpMethod method, Class resType) {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		// headers.setContentType(MediaType.MULTIPART_FORM_DATA); 如有图片打开此行
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(mvm, headers);

		ResponseEntity<Object> response = restTemplate.exchange(Constants.URI_PREFIX + uri, method, requestEntity, resType);

		MediaType type = response.getHeaders().getContentType();
		System.out.println("type:" + type);
		System.out.println("state:" + response.getStatusCode());

		HttpHeaders resHeader = response.getHeaders();
		URI location = resHeader.getLocation();
		System.out.println(location);
		String redirectUrl = location.toString();

		if (null != redirectUrl && !redirectUrl.equals(""))
			return redirectUrl;

		return null;

	}

}
