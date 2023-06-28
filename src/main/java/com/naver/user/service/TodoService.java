package com.naver.user.service;

import com.naver.user.dao.TodoDao;
import com.naver.user.dao.TodoMapper;
import com.naver.user.dao.TodoMapper2;
import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.request.UpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoDao todoDao;
    private final TodoMapper todoMapper;


    public TodoService(TodoDao todoDao, TodoMapper todoMapper) {
        this.todoDao = todoDao;
        this.todoMapper = todoMapper;
    }

    public List<TodoJoinUser> findAll(){
        return todoMapper.findAll();
    }
    public List<TodoJoinUser> findSomething(String keyword){
        return todoMapper.findSomething(keyword);
    }

    public int insert(String content,Integer uname){
       return todoDao.insert(content,uname);
    }

    public int update(UpdateRequest updateRequest){
        return todoMapper.update(updateRequest);
    }
}
