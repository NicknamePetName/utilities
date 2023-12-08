package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.pojo.Tie;
import com.itheima.service.TieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tie")
@CrossOrigin
@Slf4j
public class TieController {

    @Autowired
    private TieService tieService;

    @PostMapping("/insert")
    public Result insert(@RequestBody Tie tie){
        log.info("新增员工：{}",tie);

        tieService.insert(tie);
        return Result.success();
    }


}
