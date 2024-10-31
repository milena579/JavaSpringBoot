package com.example.demo.controllersDesafios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.EhPalindromo;
import com.example.demo.implDesafios.ImpleEhPalindromo;
import com.example.demo.servicesDesafios.EhPalindromoService;

@RestController
@RequestMapping("/reverse")
public class ReverseController {
    @Autowired
    EhPalindromoService service;
    
    @GetMapping("/{palavra}")
    public ResponseEntity<EhPalindromo> validando(@PathVariable String palavra){
       ImpleEhPalindromo palindromo = new ImpleEhPalindromo();
       if (palavra == null){
            return ResponseEntity 
                .status(400)
                .build();
       }
       
       var result = palindromo.verificar(palavra);
       return ResponseEntity.ok(result);
    }
}
