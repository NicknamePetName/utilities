package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/emps")
@Slf4j
public class EmpController {


    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
                       ){
        log.info("分页查询员工信息，参数：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);


        PageBean pagebean = empService.page( page, pageSize,name,gender,begin,end);
        return Result.success(pagebean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除员工id：{}", ids);
        empService.delete(ids);
        return  Result.success();
    }

    @PostMapping
    public  Result insert(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);

        empService.insert(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询员工id：{}",id);
        Emp emp= empService.getById(id);


        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息：{}",emp);
        empService.update(emp);
        return Result.success();
    }

}
