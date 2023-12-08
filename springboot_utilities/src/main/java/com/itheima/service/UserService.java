package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void insert(User user);

    void delete(List<Integer> ids);
}
