package com.example.demo.controllersDesafios;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.User;
import com.example.demo.servicesDesafios.UserService;

import jakarta.persistence.PostLoad;
import jdk.javadoc.doclet.Reporter;

@RestController
@RequestMapping("/create")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<String> cadastro (@RequestBody User data ){
        
        if(!service.validaEmail(data.email())){
            return new ResponseEntity<>("Email invalido", HttpStatus.OK);
        }

        if(!service.validaNome(data.username())){
            return new ResponseEntity<>("Username inválido", HttpStatus.OK);
        }

        if(!service.validaSenha((data.password()))){
            return new ResponseEntity<>("Email invalido", HttpStatus.OK);
        }

        return new ResponseEntity<>("Usuário cadastrado", HttpStatus.OK);
    }
}
