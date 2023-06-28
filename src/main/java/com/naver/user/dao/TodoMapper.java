package com.naver.user.dao;

import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.request.UpdateRequest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoMapper {
    private final SqlSessionTemplate sqlSessionTemplate;

    public TodoMapper(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<TodoJoinUser> findAll(){
        return sqlSessionTemplate.selectList("todo.findAll");
    }

    public List<TodoJoinUser> findSomething(String keyword){
        return sqlSessionTemplate.selectList("todo.findSomething","%"+keyword + "%" );
    }

    public int update(UpdateRequest updateRequest){
        return sqlSessionTemplate.update("todo.update",updateRequest);
    }
}
