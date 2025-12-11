package com.movies.demo.controller;

import com.movies.demo.models.Contenido;
import com.movies.demo.service.ContenidoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


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

    // Eliminar por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el registro con id " + id);
        }

        service.deleteById(id);
        return ResponseEntity.ok("Registro eliminado");
    }

    @PostMapping("/create")
    public Contenido create(@RequestBody Contenido contenido) {
        return service.save(contenido);
    }
    @PutMapping("/update/{id}")
    public Contenido update(@PathVariable Long id, @RequestBody Contenido contenido) {
        return service.update(id, contenido);
    }






}
