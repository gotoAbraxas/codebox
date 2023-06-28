package com.naver.user.dao;

import com.naver.user.domain.entity.User;
import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.SignupRequest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMapper {
    private final SqlSessionTemplate sqlSessionTemplate;

    public UserMapper(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public User login(LoginRequest request) {
        return sqlSessionTemplate.selectOne("user.login", request);
    }

    public int signUp(SignupRequest signupRequest) {

        return sqlSessionTemplate.insert("user.signup", signupRequest);
    }
}
