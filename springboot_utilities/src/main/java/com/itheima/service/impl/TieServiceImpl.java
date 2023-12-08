package com.itheima.service.impl;

import com.itheima.mapper.TieMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.Tie;
import com.itheima.service.TieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TieServiceImpl implements TieService {
    @Autowired
    private TieMapper tieMapper;

    @Override
    public void insert(Tie tie) {

        tieMapper.insert(tie);
    }


}
