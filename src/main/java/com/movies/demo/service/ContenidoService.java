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
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
    public Contenido save(Contenido contenido) {
        return repository.save(contenido);
    }
    public Contenido update(Long id, Contenido nuevoContenido) {
        return repository.findById(id).map(contenido -> {
            contenido.setTitulo(nuevoContenido.getTitulo());
            contenido.setGen(nuevoContenido.getGen());
            contenido.setPoster(nuevoContenido.getPoster());
            contenido.setDuracion(nuevoContenido.getDuracion());
            contenido.setTrailer(nuevoContenido.getTrailer());
            contenido.setResumen(nuevoContenido.getResumen());
            return repository.save(contenido);
        }).orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
    }





}
