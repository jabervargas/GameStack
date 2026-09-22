package com.videojuegos.demo.Controller;

import com.videojuegos.demo.Service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideojuegoController {

    private final VideojuegoService videojuegoService;

    public VideojuegoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    @GetMapping({"/", "/videojuegos"})
    public String listarVideojuegos(Model model) {
        model.addAttribute("videojuegos", videojuegoService.listarVideojuegos());
        return "videojuegos";
    }
}