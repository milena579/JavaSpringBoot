package com.example.demo.impl;

import com.example.demo.services.LoginService;

public class ExempleLoginService implements LoginService {
    
    @Override
    public Integer login(String username, String password){
        if (!username.equals("mile")){
            return-1;
        }
        if (!password.equals("123")){
            return -1;
        }

        return 1;
    }
}
