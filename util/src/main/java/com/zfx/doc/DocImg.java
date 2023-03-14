package com.zfx.doc;

/**
 * @author zhangfx
 * @date 2023/3/8
 */
public class DocImg {
	/**
	 * 文档图片 id
	 */
	private String id;
	/**
	 * 图片后缀
	 */
	private String suffix;
	/**
	 * 图片base64字符串
	 */
	private String data;
	
	public DocImg() {
	}
	
	public DocImg(String id, String suffix, String data) {
		this.id = id;
		this.suffix = suffix;
		this.data = data;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
}
