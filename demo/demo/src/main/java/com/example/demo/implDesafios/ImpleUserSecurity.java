package com.example.demo.implDesafios;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.UserData;
import com.example.demo.repositories.UserRepository;
import com.example.demo.servicesDesafios.PasswordEncoderService;
import com.example.demo.servicesDesafios.UserService;

public class ImpleUserSecurity implements UserService {

    @Autowired
    UserRepository repo;

    @Autowired 
    PasswordEncoderService encoder;

    @Override
    public UserData cadastrar(String username, String email, String password){
        var verificaEmail = repo.findByEmail(email);
        var verificaUser = repo.findByUsername(username);

        System.out.println(verificaEmail);
        System.out.println(verificaUser);

        if(!verificaEmail.isEmpty() || !verificaUser.isEmpty()){
            return  null;
        }

        if(!validaEmail(email) || !validaNome(username) || !validaSenha(password)){
            return null;
        }

        var novoUser = new UserData();
        novoUser.setUsername(username);
        novoUser.setEmail(email);
        novoUser.setPassword(encoder.encode(password));
        repo.save(novoUser);

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

    @Override
    public UserData logar (String username, String password) {
        var user = repo.findByUsername(username);

        if(user.isEmpty()){
            return null;
        }

        if(!encoder.verificarSenha(password, user.get(0).getPassword())) {
            return null;
        }


        return user.get(0);
    }

    @Override
    public UserData trocaSenha(UserData user, String senhaNova, String senhaRepetida) {  
        if(user == null){
            return null;
        }
        
        if(!senhaNova.equals(senhaRepetida)){
            return null;
        }

        if(!validaSenha(senhaNova)){
            return null;
        }

        user.setPassword(senhaNova);
        repo.save(user);

        return user;
    }
}

