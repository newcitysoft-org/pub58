package com.renren.pub58.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpClientConnectionManager {
	private static RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(SystemConfig.REQUEST_SOCKET_TIMEOUT).setConnectTimeout(SystemConfig.REQUEST_CONNECT_TIMEOUT).setConnectionRequestTimeout(SystemConfig.REQUEST_CONNECTION_REQUEST_TIMEOUT).setRedirectsEnabled(true).build();
	static PoolingHttpClientConnectionManager cm;
	static SocketConfig defaultSocketConfig = SocketConfig.custom().setSoKeepAlive(false).setSoTimeout(SystemConfig.REQUEST_SOCKET_TIMEOUT).build();
	static {
		try {
			// ProtocolSocketFactory easy = new EasySSLProtocolSocketFactory();
			//
			// Protocol protocol = new Protocol("https", easy, 443);
			//
			// Protocol.registerProtocol("https", protocol);

			// Trust own CA and all self-signed certs
			SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
				// 默认信任所有证书
				public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					return true;
				}
			}).build();
			// 设置协议http和https对应的处理socket链接工厂的对象
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.INSTANCE).register("https", new SSLConnectionSocketFactory(sslcontext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)).build();

			// Allow TLSv1 protocol only
			cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			cm.setMaxTotal(1000);
			cm.setDefaultSocketConfig(defaultSocketConfig);
			cm.setDefaultMaxPerRoute(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static CloseableHttpClient getHttpClient() throws Exception {
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(defaultRequestConfig)
		// .setSSLSocketFactory(sslsf)
				.setConnectionManagerShared(true).build();
		return httpClient;
	}

	public static CloseableHttpClient getHttpClient(RequestConfig rc) throws Exception {
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(rc)
				// .setSSLSocketFactory(sslsf)
				.setConnectionManagerShared(true).build();
		return httpClient;
	}

	public static void main(String[] args) {
		HttpGet httpget = new HttpGet("https://www.guazi.com/zibo/8c5e90f238c94de1x.htm#fr_page=list&fr_pos=city&fr_no=1");
		try {
			CloseableHttpResponse response = getHttpClient().execute(httpget);
			try {
				HttpEntity entity = response.getEntity();

				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 绕过验证
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");

		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		sc.init(null, new TrustManager[] { trustManager }, null);
		return sc;
	}
}
