package com.itheima.service;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;

import java.util.List;

public interface DeptService {
    public List<Dept> list() ;

    void delete(Integer id);

    void insert(Dept dept);

    Dept GetById(Integer id);

    void update(Integer id, String name);

    //查询全部部门数据

}
