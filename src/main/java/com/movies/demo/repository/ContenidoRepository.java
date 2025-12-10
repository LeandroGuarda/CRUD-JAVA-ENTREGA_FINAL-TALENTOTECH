package com.movies.demo.repository;

import com.movies.demo.models.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    List<Contenido> findByTituloContainingIgnoreCase(String titulo);
    List<Contenido> findByGen(String gen);
}
