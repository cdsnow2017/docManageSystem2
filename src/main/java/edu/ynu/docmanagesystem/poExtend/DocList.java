package edu.ynu.docmanagesystem.poExtend;

public class DocList {
	private Integer resourceId;
	private String docName;
	private String userName;
	private String sectionName;
	private String time;
	private String resourceTypeDescribe;

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resouceId) {
		this.resourceId = resouceId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getResourceTypeDescribe() {
		return resourceTypeDescribe;
	}

	public void setResourceTypeDescribe(String resourceTypeDescribe) {
		this.resourceTypeDescribe = resourceTypeDescribe;
	}

}
