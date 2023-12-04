package com.w.controller;


import com.w.pojo.Result;
import com.w.utils.AliOSSUtils;
import com.w.utils.MultipartFileToFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

//    @RequestMapping("/upload/uploadThumbnail")
//    public String insertOneImageFile(HttpServletRequest request, HttpServletRequest response, HttpSession session){
//        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
//        MultipartFile multipartFile = multipartRequest.getFile("file");
//        assert multipartFile != null;
//        MultipartFileToFile.saveMultipartFile(multipartFile, "src/main/resources/static/images");
//        return MultipartFileToFile.saveMultipartFile(multipartFile, "target/classes/static/images");
//    }


    //本地存储文件
//    @PostMapping("/upload/uploadThumbnail")
//    public Result upload(MultipartFile image) throws IOException {
//        log.info("文件上传: {}",image);
//
//        //获取原始文件名
//        String originalFilename = image.getOriginalFilename();
//
//        //构造唯一的文件名（不能重复） --uuid（通用唯一标识码） 7b708925-8440-4069-b5da.txt
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//        log.info("新的文件名：{}",newFileName);
//
//
//        //将文件存储在服务器的磁盘目录中
//        image.transferTo(new File("G:\\java\\"+newFileName));
//
//        return Result.success();
//    }

//    @Autowired
//    private AliOSSUtils aliOSSUtils;
//
//    @PostMapping("/upload/uploadThumbnail")
//    public Result upload(MultipartFile image) throws IOException {
//        log.info("文件上传，文件名：{}", image.getOriginalFilename());
//
//        //调用阿里云OSS工具类进行文件上传
//        String url = aliOSSUtils.upload(image);
//        log.info("文件上传完成，文件访问的url：{}", url);
//
//        return Result.success(url);
//
//    }


}
