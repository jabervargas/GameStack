package com.videojuegos.demo.Controller;

import com.videojuegos.demo.Model.Videojuego;
import com.videojuegos.demo.Repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListadoController {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @RequestMapping("/")
    public String listarVideojuegos(@RequestParam(name = "buscar", required = false) String buscar, Model model) {

        // Cargar datos iniciales si la BD H2 está vacía
        if (videojuegoRepository.count() == 0) {
            videojuegoRepository.save(new Videojuego(
                    "GTA: Vice City",
                    "Videojuego de acción y aventura de mundo abierto desarrollado por Rockstar North.",
                    "https://static.wikia.nocookie.net/esgta/images/0/0f/Grand_Theft_Auto_Vice_City.JPG/revision/latest?cb=20161127222945"));
            videojuegoRepository.save(new Videojuego(
                    "PES 6",
                    "Videojuego de fútbol desarrollado y publicado por Konami para PlayStation 2 en 2006.",
                    "https://media.vandal.net/ivandal/11/60/1146x600/53/5380/200692523656_1.jpg"));
            videojuegoRepository.save(new Videojuego(
                    "PES 2013",
                    "Videojuego de fútbol de Konami que incorpora el sistema PES FullControl.",
                    "https://m.media-amazon.com/images/M/MV5BYzlmZmUyMzEtYjY1Yy00MjJiLTkzMjctM2JhNzVmYTlhNjJhXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg"));
            videojuegoRepository.save(new Videojuego(
                    "Call of Duty 4",
                    "Videojuego de disparos en primera persona publicado por Activision en 2007.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKsk8WIMmcHNofk2EnENXPoY5e55eDtlQxTfuagEZWUA820lsSDRjnNPCE&s=10"));
        }

        List<Videojuego> lista;

        // Si el usuario escribió algo en el buscador
        if (buscar != null && !buscar.trim().isEmpty()) {
            lista = videojuegoRepository.findByTituloContainingIgnoreCase(buscar.trim());
        } else {
            // Si no buscó nada, trae todos los juegos
            lista = videojuegoRepository.findAll();
        }

        model.addAttribute("videojuegos", lista);
        model.addAttribute("palabraBuscada", buscar); // Mantener el texto en el buscador

        return "listado";
    }
}