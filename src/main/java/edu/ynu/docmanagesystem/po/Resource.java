package edu.ynu.docmanagesystem.po;

import java.util.Date;

public class Resource {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.resourceId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Integer resourceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.resourceTypeId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Integer resourcetypeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.userId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.description
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.formName
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private String formname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.originalfilename
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private String originalfilename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.size
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Double size;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.time
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.readNum
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Integer readnum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.downloadNum
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Integer downloadnum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.resourceId
     *
     * @return the value of resource.resourceId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Integer getResourceid() {
        return resourceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.resourceId
     *
     * @param resourceid the value for resource.resourceId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.resourceTypeId
     *
     * @return the value of resource.resourceTypeId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Integer getResourcetypeid() {
        return resourcetypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.resourceTypeId
     *
     * @param resourcetypeid the value for resource.resourceTypeId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setResourcetypeid(Integer resourcetypeid) {
        this.resourcetypeid = resourcetypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.userId
     *
     * @return the value of resource.userId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.userId
     *
     * @param userid the value for resource.userId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.description
     *
     * @return the value of resource.description
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.description
     *
     * @param description the value for resource.description
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.formName
     *
     * @return the value of resource.formName
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public String getFormname() {
        return formname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.formName
     *
     * @param formname the value for resource.formName
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setFormname(String formname) {
        this.formname = formname == null ? null : formname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.originalfilename
     *
     * @return the value of resource.originalfilename
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public String getOriginalfilename() {
        return originalfilename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.originalfilename
     *
     * @param originalfilename the value for resource.originalfilename
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setOriginalfilename(String originalfilename) {
        this.originalfilename = originalfilename == null ? null : originalfilename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.size
     *
     * @return the value of resource.size
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Double getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.size
     *
     * @param size the value for resource.size
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setSize(Double size) {
        this.size = size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.time
     *
     * @return the value of resource.time
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.time
     *
     * @param time the value for resource.time
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.readNum
     *
     * @return the value of resource.readNum
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Integer getReadnum() {
        return readnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.readNum
     *
     * @param readnum the value for resource.readNum
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.downloadNum
     *
     * @return the value of resource.downloadNum
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Integer getDownloadnum() {
        return downloadnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.downloadNum
     *
     * @param downloadnum the value for resource.downloadNum
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setDownloadnum(Integer downloadnum) {
        this.downloadnum = downloadnum;
    }
}