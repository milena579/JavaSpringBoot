package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.impl.ExempleLoginService;
import com.example.demo.services.LoginService;

@Configuration
public class DependencyConfiguration {
    @Bean
    @Scope("singleton") // mesmo objeto usado por todoos os usuário
    //prototype --  Toda vez que precisar do objeto ele cria um novo
    //request -- Escope que existe na requisição, só para miha requisição vai ser o mesmo objeto
    // diferença -- o prototype gera um novo e o request reutiliza o mesmo
    // session -- cria uma sessão expecífica do servidor com o navegador 
    public LoginService loginService(){
        return new ExempleLoginService();
    }
}
