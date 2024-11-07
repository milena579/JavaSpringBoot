package com.example.demo.servicesDesafios;

public interface JWTService<T> {
    String get(T token);
    T validate(String jwt);
}