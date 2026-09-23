package com.videojuegos.demo.Repository;

import com.videojuegos.demo.Model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    // Spring Data JPA crea la consulta SQL/H2 automáticamente con solo nombrar el
    // método
    List<Videojuego> findByTituloContainingIgnoreCase(String titulo);
}