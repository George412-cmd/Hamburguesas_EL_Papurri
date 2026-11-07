/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba1.api1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elmas
 */
@RestController
@RequestMapping("/apisaludos")
public class SaludoController {
    
    @GetMapping("/hola")
    public String holaMundo(){
    
        return "Hola Mundo";
    }
    
    @GetMapping("/holanombre/{nombre}/{edad}")
    public String HolaMundoNombre(@PathVariable String nombre ,@PathVariable int edad){
        return "HolaMundo "+ nombre+" Tu edad es "+ edad;
    }
}
