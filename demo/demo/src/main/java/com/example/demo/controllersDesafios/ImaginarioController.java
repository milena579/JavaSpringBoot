package com.example.demo.controllersDesafios;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.NumImaginario;

@RestController
// @RequestMapping("")
public class ImaginarioController {
    @GetMapping("/imaexp")

    public NumImaginario calculando(@RequestParam(value = "A") Double A, @RequestParam(value = "b") Double b){
        double re = A * Math.sin(b);
        double im = A * Math.cos(b);

        return new NumImaginario (re, im);
    }
}
