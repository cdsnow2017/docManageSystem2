package edu.ynu.docmanagesystem.po;

public class Userauthority {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userAuthority.userAuthorityId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private Integer userauthorityid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userAuthority.userAuthorityDescribe
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    private String userauthoritydescribe;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userAuthority.userAuthorityId
     *
     * @return the value of userAuthority.userAuthorityId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public Integer getUserauthorityid() {
        return userauthorityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userAuthority.userAuthorityId
     *
     * @param userauthorityid the value for userAuthority.userAuthorityId
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setUserauthorityid(Integer userauthorityid) {
        this.userauthorityid = userauthorityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userAuthority.userAuthorityDescribe
     *
     * @return the value of userAuthority.userAuthorityDescribe
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public String getUserauthoritydescribe() {
        return userauthoritydescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userAuthority.userAuthorityDescribe
     *
     * @param userauthoritydescribe the value for userAuthority.userAuthorityDescribe
     *
     * @mbggenerated Sat Sep 17 21:42:43 CST 2016
     */
    public void setUserauthoritydescribe(String userauthoritydescribe) {
        this.userauthoritydescribe = userauthoritydescribe == null ? null : userauthoritydescribe.trim();
    }
}