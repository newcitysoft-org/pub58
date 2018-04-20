package com.renren.pub58.converter;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/20 15:10
 */
public interface KaiXinTo58Converter<O> extends Converter<KaiXinCarModel, O>{
    /**
     * 转换开心汽车的车实体为58对应的实体
     * @param model
     * @return
     */
    @Override
    O convert(KaiXinCarModel model);
}
