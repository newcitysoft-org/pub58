/**   
 * Copyright © 神州租车. All rights reserved.
 * 
 * @Title: Test.java 
 * @Project: 58gateway-parent
 * @Package: com.zuche.gateway.test 
 * @Description: TODO
 * @author: helong   
 * @date: 2016年3月15日 上午10:52:35 
 * @version: V1.0   
 */
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

import static com.newcity.pub58.PubUtil.printStatus;

/**
 * @ClassName: Test
 * @Description:
 * @date: 2016年3月15日 上午10:52:35
 */
public class Test {

	private static PostServiceImpl postServiceImpl = new PostServiceImpl();

	private static AuthorizeImpl authorizeImpl = new AuthorizeImpl();

	// 发布方法测试　
	public static void testSend(Token token, MediaType mediaType) throws UnsupportedEncodingException {

		PostSend send = new PostSend();

		ParamXml paramVO = new ParamXml();
		// 必填选项
		paramVO.setBrand_text("奥迪");
		paramVO.setBrand_value("408844");
		paramVO.setChexi_text("A6L");
		paramVO.setChexi_value("409052");
		paramVO.setCheshenyanse_text("银色");
		paramVO.setCheshenyanse_value("3");
		paramVO.setRundistance("15");
		paramVO.setMinPrice("15.98");
		paramVO.setBuytime_value("2016");
		paramVO.setBuytime_text("2016年");
		paramVO.setShangpaiyuefen_text("6月");
		paramVO.setShangpaiyuefen_value("515686");
		paramVO.setShangpainianyue("201606"); // 上牌年月
		paramVO.setShifoufufeifabu("0"); // 是否付费发布信息
		paramVO.setShifouyishou("0"); // 车辆是否已售
		paramVO.setGoblianxiren("刘先生");
		// 必填默认
//		paramVO.setGuohufeiyong("553663"); // “553663”：包含过户费用 “553664”：不包含过户费用，
		paramVO.setApilaiyuan("1");
		paramVO.setApiedit("1");
		paramVO.setType("0");
		// 自由填充
		paramVO.setZimu_text("A"); // ~
		paramVO.setZimu_value("408783"); // ~
		paramVO.setObjectType_text("轿车"); // ~
		paramVO.setObjectType_value("1"); // ~
		paramVO.setMadein_text("合资"); // ~
		paramVO.setMadein_value("408852"); // ~
		paramVO.setChexibieming_text("奥迪A6L"); // ~
		paramVO.setChexibieming_value("515857"); // ~
		paramVO.setCarchexing_text("2014款 30 FSI 舒适型");
		paramVO.setCarchexing_value("668310");
		paramVO.setKucheid_text("288035"); // ?
		paramVO.setKucheid_value("738318"); // ?
		paramVO.setGearbox_text("自动"); // ~
		paramVO.setGearbox_value("408822"); // ~
		paramVO.setShangshishijian_text("2013"); // ~
		paramVO.setShangshishijian_value("612062"); // ~
		paramVO.setDisplacement_text("2.5"); // ~
		paramVO.setDisplacement_value("409110");// ~
		// 选填
		paramVO.setErscpinpai("2008款 2.5V 豪华版");
		paramVO.setRundistanceqj("3_5");
		paramVO.setChelingqj("2016_2018");
		paramVO.setMinPriceqj("40_999999");
		paramVO.setBaoyang_text("是");
		paramVO.setBaoyang_value("515673");
		paramVO.setShiguqk_text("无");
		paramVO.setShiguqk_value("515713");
		paramVO.setShigumiaoshu("");
		paramVO.setCjshijian("");
		paramVO.setQxshijian("");
		paramVO.setSyshijian("无商业险");
		paramVO.setYczbpic(""); // 	行驶证图片
		paramVO.setYczhibao("525379"); // 默认就是525379
		paramVO.setXbsx("0"); // “1”：包含七天可退，“0”：不包含七天可退
		paramVO.setPaifangbiaozhun("");
		paramVO.setShifougaodang("");
		paramVO.setApixinxiid("");
//		paramVO.setVin("45534kk3333333345");
		// VIP 信息
		paramVO.setQtkt("");
		paramVO.setMianfeiguohu("");
		paramVO.setCylb("");
		paramVO.setEscwltv2("0");
		paramVO.setQitadianhua("");
		paramVO.setWanglintongbieming("");
		paramVO.setGuohufeiyong("553663"); // “553663”：包含过户费用 “553664”：不包含过户费用，

		send.setParamVO(paramVO);

		send.setCate_id("29");
		// 这里的城市id ,一定要和账户中的城市一致，而id则可以从58提供的文档上找
		send.setLocal_id("2054");
		send.setTitle("丰田锐志 2008款 2.5V 豪华版 2008年上牌-全网最实惠价+物超所值+清仓价");
		send.setContent("1、车辆介绍：2008年6月份上牌、一手车、保险和年审都到2014年6月份、车身内外都有8.5成新、车况超靓和后驱车动力十足、空间超级大和宽敞。2.5自动波、豪华版带天窗、DVD导航、胎压监测装置、车内中控锁、遥控钥匙、ABS防抱死、真皮方向盘、真皮座椅、氙气大灯、恒温空调、定速巡航等等最先进配置。原车主爱车如爱子、每走5000公里就会定时保养和检测车子、平常只用于上下班代步用途、杜绝一切不惜车的行为确保车辆：新+靓。");
		send.setPhone("13655454545");
		send.setEmail("sefs@sef.com");
		send.setIm("541242010");

		String[] pics =
			{ "D:/data/fengtian/1.jpg", "D:/data/fengtian/2.jpg",
			"D:/data/fengtian/3.jpg", "D:/data/fengtian/4.jpg"};
		send.setPic(pics);

		ServiceResponse sendResponse = postServiceImpl.send(send, token, mediaType);
		printStatus(sendResponse);
	}

	// 更新方法测试
	public static void postUpdate(Token token, long infoId, MediaType mediaType) {
		PostUpdate update = new PostUpdate();
		ParamXml paramVO = new ParamXml();

		paramVO.setZimu_text("A");
		paramVO.setZimu_value("408783");
		paramVO.setBrand_text("奥迪");
		paramVO.setBrand_value("408844");
		paramVO.setChexi_text("A6L");
		paramVO.setChexi_value("409052");
		paramVO.setObjectType_text("轿车");
		paramVO.setObjectType_value("1");
		paramVO.setMadein_text("合资");
		paramVO.setMadein_value("408852");
		paramVO.setChexibieming_text("奥迪A6L");
		paramVO.setChexibieming_value("515857");
		paramVO.setCarchexing_text("2014款 30 FSI 舒适型");
		paramVO.setCarchexing_value("668310");
		paramVO.setKucheid_text("288035");
		paramVO.setKucheid_value("738318");
		paramVO.setGearbox_text("自动");
		paramVO.setGearbox_value("408822");
		paramVO.setShangshishijian_text("2013");
		paramVO.setShangshishijian_value("612062");
		paramVO.setCheshenyanse_text("银色");
		paramVO.setCheshenyanse_value("3");
		paramVO.setDisplacement_text("2.5");
		paramVO.setDisplacement_value("409110");

		paramVO.setErscpinpai("2009款 2.5V 豪华版");
		paramVO.setRundistance("15");
		paramVO.setRundistanceqj("8_12");
		paramVO.setChelingqj("2008_2010");
		paramVO.setMinPrice("15.98");
		paramVO.setMinPriceqj("40_999999");

		paramVO.setBuytime_value("2015");
		paramVO.setBuytime_text("2015年");
		paramVO.setShangpaiyuefen_text("6月");
		paramVO.setShangpaiyuefen_value("515686");
		paramVO.setBaoyang_text("是");
		paramVO.setBaoyang_value("515673");
		paramVO.setShiguqk_text("无");
		paramVO.setShiguqk_value("515713");

		paramVO.setShigumiaoshu("");
		paramVO.setSyshijian("无商业险");
		paramVO.setYczbpic("");
		paramVO.setYczhibao("525379");
		paramVO.setXbsx("0");
		paramVO.setShangpainianyue("200806");
		paramVO.setShifoufufeifabu("0");
		paramVO.setShifouyishou("0");
		paramVO.setPaifangbiaozhun("");
		paramVO.setGuohufeiyong("553663");
		paramVO.setShifougaodang("");
		paramVO.setGoblianxiren("刘先生");
		paramVO.setApixinxiid("");
		paramVO.setApilaiyuan("1");
		paramVO.setApiedit("1");
		paramVO.setType("0");
//		paramVO.setVin("45534kk3333333345");
		// VIP 信息
		paramVO.setQtkt("");
		paramVO.setMianfeiguohu("");
		paramVO.setCylb("");
		paramVO.setEscwltv2("0");
		paramVO.setQitadianhua("");
		paramVO.setWanglintongbieming("");

		update.setInfoid(infoId);
		update.setParamVO(paramVO);
		update.setCate_id("29");
		// 这里的城市id ,一定要和账户中的城市一致，而id则可以从58提供的文档上找
		update.setLocal_id("2054");
		update.setTitle("丰田锐志 2009款 2.5V 豪华版");
		update.setContent("1、车辆介绍：2008年6月份上牌、一手车、保险和年审都到2014年6月份、车身内外都有8.5成新、车况超靓和后驱车动力十足、空间超级大和宽敞。2.5自动波、豪华版带天窗、DVD导航、胎压监测装置、车内中控锁、遥控钥匙、ABS防抱死、真皮方向盘、真皮座椅、氙气大灯、恒温空调、定速巡航等等最先进配置。原车主爱车如爱子、每走5000公里就会定时保养和检测车子、平常只用于上下班代步用途、杜绝一切不惜车的行为确保车辆：新+靓。");
		update.setPhone("13655454545");
		update.setEmail("sefs@sef.com");
		update.setIm("541242010");

		String[] pics =
				{ "D:/data/fengtian/1.jpg"};

		 update.setPic(pics);

		ServiceResponse sendResponse = PubUtil.testUpdate(token, update, mediaType);
		printStatus(sendResponse);
	}

	public static void main(String[] args) {

		// 先设置好token

		try {
			// 带图片的
			Token token = new Token();
			token.setUid("19475933152263");
			token.setRefresh_token("5876228671f0d56664de508fe25592d1_v1");
			token.setAccess_token("ac25d95fba39b21af1a9e26cf4324ca_v1");
			token.setExpires_in("364");


			Token token1 = PubUtil.getToken(token);
			System.out.println(token1.toString());

//			testSend(token1,  MediaType.MULTIPART_FORM_DATA);
			postUpdate(token1, 33741662801587L, MediaType.MULTIPART_FORM_DATA);
//			testDelete(token1, 33741662801587L);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
