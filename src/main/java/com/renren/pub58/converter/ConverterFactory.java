package com.renren.pub58.converter;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/20 15:42
 */
public class ConverterFactory {

    public static KaiXinToSendConverter getSendConverter() {
        return new KaiXinToSendConverter();
    }

    public static KaiXinToUpdateConverter getUpdateConverter() {
        return new KaiXinToUpdateConverter();
    }

//    public static Converter getConverter() {
//
//    }
}
