package com.videojuegos.demo.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListadoController {

    @RequestMapping("/")
    public String ListarVideojuegos() {
        return "listado";
    }

}