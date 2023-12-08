package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {



    @Select("select * from dept")
    List<Dept> list();


    @Delete("delete from dept where id=#{id}")
    void delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time)values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("select * from dept where id=#{id}")
    Dept GetById(Integer id);

    @Update("update dept set name=#{name} where id=#{id} ")
    void update(Integer id, String name);
}
