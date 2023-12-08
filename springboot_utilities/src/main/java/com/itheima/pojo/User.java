package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer Id;
    private String  username;
    private Integer age;
    private Short gender;//1。男，2. 女
    private String clas;
    private Integer electricity;
    private Integer water;

    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
