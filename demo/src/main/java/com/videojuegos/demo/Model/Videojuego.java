package com.videojuegos.demo.Model;

public class Videojuego {

    private final String titulo;
    private final String genero;
    private final int anio;

    public Videojuego(String titulo, String genero, int anio) {
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnio() {
        return anio;
    }
}