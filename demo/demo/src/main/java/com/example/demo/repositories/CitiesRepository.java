package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.City;

public interface CitiesRepository extends JpaRepository<City, Long> {
    List<City> findByCity(String city);

}
