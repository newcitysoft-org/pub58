package com.renren.pub58.api.service;

import com.renren.pub58.api.pojo.PostDelete;
import com.renren.pub58.api.pojo.PostSend;
import com.renren.pub58.api.pojo.PostUpdate;
import com.renren.pub58.api.pojo.ServiceResponse;
import com.renren.pub58.api.pojo.Token;
import org.springframework.http.MediaType;

/**
 * @ClassName: PostService
 * @Description: TODO
 * @author: helong
 * @date: 2016年3月15日 下午7:32:56
 */
public interface PostService {

	/**
	 * 
	 * @Title: send
	 * @Description: 发布帖子
	 * @param send
	 * @return
	 * @return: ServiceResponse
	 */
	public ServiceResponse send(PostSend send, Token token, MediaType mediaType);

	/**
	 * 
	 * @Title: update
	 * @Description: 修改帖子
	 * @param update
	 * @return
	 * @return: ServiceResponse
	 */
	public ServiceResponse update(PostUpdate update, Token token, MediaType mediaType);

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除帖子
	 * @param delete
	 * @return
	 * @return: ServiceResponse
	 */
	public ServiceResponse delete(PostDelete delete, Token token);

}
