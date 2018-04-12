/**   
 * 
 * @Title: StringUtil.java 
 * @Project: 58gateway-parent
 * @Package: com.zuche.gateway.util 
 * @Description: TODO
 * @date: 2016年3月15日 下午5:44:08 
 * @version: V1.0   
 */
package com.renren.pub58.api.util;

import com.renren.pub58.api.pojo.ParamXml;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: StringUtil
 * @Description:
 * @author: helong
 * @date: 2016年3月15日 下午5:44:08
 */
public class StringUtil {

	@SuppressWarnings("rawtypes")
	public static String getUrlParamByParamName(String str, String param) {

		String aid = str;
		Pattern p = Pattern.compile("(\\?|&+)(.+?)=([^&]*)");
		Matcher m = p.matcher(aid);
		HashMap<String, String> map = new HashMap<String, String>();
		String returnVallue = "";
		while (m.find()) {
			map.put(m.group(2), m.group(3));
			// System.out.println(m.group(2) + "=" + m.group(3));
		}

		for (Iterator ite = map.entrySet().iterator(); ite.hasNext();) {
			Map.Entry entry = (Map.Entry) ite.next();
			if (param.equals(entry.getKey())) {
				returnVallue = (String) entry.getValue();
			}

		}
		return returnVallue;

	}

	/**
	 * 
	 * @Title: wrapXmlString
	 * @Description: 根据对象包装成xml字符串
	 * @param obj
	 * @param outerStr
	 *            xml外包围字符串,如没有可以为空串,为空则不在外层添加任何字符
	 * @param exceptFields
	 *            需要去除的字段,如没有,可以为空
	 * @return
	 * @return: String
	 */
	public static <T> String wrapXmlString(T obj, String outerStr, String[] exceptFields) {

		Class<? extends Object> clazz = obj.getClass();

		Field[] fields = clazz.getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		StringBuffer sbResult = new StringBuffer();

		boolean flag = false;
		try {
			for (Field field : fields) {

				// 去除不包含的属性
				if (exceptFields != null) {
					for (String except : exceptFields) {

						if (except.equals(field.getName())) {
							flag = true;
							break;
						}

					}
				}

				if (flag) {
					flag = false;
					continue;
				}

				if (field.getName().indexOf("_text") != -1) {
					// 包括 text属性的不处理　
					continue;
				}

				else {
					String upperFieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1, field.getName().length());
					Method method = clazz.getDeclaredMethod("get" + upperFieldName);
					Object invoke = method.invoke(obj);
					String fieldName = field.getName();
					if (fieldName.indexOf("_value") != -1) {
						fieldName = fieldName.substring(0, fieldName.length() - 6);
					}

					sb.append("<para name=").append("\"").append(fieldName).append("\"").append(" value=").append("\"").append(invoke == null ? "" : invoke).append("\"")
							.append(" />").append("\n");
				}

			}

			if (outerStr.equals("")) {
				sbResult.append(sb);
			}
			else {
				sbResult.append("<" + outerStr + ">").append("\n").append(sb).append("</" + outerStr + ">");

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		// System.out.println(sbResult.toString());
		return sbResult.toString();
	}

	/**
	 * 
	 * @Title: getGobquzhiStr
	 * @Description: 拼接 gobquzhi字符串
	 * @param xml
	 * @param localId
	 * @return
	 * @return: String
	 */
	public static String getGobquzhiStr(ParamXml xml, String localId) {

		StringBuffer sb = new StringBuffer();

		try {

			sb.append("zimu=").append(URLEncoder.encode(xml.getZimu_text() != null ? xml.getZimu_text() : "", "UTF-8")).append("&amp;");
			sb.append("brand=").append(URLEncoder.encode(xml.getBrand_text() != null ? xml.getBrand_text() : "", "UTF-8")).append("&amp;");
			sb.append("chexi=").append(URLEncoder.encode(xml.getChexi_text() != null ? xml.getChexi_text() : "", "UTF-8")).append("&amp;");
			sb.append("objecttype=").append(URLEncoder.encode(xml.getObjectType_text() != null ? xml.getObjectType_text() : "", "UTF-8")).append("&amp;");
			sb.append("carchexing=").append(URLEncoder.encode(xml.getCarchexing_text() != null ? xml.getCarchexing_text() : "", "UTF-8")).append("&amp;");
			sb.append("madein=").append(URLEncoder.encode(xml.getMadein_text() != null ? xml.getMadein_text() : "", "UTF-8")).append("&amp;");
			sb.append("chexibieming=").append(URLEncoder.encode(xml.getChexibieming_text() != null ? xml.getChexibieming_text() : "", "UTF-8")).append("&amp;");
			sb.append("displacement=").append(URLEncoder.encode(xml.getDisplacement_text() != null ? xml.getDisplacement_text() : "", "UTF-8")).append("&amp;");
			sb.append("gearbox=").append(URLEncoder.encode(xml.getGearbox_text() != null ? xml.getGearbox_text() : "", "UTF-8")).append("&amp;");
			sb.append("kucheid=").append(URLEncoder.encode(xml.getKucheid_text() != null ? xml.getKucheid_text() : "", "UTF-8")).append("&amp;");
			sb.append("shangshishijian=").append(URLEncoder.encode(xml.getShangshishijian_text() != null ? xml.getShangshishijian_text() : "", "UTF-8")).append("&amp;");
			sb.append("cheshenyanse=").append(URLEncoder.encode(xml.getCheshenyanse_text() != null ? xml.getCheshenyanse_text() : "", "UTF-8")).append("&amp;");
			sb.append("rundistanceqj=").append(URLEncoder.encode(xml.getRundistanceqj() != null ? xml.getRundistanceqj() : "", "UTF-8")).append("&amp;");
			sb.append("chelingqj=").append(URLEncoder.encode(xml.getChelingqj() != null ? xml.getChelingqj() : "", "UTF-8")).append("&amp;");
			sb.append("minpriceqj=").append(URLEncoder.encode(xml.getMinPriceqj() != null ? xml.getMinPriceqj() : "", "UTF-8")).append("&amp;");
			sb.append("buytime=").append(URLEncoder.encode(xml.getBuytime_text() != null ? xml.getBuytime_text() : "", "UTF-8")).append("&amp;");
			sb.append("shangpaiyuefen=").append(URLEncoder.encode(xml.getShangpaiyuefen_text() != null ? xml.getShangpaiyuefen_text() : "", "UTF-8")).append("&amp;");
			sb.append("baoyang=").append(URLEncoder.encode(xml.getBaoyang_text() != null ? xml.getBaoyang_text() : "", "UTF-8")).append("&amp;");

			String shiguqk = xml.getShiguqk_text();
			String baoyang_value = xml.getBaoyang_value();

			if (baoyang_value != null && shiguqk != null) {
				if (baoyang_value.equals("515673") && !shiguqk.equals("")) {
					sb.append("shiguqk=").append(URLEncoder.encode(shiguqk, "UTF-8")).append("&amp;");
				}
			}

		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return sb.append("cateapplyed=29&amp;localapplyed=").append(localId).toString();

	}

	/**
	 * 
	 * @Title: getExpiresMills
	 * @Description: 得到增加天数后的毫秒数
	 * @param mount
	 * @return
	 * @return: long
	 */
	public static long getExpiresMills(int mount) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, mount);
		return cal.getTimeInMillis();
	}

}
