package com.itheima.mapper;


import com.itheima.pojo.Emp;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UserMapper {

    List<User> list(String name, Short gender, LocalDate begin, LocalDate end);

    @Insert("insert into user (username, age, gender, class, electricity,water , create_time, update_time) " +
            "values (#{username},#{age},#{gender},#{class},#{electricity},#{water},#{createTime},#{updateTime})")
    void insert(User user);

    void delete(List<Integer> ids);
}
