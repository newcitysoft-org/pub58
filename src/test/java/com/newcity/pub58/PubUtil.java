package com.newcity.pub58;

import com.renren.pub58.api.pojo.ParamXml;
import com.renren.pub58.api.pojo.PostDelete;
import com.renren.pub58.api.pojo.PostSend;
import com.renren.pub58.api.pojo.PostUpdate;
import com.renren.pub58.api.pojo.ServiceResponse;
import com.renren.pub58.api.pojo.Token;
import com.renren.pub58.api.serviceImpl.AuthorizeImpl;
import com.renren.pub58.api.serviceImpl.PostServiceImpl;
import com.renren.pub58.api.util.HttpClientUtil;
import com.renren.pub58.api.util.StringUtil;
import org.springframework.http.MediaType;

import java.io.UnsupportedEncodingException;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/13 16:26
 */
public class PubUtil {

    private static PostServiceImpl postServiceImpl = new PostServiceImpl();

    private static AuthorizeImpl authorizeImpl = new AuthorizeImpl();

    // 发布方法测试　
    public static ServiceResponse testSend(Token token, PostSend send, MediaType mediaType) throws UnsupportedEncodingException {
       return postServiceImpl.send(send, token, mediaType);
    }

    // 更新方法测试
    public static ServiceResponse testUpdate(Token token, PostUpdate update, MediaType mediaType) {
        return postServiceImpl.update(update, token, mediaType);
    }

    // 删除方法测试
    public static ServiceResponse testDelete(Token token, long infoId) {
        PostDelete delete = new PostDelete();
        delete.setInfoid(infoId);
        return postServiceImpl.delete(delete, token);
    }

    public static void printStatus(ServiceResponse sendeResponse) {

        if (sendeResponse == null) {
            System.out.println("接口调用异常");
        }
        else {

            System.out.println("status: " + sendeResponse.getStatus());
            System.out.println("url: " + sendeResponse.getUrl());
            System.out.println("apimsg: " + sendeResponse.getApimsg());
            System.out.println("errmsg: " + sendeResponse.getErrmsg());
            System.out.println("error: " + sendeResponse.getError());
            System.out.println("errorDesc: " + sendeResponse.getErrorDescription());
            System.out.println("gatewaySuccess " + sendeResponse.getGatewaySuccess());
            System.out.println("infoid: " + sendeResponse.getInfoid());
        }
    }

    /**
     *
     * @Title: getToken
     * @Description: 如果之前已经获取过token,则从数据库中读取token记录,例子程序中就直接生成了，真正运行的时候，针对每一个账户，
     *               第一次的时候需要程序生成token，后面则从数据库读取，如过了失效时间则刷新token
     * @return
     * @return: Token
     */
    public static Token getToken(Token token) {

        if (null !=token.getAccess_token() && !token.getAccess_token().equals("") && null !=token.getRefresh_token() && !token.getRefresh_token().equals("") &&  null !=token.getExpires_in() &&  !token.getExpires_in().equals("")) {
            if (System.currentTimeMillis() > StringUtil.getExpiresMills(Integer.valueOf(token.getExpires_in()))) {
                // token 过期 刷新token后用数据库存储起来,记得要把最新的token更新到数据库中
                token = authorizeImpl.refreshToken(token);
            }
            else {

                return token;
            }
        }
        else {
            String tempToken = HttpClientUtil.getTempToken(token.getUserName(), token.getPassword());
            System.out.println(tempToken);
            token = authorizeImpl.getToken(tempToken);
            return token;
        }

        return null;

    }
}
