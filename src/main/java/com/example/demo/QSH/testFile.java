//package com.example.demo.QSH;
//
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//import java.io.File;
//
//public class testFile {
//
//    public static void main(String[] args) throws Exception {
//        // 创建一个HttpClient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        // 创建一个HttpPost对象，指定上传的URL
//        HttpPost httpPost = new HttpPost("http://localhost:8080/upload");
//
//        // 创建一个MultipartEntityBuilder对象，用于构建上传的文件实体
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//
//        // 添加一个文件实体，指定文件名和内容类型
//        File file = new File("test.jpg"); // 这里你需要修改为你要上传的文件路径
//        builder.addBinaryBody("file", file, ContentType.IMAGE_JPEG, file.getName());
//
//        // 设置请求的实体
//        HttpEntity multipart = builder.build();
//        httpPost.setEntity(multipart);
//
//        // 执行请求并获取响应
//        CloseableHttpResponse response = httpClient.execute(httpPost);
//
//        try {
//            // 获取响应的状态码和内容
//            int statusCode = response.getStatusLine().getStatusCode();
//            HttpEntity responseEntity = response.getEntity();
//            String content = EntityUtils.toString(responseEntity);
//
//            // 打印结果
//            System.out.println("Status code: " + statusCode);
//            System.out.println("Content: " + content);
//        } finally {
//            // 关闭响应和客户端
//            response.close();
//            httpClient.close();
//        }
//    }
//}
