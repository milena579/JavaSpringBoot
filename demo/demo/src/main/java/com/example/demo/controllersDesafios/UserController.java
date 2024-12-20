package com.example.demo.controllersDesafios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.LoginUser;
import com.example.demo.dtoDesafios.NovaSenha;
import com.example.demo.dtoDesafios.Token;
import com.example.demo.dtoDesafios.TokenData;
import com.example.demo.dtoDesafios.User;
import com.example.demo.implDesafios.BcryptPasswordEncoderService;
import com.example.demo.repositories.UserRepository;
import com.example.demo.servicesDesafios.JWTService;
import com.example.demo.servicesDesafios.UserService;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/create")
    public ResponseEntity<String> cadastro (@RequestBody User data ){
        
        if(!service.validaEmail(data.email())){
            return new ResponseEntity<>("Email invalido", HttpStatus.OK);
        }

        if(!service.validaNome(data.username())){
            return new ResponseEntity<>("Username inválido", HttpStatus.OK);
        }

        if(!service.validaSenha((data.password()))){
            return new ResponseEntity<>("Senha invalida", HttpStatus.OK);
        }

        if(service.cadastrar(data.username(), data.email(), data.password()) == null){
            return new ResponseEntity<>("Email ou Username já em uso!", HttpStatus.OK);
        }
        
        service.cadastrar(data.username(), data.email(), data.password());

        return new ResponseEntity<>("Usuário cadastrado", HttpStatus.OK);
    }

   

}
