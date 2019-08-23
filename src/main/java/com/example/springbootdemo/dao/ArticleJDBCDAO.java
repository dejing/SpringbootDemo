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
    private JdbcTemplate primaryJdbcTemplate;

    public void save(Article article, JdbcTemplate jdbcTemplate)
    {
        jdbcTemplate.update("INSERT INTO article(author, title, content,createtime) values (?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }
    public void deleteById(Long id, JdbcTemplate jdbcTemplate){
        jdbcTemplate.update("DELETE FROM article WHERE id = ?", new Object[]{id});
    }
    public void updateById(Article article, JdbcTemplate jdbcTemplate){
        jdbcTemplate.update("UPDATE article SET author = ?, title = ?, content=?, createTime=? WHERE id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }
    public Article findById(Long id, JdbcTemplate jdbcTemplate){
        return (Article)jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper(Article.class));
    }

    public List<Article> findAll(JdbcTemplate jdbcTemplate){
        return (List<Article>)jdbcTemplate.query("SELECT * FROM article ", new BeanPropertyRowMapper(Article.class));
    }
}
