package com.zfx.doc;

/**
 * @author zhangfx
 * @date 2023/3/8
 */
public class DocData {
	/**
	 * 项目名
	 */
	private String projectName;
	/**
	 * 计划工作
	 */
	private String workPlan;
	/**
	 * 计划投资
	 */
	private String capital;
	/**
	 * 资金来源
	 */
	private String capitalSource;
	/**
	 * 实施时间 年
	 */
	private String years;
	/**
	 * 实施时间 月
	 */
	private String month;
	/**
	 * 立项意义 内容
	 */
	private String data;
	/**
	 * 建设单位
	 */
	private String consUnit;
	/**
	 * 领导签字 图片Base64数据
	 */
	private DocImg img;
	/**
	 * 立项签字 年
	 */
	private String signYears;
	/**
	 * 立项签字 月
	 */
	private String signMonth;
	/**
	 * 立项签字 日
	 */
	private String signDay;
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getWorkPlan() {
		return workPlan;
	}
	
	public void setWorkPlan(String workPlan) {
		this.workPlan = workPlan;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	public String getCapitalSource() {
		return capitalSource;
	}
	
	public void setCapitalSource(String capitalSource) {
		this.capitalSource = capitalSource;
	}
	
	public String getYears() {
		return years;
	}
	
	public void setYears(String years) {
		this.years = years;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getConsUnit() {
		return consUnit;
	}
	
	public void setConsUnit(String consUnit) {
		this.consUnit = consUnit;
	}
	
	public DocImg getImg() {
		return img;
	}
	
	public void setImg(DocImg img) {
		this.img = img;
	}
	
	public String getSignYears() {
		return signYears;
	}
	
	public void setSignYears(String signYears) {
		this.signYears = signYears;
	}
	
	public String getSignMonth() {
		return signMonth;
	}
	
	public void setSignMonth(String signMonth) {
		this.signMonth = signMonth;
	}
	
	public String getSignDay() {
		return signDay;
	}
	
	public void setSignDay(String signDay) {
		this.signDay = signDay;
	}
}
