package com.example.demo.QSH;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//接收客户端文件的接口
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@RestController
public class FileUploadController {
    //文件存到本机的目录
    private static final String UPLOAD_DIR = "C:/Users/11230/Desktop/2";

    @PostMapping("/upload")
    public ApiResponse<String> uploadFile(@RequestParam("file") MultipartFile file){
        if (file.isEmpty())
            return new ApiResponse<>(404,"没找到");

        // 限制类型
        String contentType = file.getContentType();
//        System.out.println(contentType);
        if (!contentType.equals("image/jpeg") && !contentType.equals("image/png"))
            return new ApiResponse<>(400,"类型不匹配");

        // 限制1MB
        if (file.getSize() > 1024*1024)
            return new ApiResponse<>(400,"文件>1MB");

        try {
            /*提取的文件上传到指定目录*/
            File up = new File(UPLOAD_DIR,file.getOriginalFilename());
            file.transferTo(up);
            //成功
            return new ApiResponse<>(200,"提取文件到:" + UPLOAD_DIR);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500,"提取失败");
        }
    }
}