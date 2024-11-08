package com.example.demo.controllersDesafios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.Produto;
import com.example.demo.dtoDesafios.Token;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.servicesDesafios.ProdutoService;


@RestController
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoRepository repo;

    @PostMapping("/product")
    public ResponseEntity<String> cadastrarProd(@RequestAttribute("token") Token token, @RequestBody Produto data ){
        
        if(token == null) {
            return ResponseEntity.status(401).build();
        }

        if(!service.validaEmail(token.getEmail())){
            return ResponseEntity.status(403).build();
        }
        
        // service.adicionarProd(token, data.nome(), data.valor());

        return new ResponseEntity<>("Produto cadastrado com sucesso!", HttpStatus.OK);
    }
}
