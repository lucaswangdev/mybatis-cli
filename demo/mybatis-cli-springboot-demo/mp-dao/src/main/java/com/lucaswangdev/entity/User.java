package com.lucaswangdev.entity;

import lombok.Data;

/**
* 
* User
*/
@Data
public class User {

    /**
    * 
    * type INT
    */
    private Integer id;
    /**
    * 
    * type VARCHAR
    */
    private String userName;
    /**
    * 
    * type VARCHAR
    */
    private String sex;
    /**
    * 
    * type VARCHAR
    */
    private String address;
  
/** The above part of the comment is auto generated, the following part is written by the user, please do not delete this comment. */

	// 分页-页数
	private Integer pageNo;

	// 分页-每页条数
	private Integer pageSize;
}