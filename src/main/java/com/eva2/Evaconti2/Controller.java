package com.eva2.Evaconti2;

import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path="/")
public class Controller{

    @GetMapping(path="/")
    public String home(){
        return "SM74128971 - Adrian Salas";
    }

    @GetMapping(path="/idat/codigo")
    public  String codigo(){
        return "SM74128971";
    }

    @GetMapping(path="/idat/nombre-completo")
    public String nombrecompleto(){
        return "Adrian Enrique Salas Vicente";
    }

    
}