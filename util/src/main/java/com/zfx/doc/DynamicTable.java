package com.zfx.doc;

/**
 * @author zhangfx
 * @date 2023/3/8
 */
public class DynamicTable {
	/**
	 * 审批单位
	 */
	private String approval;
	/**
	 * 审批内容
	 */
	private String approvalContent;
	/**
	 * 审批时间 年
	 */
	private String year;
	/**
	 * 审批时间 月
	 */
	private String month;
	/**
	 * 审批时间 日
	 */
	private String day;
	/**
	 * 审批签字图片对象
	 */
	private DocImg img;
	
	public String getApproval() {
		return approval;
	}
	
	public void setApproval(String approval) {
		this.approval = approval;
	}
	
	public String getApprovalContent() {
		return approvalContent;
	}
	
	public void setApprovalContent(String approvalContent) {
		this.approvalContent = approvalContent;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public DocImg getImg() {
		return img;
	}
	
	public void setImg(DocImg img) {
		this.img = img;
	}
}
