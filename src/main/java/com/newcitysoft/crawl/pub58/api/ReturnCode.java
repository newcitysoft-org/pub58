
package com.newcitysoft.crawl.pub58.api;

import java.util.HashMap;
import java.util.Map;

/**
 * 58全局返回码
 */
public class ReturnCode {
    
    @SuppressWarnings("serial")
    private static final Map<Integer, String> errCodeToErrMsg = new HashMap<Integer, String>(){{
        put(-1, "无错误和异常");
        put(0, "发生未知异常");
        put(1, "服务已失效");
        put(2, "通讯密码错误");
        put(3, "xml数据格式不合法");
        put(4, "源权限不足");
        put(6, "类别不存在");
        put(7, "区域不存在");
        put(8, "属性值验证失败");
        put(9, "参数值验证失败");
        put(10, "IQAS验证失败");
        put(11, "信息保存失败");
        put(12, "信息状态错误  用于修改时的权限验证：state只允许为1/3/11。");
        put(13, "vin验证失败");
        put(14, "身份验证不通过 openapi仅允许网邻通用户接入");
        put(15, "vin验证失败为空");
        put(16, "vin验证失败错误");
        put(17, "vin验证失败已经使用");
        put(18, "检测信息不符合规则");
        put(19, "vin服务异常");
        put(20, "超过发布条数限制");
        put(21, "类别不是二手车");
        put(22, "消息不合法");
        put(23, "一句话广告字数需控制在15字符以内");
        put(24, "上牌时间不合理");
        put(25, "请不要输入非法字符");
        put(26, "标题为空");
        put(27, "车型不存在");
        put(28, "标题过长字数需控制在80字符以内");
        put(29, "发布来源错误");
        put(30, "userId错误不允许修改");
        put(31, "车型没有填写");
        put(32, "精评帖子不允许修改");
        put(33, "请至少填写一项证件信息");

    }};

    /**
     * 通过返回码获取返回信息
     * @param errCode 错误码
     * @return {String}
     */
    public static String get(int errCode) {
        return errCodeToErrMsg.get(errCode);
    }
}




