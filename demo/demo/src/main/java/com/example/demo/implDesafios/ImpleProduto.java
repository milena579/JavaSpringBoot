package com.example.demo.implDesafios;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dtoDesafios.Token;
import com.example.demo.model.ProdutoData;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.servicesDesafios.ProdutoService;

public class ImpleProduto implements ProdutoService {
    @Autowired
    ProdutoRepository repo;

    @Override
    public ProdutoData adicionarProd(Token token, String nome, Float valor) {
        var verificaProd = repo.findByNome(nome);

        if(!verificaProd.isEmpty()){
            return null;
        }

        if(!validaEmail(token.getEmail())){
            return  null;
        }

        var produto = new ProdutoData();
        produto.setNome(nome);
        produto.setValor(valor);
        repo.saveAndFlush(produto);

        return produto;
    }

    @Override
    public Boolean validaEmail(String email) {
        
        if(!email.endsWith("@loja.com")){
            return false;
        }

        return true;
    }
    
}
