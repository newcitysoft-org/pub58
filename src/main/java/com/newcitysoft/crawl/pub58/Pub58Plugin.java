package com.newcitysoft.crawl.pub58;

import com.jfinal.kit.Prop;
import com.jfinal.plugin.IPlugin;
import com.newcitysoft.crawl.pub58.util.PhantomJsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/10 15:09
 */
public class Pub58Plugin implements IPlugin {
    private final static Logger LOGGER = LoggerFactory.getLogger(Pub58Plugin.class);
    private final static Prop prop = new Prop("config.properties");
    private final static String userName = prop.get("58.username");
    private final static String password = prop.get("58.password");
    private final static WebDriver driver = PhantomJsUtil.getPhantomJs(false);
    private final static String POST_URL = "http://post.58.com/1/29/s5?kuaipai=true";

    private volatile static boolean isStart = false;

    public static void main(String[] args) throws InterruptedException {
        login();
    }

    @Override
    public boolean start() {
        try {
            if(!isStart) {
                login();
                isStart = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean stop() {
        if(isStart) {
            driver.quit();
            isStart = false;
        }
        return true;
    }

    public  static void login() throws InterruptedException {
        driver.get(POST_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PhantomJsUtil.snapshot((TakesScreenshot)driver, "end-1.png");
        TimeUnit.SECONDS.sleep(5);
        PhantomJsUtil.snapshot((TakesScreenshot)driver, "end-2.png");

        WebElement clickElement = driver.findElement(By.id("flLogin_pwdLogin"));
        clickElement.click();
        PhantomJsUtil.snapshot((TakesScreenshot)driver, "end-3.png");

        WebElement userNameElement = driver.findElement(By.cssSelector("input[name='username']"));
        userNameElement.clear();
        userNameElement.sendKeys(userName);
        PhantomJsUtil.snapshot((TakesScreenshot)driver, "end-4.png");
        driver.findElement(By.cssSelector("input[name='passwordInputEmpty']")).click();
        WebElement userPwdElement = driver.findElement(By.cssSelector("input[name='passwordInput']"));
        userPwdElement.clear();
        userPwdElement.sendKeys(password);
        PhantomJsUtil.snapshot((TakesScreenshot)driver, "end-5.png");
        // 登录
        driver.findElement(By.id("btnSubmitUser")).click();
        TimeUnit.SECONDS.sleep(5);
        PhantomJsUtil.snapshot((TakesScreenshot)driver, "end-6.png");
        // 是否需要验证

        WebElement mobileSureCodeBtn = driver.findElement(By.id("mobileSureCodeBtn"));
        if(mobileSureCodeBtn != null) {
            mobileSureCode();
        }

        driver.quit();
    }

    /**
     * 短信验证
     */
    public static void mobileSureCode() {
        Scanner scanner = new Scanner(System.in);
//        if()
    }

    public static void index() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
}
