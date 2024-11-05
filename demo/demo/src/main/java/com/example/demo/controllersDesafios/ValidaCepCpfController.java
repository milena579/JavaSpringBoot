package com.example.demo.controllersDesafios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.CepCpf;
import com.example.demo.servicesDesafios.CepCpfService;

@RestController
@RequestMapping("/curitiba")
public class ValidaCepCpfController {
    @Autowired
    CepCpfService service;

    @GetMapping
    public ResponseEntity<CepCpf> validando(String cpf, String cep){
       var result = service.valida(cpf, cep);

       System.out.println("Teste");

       return ResponseEntity.ok(result);

    }

}
