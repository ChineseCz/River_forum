package com.example.demo.QSH;
//web
import org.springframework.web.bind.annotation.*;
//数据库
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//异常与核心库
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class PostQingShuiHeController  {


    // 新增一条帖子
    @PostMapping
    public ApiResponse<String> createPost(@RequestBody Post post) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            //获取帖子表
            PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
            // 调用MyBatis Mapper方法插入数据
            postMapper.createPost(post);
            sqlSession.commit();  // 提交事务
            return new ApiResponse<>(200, "帖子已创建，ID：" + postMapper.getId(post));
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "创建帖子失败");
        }
    }

    // 查询一条帖子内容（根据标题关键词或ID）
    @GetMapping
    public ApiResponse<Post> getPost(@RequestParam(value = "title", required = false) String title,
                                     @RequestParam(value = "id", required = false) Long id
                                     ) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            PostMapper postMapper = sqlSession.getMapper(PostMapper.class);

            if (title != null ) {
                List<Post> posts = postMapper.getPostByTitle(title);//SQL调出所有表
                if (!posts.isEmpty()) {
                    return new ApiResponse<>(200, "帖子找到咯", posts);
                }
            } else if (id != null) {
                Post post = postMapper.getPostById(id);
                if (post != null) {
                    return new ApiResponse<>(200, "帖子找到咯", post);
                }
            }

            return new ApiResponse<>(404, "对不起，没有找到匹配结果");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "查询帖子失败");
        }
    }

    //修改帖子
    @PutMapping("/{id}")
    public ApiResponse<String> revisePost(@PathVariable Long id, @RequestBody Post revisePost) {
        //数据库读取这里要用try(){}进行事务管理，结束时会自己关闭
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
            Post existingPost = postMapper.getPostById(id);

            if (existingPost != null) {
                existingPost.setTitle(revisePost.getTitle());
                existingPost.setContent(revisePost.getContent());
                existingPost.setRecentResponseTime(revisePost.getRecentResponseTime());
                postMapper.updatePost(existingPost);
                sqlSession.commit();
                return new ApiResponse<>(200, "ID：" + id + "的帖子已修改");
            } else {
                return new ApiResponse<>(404, "对不起，没有找到匹配的帖子");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "修改帖子失败");
        }
    }
    //删除帖子
    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePost(@PathVariable Long id) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
            Post existingPost = postMapper.getPostById(id);

            if (existingPost != null) {
                postMapper.deletePost(id);
                sqlSession.commit();
                return new ApiResponse<>(200, "ID: " + id + "的帖子已删除");
            } else {
                return new ApiResponse<>(404, "对不起，没有找到匹配的帖子");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "删除帖子失败");
        }
    }

    //载入数据
    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}