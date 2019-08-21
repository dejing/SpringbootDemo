package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void save(Article article)
    {
        jdbcTemplate.update("INSERT INTO article(author, title, content,createtime) values (?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }
    public void deleteById(Long id){
        jdbcTemplate.update("DELETE FROM article WHERE id = ?", new Object[]{id});
    }
    public void updateById(Article article){
        jdbcTemplate.update("UPDATE article SET author = ?, title = ?, content=?, createTime=? WHERE id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }
    public Article findById(Long id){
        return (Article)jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Article.class));
    }

    public List<Article> findAll(){
        return (List<Article>)jdbcTemplate.query("SELECT * FROM article ", new BeanPropertyRowMapper<>(Article.class));
    }
}
