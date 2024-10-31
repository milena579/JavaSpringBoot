// package com.example.demo.controllersDesafios;

// import org.springframework.http.HttpRequest;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.dtoDesafios.CepCpf;
// import com.example.demo.dtoDesafios.Endereco;
// import java.net.http.HttpResponse;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import java.net.http.HttpClient;
// import java.net.URI;

// @CrossOrigin(origins = {"http://localhost:5257"})
// @RestController
// public class ValidaCepCpfController {
//     @GetMapping("/collatz")
    
//     String webService = "http://viacep.com.br/ws/";
//     Integer codigoSucesso = 200;

//     public ResponseEntity<CepCpf> validando(@RequestParam(value = "cep") Integer cep, @RequestParam(value = "cpf") Integer cpf){
    
//     final HttpRequest request = HttpRequest.newBuilder(URI.create("https://viacep.com.br/ws/%s/json/".formatted(cep))).build();

//     final HttpClient client = HttpClient.newHttpClient();

//     final HttpResponse<String> response = client.send(request, body.ofString());

//     final ObjectMapper objectMapper = new ObjectMapper();

//     final Endereco endereco = objectMapper.readValue(response.body(), Endereco.class);


//     }
// }
