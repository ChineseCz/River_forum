package com.example.demo.test1;

// 导入相关的包
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

// 定义一个控制器类
@RestController
public class HttpController {

    // 定义一个 GET 方法，映射到 /http 路径
    @GetMapping("/http")
    public String httpGet(
            @RequestParam String name, // 从 URL 中获取 name 参数
            @RequestParam String type, // 从 URL 中获取 type 参数
            @RequestHeader(required = false) String auth // 从 header 中获取 auth 参数，如果没有则为 null
    ) {
        // 判断 auth 是否存在，如果不存在则返回 "Invalid User"
        if (auth == null) {
            return "Invalid User";
        }
        // 否则，将 name 和 type 拼接成 name-type 的形式，并返回
        return name + "-" + type;
    }

    // 定义一个 POST 方法，映射到 /http 路径
    @PostMapping("/http")
    public ResponseEntity<?> httpPost(
            @RequestBody HttpBody body, // 从 body 中获取一个 HttpBody 对象，需要定义一个 HttpBody 类
            @RequestHeader(value = "auth",required = false) String auth // 从 header 中获取 auth 参数，如果没有则为 null
    ) {
        // 判断 auth 是否存在，如果不存在则返回 "Invalid User"
        if (auth == null) {
            return new ResponseEntity<>("Invalid User", HttpStatus.UNAUTHORIZED);
        }
        // 否则，将 body 中的 name 和 type 拼接成 name-type 的形式，并封装成一个 HttpResult 对象，需要定义一个 HttpResult 类
        HttpResult result = new HttpResult(body.getName() + "-" + body.getType());
        // 返回一个 ResponseEntity 对象，设置状态码为 200，并设置 body 为 result
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 定义一个 HttpBody 类，用于接收前端传来的参数
    public static class HttpBody {
        private String name; // 定义一个 name 属性
        private String type; // 定义一个 type 属性

        // 提供 getter 和 setter 方法
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    // 定义一个 HttpResult 类，用于封装返回给前端的数据
    public static class HttpResult {
        private String data; // 定义一个 data 属性

        // 提供构造方法和 getter 方法
        public HttpResult(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }
}
