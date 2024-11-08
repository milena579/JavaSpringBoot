package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProdutoData;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoData, Long>{
    List<ProdutoData> findByNome(String nome);
}
