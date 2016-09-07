package edu.ynu.docmanagesystem.mapperExtend;

import java.util.List;

import edu.ynu.docmanagesystem.po.Section;

public interface SectionExtendMapper {

	List<Section> findAllSubSectionsById(Integer sectionId);

	Integer selectDocCountOneSection(Integer sectionId);

}
