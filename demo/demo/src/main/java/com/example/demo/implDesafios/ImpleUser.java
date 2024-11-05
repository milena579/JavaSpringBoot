package com.example.demo.implDesafios;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.UserData;
import com.example.demo.repositories.UserRepository;
import com.example.demo.servicesDesafios.UserService;

public class ImpleUser implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public UserData cadastrar(String username, String email, String password){
        var verificaEmail = repo.findByEmail(email);
        var verificaUser = repo.findByEmail(email);

        if(!verificaEmail.isEmpty() || !verificaUser.isEmpty()){
            return  null;
        }

        if(!validaEmail(email) || !validaNome(username) || !validaSenha(password)){
            return null;
        }

        var novoUser = new UserData();
        novoUser.setUsername(username);
        novoUser.setEmail(email);
        novoUser.setPassword(password);
        repo.saveAndFlush(novoUser);

        return novoUser;
        
    }

    @Override
    public Boolean validaSenha(String password) {

        if (password.isEmpty() || password.length() < 8){
            return false;
        }

        boolean passwordLower = false;
        boolean passwordUpper = false;
        boolean passwordDigit = false;

        for (char c : password.toCharArray()) {
            if(Character.isLowerCase(c)){
                return passwordLower = true;
            }

            if(Character.isUpperCase(c)){
                return  passwordUpper = true;
            }

            if(Character.isDigit(c)){
                return passwordDigit = true;
            }
        }

        if(!passwordLower || !passwordUpper || !passwordDigit){
            return  false;
        }

        return true;
    }

    @Override
    public Boolean validaEmail(String email) {

       if(email.length() < 4 || email.isEmpty()){
            return  false;
       }

       var arroba = email.indexOf("@");
       var ponto = email.indexOf(".");

        if (arroba < 1 || ponto < arroba + 1 || ponto >= email.length() - 1) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean validaNome (String username){

        if(username.length() < 4 || username.isEmpty()){
            return  false;
        }

       return true;
    }


}
