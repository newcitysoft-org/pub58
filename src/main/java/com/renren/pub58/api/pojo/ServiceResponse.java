/**   
 * 
 * @Title: Response58.java 
 * @Project: 58gateway-parent
 * @Package: com.zuche.gateway.pojo 
 * @Description: TODO
 * @date: 2016年3月15日 下午1:38:07 
 * @version: V1.0   
 */
package com.renren.pub58.api.pojo;


/**
 * @ClassName: Response58
 * @Description: 接口请求返回结果
 * @date: 2016年3月15日 下午1:38:07
 */
public class ServiceResponse {

	/*
	 * 如有错误，则格式为{"error":"invalid_client","error_description":"invalid user auth"
	 * }
	 */
	private String error;

	private String errorDescription;

	/* gateway_success为0的时候表示接口业务调用失败，属于业务级别的失败，同时返回一个字段叫errmsg，是错误说明 */
	private String errmsg;

	/*
	 * 如正确，则格式为{"gateway_success":"1","infoid":"14961028292994","status":"1","url"
	 * :"http://bj.58.com/zufang/11111111111x.html"}
	 * gateway_success为1的时候表示接口业务调用成功，同时还会返回一些业务参数
	 */
	private String gatewaySuccess;

	/* 发布成功后生成的信息编号。如果失败，则返回为0 */
	private String infoid;

	/* 发布成功后的状态。1代表成功、3代表敏感。如果失败 */
	private String status;

	private String url;

	/**/
	private String apimsg;

	/**
	 * @return the apimsg
	 */
	public String getApimsg() {
		return apimsg;
	}

	/**
	 * @param apimsg
	 *            the apimsg to set
	 */
	public void setApimsg(String apimsg) {
		this.apimsg = apimsg;
	}

	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @return the gatewaySuccess
	 */
	public String getGatewaySuccess() {
		return gatewaySuccess;
	}

	/**
	 * @return the infoid
	 */
	public String getInfoid() {
		return infoid;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param errmsg
	 *            the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @param errorDescription
	 *            the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * @param gatewaySuccess
	 *            the gatewaySuccess to set
	 */
	public void setGatewaySuccess(String gatewaySuccess) {
		this.gatewaySuccess = gatewaySuccess;
	}

	/**
	 * @param infoid
	 *            the infoid to set
	 */
	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public static void main(String[] args) {
		
		System.out.println(Long.toString(System.currentTimeMillis()/1000, 34));
	}
}
