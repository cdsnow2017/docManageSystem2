package edu.ynu.docmanagesystem.mapper;

import edu.ynu.docmanagesystem.po.UserResourceLog;
import edu.ynu.docmanagesystem.po.UserResourceLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserResourceLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource_log
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    int countByExample(UserResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource_log
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    int deleteByExample(UserResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource_log
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    int insert(UserResourceLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource_log
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    int insertSelective(UserResourceLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource_log
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    List<UserResourceLog> selectByExample(UserResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource_log
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserResourceLog record, @Param("example") UserResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_resource_log
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    int updateByExample(@Param("record") UserResourceLog record, @Param("example") UserResourceLogExample example);
}