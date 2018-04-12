package com.renren.pub58.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类
 *
 * @author lixin.tian@renren-inc.com
 * @Date 2017-12-11
 */
public class HttpClientUtil {
    static PoolingHttpClientConnectionManager cm;
    static SocketConfig defaultSocketConfig = SocketConfig.custom().setSoKeepAlive(false).setSoTimeout(10000).build();

    static {
        try {
            SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                // 默认信任所有证书
                public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    return true;
                }
            }).build();
            // 设置协议http和https对应的处理socket链接工厂的对象
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslcontext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER))
                    .build();

            // Allow TLSv1 protocol only
            cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            cm.setMaxTotal(1000);
            cm.setDefaultSocketConfig(defaultSocketConfig);
            cm.setDefaultMaxPerRoute(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setSocketTimeout(10000)
            .setConnectTimeout(4000)
            .setConnectionRequestTimeout(SystemConfig.REQUEST_CONNECTION_REQUEST_TIMEOUT)
            .setRedirectsEnabled(true).build();

    /**
     * HttpClient的post请求
     *
     * @param url
     * @param map
     * @return
     */
    public static String doPost(String url, Map<String, String> map) throws Exception{
        return doPost(url, map, "utf-8");
    }

    /**
     * HttpClient的post请求
     *
     * @param url
     * @param map
     * @param charset
     * @return
     */
    public static String doPost(String url, Map<String, String> map, String charset) throws Exception {
        CloseableHttpClient httpClient = HttpClientConnectionManager.getHttpClient(defaultRequestConfig);
        //新建HttpClient对象
        HttpPost httpPost = null;
        String result = null;

        httpPost = new HttpPost(url);
        //设置参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        if(map!=null){
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
        }else{
            throw new Exception("提交的entity map不能为空！");
        }

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
//        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
//        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        CloseableHttpResponse response = httpClient.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            result = EntityUtils.toString(entity, charset);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        httpClient.close();

        return result;
    }


    private static void setPostEntity(HttpPost httpPost, Map<String, String> map, String charset) throws UnsupportedEncodingException {
        //设置参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
            list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
        }
        if (list.size() > 0) {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
            httpPost.setEntity(entity);
        }
    }

    public static CloseableHttpClient getHttpClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(defaultRequestConfig)
                // .setSSLSocketFactory(sslsf)
                .setConnectionManagerShared(true).build();
        return httpClient;
    }

    /**
     * 创建基本的网络请求
     * @param url
     * @param map
     * @param charset
     * @param ifUseProxy
     * @param proxyMap
     * @return
     * @throws Exception
     */
    public static String createBaseRequest(String url, Map<String, String> map, String charset, boolean ifUseProxy, Map<String, String> proxyMap) throws Exception{
        //Map<String, String> resultMap = new HashMap<>();
        String result = "";

        HttpRequestBase httpRequestBase = null;
        if(map!=null && !map.isEmpty()){
            HttpPost post = new HttpPost(url);
            setPostEntity(post, map, charset);
            httpRequestBase = post;
        }else{
            HttpGet httpget = new HttpGet(url);
            httpRequestBase = httpget;
        }

        RequestConfig.Builder configBuilder = RequestConfig.copy(defaultRequestConfig);
        if(ifUseProxy){
            HttpHost host = new HttpHost(proxyMap.get("ip"), Integer.parseInt(proxyMap.get("port")));

            configBuilder.setProxy(host);
        }

        httpRequestBase.setConfig(configBuilder.build());

        CloseableHttpClient httpClient = getHttpClient();
        HttpClientContext httpClientContext = HttpClientContext.create();

        CloseableHttpResponse response = httpClient.execute(httpRequestBase, httpClientContext);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            result = EntityUtils.toString(entity, charset);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        httpClient.close();
//
//        response.getEntity().getContent();
//        int statusCode = response.getStatusLine().getStatusCode();
//        resultMap.put("statusCode", String.valueOf(statusCode));
//        resultMap.put("result", JSONObject.toJSONString(response.getEntity()));

        return result;
    }

    public static void main(String[] args) throws Exception {
        /*String url="http://php.weather.sina.com.cn/iframe/index/w_cl.php";
        Map<String, String> map = new HashMap<String, String>();
        map.put("code", "js");
        map.put("day", "0");
        map.put("city", "上海");
        map.put("dfc", "1");
        map.put("charset", "utf-8");
        String body = doPost(url, map,"utf-8");
        System.out.println("交易响应结果：");
        System.out.println(body);

        System.out.println("-----------------------------------");

        map.put("city", "北京");
        body = doPost(url, map, "utf-8");
        System.out.println("交易响应结果：");
        System.out.println(body);*/

        /*Map<String, String> proxyMap = IpPoolService.randomGetAvailableIp();
        System.out.println(proxyMap.get("hostname")+"--"+proxyMap.get("ip")+":"+proxyMap.get("port"));
        String url = "https://www.baidu.com/";

        Map<String, String> map = createBaseRequest(url, null, "utf-8", true, proxyMap);

        System.out.println(map.get("statusCode"));
        System.out.println(map.get("result"));*/
    }
}
