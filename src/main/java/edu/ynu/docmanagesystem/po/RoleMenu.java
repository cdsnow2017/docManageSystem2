package edu.ynu.docmanagesystem.po;

public class RoleMenu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.roleId
     *
     * @mbggenerated Tue Sep 06 14:22:26 CST 2016
     */
    private Integer roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.menu
     *
     * @mbggenerated Tue Sep 06 14:22:26 CST 2016
     */
    private String menu;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.roleId
     *
     * @return the value of role_menu.roleId
     *
     * @mbggenerated Tue Sep 06 14:22:26 CST 2016
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.roleId
     *
     * @param roleid the value for role_menu.roleId
     *
     * @mbggenerated Tue Sep 06 14:22:26 CST 2016
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.menu
     *
     * @return the value of role_menu.menu
     *
     * @mbggenerated Tue Sep 06 14:22:26 CST 2016
     */
    public String getMenu() {
        return menu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.menu
     *
     * @param menu the value for role_menu.menu
     *
     * @mbggenerated Tue Sep 06 14:22:26 CST 2016
     */
    public void setMenu(String menu) {
        this.menu = menu == null ? null : menu.trim();
    }
}