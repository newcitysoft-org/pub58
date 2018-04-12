package com.renren.pub58.api.serviceImpl;

import com.google.gson.Gson;
import com.renren.pub58.api.constant.Constants;
import com.renren.pub58.api.pojo.PostDelete;
import com.renren.pub58.api.pojo.PostSend;
import com.renren.pub58.api.pojo.PostUpdate;
import com.renren.pub58.api.pojo.ServiceResponse;
import com.renren.pub58.api.pojo.Token;
import com.renren.pub58.api.service.PostService;
import com.renren.pub58.api.util.CommonRequest;
import com.renren.pub58.api.util.StringUtil;
import com.renren.pub58.util.HttpClientUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: PostServiceImpl
 * @Description:
 * @date: 2016年3月16日 下午4:35:55
 */
public class PostServiceImpl implements PostService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PostServiceImpl.class);

	/**
	 * 如果有传递图片,那么mediaType则为MediaType.MULTIPART_FORM_DATA,否则设置为null
	 */
	@SuppressWarnings("static-access")
	@Override
	public ServiceResponse send(PostSend send, Token token, MediaType mediaType) {
		if (logger.isDebugEnabled()) {
			logger.debug("send(PostSend, MediaType) - start");
		}

//		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();
		Map<String, String> mvm = new HashMap<>();

		mvm.put("cate_id", send.getCate_id() != null ? send.getCate_id() : "");
		mvm.put("local_id", send.getLocal_id() != null ? send.getLocal_id() : "");
		mvm.put("title", send.getTitle() != null ? send.getTitle() : "");
		mvm.put("content", send.getContent() != null ? send.getContent() : "");
		mvm.put("phone", send.getPhone() != null ? send.getPhone() : "");
		mvm.put("email", send.getEmail() != null ? send.getEmail() : "");
		mvm.put("im", send.getIm() != null ? send.getIm() : "");

//		if (send.getPic() != null && send.getPic().length > 0) {
//			String[] pic = send.getPic();
//			for (int i = 0; i < pic.length; i++) {
//
//				FileSystemResource resource = new FileSystemResource(new File(pic[i], ""));
//				EncodedResource encRes = new EncodedResource(resource, "UTF-8");
//				FileSystemResource resource2 = (FileSystemResource) encRes.getResource();
//				mvm.put("pic" + i, resource2);
//
//			}
//		}

		mvm.put("paras", wrapParas(send));

		String time_sign = String.valueOf(System.currentTimeMillis());
		System.out.println(time_sign);

		mvm.put("time_sign", time_sign);
		mvm.put("client_id", String.valueOf(Constants.CLIENT_ID));
		mvm.put("client_secret", DigestUtils.md5Hex(Constants.CLIENT_SECRET + "openapi.58.com" + time_sign));
		mvm.put("58user_id", token.getUid());
		mvm.put("access_token", token.getAccess_token());
		String response = "";
		try {
			response = HttpClientUtil.doPost(Constants.URI_PREFIX + "gateway/postservice/send", mvm, "utf-8");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//String response = (String) CommonRequest.request("gateway/postservice/send", mediaType, mvm, HttpMethod.POST, String.class);

		Gson gson = new Gson();
		ServiceResponse serviceResponse = gson.fromJson(response, ServiceResponse.class);

		if (logger.isDebugEnabled()) {
			logger.debug("send(PostSend, MediaType) - end");
		}
		return serviceResponse;
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: update
	 * 
	 * @Description:
	 * 
	 * @param update
	 * 
	 * @return
	 * 
	 * @see com.zuche.gateway.service.PostService#update(com.zuche.gateway.pojo.
	 * PostUpdate)
	 */
	@SuppressWarnings(
		{ "unused", "static-access" })
	@Override
	public ServiceResponse update(PostUpdate update, Token token, MediaType mediaType) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(PostUpdate) - start");
		}

		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();
		mvm.add("infoid", String.valueOf(update.getInfoid()));

		mvm.add("cate_id", update.getCate_id() != null ? update.getCate_id() : "");
		mvm.add("local_id", update.getLocal_id() != null ? update.getLocal_id() : "");
		mvm.add("title", update.getTitle() != null ? update.getTitle() : "");

		mvm.add("content", update.getContent() != null ? update.getContent() : "");
		mvm.add("phone", update.getPhone() != null ? update.getPhone() : "");
		mvm.add("email", update.getEmail() != null ? update.getEmail() : "");
		mvm.add("im", update.getIm() != null ? update.getIm() : "");

		if (update.getPic() != null && update.getPic().length > 0) {
			String[] pic = update.getPic();
			for (int i = 0; i < pic.length; i++) {

				FileSystemResource resource = new FileSystemResource(new File(pic[i], ""));
				EncodedResource encRes = new EncodedResource(resource, "UTF-8");
				FileSystemResource resource2 = (FileSystemResource) encRes.getResource();
				mvm.add("pic" + i, resource2);

			}
		}

		mvm.add("paras", wrapParas(update));

		mvm.add("time_sign", String.valueOf(System.currentTimeMillis()));
		mvm.add("client_id", String.valueOf(Constants.CLIENT_ID));
		mvm.add("client_secret", Constants.getClientSecretMD5());
		mvm.add("58user_id", token.getUid());
		mvm.add("access_token", token.getAccess_token());

		String response = (String) CommonRequest.request("gateway/postservice/update", mediaType, mvm, HttpMethod.POST, String.class);
		Gson gson = new Gson();
		ServiceResponse serviceResponse = gson.fromJson(response, ServiceResponse.class);
		if (logger.isDebugEnabled()) {
			logger.debug("update(PostUpdate) - end");
		}
		return serviceResponse;
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: delete
	 * 
	 * @Description: 删除帖子
	 * 
	 * @param delete
	 * 
	 * @return
	 * 
	 * @see com.zuche.gateway.service.PostService#delete(com.zuche.gateway.pojo.
	 * PostDelete)
	 */
	@SuppressWarnings("static-access")
	@Override
	public ServiceResponse delete(PostDelete delete, Token token) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(PostDelete) - start");
		}

		CommonRequest commonRequest = new CommonRequest();
		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();
		mvm.add("infoid", String.valueOf(delete.getInfoid()));
		mvm.add("time_sign", String.valueOf(System.currentTimeMillis()));
		mvm.add("client_id", String.valueOf(Constants.CLIENT_ID));
		mvm.add("client_secret", Constants.getClientSecretMD5());
		mvm.add("58user_id", token.getUid());
		mvm.add("access_token", token.getAccess_token());

		String response = (String) CommonRequest.request("gateway/delservice/delete", null, mvm, HttpMethod.POST, String.class);
		Gson gson = new Gson();
		ServiceResponse serviceResponse = gson.fromJson(response, ServiceResponse.class);

		if (logger.isDebugEnabled()) {
			logger.debug("delete(PostDelete) - end");
		}
		return serviceResponse;
	}

	/**
	 * @Title: wrapParas
	 * @Description: 拼接paras参数
	 * @param send
	 * @return
	 * @return: Object
	 */
	private String wrapParas(PostSend send) {
		if (logger.isDebugEnabled()) {
			logger.debug("wrapParas(PostSend) - start");
		}

		String[] requiredFields = new String[19];

		requiredFields[0] = "zimu";
		requiredFields[1] = "brand";
		requiredFields[2] = "chexi";
		requiredFields[3] = "ObjectType";
		requiredFields[4] = "carchexing";
		requiredFields[5] = "madein";
		requiredFields[6] = "chexibieming";
		requiredFields[7] = "displacement";
		requiredFields[8] = "gearbox";
		requiredFields[9] = "kucheid";
		requiredFields[10] = "shangshishijian";
		requiredFields[11] = "cheshenyanse";
		requiredFields[12] = "rundistanceqj";
		requiredFields[13] = "chelingqj";
		requiredFields[14] = "MinPriceqj";
		requiredFields[15] = "buytime";
		requiredFields[16] = "shangpaiyuefen";
		requiredFields[17] = "baoyang";
		requiredFields[18] = "shiguqk";

		StringBuffer result = new StringBuffer();

		String gobquzhiStr = "<para name=\"gobquzhi\" value=\"" + StringUtil.getGobquzhiStr(send.getParamVO(), send.getLocal_id()) + "\"/>";

		String[] exceptFields =
			{ "gobquzhi" };

		result.append(StringUtil.wrapXmlString(send.getParamVO(), "", exceptFields)).append(gobquzhiStr).append("\n");

		if (logger.isDebugEnabled()) {
			logger.debug("wrapParas(PostSend) - end");
		}
		return result.toString();

	}

}
