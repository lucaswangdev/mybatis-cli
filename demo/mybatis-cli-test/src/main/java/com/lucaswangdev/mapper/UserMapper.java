package com.lucaswangdev.mapper;

import com.lucaswangdev.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

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
    int deleteByPrimaryKey(@Param("id") Long id);


    User selectByPrimaryKey(@Param("id") Long id);


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
     * batch insert entity
     * @param list
     */
    int insertBatch(@Param("list") List<User> list);

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


    /**
    * selectCount
    * @param user
    * @return
    */
    int selectCount(@Param("user") User user);

    /**
    * selectPage
    * @param user
    * @return
    */
    List<User> selectPage(@Param("user") User user, @Param("pageable") Pageable pageable);

/** The above part of the comment is auto generated, the following part is written by the user, please do not delete this comment. */

}
