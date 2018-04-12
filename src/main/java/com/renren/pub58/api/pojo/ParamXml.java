/**   
 * 
 * @Title: Xml.java 
 * @Project: 58gateway-parent
 * @Package: com.zuche.gateway.pojo 
 * @Description: TODO 
 * @date: 2016年3月16日 上午10:07:53 
 * @version: V1.0   
 */
package com.renren.pub58.api.pojo;

import java.net.URLEncoder;

/**
 * @ClassName: Xml
 * @Description: 单元参数格式 以下属于注意是否必填
 * @date: 2016年3月16日 上午10:07:53
 */
public class ParamXml {

	/* 字母，品牌归属字母 必填 */
	private String zimu_value;

	private String zimu_text;

	/* 品牌 必填 */
	private String brand_value;

	private String brand_text;

	/* 车系 必填 */
	private String chexi_value;

	private String chexi_text;

	/* 车辆类型 必填 */
	private String ObjectType_value;

	private String ObjectType_text;

	/* 车型 选填 */
	private String carchexing_value;

	private String carchexing_text;

	/* 产地 选填 */
	private String madein_value;

	private String madein_text;

	/* 车系别名 必填 */
	private String chexibieming_value;

	private String chexibieming_text;

	/* 排量 选填 */
	private String displacement_value;

	private String displacement_text;

	/* 变速器 选填 */
	private String gearbox_value;

	private String gearbox_text;

	/* 酷车车型编号 如果是匹配58二手车的车型的就有而且必填 选填 */
	private String kucheid_value;

	private String kucheid_text;

	/* 上市时间 选填 */
	private String shangshishijian_value;

	private String shangshishijian_text;

	/* 车身颜色 必填 */
	private String cheshenyanse_value;

	private String cheshenyanse_text;

	/* 自定义车型存储 20个字以内，不能填写特殊符号和电话号码 必填 */
	private String erscpinpai;

	/* 行驶里程 单位：万公里，最多2位整数和2位小数， 例如：3.5万公里,set前面的小数部分就可以了 必填 */
	private String rundistance;

	/* 行驶里程区间 选填 */
	private String rundistanceqj;

	/* 车龄区间 选填 */
	private String chelingqj;

	/* 价格 单位：万元，价格不能为0，最多3位整数和2位小数， 例如：10.8万元 必填 */
	private String MinPrice;

	/* 价格区间 选填 */
	private String MinPriceqj;

	/* 上牌年 1995年”---“1995” “1995年以前”---“1994” 必填 */
	private String buytime_value;

	private String buytime_text;

	/*
	 * 上牌月份
	 * 
	 * “1月”---“515681” “2月”---“515682” “3月”---“515683” “4月”---“515684”
	 * “5月”---“515685” “6月”---“515686” “7月”---“515687” “8月”---“515688”
	 * “9月”---“515689” “10月”---“515690” “11月”---“515691” “12月”---“515692”
	 * 
	 * 
	 * 
	 * 必填
	 */
	private String shangpaiyuefen_text;

	private String shangpaiyuefen_value;

	/*
	 * 是否定期4S店保养 此项没有，则为空 选填 “是”---“515673”， “否”---“515674”
	 */
	private String baoyang_value;

	private String baoyang_text;

	/*
	 * 事故情况 选填 如果“baoyang”为515673，切此项有内容有说明，则需要拼接到gobquzhi， “有”---“515712”，
	 * “无”---“515713” 如果此项内容无，则值为空即可。
	 */
	private String shiguqk_value;

	private String shiguqk_text;

	/* 事故描述 选填 */
	private String shigumiaoshu;

	/* 年检到期时间 选填 格式为“yyyy|MM”,例如“2009|8”或者“未检” */
	private String cjshijian;

	/* 交强险到期时间 选填 格式为“yyyy|MM”,例如“2009|8”或者“过保” */
	private String qxshijian;

	/* 商业险到期时间 选填 格式为“yyyy|MM”,例如“2009|8”或者“无商业险” 注意不能写过去时间 */
	private String syshijian;

	/* 行驶证图片 选填 */
	private String yczbpic;

	/* 原厂质保 必填 消保参数，默认传“525379” */
	private String yczhibao = "525379";

	/*
	 * 七天可退 vip选填 vip用户专属参数(非VIP值为空即可)，属于消保参数，如果存有在列表页，详情页会有消保标识
	 * “1”：包含七天可退，“0”：不包含七天可退
	 */
	private String qtkt;

	/* 消保属性 选填 标识信息是否是消保信息，默认传“0” */
	private String xbsx = "0";

	/* 上牌年月 必填 格式为“yyyyyMM”，例如“200908” */
	private String shangpainianyue;

	/* 是否付费发布信息 必填 默认传“0” */
	private String shifoufufeifabu = "0";

	/* 车辆是否已售 必填 默认传“0” */
	private String shifouyishou = "0";

	/* 排放标准 选填 默认值为空即可，该参数关联kucheid，由58API处理 */
	private String paifangbiaozhun;

	/*
	 * 是否包含过户费用 必填 “553663”：包含过户费用 “553664”：不包含过户费用， 默认传“553664”不包含过户费用，
	 * vip诚信车商也默认传“553663”包含过户费用
	 */
	private String guohufeiyong = "553663";

	/*
	 * 免费过户 vip选填 vip诚信车商如果支持免费过户传“1”，不支持传“0” 非vip用户及非诚信车商版都为空即可。
	 */
	private String mianfeiguohu;

	/* 是否高档车 选填 默认值为空即可，由58API处理 */
	private String shifougaodang;

	/*
	 * 车源类别 vip选填 如果是诚信车商必须传“525376”， 如果是诚信车商4s店切该车源为认证认证二手车传“525375，525376”
	 * 非vip用户及非诚信车商版都为空即可。
	 */
	private String cylb;

	/* 信息编号 必填 当前日期精确到秒的34进制 (字母用小写) */
	@SuppressWarnings("unused")
	private String xinxibianhao;

	/* 二手车网邻通版本 vip必填 默认传“0” */
	private String escwltv2 = "0";

	/* 其他电话 vip选填 非VIP用户为空即可。 */
	private String qitadianhua;

	/* 联系人 必填 2-6个字，不能填写电话和联系方式以及特殊符号 */
	private String goblianxiren;

	/* 网邻通别名 vip选填 */
	private String wanglintongbieming;

	/* 存储API第三方信息id 选填 存第三方的自己的信息id号 */
	private String apixinxiid;

	/* 存储API信息来源 必填 默认传“1” */
	private String apilaiyuan = "1";

	/* 存储API信息是否可编辑 必填 默认传“1” */
	private String apiedit = "1";

	/* 类型 必填 默认传“0” */
	private String type = "0";

	/* Vin码 必填 车架号 */
	private String Vin;

	/*
	 * 参数取值 必填 按照文档说明的“特殊的单元参数”说明进行拼接，必填的都需要拼接，选填的没有值可不拼接。
	 */
	private String gobquzhi;

	/**
	 * @return the apiedit
	 */
	public String getApiedit() {
		return apiedit;
	}

	/**
	 * @return the apilaiyuan
	 */
	public String getApilaiyuan() {
		return apilaiyuan;
	}

	/**
	 * @return the apixinxiid
	 */
	public String getApixinxiid() {
		return apixinxiid;
	}

	/**
	 * @return the cjshijian
	 */
	public String getCjshijian() {
		return cjshijian;
	}

	/**
	 * @return the cylb
	 */
	public String getCylb() {
		return cylb;
	}

	/**
	 * @return the erscpinpai
	 */
	public String getErscpinpai() {

		if (erscpinpai.length() > 20) {
			return erscpinpai.substring(0, 19);
		}
		return erscpinpai;
	}

	/**
	 * @return the escwltv2
	 */
	public String getEscwltv2() {
		return escwltv2;
	}

	/**
	 * @return the goblianxiren
	 */
	public String getGoblianxiren() {
		return goblianxiren;
	}

	/**
	 * @return the gobquzhi
	 */
	public String getGobquzhi() {
		return gobquzhi;
	}

	/**
	 * @return the guohufeiyong
	 */
	public String getGuohufeiyong() {
		return guohufeiyong;
	}

	/**
	 * @return the mianfeiguohu
	 */
	public String getMianfeiguohu() {
		return mianfeiguohu;
	}

	/**
	 * @return the minPrice
	 */
	public String getMinPrice() {
		return MinPrice;
	}

	/**
	 * @return the paifangbiaozhun
	 */
	public String getPaifangbiaozhun() {
		return paifangbiaozhun;
	}

	/**
	 * @return the qitadianhua
	 */
	public String getQitadianhua() {
		return qitadianhua;
	}

	/**
	 * @return the qtkt
	 */
	public String getQtkt() {
		return qtkt;
	}

	/**
	 * @return the qxshijian
	 */
	public String getQxshijian() {
		return qxshijian;
	}

	/**
	 * @return the rundistance
	 */
	public String getRundistance() {
		return rundistance;
	}

	/**
	 * @return the rundistanceqj
	 */
	public String getRundistanceqj() {
		return rundistanceqj;
	}

	/**
	 * @return the shangpainianyue
	 */
	public String getShangpainianyue() {
		return shangpainianyue;
	}

	/**
	 * @return the shifoufufeifabu
	 */
	public String getShifoufufeifabu() {
		return shifoufufeifabu;
	}

	/**
	 * @return the shifougaodang
	 */
	public String getShifougaodang() {
		return shifougaodang;
	}

	/**
	 * @return the shifouyishou
	 */
	public String getShifouyishou() {
		return shifouyishou;
	}

	/**
	 * @return the shigumiaoshu
	 */
	public String getShigumiaoshu() {
		return shigumiaoshu;
	}

	/**
	 * @return the syshijian
	 */
	public String getSyshijian() {
		return syshijian;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the vin
	 */
	public String getVin() {
		return Vin;
	}

	/**
	 * @return the wanglintongbieming
	 */
	public String getWanglintongbieming() {
		return wanglintongbieming;
	}

	/**
	 * @return the xbsx
	 */
	public String getXbsx() {
		return xbsx;
	}

	/**
	 * @return the xinxibianhao
	 */
	public String getXinxibianhao() {
		return Long.toString(System.currentTimeMillis() / 1000, 34);
	}

	/**
	 * @return the yczbpic
	 */
	public String getYczbpic() {
		return yczbpic;
	}

	/**
	 * @return the yczhibao
	 */
	public String getYczhibao() {
		return yczhibao;
	}

	/**
	 * @param apiedit
	 *            the apiedit to set
	 */
	public void setApiedit(String apiedit) {
		this.apiedit = apiedit;
	}

	/**
	 * @param apilaiyuan
	 *            the apilaiyuan to set
	 */
	public void setApilaiyuan(String apilaiyuan) {
		this.apilaiyuan = apilaiyuan;
	}

	/**
	 * @param apixinxiid
	 *            the apixinxiid to set
	 */
	public void setApixinxiid(String apixinxiid) {
		this.apixinxiid = apixinxiid;
	}

	/**
	 * @param cjshijian
	 *            the cjshijian to set
	 */
	public void setCjshijian(String cjshijian) {
		this.cjshijian = cjshijian;
	}

	/**
	 * @param cylb
	 *            the cylb to set
	 */
	public void setCylb(String cylb) {
		this.cylb = cylb;
	}

	/**
	 * @param erscpinpai
	 *            the erscpinpai to set
	 */
	public void setErscpinpai(String erscpinpai) {
		this.erscpinpai = erscpinpai;
	}

	/**
	 * @param escwltv2
	 *            the escwltv2 to set
	 */
	public void setEscwltv2(String escwltv2) {
		this.escwltv2 = escwltv2;
	}

	/**
	 * @param goblianxiren
	 *            the goblianxiren to set
	 */
	public void setGoblianxiren(String goblianxiren) {
		this.goblianxiren = goblianxiren;
	}

	/**
	 * @param gobquzhi
	 *            the gobquzhi to set
	 */
	public void setGobquzhi(String gobquzhi) {
		this.gobquzhi = gobquzhi;
	}

	/**
	 * @param guohufeiyong
	 *            the guohufeiyong to set
	 */
	public void setGuohufeiyong(String guohufeiyong) {
		this.guohufeiyong = guohufeiyong;
	}

	/**
	 * @param mianfeiguohu
	 *            the mianfeiguohu to set
	 */
	public void setMianfeiguohu(String mianfeiguohu) {
		this.mianfeiguohu = mianfeiguohu;
	}

	/**
	 * @param minPrice
	 *            the minPrice to set
	 */
	public void setMinPrice(String minPrice) {
		MinPrice = minPrice;
	}

	/**
	 * @param paifangbiaozhun
	 *            the paifangbiaozhun to set
	 */
	public void setPaifangbiaozhun(String paifangbiaozhun) {
		this.paifangbiaozhun = paifangbiaozhun;
	}

	/**
	 * @param qitadianhua
	 *            the qitadianhua to set
	 */
	public void setQitadianhua(String qitadianhua) {
		this.qitadianhua = qitadianhua;
	}

	/**
	 * @param qtkt
	 *            the qtkt to set
	 */
	public void setQtkt(String qtkt) {
		this.qtkt = qtkt;
	}

	/**
	 * @param qxshijian
	 *            the qxshijian to set
	 */
	public void setQxshijian(String qxshijian) {
		this.qxshijian = qxshijian;
	}

	/**
	 * @param rundistance
	 *            the rundistance to set
	 */
	public void setRundistance(String rundistance) {
		this.rundistance = rundistance;
	}

	/**
	 * @param rundistanceqj
	 *            the rundistanceqj to set
	 */
	public void setRundistanceqj(String rundistanceqj) {
		this.rundistanceqj = rundistanceqj;
	}

	/**
	 * @param shangpainianyue
	 *            the shangpainianyue to set
	 */
	public void setShangpainianyue(String shangpainianyue) {
		this.shangpainianyue = shangpainianyue;
	}

	/**
	 * @return the zimu_value
	 */
	public String getZimu_value() {
		return zimu_value;
	}

	/**
	 * @param zimu_value
	 *            the zimu_value to set
	 */
	public void setZimu_value(String zimu_value) {
		this.zimu_value = zimu_value;
	}

	/**
	 * @return the zimu_text
	 */
	public String getZimu_text() {
		return zimu_text;
	}

	/**
	 * @param zimu_text
	 *            the zimu_text to set
	 */
	public void setZimu_text(String zimu_text) {
		this.zimu_text = zimu_text;
	}

	/**
	 * @return the brand_value
	 */
	public String getBrand_value() {
		return brand_value;
	}

	/**
	 * @param brand_value
	 *            the brand_value to set
	 */
	public void setBrand_value(String brand_value) {
		this.brand_value = brand_value;
	}

	/**
	 * @return the brand_text
	 */
	public String getBrand_text() {
		return brand_text;
	}

	/**
	 * @param brand_text
	 *            the brand_text to set
	 */
	public void setBrand_text(String brand_text) {
		this.brand_text = brand_text;
	}

	/**
	 * @return the chexi_value
	 */
	public String getChexi_value() {
		return chexi_value;
	}

	/**
	 * @param chexi_value
	 *            the chexi_value to set
	 */
	public void setChexi_value(String chexi_value) {
		this.chexi_value = chexi_value;
	}

	/**
	 * @return the chexi_text
	 */
	public String getChexi_text() {
		return chexi_text;
	}

	/**
	 * @param chexi_text
	 *            the chexi_text to set
	 */
	public void setChexi_text(String chexi_text) {
		this.chexi_text = chexi_text;
	}

	/**
	 * @return the objectType_value
	 */
	public String getObjectType_value() {
		return ObjectType_value;
	}

	/**
	 * @param objectType_value
	 *            the objectType_value to set
	 */
	public void setObjectType_value(String objectType_value) {
		ObjectType_value = objectType_value;
	}

	/**
	 * @return the objectType_text
	 */
	public String getObjectType_text() {
		return ObjectType_text;
	}

	/**
	 * @param objectType_text
	 *            the objectType_text to set
	 */
	public void setObjectType_text(String objectType_text) {
		ObjectType_text = objectType_text;
	}

	/**
	 * @return the carchexing_value
	 */
	public String getCarchexing_value() {
		return carchexing_value;
	}

	/**
	 * @param carchexing_value
	 *            the carchexing_value to set
	 */
	public void setCarchexing_value(String carchexing_value) {
		this.carchexing_value = carchexing_value;
	}

	/**
	 * @return the carchexing_text
	 */
	public String getCarchexing_text() {
		return carchexing_text;
	}

	/**
	 * @param carchexing_text
	 *            the carchexing_text to set
	 */
	public void setCarchexing_text(String carchexing_text) {
		this.carchexing_text = carchexing_text;
	}

	/**
	 * @return the madein_value
	 */
	public String getMadein_value() {
		return madein_value;
	}

	/**
	 * @param madein_value
	 *            the madein_value to set
	 */
	public void setMadein_value(String madein_value) {
		this.madein_value = madein_value;
	}

	/**
	 * @return the madein_textd
	 */
	public String getMadein_text() {
		return madein_text;
	}

	/**
	 * @param madein_textd
	 *            the madein_textd to set
	 */
	public void setMadein_text(String madein_text) {
		this.madein_text = madein_text;
	}

	/**
	 * @return the chexibieming_value
	 */
	public String getChexibieming_value() {
		return chexibieming_value;
	}

	/**
	 * @param chexibieming_value
	 *            the chexibieming_value to set
	 */
	public void setChexibieming_value(String chexibieming_value) {
		this.chexibieming_value = chexibieming_value;
	}

	/**
	 * @return the chexibieming_text
	 */
	public String getChexibieming_text() {
		return chexibieming_text;
	}

	/**
	 * @param chexibieming_text
	 *            the chexibieming_text to set
	 */
	public void setChexibieming_text(String chexibieming_text) {
		this.chexibieming_text = chexibieming_text;
	}

	/**
	 * @return the displacement_value
	 */
	public String getDisplacement_value() {
		return displacement_value;
	}

	/**
	 * @param displacement_value
	 *            the displacement_value to set
	 */
	public void setDisplacement_value(String displacement_value) {
		this.displacement_value = displacement_value;
	}

	/**
	 * @return the displacement_text
	 */
	public String getDisplacement_text() {
		return displacement_text;
	}

	/**
	 * @param displacement_text
	 *            the displacement_text to set
	 */
	public void setDisplacement_text(String displacement_text) {
		this.displacement_text = displacement_text;
	}

	/**
	 * @return the gearbox_value
	 */
	public String getGearbox_value() {
		return gearbox_value;
	}

	/**
	 * @param gearbox_value
	 *            the gearbox_value to set
	 */
	public void setGearbox_value(String gearbox_value) {
		this.gearbox_value = gearbox_value;
	}

	/**
	 * @return the gearbox_text
	 */
	public String getGearbox_text() {
		return gearbox_text;
	}

	/**
	 * @param gearbox_text
	 *            the gearbox_text to set
	 */
	public void setGearbox_text(String gearbox_text) {
		this.gearbox_text = gearbox_text;
	}

	/**
	 * @return the kucheid_value
	 */
	public String getKucheid_value() {
		return kucheid_value;
	}

	/**
	 * @param kucheid_value
	 *            the kucheid_value to set
	 */
	public void setKucheid_value(String kucheid_value) {
		this.kucheid_value = kucheid_value;
	}

	/**
	 * @return the kucheid_text
	 */
	public String getKucheid_text() {
		return kucheid_text;
	}

	/**
	 * @param kucheid_text
	 *            the kucheid_text to set
	 */
	public void setKucheid_text(String kucheid_text) {
		this.kucheid_text = kucheid_text;
	}

	/**
	 * @return the shangshishijian_value
	 */
	public String getShangshishijian_value() {
		return shangshishijian_value;
	}

	/**
	 * @param shangshishijian_value
	 *            the shangshishijian_value to set
	 */
	public void setShangshishijian_value(String shangshishijian_value) {
		this.shangshishijian_value = shangshishijian_value;
	}

	/**
	 * @return the shangshishijian_text
	 */
	public String getShangshishijian_text() {
		return shangshishijian_text;
	}

	/**
	 * @param shangshishijian_text
	 *            the shangshishijian_text to set
	 */
	public void setShangshishijian_text(String shangshishijian_text) {
		this.shangshishijian_text = shangshishijian_text;
	}

	/**
	 * @return the cheshenyanse_value
	 */
	public String getCheshenyanse_value() {
		return cheshenyanse_value;
	}

	/**
	 * @param cheshenyanse_value
	 *            the cheshenyanse_value to set
	 */
	public void setCheshenyanse_value(String cheshenyanse_value) {
		this.cheshenyanse_value = cheshenyanse_value;
	}

	/**
	 * @return the cheshenyanse_text
	 */
	public String getCheshenyanse_text() {
		return cheshenyanse_text;
	}

	/**
	 * @param cheshenyanse_text
	 *            the cheshenyanse_text to set
	 */
	public void setCheshenyanse_text(String cheshenyanse_text) {
		this.cheshenyanse_text = cheshenyanse_text;
	}

	/**
	 * @return the chelingqj
	 */
	public String getChelingqj() {
		return chelingqj;
	}

	/**
	 * @param chelingqj
	 *            the chelingqj to set
	 */
	public void setChelingqj(String chelingqj) {
		this.chelingqj = chelingqj;
	}

	/**
	 * @return the minPriceqj
	 */
	public String getMinPriceqj() {
		return MinPriceqj;
	}

	/**
	 * @param minPriceqj
	 *            the minPriceqj to set
	 */
	public void setMinPriceqj(String minPriceqj) {
		MinPriceqj = minPriceqj;
	}

	/**
	 * @param shifoufufeifabu
	 *            the shifoufufeifabu to set
	 */
	public void setShifoufufeifabu(String shifoufufeifabu) {
		this.shifoufufeifabu = shifoufufeifabu;
	}

	/**
	 * @param shifougaodang
	 *            the shifougaodang to set
	 */
	public void setShifougaodang(String shifougaodang) {
		this.shifougaodang = shifougaodang;
	}

	/**
	 * @param shifouyishou
	 *            the shifouyishou to set
	 */
	public void setShifouyishou(String shifouyishou) {
		this.shifouyishou = shifouyishou;
	}

	/**
	 * @param shigumiaoshu
	 *            the shigumiaoshu to set
	 */
	public void setShigumiaoshu(String shigumiaoshu) {
		this.shigumiaoshu = shigumiaoshu;
	}

	/**
	 * @param syshijian
	 *            the syshijian to set
	 */
	public void setSyshijian(String syshijian) {
		this.syshijian = syshijian;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param vin
	 *            the vin to set
	 */
	public void setVin(String vin) {
		Vin = vin;
	}

	/**
	 * @param wanglintongbieming
	 *            the wanglintongbieming to set
	 */
	public void setWanglintongbieming(String wanglintongbieming) {
		this.wanglintongbieming = wanglintongbieming;
	}

	/**
	 * @param xbsx
	 *            the xbsx to set
	 */
	public void setXbsx(String xbsx) {
		this.xbsx = xbsx;
	}

	/**
	 * @param xinxibianhao
	 *            the xinxibianhao to set
	 */
	public void setXinxibianhao(String xinxibianhao) {
		this.xinxibianhao = xinxibianhao;
	}

	/**
	 * @return the buytime_value
	 */
	public String getBuytime_value() {
		return buytime_value;
	}

	/**
	 * @param buytime_value
	 *            the buytime_value to set
	 */
	public void setBuytime_value(String buytime_value) {
		this.buytime_value = buytime_value;
	}

	/**
	 * @return the buytime_text
	 */
	public String getBuytime_text() {
		return buytime_text;
	}

	/**
	 * @param buytime_text
	 *            the buytime_text to set
	 */
	public void setBuytime_text(String buytime_text) {
		this.buytime_text = buytime_text;
	}

	/**
	 * @return the shangpaiyuefen_text
	 */
	public String getShangpaiyuefen_text() {
		return shangpaiyuefen_text;
	}

	/**
	 * @param shangpaiyuefen_text
	 *            the shangpaiyuefen_text to set
	 */
	public void setShangpaiyuefen_text(String shangpaiyuefen_text) {
		this.shangpaiyuefen_text = shangpaiyuefen_text;
	}

	/**
	 * @return the shangpaiyuefen_value
	 */
	public String getShangpaiyuefen_value() {
		return shangpaiyuefen_value;
	}

	/**
	 * @param shangpaiyuefen_value
	 *            the shangpaiyuefen_value to set
	 */
	public void setShangpaiyuefen_value(String shangpaiyuefen_value) {
		this.shangpaiyuefen_value = shangpaiyuefen_value;
	}

	/**
	 * @return the baoyang_value
	 */
	public String getBaoyang_value() {
		return baoyang_value;
	}

	/**
	 * @param baoyang_value
	 *            the baoyang_value to set
	 */
	public void setBaoyang_value(String baoyang_value) {
		this.baoyang_value = baoyang_value;
	}

	/**
	 * @return the baoyang_text
	 */
	public String getBaoyang_text() {
		return baoyang_text;
	}

	/**
	 * @param baoyang_text
	 *            the baoyang_text to set
	 */
	public void setBaoyang_text(String baoyang_text) {
		this.baoyang_text = baoyang_text;
	}

	/**
	 * @return the shiguqk_value
	 */
	public String getShiguqk_value() {
		return shiguqk_value;
	}

	/**
	 * @param shiguqk_value
	 *            the shiguqk_value to set
	 */
	public void setShiguqk_value(String shiguqk_value) {
		this.shiguqk_value = shiguqk_value;
	}

	/**
	 * @return the shiguqk_text
	 */
	public String getShiguqk_text() {
		return shiguqk_text;
	}

	/**
	 * @param shiguqk_text
	 *            the shiguqk_text to set
	 */
	public void setShiguqk_text(String shiguqk_text) {
		this.shiguqk_text = shiguqk_text;
	}

	/**
	 * @param yczbpic
	 *            the yczbpic to set
	 */
	public void setYczbpic(String yczbpic) {
		this.yczbpic = yczbpic;
	}

	/**
	 * @param yczhibao
	 *            the yczhibao to set
	 */
	public void setYczhibao(String yczhibao) {
		this.yczhibao = yczhibao;
	}

	public static void main(String[] args) {
		System.out.println(URLEncoder.encode("abc"));
	}
}
