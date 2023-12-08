package com.itheima.mapper;


import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);


    //@Select("select * from emp")
    //Short必须大写
    public List<Emp> list(String name,Short gender,LocalDate begin,LocalDate end);

//    @Delete("delete from emp where id=")
    void delete(List<Integer> ids);


    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp login(Emp emp);

}
