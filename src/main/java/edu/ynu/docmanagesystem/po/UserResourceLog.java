package edu.ynu.docmanagesystem.po;

import java.util.Date;

public class UserResourceLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resource_log.userId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resource_log.resourceId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Integer resourceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resource_log.time
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resource_log.operation
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private String operation;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resource_log.userId
     *
     * @return the value of user_resource_log.userId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resource_log.userId
     *
     * @param userid the value for user_resource_log.userId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resource_log.resourceId
     *
     * @return the value of user_resource_log.resourceId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Integer getResourceid() {
        return resourceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resource_log.resourceId
     *
     * @param resourceid the value for user_resource_log.resourceId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resource_log.time
     *
     * @return the value of user_resource_log.time
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resource_log.time
     *
     * @param time the value for user_resource_log.time
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resource_log.operation
     *
     * @return the value of user_resource_log.operation
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public String getOperation() {
        return operation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resource_log.operation
     *
     * @param operation the value for user_resource_log.operation
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }
}