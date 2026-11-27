package com.adas.contatos.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
public class InicioControler {
    @GetMapping
    public String boasVindas(){
        return "Chegou ao endpoint    /inicio";
    }
}
