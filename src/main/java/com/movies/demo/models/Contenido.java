package com.movies.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contenidos")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 50)
    private String gen;

    @Column(length = 255)
    private String poster;

    private Integer duracion;

    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(length = 255)
    private String trailer;

    @Column(length = 10)
    private String temporadas;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String resumen;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGen() { return gen; }
    public void setGen(String gen) { this.gen = gen; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }

    public Long getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Long idCategoria) { this.idCategoria = idCategoria; }

    public String getTrailer() { return trailer; }
    public void setTrailer(String trailer) { this.trailer = trailer; }

    public String getTemporadas() { return temporadas; }
    public void setTemporadas(String temporadas) { this.temporadas = temporadas; }

    public String getResumen() { return resumen; }
    public void setResumen(String resumen) { this.resumen = resumen; }
}
