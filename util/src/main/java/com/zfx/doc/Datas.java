package com.zfx.doc;

/**
 * @author zhangfx
 * @date 2023/3/8
 */
public class Datas {
	private String key;
	private Images images;
	
	public Datas() {
	}
	
	public Datas(String key, Images images) {
		this.key = key;
		this.images = images;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public Images getImages() {
		return images;
	}
	
	public void setImages(Images images) {
		this.images = images;
	}
}
