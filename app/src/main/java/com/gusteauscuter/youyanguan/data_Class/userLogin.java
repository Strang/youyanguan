package com.gusteauscuter.youyanguan.data_Class;

import java.io.Serializable;

/**用户登陆信息和状态类
 * Created by Ziqian on 2015/9/3.
 */
public class userLogin implements Serializable {


    String username;
    String password;
    private boolean isLogined;

    public userLogin(){
        this("","");
    }

    public userLogin(String username,String password){
        this(username, password, false);
    };

    public userLogin(String username,String password, boolean isLogined){
        this.username=username;
        this.password=password;
        this.isLogined=isLogined;
    };

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public boolean IsLogined(){
        return isLogined;
    }

}

