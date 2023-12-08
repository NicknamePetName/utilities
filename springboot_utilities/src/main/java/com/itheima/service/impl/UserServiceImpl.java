package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize,String name,Short gender,LocalDate begin,LocalDate end) {

        PageHelper.startPage(page, pageSize);
        List<User> userList = userMapper.list(name,gender,begin,end);
        Page<User> p = (Page<User>) userList;


        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void insert(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Override
    public void delete(List<Integer> ids) {
        userMapper.delete(ids);
    }
}
