package com.aluracursos.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "libro_generos", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "genero")
    private List<String> genero;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "libro_lenguajes", joinColumns = @JoinColumn(name = "libro_id"))
    @Enumerated(EnumType.STRING)
    private List<Idioma> lenguaje;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private Double numeroDeDescargas;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {}

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.lenguaje = datosLibro.lenguaje().stream()
                .map(Idioma::fromString)
                .toList();
        this.genero = datosLibro.genero();
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();
        if (datosLibro.descripcion() != null && !datosLibro.descripcion().isEmpty()) {
            this.descripcion = String.join(" ", datosLibro.descripcion());
        }
        if (datosLibro.autor() != null && !datosLibro.autor().isEmpty()) {
            this.autor = new Autor(datosLibro.autor().get(0));
            this.autor.setLibros(List.of(this));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Idioma> getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(List<Idioma> lenguaje) {
        this.lenguaje = lenguaje;
    }

    public List<String> getGenero() {
        return genero;
    }

    public void setGenero(List<String> genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        String nombreAutor = (autor != null) ? autor.getNombre() : "Desconocido";

        String nombresIdiomas = (lenguaje != null) ? lenguaje.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")) : "N/A";

        return """
                ---------- LIBRO ----------
                Título: %s
                Autor: %s
                Idiomas: %s
                Número de descargas: %.2f
                ---------------------------
                """.formatted(titulo, nombreAutor, nombresIdiomas, numeroDeDescargas
        );
    }
}

















