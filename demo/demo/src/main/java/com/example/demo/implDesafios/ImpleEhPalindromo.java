package com.example.demo.implDesafios;

import com.example.demo.dtoDesafios.EhPalindromo;
import com.example.demo.servicesDesafios.EhPalindromoService;

public class ImpleEhPalindromo implements EhPalindromoService{
    
    @Override
    public EhPalindromo verificar(String palavra) {
        StringBuffer buffer = new StringBuffer(palavra);
        buffer.reverse();
        String data = buffer.toString();
 
        if (data.equals(palavra)) {
            return new EhPalindromo(data, true);
        }

        return new EhPalindromo(data, false);
    }
}

