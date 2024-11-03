package com.example.demo.controllersDesafios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.CepCpf;
import com.example.demo.implDesafios.ImpleCepCpf;
import com.example.demo.servicesDesafios.CepCpfService;

@RestController
@RequestMapping("/cpdcep")
public class ValidaCepCpfController {
    @Autowired
    CepCpfService service;

    @GetMapping("/{cep}{cpf}")
    public ResponseEntity<CepCpf> validando(@PathVariable String cpf, @PathVariable String cep){
        ImpleCepCpf validaCpf = new ImpleCepCpf();

        if (cpf == null){
            return ResponseEntity 
                .status(400)
                .build();
       }

       var result = validaCpf.valida(cpf);

       return ResponseEntity.ok(result);
    }

}
