package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize,String name,Short gender,LocalDate begin,LocalDate end);

    void delete(List<Integer> ids);

    void insert(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);

}
