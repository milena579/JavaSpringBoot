package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Veiculo;

//segundo parametro tem que ser o tipo do id da classe
@Repository
public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByTipo(String tipo);
    
} 