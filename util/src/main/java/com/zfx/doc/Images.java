package com.zfx.doc;

/**
 * @author zhangfx
 * @date 2023/3/8
 */
public class Images {
	private String suffix;
	private String data;
	
	public Images() {
	}
	
	public Images(String suffix, String data) {
		this.suffix = suffix;
		this.data = data;
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
