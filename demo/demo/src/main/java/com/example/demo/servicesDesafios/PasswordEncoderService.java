package com.example.demo.servicesDesafios;

public interface PasswordEncoderService {
    String encode(String password);
    Boolean verificarSenha(String password, String passwordCryp);
}
