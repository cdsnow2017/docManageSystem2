package edu.ynu.docmanagesystem.po;

public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.roleId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Integer roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.describe
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private String describe;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.roleId
     *
     * @return the value of role.roleId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.roleId
     *
     * @param roleid the value for role.roleId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.describe
     *
     * @return the value of role.describe
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.describe
     *
     * @param describe the value for role.describe
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}