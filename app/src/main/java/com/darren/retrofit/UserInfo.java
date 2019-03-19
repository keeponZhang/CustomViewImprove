package com.darren.retrofit;

/**
 * Created by hcDarren on 2017/12/16.
 */

public class UserInfo {
    public String userName;
    public String userSex;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userSex + '\'' +
                '}';
    }
}
