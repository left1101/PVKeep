package com.pvkeep.wjdh.common.entity;

/**
 * Created by Admin on 2016/10/15.
 */
public class UserVo {

    String userId; // 用户ID
    String userName; // 用户名
    String password; // 用户密码
    String real_name;//汉字姓名
    String haedImageUrl; // 头像地址
    String tenantId;

    public UserVo(String userId, String userName, String password, String real_name, String haedImageUrl, String tenantId) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.real_name = real_name;
        this.haedImageUrl = haedImageUrl;
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getHaedImageUrl() {
        return haedImageUrl;
    }

    public void setHaedImageUrl(String haedImageUrl) {
        this.haedImageUrl = haedImageUrl;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", real_name='" + real_name + '\'' +
                ", haedImageUrl='" + haedImageUrl + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}
