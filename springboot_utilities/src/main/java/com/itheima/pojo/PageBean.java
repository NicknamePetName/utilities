package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;
    private List rows;
}
