package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.DeptService;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize,String name,Short gender,LocalDate begin,LocalDate end) {

        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) empList;


        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
       return empMapper.getById(id);

    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {

        return empMapper.login(emp);
    }
}
