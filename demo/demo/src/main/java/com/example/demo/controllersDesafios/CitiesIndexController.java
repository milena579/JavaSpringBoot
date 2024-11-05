package com.example.demo.controllersDesafios;

import java.io.Console;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.CitiesIndex;
import com.example.demo.repositories.CitiesRepository;

@RestController
@RequestMapping("/cities")
public class  CitiesIndexController{
    @Autowired
    CitiesRepository repo;

    @GetMapping("")
    public ResponseEntity<List<CitiesIndex>> verCidades(){
        var cidades = repo.findAll()
        .stream()
        .map( c -> new CitiesIndex(c.getCity(), c.getState(), c.getCountry()))
        .collect(Collectors.toList());

        System.out.println(cidades);
        
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

    @GetMapping("/{query}")
    public ResponseEntity<List<CitiesIndex>> getByCity(@PathVariable String query){
        var cidade = repo.findByCity(query)
        .stream()
        .map( c -> new CitiesIndex(c.getCity(), c.getState(), c.getCountry()))
        .collect(Collectors.toList());

        return new ResponseEntity<>(cidade, HttpStatus.OK);
    }
}