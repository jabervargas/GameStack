package com.videojuegos.demo.Service;

import com.videojuegos.demo.Model.Videojuego;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoService {

    public List<Videojuego> listarVideojuegos() {
        return List.of(
                new Videojuego("Hollow Knight", "Metroidvania", 2017),
                new Videojuego("Stardew Valley", "Simulacion", 2016),
                new Videojuego("Celeste", "Plataformas", 2018)
        );
    }
}