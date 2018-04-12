package com.renren.pub58.controller;

import com.jfinal.core.Controller;
import com.renren.pub58.api.constant.Constants;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/11 15:42
 */
public class AuthController extends Controller{
    private static final String uri = Constants.URI_PREFIX + "authorize?client_id=" + Constants.CLIENT_ID + "&redirect_uri=" + Constants.REDIRECT_URI + "auto?userName=%s&response_type=code";

    public void mask() {
        String userName = getPara("userName");
        String userPwd = getPara("userPwd");
    }

    public void index() {
        String userName = getPara("userName");
        String code = getPara("code");
        renderJson(code);
    }

//    public static void maskLogin(String userName, String userPwd) {
//        WebDriver driver = PhantomJsUtil.getPhantomJs(false);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        String url = String.format(uri, userName);
//        System.out.println(url);
//        driver.get(url);
//
//        PhantomJsUtil.snapshot((TakesScreenshot)driver, "1.png");
//
//        WebElement userNameElement = driver.findElement(By.id("username_new"));
//        userNameElement.sendKeys(userName);
//
//        WebElement userPwdElement = driver.findElement(By.id("password_new"));
//        userPwdElement.sendKeys(userPwd);
//
//        WebElement clickElement = driver.findElement(By.id("btnSubmit_new"));
//        clickElement.click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        PhantomJsUtil.snapshot((TakesScreenshot)driver, "2.png");
//
//        // 短信验证
//        WebElement pptmobilecoderesendbtn = driver.findElement(By.id("pptmobilecoderesendbtn"));
//        if(pptmobilecoderesendbtn != null) {
//            pptmobilecoderesendbtn.click();
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            PhantomJsUtil.snapshot((TakesScreenshot) driver, "3.png");
//            Scanner scanner = new Scanner(System.in);
//            String code = scanner.next();
//            WebElement pptmobilecode = driver.findElement(By.id("pptmobilecode"));
//            pptmobilecode.sendKeys(code);
//
//            WebElement submitButton = driver.findElement(By.id("submitButton"));
//            submitButton.click();
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        }
//
//        // 重新登录
//        WebElement username_new = driver.findElement(By.id("username_new"));
//        if(userName!=null) {
//            username_new.sendKeys(userName);
//            WebElement password_new = driver.findElement(By.id("password_new"));
//            password_new.sendKeys(userPwd);
//
//            WebElement btnSubmit_new = driver.findElement(By.id("btnSubmit_new"));
//            btnSubmit_new.click();
//
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        }
//
//        PhantomJsUtil.snapshot((TakesScreenshot) driver, "6.png");
//
//        System.out.println(driver.getPageSource());
//
//        driver.quit();
//    }

    public static void main(String[] args) {

    }
}
