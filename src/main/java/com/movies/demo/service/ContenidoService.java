package com.movies.demo.service;

import com.movies.demo.models.Contenido;
import com.movies.demo.repository.ContenidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoService {

    private final ContenidoRepository repository;

    public ContenidoService(ContenidoRepository repository) {
        this.repository = repository;
    }

    public List<Contenido> findAll() {
        return repository.findAll();
    }

    public List<Contenido> searchByTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Contenido> searchByGenero(String gen) {
        return repository.findByGen(gen);
    }
}
