package com.naver.user.service;

import com.naver.user.dao.UserDao;
import com.naver.user.dao.UserMapper;
import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    List<User> users = new ArrayList<>();

//    public UserServiceImpl() {
//        users.add(new User("id","pw"));
//        users.add(new User("id1","123"));
//    }
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDao userDao;
    @Override
    public User login(LoginRequest request) {

       User user= userMapper.login(request);
        System.out.println(user);
        if(user != null){
            return user;
        }
        return null;

//        for (User user:
//             users) {
//            if (user.getId().equals(id) && user.getPw().equals(pw) ){
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public boolean signup(SignupRequest signupRequest) {

        Integer signUpId = userMapper.signUp(signupRequest);
        if(signUpId != null){
            return true;
        }
        return false;
//        for (User user:
//                users) {
//            if (user.getId().equals(id) ){
//                return false;
//            }
//        } // 중복체크
        //return users.add(new User(id,pw));
    }
}
