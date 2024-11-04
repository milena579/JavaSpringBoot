package com.example.demo.implDesafios;

import java.util.ArrayList;

import com.example.demo.dtoDesafios.CepCpf;
import com.example.demo.servicesDesafios.CepCpfService;

public class ImpleCepCpf implements CepCpfService{
    
    @Override
    public CepCpf valida(String cpf, String cep) {
        int primeiroDigito;
        int segundoDigito;
        int somaUm = 0;
        int somaDois = 0;
    
        // Cálculo para o primeiro dígito verificador
        for (int i = 0; i < 9; i++) {
            var numero =  Character.toString(cpf.charAt(i));
            somaUm += Integer.parseInt(numero) * (i + 1);
        }

        int restoUm = somaUm % 11;

        System.out.println(restoUm);

        if (restoUm == 10) {
            primeiroDigito = 0;
        } else{
            primeiroDigito = restoUm;
        }
        
        System.out.println();

        if(primeiroDigito != Character.getNumericValue(cpf.charAt(9))){
        // Cálculo para o segundo dígito verificador
            return new CepCpf(false, "inválido");
        }

        for (int i = 0; i < 10; i++) {
            var numero =  Character.toString(cpf.charAt(i));
            somaDois += Integer.parseInt(numero) * (i);
        }
        int restoDois = somaDois % 11;
        
        if (restoDois == 10) {
            segundoDigito = 0;
        } else {
            segundoDigito = restoDois;
        }

        if(segundoDigito != Character.getNumericValue(cpf.charAt(10))){
            return new CepCpf(false, "inválido");
        }

        return new CepCpf(true, "válido");
    }
    
}
    
