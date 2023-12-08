package com.itheima.mapper;


import com.itheima.pojo.Tie;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TieMapper {


    void insert(Tie tie);
}
