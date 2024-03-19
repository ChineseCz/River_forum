
//帖子类
package com.example.demo.QSH;

import lombok.Data;


@Data
public class Post {
    private Long id; // 帖子唯一标识
    private String title; // 帖子标题
    private String content; // 帖子内容
    private String author; // 帖子作者
    private String createTime; // 帖子创建时间
    private String recentResponseTime; // 最近回复的时间


}