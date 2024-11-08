package com.example.demo.servicesDesafios;

import com.example.demo.dtoDesafios.Token;
import com.example.demo.model.ProdutoData;

public interface ProdutoService {
    ProdutoData adicionarProd( Token token, String nome, Float valor);
    Boolean validaEmail(String email);
}
