package com.lucaswangdev.mapper;

import com.lucaswangdev.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * UserMapper
 */
public interface UserMapper{
    /**
     * physical delete
     * @param id
     * @return
     */
    int deleteByPrimaryKey(@Param("id") Integer id);


    User selectByPrimaryKey(@Param("id") Integer id);


    /**
     * insert entity
     * @param user
     * @return
     */
    int insert(@Param("user") User user);

    /**
     * insert entity selective.
     * @param user
     * @return
     */
    int insertSelective(@Param("user") User user);


    /**
     * update
     * @param user
     * @return
     */
    int updateByPrimaryKey(@Param("user") User user);

    /**
     * update selective
     * @param user
     * @return
     */
    int updateByPrimaryKeySelective(@Param("user") User user);


/** The above part of the comment is auto generated, the following part is written by the user, please do not delete this comment. */

}
