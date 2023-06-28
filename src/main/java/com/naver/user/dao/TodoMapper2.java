package com.naver.user.dao;

import com.naver.user.domain.entity.TodoJoinUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TodoMapper2 {
    List<TodoJoinUser> findAll();
}
