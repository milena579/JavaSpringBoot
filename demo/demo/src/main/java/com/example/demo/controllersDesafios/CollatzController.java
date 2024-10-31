package com.example.demo.controllersDesafios;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtoDesafios.Collatz;

@RestController
public class CollatzController {
    @GetMapping("/collatz")

    public ResponseEntity<Collatz> variando(@RequestParam(value = "current") Integer current, @RequestParam(value = "step") Integer step){
        
        var new_current = 0;

        if( step < 0 || current < 0){
            return ResponseEntity
            .status(404)
            .build();
        }

        for(int i = 0; i < step; i ++){
            if(i %2 == 0){
                new_current = current/2;
            } else{
                new_current = current * i + 1;
            }
        }

        return  ResponseEntity.ok(new Collatz(new_current));
    }
}
