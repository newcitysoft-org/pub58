/**   
 * 
 * @Title: PostUpdate.java 
 * @Project: 58gateway-parent
 * @Package: com.zuche.gateway.pojo 
 * @Description: TODO
 * @date: 2016年3月15日 下午7:46:40 
 * @version: V1.0   
 */
package com.renren.pub58.api.pojo;

/**
 * @ClassName: PostUpdate
 * @Description: 更新帖子pojo
 * @author: helong
 * @date: 2016年3月15日 下午7:46:40
 */
public class PostUpdate extends PostSend {

	/*帖子ID*/
	private long infoid;

	/**
	 * @return the infoid
	 */
	public long getInfoid() {
		return infoid;
	}

	/**
	 * @param infoid the infoid to set
	 */
	public void setInfoid(long infoid) {
		this.infoid = infoid;
	}

	

}
