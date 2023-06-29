package com.naver.user.dao;

import com.naver.user.domain.dto.Hearts;
import com.naver.user.domain.dto.SelectId;
import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.request.LikeRequest;
import com.naver.user.domain.request.UpdateRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper2 {
    List<TodoJoinUser> findAll();

    List<TodoJoinUser> findSomething(String keyword);

    int update(UpdateRequest updateRequest);

    int like(LikeRequest likeRequest);

    Hearts selectlike(SelectId selectId);

    int insertlike(SelectId selectId);

    int deletelike(SelectId selectId);
}
