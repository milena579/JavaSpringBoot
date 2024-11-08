package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.dtoDesafios.Token;
import com.example.demo.implDesafios.BcryptPasswordEncoderService;
import com.example.demo.implDesafios.DefaultJWTImple;
import com.example.demo.implDesafios.ImpleCepCpf;
import com.example.demo.implDesafios.ImpleEhPalindromo;
import com.example.demo.implDesafios.ImpleProduto;
import com.example.demo.implDesafios.ImpleUserSecurity;
import com.example.demo.servicesDesafios.CepCpfService;
import com.example.demo.servicesDesafios.EhPalindromoService;
import com.example.demo.servicesDesafios.JWTService;
import com.example.demo.servicesDesafios.PasswordEncoderService;
import com.example.demo.servicesDesafios.ProdutoService;
import com.example.demo.servicesDesafios.UserService;

@Configuration
public class DependencyConfiguration {
    // @Bean
    // @Scope("singleton")
    // mesmo objeto usado por todoos os usuário
    //prototype --  Toda vez que precisar do objeto ele cria um novo
    //request -- Escope que existe na requisição, só para minha requisição vai ser o mesmo objeto
    // diferença -- o prototype gera um novo e o request reutiliza o mesmo
    // session -- cria uma sessão expecífica do servidor com o navegador 

    // public LoginService loginService(){
    //     return new ExempleLoginService();
    // }

    @Bean
    @Scope("singleton")
    public EhPalindromoService ehPalindromoService(){
        return new ImpleEhPalindromo();
    }

    @Bean
    @Scope("singleton")
    public CepCpfService validaCepCpfService(){
        return new ImpleCepCpf();
    }

    @Bean
    @Scope("singleton")
    public UserService validaUserService(){
        return new ImpleUserSecurity();
    }

    @Bean

    @Scope("singleton")
    public PasswordEncoderService passwordEncoderService() {
        return new BcryptPasswordEncoderService();
    }

    @Bean
    @Scope("singleton")
    public JWTService<Token> jwtService() {
        return new DefaultJWTImple();
    }

    @Bean
    @Scope("singleton")
    public ProdutoService productService() {
        return new ImpleProduto();
    }

}
