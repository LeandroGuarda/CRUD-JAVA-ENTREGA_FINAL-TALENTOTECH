package com.movies.demo.controller;

import com.movies.demo.models.Contenido;
import com.movies.demo.service.ContenidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

    private final ContenidoService service;

    public ContenidoController(ContenidoService service) {
        this.service = service;
    }

    // Obtener todos
    @GetMapping("/list")
    public List<Contenido> list() {
        return service.findAll();
    }

    // Buscar por título
    @GetMapping("/search")
    public List<Contenido> search(@RequestParam String titulo) {
        return service.searchByTitulo(titulo);
    }

    // Buscar por género exacto (gen)
    @GetMapping("/genero")
    public List<Contenido> porGenero(@RequestParam String gen) {
        return service.searchByGenero(gen);
    }
}
