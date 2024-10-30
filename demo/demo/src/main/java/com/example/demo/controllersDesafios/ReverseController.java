package com.example.demo.controllersDesafios;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.EhPalindromo;

@CrossOrigin(origins = {"http://localhost:5257"})
@RestController
@RequestMapping("/reverse")
public class ReverseController {
    @GetMapping("/{palavra}")

    public EhPalindromo testando(@PathVariable String palavra){
        StringBuffer buffer = new StringBuffer(palavra);
        buffer.reverse();
        String data = buffer.toString();
 
        if (palavra.equals(data)) {
            return new EhPalindromo(palavra, true);
        }
        return new EhPalindromo(palavra, false);
    }
}
