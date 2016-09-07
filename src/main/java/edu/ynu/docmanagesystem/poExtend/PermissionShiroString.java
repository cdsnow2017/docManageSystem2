package edu.ynu.docmanagesystem.poExtend;

public class PermissionShiroString {

	private Integer resourceTypeId;

	private Integer userAuthorityId;

	public Integer getResourceType() {
		return resourceTypeId;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceTypeId = resourceType;
	}

	public Integer getUserAuthorityId() {
		return userAuthorityId;
	}

	public void setUserAuthorityId(Integer userAuthorityId) {
		this.userAuthorityId = userAuthorityId;
	}

	@Override
	public String toString() {
		return resourceTypeId + ":" + userAuthorityId;
	}

}
