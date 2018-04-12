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

		paramVO.setErscpinpai("2008款 2.5V 豪华版");
		paramVO.setRundistance("15");
		paramVO.setRundistanceqj("8_12");
		paramVO.setChelingqj("2008_2010");
		paramVO.setMinPrice("15.98");
		paramVO.setMinPriceqj("40_999999");

		paramVO.setBuytime_value("2008");
		paramVO.setBuytime_text("2008年");
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
		paramVO.setVin("45534kk3333333345");
		// VIP 信息
		paramVO.setQtkt("");
		paramVO.setMianfeiguohu("");
		paramVO.setCylb("");
		paramVO.setEscwltv2("0");
		paramVO.setQitadianhua("");
		paramVO.setWanglintongbieming("");

		send.setParamVO(paramVO);

		send.setCate_id("29");
		// 这里的城市id ,一定要和账户中的城市一致，而id则可以从58提供的文档上找
		send.setLocal_id("1");
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
	public static void testUpdate(Token token, long infoId, MediaType mediaType) {

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

		paramVO.setBuytime_value("2008");
		paramVO.setBuytime_text("2008年");
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
		paramVO.setVin("45534kk3333333345");
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
		update.setLocal_id("1");
		update.setTitle("丰田锐志 2009款 2.5V 豪华版 2008年上牌-全网最实惠价+物超所值+清仓价");
		update.setContent("1、车辆介绍：2008年6月份上牌、一手车、保险和年审都到2014年6月份、车身内外都有8.5成新、车况超靓和后驱车动力十足、空间超级大和宽敞。2.5自动波、豪华版带天窗、DVD导航、胎压监测装置、车内中控锁、遥控钥匙、ABS防抱死、真皮方向盘、真皮座椅、氙气大灯、恒温空调、定速巡航等等最先进配置。原车主爱车如爱子、每走5000公里就会定时保养和检测车子、平常只用于上下班代步用途、杜绝一切不惜车的行为确保车辆：新+靓。");
		update.setPhone("13655454545");
		update.setEmail("sefs@sef.com");
		update.setIm("541242010");
		// update.setPic(pic);

		ServiceResponse sendResponse = postServiceImpl.update(update, token, mediaType);
		printStatus(sendResponse);

	}

	// 删除方法测试
	public static void testDelete(Token token, long infoId) {

		PostDelete delete = new PostDelete();
		delete.setInfoid(infoId);
		ServiceResponse sendResponse = postServiceImpl.delete(delete, token);
		printStatus(sendResponse);

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

	public static void main(String[] args) {

		// 先设置好token

		try {
			// 带图片的
			Token token = new Token();
			token.setUserName("15841694657");
			token.setPassword("axin19930930");
			token.setUid("52147071000845");
			token.setRefresh_token("7c61d61a229b7837d42ad77a4183bcfb_v1");
			token.setAccess_token("f49f47380962a3c6f758d9599663018_v1");
			token.setExpires_in("364");

//			token.setUid("52147071000845");
//			token.setExpires_in("364");
//			token.setAccess_token("8dfb1b191af99369486528443734ace0_v1");
//			token.setRefresh_token("ef3bb66f9d7369fb1c51f7d8dede3b63_v1");

//			Token token1 = getToken(token);
//			System.out.println(token1.toString());
			testSend(token, null);

			// 不带图片的
			// testSend(getToken(""), null);
			// 25411283105079L,MediaType.MULTIPART_FORM_DATA);

			// testDelete(getToken("4a88e421dddf44f51a070a2f158ae1"),
			// 25411283105079L);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
