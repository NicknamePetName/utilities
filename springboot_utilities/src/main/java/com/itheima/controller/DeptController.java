package com.itheima.controller;


import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("显示所有的部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        //这个PathVariable是来获取路径参数，给形参id的
        log.info("根据id删除指定部门数据:{}", id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        deptService.insert(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result GetById(@PathVariable Integer id){
        log.info("根据id查询部门:{}",id);
        Dept dept = deptService.GetById(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result update(Integer id,String name){
        log.info("根据id修改部门:{}",id);
        deptService.update(id, name);
        return Result.success();
    }
}
