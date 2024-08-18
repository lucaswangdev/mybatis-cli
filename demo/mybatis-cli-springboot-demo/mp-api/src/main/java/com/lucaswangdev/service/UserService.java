package com.lucaswangdev.service;


import com.lucaswangdev.entity.User;
import java.util.List;

public interface UserService {
    // 更加id查询
    User selectById(Long id);

    // 插入数据
    Integer insert(User user);

    // 更新操作
    Integer updateByPrimaryKeySelective(User user);

    // 删除数据
    Integer delete(Long id);

    // 通过地址查询用户
    List<User> queryByAddress(User user);

}
