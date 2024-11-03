package com.example.demo.implDesafios;

import java.util.ArrayList;

import com.example.demo.dtoDesafios.CepCpf;
import com.example.demo.servicesDesafios.CepCpfService;

public class ImpleCepCpf implements CepCpfService{
    
    @Override
    public CepCpf valida(String cpf) {
        char[] confereCpf = cpf.toCharArray();
    
        ArrayList<Integer> list = new ArrayList<>();
        for (char num : confereCpf) {
            list.add(Character.getNumericValue(num)); // Corrigindo a conversão para Integer
        }
    
        int primeiroDigito;
        int segundoDigito;
        int somaUm = 0;
        int somaDois = 0;
    
        // Cálculo para o primeiro dígito verificador
        for (int i = 0; i < 9; i++) {
            somaUm += list.get(i) * (10 - i);
        }
        int restoUm = somaUm % 11;
        
        if (restoUm < 2) {
            primeiroDigito = 0;
        } else {
            primeiroDigito = 11 - restoUm;
        }
    
        confereCpf[9] = Character.forDigit(primeiroDigito, 10); 
    
        // Cálculo para o segundo dígito verificador
        for (int i = 0; i < 10; i++) {
            somaDois += list.get(i) * (11 - i);
        }
        int restoDois = somaDois % 11;
        
        if (restoDois < 2) {
            segundoDigito = 0;
        } else {
            segundoDigito = 11 - restoDois;
        }
    
        confereCpf[10] = Character.forDigit(segundoDigito, 10);
    
        boolean cpfValido = cpf.equals(new String(confereCpf));
        
        return new CepCpf(cpfValido, cpf);
    }
    
}
    
