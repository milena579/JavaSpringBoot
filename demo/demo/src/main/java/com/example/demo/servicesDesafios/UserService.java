package com.example.demo.servicesDesafios;

import com.example.demo.model.UserData;

public interface UserService {
    UserData cadastrar(String username, String email, String password);
    Boolean validaSenha(String password);
    Boolean validaEmail(String email);
    Boolean validaNome(String username);
}
