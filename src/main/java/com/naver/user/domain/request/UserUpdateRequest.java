package com.naver.user.domain.request;

import com.naver.user.domain.dto.UpdateUser;

public class UserUpdateRequest {

    private final String name;
    private final String password;

    public UserUpdateRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UpdateUser makeDto(int uid){
        return new UpdateUser(uid,name,password);
    }
}
