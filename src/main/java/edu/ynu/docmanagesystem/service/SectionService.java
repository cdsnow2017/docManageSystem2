package edu.ynu.docmanagesystem.service;

import java.util.Map;

public interface SectionService {

	/**
	 * description: 添加部门类别权限
	 * @param sectionId 部门id
	 * @param resourceTypeId 资源类别Id
	 * @param userAuthorityId 权限id
	 * @param isCascade 是否级联操作
	 */
	void addSectionResourceTypeAuthorization(Integer sectionId, Integer resourceTypeId, Integer userAuthorityId,
	        Boolean isCascade);

	/**
	 * description:删除部门类别权限
	 * @param sectionId 部门id
	 * @param resourceTypeId 资源类别Id
	 * @param userAuthorityId 权限id
	 * @param isCascade 是否级联操作 
	 */
	void deleteSectionResourceTypeAuthorization(Integer sectionId, Integer resourceTypeId, Integer userAuthorityId,
	        Boolean isCascade);

	Map<Object, Object> sectionCountStatistics();
	
	

}
