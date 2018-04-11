package com.newcitysoft.crawl.pub58.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgent {
	public static List<String> userAgentList = new ArrayList<String>();
	public static List<String> userAgentMobileList = new ArrayList<String>();
	public static Random random = new Random();
	static {
		init();
	}
	public static volatile int index = random.nextInt(20);
	public static volatile int mobileIndex = random.nextInt(20);
	private static void init() {
		userAgentList.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
		userAgentList.add("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
		InputStream is = UserAgent.class.getClassLoader().getResourceAsStream("user_agent.txt");
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader input = new BufferedReader(ir);
		String line;
		try {
			while ((line = input.readLine()) != null) {
				userAgentList.add(line.trim());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		index = random.nextInt(userAgentList.size());
		userAgentMobileList.add("Dalvik/1.6.0 (Linux; U; Android 4.1.2; ZTE N909 Build/JZO54K)");
		userAgentMobileList.add("Dalvik/1.6.0 (Linux; U; Android 4.1.2; GT-I9300 Build/JZO54K)");
		is = UserAgent.class.getClassLoader().getResourceAsStream("user_agent_mobile.txt");
		ir = new InputStreamReader(is);
		input = new BufferedReader(ir);
		try {
			while ((line = input.readLine()) != null) {
				userAgentMobileList.add(line.trim());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String next() {
		index++;
		if (index >= userAgentList.size()) {
			index = index%userAgentList.size();
		}
		try {
			return formatUA(userAgentList.get(index));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return next();
		
	}
	public static String nextMobile() {
		mobileIndex++;
		if (mobileIndex >= userAgentMobileList.size()) {
			mobileIndex = index%userAgentMobileList.size();
		}
		try {
			return formatUA(userAgentMobileList.get(mobileIndex));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nextMobile();
		
	}
	private static Pattern pattern = Pattern.compile("\\$random\\{[\\wd\\d:,]+\\}");

	private static String formatUA(String ua) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Matcher m = pattern.matcher(ua);
		Set<String> set = new HashSet<String>();
		while (m.find()) {
			set.add(m.group());
		}
		for (String string : set) {
			String randomString = string.substring(8, string.length() - 1);
			String key = null;
			String rv = null;
			String[] conf = randomString.split(":");
			if (conf.length == 2) {
				key = conf[0];
				rv = conf[1];
			} else {
				rv = conf[0];
			}
			String[] v = rv.split(",");
			Integer vstart = 0;
			Integer vend = 0;
			if (v.length == 2) {
				vstart = Integer.parseInt(v[0]);
				vend = Integer.parseInt(v[1]);
			}else{
				vend =  Integer.parseInt(v[0]);
			}
			Integer value = random.nextInt((vend-vstart))+vstart;
			if(key!=null){
				if(map.containsKey(key)){
					value = map.get(key);
				}else{
					map.put(key, value);
				}
			}
			ua = ua.replaceAll("\\$random\\{"+randomString+"\\}", value+"");
		}
		return ua;
	}
	
}
