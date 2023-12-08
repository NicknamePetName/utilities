package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
public class LoadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {

        log.info("文件上传，文件名：{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件方位的url:{}",url);
        return Result.success(url);
    }
}
