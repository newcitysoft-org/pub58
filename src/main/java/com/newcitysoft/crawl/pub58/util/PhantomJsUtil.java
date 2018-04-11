package com.newcitysoft.crawl.pub58.util;

import com.jfinal.kit.Prop;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

/**
 * @author newcitysoft@163.com
 * @Description phantomjs工具类
 * @Date 2017-12-13 12:10
 *
 */
public class PhantomJsUtil {

    private static final boolean ACCEPT_SSL_CERTS = true;
    private static final boolean TAKES_SCREEN_SHOT = true;
    private static final boolean CSS_SELECTORS_ENABLED = true;

    public static WebDriver driver;
    public static WebDriver linuxDriver;

    public static String osName;

    static {
        osName = System.getProperties().getProperty("os.name");
    }

    private static Prop prop = new Prop("phantomjs.properties");

    public static WebDriver getDriver(){
        if(driver == null) {
            driver  = new PhantomJSDriver(config(ACCEPT_SSL_CERTS, TAKES_SCREEN_SHOT, CSS_SELECTORS_ENABLED, prop.get("DRIVER_DEFAULT_PATH"), false));
            return driver;
        }else{
            return driver;
        }
    }

    public static WebDriver getLinuxDriver(){
        if(linuxDriver == null) {
            linuxDriver  = new PhantomJSDriver(config(ACCEPT_SSL_CERTS, TAKES_SCREEN_SHOT, CSS_SELECTORS_ENABLED, prop.get("DRIVER_LINUX_PATH"), true));
            return linuxDriver;
        }else{
            return linuxDriver;
        }
    }

    public static DesiredCapabilities config(boolean acceptSslCerts, boolean takesScreenshot, boolean cssSelectorsEnabled, String driverPath, boolean isProxy){
        //设置必要参数
        DesiredCapabilities dcaps = new DesiredCapabilities();
        //ssl证书支持
        dcaps.setCapability("acceptSslCerts", acceptSslCerts);
        //截屏支持
        dcaps.setCapability("takesScreenshot", takesScreenshot);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", cssSelectorsEnabled);
        //js支持
        dcaps.setJavascriptEnabled(true);
        //驱动支持
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, driverPath);
        //设置参数
//        dcaps.setCapability("phantomjs.page.settings.userAgent", UserAgent.next());
//        dcaps.setCapability("phantomjs.page.customHeaders.User-Agent", UserAgent.next());
//        if (isProxy) {
//            //是否使用代理
//            org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//            proxy.setProxyType(org.openqa.selenium.Proxy.ProxyType.MANUAL);
//            proxy.setAutodetect(false);
//            String proxyStr = "";
//            do {
//                //自定义函数，返回代理ip及端口
//                proxyStr = prop.get("proxy");
//            } while (proxyStr.length() == 0);
//            proxy.setHttpProxy(proxyStr);
//            dcaps.setCapability(CapabilityType.PROXY, proxy);
//        }
        //创建无界面浏览器对象
        return dcaps;
    }

    public static void executeScript(PhantomJSDriver driver, String js){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(js);
    }

    public static void snapshot(TakesScreenshot drivername, String filename)
    {
        String currentPath = System.getProperty("user.dir");
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            if(osName.equals("Linux")){
                FileUtils.copyFile(scrFile, new File(prop.get("snapshots_path")+filename));
            }else{
                FileUtils.copyFile(scrFile, new File(currentPath+"\\snapshots\\"+filename));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getPhantomJs(boolean isProxy) {
        System.out.println(osName);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //设置参数
//        desiredCapabilities.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
//        desiredCapabilities.setCapability("phantomjs.page.customHeaders.User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:50.0) Gecko/20100101 　　Firefox/50.0");
        String userAgent = UserAgent.next();
        //ssl证书支持
        //desiredCapabilities.setCapability("acceptSslCerts", true);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //截屏支持
        desiredCapabilities.setCapability("takesScreenshot", true);
        //css搜索支持
        desiredCapabilities.setCapability("cssSelectorsEnabled", true);
        //js支持
        desiredCapabilities.setJavascriptEnabled(true);
        //https
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--web-security=no", "--ssl-protocol=any", "--ignore-ssl-errors=yes"});
        //UA
        desiredCapabilities.setCapability("phantomjs.page.settings.userAgent", userAgent);
        desiredCapabilities.setCapability("phantomjs.page.customHeaders.User-Agent", userAgent);

        if (isProxy) {
            //是否使用代理
            Proxy proxy = new Proxy();
            proxy.setProxyType(Proxy.ProxyType.MANUAL);
            proxy.setAutodetect(false);
//            String proxyStr = "";
//            do {
//                //自定义函数，返回代理ip及端口
////                proxyStr = ProxyUtil.getProxy();
//                proxyStr = prop.get("proxy");
//            } while (proxyStr.length() == 0);
            proxy.setHttpProxy(prop.get("proxy"));
            desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);
        }

        if (osName.equals("Linux")) {
            //判断系统的环境win or Linux
            System.setProperty("phantomjs.binary.path", prop.get("DRIVER_LINUX_PATH"));
            //return new HtmlUnitDriver(desiredCapabilities);
        } else {
            //设置PhantomJs访问路径
            System.setProperty("phantomjs.binary.path", prop.get("DRIVER_DEFAULT_PATH"));
        }
        return new PhantomJSDriver(desiredCapabilities);
    }
}
