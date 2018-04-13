package com.renren.pub58.api.pojo;


/**
 * @ClassName: PostSend
 * @Description: 发布帖子pojo
 * @author: helong
 * @date: 2016年3月15日 下午7:37:32
 */
public class PostSend {

	/* 发布类别 */
	private String cate_id;

	/* 发布地区 */
	private String local_id;

	/* 帖子标题 */
	private String title;

	/* 帖子内容 */
	private String content;

	/* 联系电话 */
	private String phone;

	/* 电子邮箱 */
	private String email;

	/* QQ或msn */
	private String im;

	/* 图片 */
	private String[] pic;

	/* 单元参数 */
	private String paras;

	private ParamXml paramVO;

	private ParamXml xml;

	/**
	 * @return the xml
	 */
	public ParamXml getXml() {
		return xml;
	}

	/**
	 * @return the paramVO
	 */
	public ParamXml getParamVO() {
		return paramVO;
	}

	/**
	 * @param paramVO
	 *            the paramVO to set
	 */
	public void setParamVO(ParamXml paramVO) {
		this.paramVO = paramVO;
	}

	/**
	 * @param xml
	 *            the xml to set
	 */
	public void setXml(ParamXml xml) {
		this.xml = xml;
	}

	/**
	 * @return the cate_id
	 */
	public String getCate_id() {
		return cate_id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the im
	 */
	public String getIm() {
		return im;
	}

	/**
	 * @return the local_id
	 */
	public String getLocal_id() {
		return local_id;
	}

	/**
	 * @return the paras
	 */
	public String getParas() {
		return paras;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param cate_id
	 *            the cate_id to set
	 */
	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param im
	 *            the im to set
	 */
	public void setIm(String im) {
		this.im = im;
	}

	/**
	 * @param local_id
	 *            the local_id to set
	 */
	public void setLocal_id(String local_id) {
		this.local_id = local_id;
	}

	/**
	 * @param paras
	 *            需要传递一个对象过来 ,然后拼接xml再拼接整个string字符串
	 */
	public void setParas(String paras) {
		this.paras = paras;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the pic
	 */
	public String[] getPic() {
		return pic;
	}

	/**
	 * @param pic
	 *            the pic to set
	 */
	public void setPic(String[] pic) {
		this.pic = pic;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
