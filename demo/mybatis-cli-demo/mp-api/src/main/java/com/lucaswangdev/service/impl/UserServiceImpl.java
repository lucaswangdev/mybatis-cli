package com.lucaswangdev.service.impl;

import com.github.pagehelper.PageHelper;
import com.lucaswangdev.entity.User;
import com.lucaswangdev.mapper.UserMapper;
import com.lucaswangdev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User selectById(Integer id) {
        return userMapper.query(id);
    }

    @Override
    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }


    @Override
    public Integer delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public List<User> queryByAddress(User user) {
        // 分页
        if(user.getPageNo() != null && user.getPageSize() != null){
            PageHelper.startPage(user.getPageNo(), user.getPageSize());
        }
        return userMapper.queryByAddress(user);
    }
}
