package com.lucaswangdev.entity;

import lombok.Data;

/**
* 
* User
*/
@Data
public class User {

    /**
    * 主键
    * type INT
    */
    private Integer id;
    /**
    * 用户名
    * type VARCHAR
    */
    private String userName;
    /**
    * 性别
    * type VARCHAR
    */
    private String sex;
    /**
    * 地址
    * type VARCHAR
    */
    private String address;
  
/** The above part of the comment is auto generated, the following part is written by the user, please do not delete this comment. */

}