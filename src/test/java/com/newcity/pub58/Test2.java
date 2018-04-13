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
import org.eclipse.jetty.util.ajax.JSONObjectConvertor;
import org.springframework.http.MediaType;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName: Test
 * @Description:
 * @date: 2016年3月15日 上午10:52:35
 */
public class Test2 {

	private static PostServiceImpl postServiceImpl = new PostServiceImpl();

	private static AuthorizeImpl authorizeImpl = new AuthorizeImpl();

	// 发布方法测试　
	public static void testSend(Token token, MediaType mediaType) throws UnsupportedEncodingException {

		PostSend send = new PostSend();

		send.setCate_id("29");
		// 这里的城市id ,一定要和账户中的城市一致，而id则可以从58提供的文档上找
		send.setLocal_id("2054");
		send.setTitle("众泰Z700 2016款 1.8T 手动尊贵型");
		send.setContent("“颜值高”--外观好看、“有内涵”--配置很高、“胸怀宽广”--空间大。");
		send.setPhone("13655454545");
		send.setEmail("sefs@sef.com");
		send.setIm("541242010");

		String[] pics =
				{ "D:/data/test/timg.jpg"};
		send.setPic(pics);

		ParamXml paramVO = new ParamXml();
		// 必填选项
		paramVO.setBrand_text("众泰");
		paramVO.setBrand_value("419610");
		paramVO.setChexi_text("众泰Z700");
		paramVO.setChexi_value("900143");
		paramVO.setCarchexing_text("2016款 1.8T 手动尊贵型");
		paramVO.setCarchexing_value("910075");
		paramVO.setCheshenyanse_text("银色");// ??
		paramVO.setCheshenyanse_value("3"); // ??
		paramVO.setRundistance("6");
		paramVO.setMinPrice("11.98");
		paramVO.setBuytime_value("2017");
		paramVO.setBuytime_text("2017年");
		paramVO.setShangpaiyuefen_text("6月");
		paramVO.setShangpaiyuefen_value("515686");
		paramVO.setShangpainianyue("201706"); // 上牌年月
		paramVO.setShifoufufeifabu("0"); // 是否付费发布信息
		paramVO.setShifouyishou("0"); // 车辆是否已售
		paramVO.setGoblianxiren("田先生");
		// 必填默认
//		paramVO.setGuohufeiyong("553663"); // “553663”：包含过户费用 “553664”：不包含过户费用，
		paramVO.setApilaiyuan("1");
		paramVO.setApiedit("1");
		paramVO.setType("0");
		// 自由填充
//		paramVO.setZimu_text("A"); // ~
//		paramVO.setZimu_value("408783"); // ~
//		paramVO.setObjectType_text("轿车"); // ~
//		paramVO.setObjectType_value("1"); // ~
//		paramVO.setMadein_text("合资"); // ~
//		paramVO.setMadein_value("408852"); // ~
//		paramVO.setChexibieming_text("奥迪A3"); // ~
//		paramVO.setChexibieming_value("668468"); // ~
//		paramVO.setKucheid_text("288035"); // ?
//		paramVO.setKucheid_value("738318"); // ?
//		paramVO.setGearbox_text("自动"); // ~
//		paramVO.setGearbox_value("408822"); // ~
//		paramVO.setShangshishijian_text("2013"); // ~
//		paramVO.setShangshishijian_value("802393"); // ~
//		paramVO.setDisplacement_text("1.4"); // ~
//		paramVO.setDisplacement_value("409110");// ~
		// 选填
		paramVO.setErscpinpai("轿车");
		paramVO.setRundistanceqj("6_8");
		paramVO.setChelingqj("2017_2018");
		paramVO.setMinPriceqj("11_15");
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

		ServiceResponse sendResponse = postServiceImpl.send(send, token, mediaType);
		printStatus(sendResponse);
	}

	// 更新方法测试
	public static void testUpdate(Token token, long infoId, MediaType mediaType) {

		PostUpdate update = new PostUpdate();

		update.setInfoid(infoId);
		update.setCate_id("29");
		// 这里的城市id ,一定要和账户中的城市一致，而id则可以从58提供的文档上找
		update.setLocal_id("2054");
		update.setTitle("众泰Z700 2016款 1.8T 手动尊贵型--全网最实惠价+物超所值+清仓价");
		update.setContent("“颜值高”--外观好看、“有内涵”--配置很高、“胸怀宽广”--空间大。10万块买一辆车长超过5米，空间表现能跟奥迪A6L媲美的中级车，相信这对于大多数国内消费者而言都极具吸引力。除此之外众泰Z700还有电吸门、电动折叠屏幕等豪华配置，想不火都难。");
		update.setPhone("13655454545");
		update.setEmail("sefs@sef.com");
		update.setIm("541242010");

		String[] pics =
				{ "D:/data/test/timg.jpg"};
		update.setPic(pics);

		ParamXml paramVO = new ParamXml();
		// 必填选项
		paramVO.setBrand_text("众泰");
		paramVO.setBrand_value("419610");
		paramVO.setChexi_text("众泰Z700");
		paramVO.setChexi_value("900143");
		paramVO.setCarchexing_text("2016款 1.8T 手动尊贵型");
		paramVO.setCarchexing_value("910075");
		paramVO.setCheshenyanse_text("银色");// ??
		paramVO.setCheshenyanse_value("3"); // ??
		paramVO.setRundistance("6");
		paramVO.setMinPrice("11.98");
		paramVO.setBuytime_value("2017");
		paramVO.setBuytime_text("2017年");
		paramVO.setShangpaiyuefen_text("6月");
		paramVO.setShangpaiyuefen_value("515686");
		paramVO.setShangpainianyue("201706"); // 上牌年月
		paramVO.setShifoufufeifabu("0"); // 是否付费发布信息
		paramVO.setShifouyishou("0"); // 车辆是否已售
		paramVO.setGoblianxiren("田先生");
		// 必填默认
//		paramVO.setGuohufeiyong("553663"); // “553663”：包含过户费用 “553664”：不包含过户费用，
		paramVO.setApilaiyuan("1");
		paramVO.setApiedit("1");
		paramVO.setType("0");
		// 自由填充
//		paramVO.setZimu_text("A"); // ~
//		paramVO.setZimu_value("408783"); // ~
//		paramVO.setObjectType_text("轿车"); // ~
//		paramVO.setObjectType_value("1"); // ~
//		paramVO.setMadein_text("合资"); // ~
//		paramVO.setMadein_value("408852"); // ~
//		paramVO.setChexibieming_text("奥迪A3"); // ~
//		paramVO.setChexibieming_value("668468"); // ~
//		paramVO.setKucheid_text("288035"); // ?
//		paramVO.setKucheid_value("738318"); // ?
//		paramVO.setGearbox_text("自动"); // ~
//		paramVO.setGearbox_value("408822"); // ~
//		paramVO.setShangshishijian_text("2013"); // ~
//		paramVO.setShangshishijian_value("802393"); // ~
//		paramVO.setDisplacement_text("1.4"); // ~
//		paramVO.setDisplacement_value("409110");// ~
		// 选填
		paramVO.setErscpinpai("轿车");
		paramVO.setRundistanceqj("6_8");
		paramVO.setChelingqj("2017_2018");
		paramVO.setMinPriceqj("11_15");
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

		update.setParamVO(paramVO);

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
			token.setUid("19475933152263");
			token.setRefresh_token("5876228671f0d56664de508fe25592d1_v1");
			token.setAccess_token("ac25d95fba39b21af1a9e26cf4324ca_v1");
			token.setExpires_in("364");

			Token token1 = getToken(token);
//			testSend(token1, MediaType.MULTIPART_FORM_DATA);

			long infoId = 33742156815813L;
			testUpdate(token1, infoId, MediaType.MULTIPART_FORM_DATA);
//			testDelete(token1, infoId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
