package edu.ynu.docmanagesystem.mapperExtend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.ynu.docmanagesystem.poExtend.DocDetail;
import edu.ynu.docmanagesystem.poExtend.DocList;

public interface DocExtendMapper {

	List<DocList> findAllresouceList(@Param("sectionId") Integer sectionId, @Param("resouceType") Integer resouceType);

	void updateViewCount(Integer resouceId);

	DocDetail findDocDetailById(Integer resouceId);

	Object findSwfFileById(Integer resouceId);
	
	Integer findResourceTypeByResourceId(Integer resourceId);
	
	Object findDocFileById(Integer resourceId);
	
	String findDocNameById(Integer resourceId);
}
