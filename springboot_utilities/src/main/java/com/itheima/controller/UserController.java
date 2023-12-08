package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ){
        log.info("分页查询员工信息，参数：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);


        PageBean pagebean = userService.page( page, pageSize,name,gender,begin,end);
        return Result.success(pagebean);
    }

    @PostMapping("/users")
    public  Result insert(@RequestBody User user){
        log.info("新增人员：{}",user);

        userService.insert(user);
        return Result.success();
    }

    @DeleteMapping("/users/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除员工id：{}", ids);
        userService.delete(ids);
        return  Result.success();
    }

}
