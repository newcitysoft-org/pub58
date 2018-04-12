package com.renren.pub58.api.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.renren.pub58.api.constant.Constants;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
public class HttpClientUtil {

	private static HttpClient httpClient = null;

	public static String getLoginCookie(String url, Map<String, String> map, String charset) {

		HttpPost httpPost = null;
		StringBuffer result = new StringBuffer();
		StringBuffer threeCookie = new StringBuffer();

		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			// 设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
			}
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);

			Header[] allHeaders = response.getAllHeaders();
			for (Header header : allHeaders) {

				if (header.getName().equals("Set-Cookie")) {
					result.append(header.getValue() + ";");
				}
			}

			String[] split = result.toString().split(";");

			for (String string : split) {
				if (string.startsWith("PPU") || string.startsWith("58cooper") || string.startsWith("www58com")) {
					threeCookie.append(string).append("; ");
				}
			}

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			httpPost.abort();
		}
		return threeCookie.toString();
	}

	public static String getCode(String cooString, String url) {

		String code = "";

		DefaultHttpClient httpclient = new DefaultHttpClient();

		HttpGet httpget = new HttpGet(url);
		HttpParams params = httpclient.getParams();
		params.setParameter(ClientPNames.HANDLE_AUTHENTICATION, true);
		params.setParameter(ClientPNames.HANDLE_REDIRECTS, false);
		httpget.setParams(params);

		httpget.setHeader("Cookie", cooString);
		httpget.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpget.setHeader("Accept-Encoding", "gzip, deflate");
		httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpget.setHeader("Connection", "keep-alive");
		httpget.setHeader("Host", "openapi.58.com");
		httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");
		httpget.setHeader("Referer", "http://openapi.58.com/oauth2/authorize?client_id=38058819994625&redirect_uri=http://www.zhunxinche.com/validate&response_type=code");
		try {

			HttpResponse response = httpclient.execute(httpget);

			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 302) {
				code = response.getFirstHeader("Location").getValue();

			}
			if (!code.equals("")) {
				code = StringUtil.getUrlParamByParamName(code, "code");
			}

		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			httpget.abort();
		}
		return code;

	}

	/**
	 * 
	 * @Title: getTempToken 
	 * @Description: 获取临时token
	 * @param uname
	 * @param password
	 * @return
	 * @return: String
	 */
	public static String getTempToken(String uname, String password) {
		String httpOrgCreateTest = "https://passport.58.com/douilogin";
		Map<String, String> params = new HashMap<String, String>();
		params.put("domain", "58.com");
		params.put("callback", "handleLoginResult");
		params.put("sysIndex", "1");
		params.put("pptusername", uname);
		params.put("pptpassword", password);

		String url = Constants.URI_PREFIX + "authorize?client_id=" + Constants.CLIENT_ID + "&redirect_uri=" + Constants.REDIRECT_URI + "&response_type=code&confirm=1";

		String cookieStr = HttpClientUtil.getLoginCookie(httpOrgCreateTest, params, "utf-8");
		String code = HttpClientUtil.getCode(cookieStr, url);
		return code;
	}

}