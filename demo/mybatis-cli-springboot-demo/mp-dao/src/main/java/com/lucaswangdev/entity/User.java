package com.lucaswangdev.entity;

import lombok.Data;

/**
* 用户表
* User
*/
@Data
public class User {

    /**
    * 主键
    * type BIGINT
    */
    private Long id;
    /**
    * 创建时间
    * type DATETIME
    */
    private java.util.Date gmtCreate;
    /**
    * 更新时间
    * type DATETIME
    */
    private java.util.Date gmtModified;
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

	// 分页-页数
	private Integer pageNo;

	// 分页-每页条数
	private Integer pageSize;
}