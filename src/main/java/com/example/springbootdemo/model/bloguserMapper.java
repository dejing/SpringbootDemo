package com.example.springbootdemo.model;

import com.example.springbootdemo.model.bloguser;

public interface bloguserMapper {
    int insert(bloguser record);

    int insertSelective(bloguser record);
}