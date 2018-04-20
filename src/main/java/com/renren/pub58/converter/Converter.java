package com.renren.pub58.converter;

/**
 * 转换器
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/20 15:07
 * @param <I> 输入类型
 * @param <O> 输出类型
 */
public interface Converter<I, O> {
    /**
     * 转换
     * @param i
     * @return
     */
    O convert(I i);
}
