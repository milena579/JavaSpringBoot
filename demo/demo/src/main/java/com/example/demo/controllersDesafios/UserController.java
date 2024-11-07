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
    
    @Autowired
    UserRepository repo;

    @Autowired 
    BcryptPasswordEncoderService encoder;

    @Autowired
    JWTService<Token> jwtService;

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

    @PatchMapping("/changepassword")
    public ResponseEntity<String> login (@RequestBody NovaSenha data){
        var user = service.logar(data.username(), data.password());
        
        System.out.println(data.newPassword());

        if(service.trocaSenha(user, data.newPassword(), data.repeatPassword()) == null){
            return new ResponseEntity<>("Senhas divergentes!", HttpStatus.OK);
        }

        return new ResponseEntity<>("Senha alterada com sucesso!", HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> cadastroSecurity (@RequestBody User data ){
        
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

    @PostMapping("/login")
    public ResponseEntity<TokenData> create(@RequestBody LoginUser loginData) {

        if (loginData.login() == null || loginData.password() == null) {
            return new ResponseEntity<>(new TokenData("Dados Inválidos", ""), HttpStatus.OK);

        }
    
        var users = repo.login(loginData.login());

        if (users.isEmpty()) {
            return new ResponseEntity<>(new TokenData("Dados Inválidos", ""), HttpStatus.OK);
        }

        var user = users.get(0);

        if (!encoder.verificarSenha(loginData.password(), user.getPassword())) {
            return new ResponseEntity<>(new TokenData("Senha não compatível", ""), HttpStatus.OK);
        }

        Token token = new Token();
        token.setId(user.getId());
        token.setNome(user.getUsername());
        token.setEmail(user.getEmail());
        
        var jwt = jwtService.get(token);

        return new ResponseEntity<>(new TokenData("Token gerado com sucesso!", jwt), HttpStatus.OK);
    }

}
