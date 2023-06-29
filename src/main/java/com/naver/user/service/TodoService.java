package com.naver.user.service;

import com.naver.user.dao.TodoDao;
import com.naver.user.dao.TodoMapper2;
import com.naver.user.domain.dto.Hearts;
import com.naver.user.domain.dto.SelectId;
import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.request.LikeRequest;
import com.naver.user.domain.request.UpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoDao todoDao;
    private final TodoMapper2 todoMapper;


    public TodoService(TodoDao todoDao, TodoMapper2 todoMapper) {
        this.todoDao = todoDao;
        this.todoMapper = todoMapper;
    }

    public List<TodoJoinUser> findAll(){
        return todoMapper.findAll();
    }
    public List<TodoJoinUser> findSomething(String keyword){
        if(keyword != null && (!keyword.equals(""))){
            keyword += "%"+ keyword+"%";
        }
        return todoMapper.findSomething(keyword);
    }

    public int insert(String content,Integer uname){
       return todoDao.insert(content,uname);
    }

    public int update(UpdateRequest updateRequest){
        return todoMapper.update(updateRequest);
    }

    public int like(LikeRequest likeRequest, int uid){

         SelectId selectId= new SelectId(uid,likeRequest.getId());

        Hearts hearts = todoMapper.selectlike(selectId);

        if(hearts == null){
            //하트를 하나 증가시키고
            todoMapper.insertlike(selectId);
            likeRequest.setHearts(likeRequest.getHearts() +1);
        }else {
            todoMapper.deletelike(selectId);
            likeRequest.setHearts(likeRequest.getHearts() -1);
        }
        return todoMapper.like(likeRequest);
    }
}
