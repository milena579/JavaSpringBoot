package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VeiculoDto;
import com.example.demo.model.Veiculo;
import com.example.demo.repositories.VeiculoRepositorio;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    VeiculoRepositorio repo; //faz com que o controller dependa de um servico

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getById(@PathVariable Long id){
        var veiculo = repo.findById(id);

        if(!veiculo.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(veiculo.get(), HttpStatus.OK);
    }

    @GetMapping("/find/{tipo}")
    public ResponseEntity<List<VeiculoDto>> getByTipo(@PathVariable String tipo){

        var veiculo = repo.findByTipo(tipo)
        .stream()
        .map(v -> new VeiculoDto(v.getQtdRodas(), v.getTipo()))
        .collect(Collectors.toList());

        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }
}
