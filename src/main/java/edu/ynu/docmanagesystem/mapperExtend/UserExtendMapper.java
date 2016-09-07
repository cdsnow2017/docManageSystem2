package edu.ynu.docmanagesystem.mapperExtend;

import java.util.List;

import edu.ynu.docmanagesystem.po.Section;
import edu.ynu.docmanagesystem.poExtend.PermissionShiroString;
import edu.ynu.docmanagesystem.poExtend.SectionReourceTypeAuthorizationList;

public interface UserExtendMapper {

	List<PermissionShiroString> findShiroPermissionById(Integer sectionId);

	Section findSectionByUserId(Integer userId);
	
	Integer selectOperationCountOneUser(Integer userId, String operation);
	
	List<Integer> selectAllUserId();
	
	
	List<SectionReourceTypeAuthorizationList> findSectionReourceTypeAuthorizationList();

}
