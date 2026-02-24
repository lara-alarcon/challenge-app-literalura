package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner entrada = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    private final String URL_BASE = "https://gutendex.com/books/";

    private List<DatosLibro> datosLibros;
    private List<Libro> libros;

    private List<DatosAutor> datosAutores;
    private List<Autor> autores;

    private Optional<Libro> libroBuscado;

    private LibroRepository repositorio;
    private AutorRepository autorRepositorio;

    public Principal(LibroRepository repository, AutorRepository autorRepositorio) {
        this.repositorio = repository;
        this.autorRepositorio = autorRepositorio;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1- Buscar libro por título
                    2- Mostrar libros registrados
                    3- Mostrar autores registrados
                    4- Mostrar autores vivos en un determinado año
                    5- Mostrar libros por idioma
                    6- Mostrar libros por categoría/género
                    0- Salir
                    """;
            System.out.println(menu);

            try {
                opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                    case 2:
                        mostrarLibrosRegistrados();
                        break;
                    case 3:
                        mostrarAutoresRegistrados();
                        break;
                    case 4:
                        mostrarAutoresDeUnDeterminadoAnio();
                        break;
                    case 5:
                        mostrarLibrosPorIdioma();
                        break;
                    case 6:
                        mostarLibrosPorCategoria();
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
            }
            }catch(InputMismatchException e){
                System.out.println("ERROR: Solo se admiten números.");
                entrada.nextLine();
                opcion = -1;
            }
        }
    }

    private DatosLibro getDatosLibros(String nombreLibro) {
        var json = consumoApi.obtenerDatos((URL_BASE + "?search=" + nombreLibro.replace(" ", "%20")));
        Datos datosRespuesta = convierteDatos.obtenerDatos(json, Datos.class);

        if (datosRespuesta != null && !datosRespuesta.resultados().isEmpty()) {
            return datosRespuesta.resultados().get(0);
        } else {
            System.out.println("Libro no encontrado.");
            return null;
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Escribe el nombre del libro que deseas buscar: ");
        var nombreLibro = entrada.nextLine();

        Optional<Libro> libroBuscado = repositorio.findByTituloContainsIgnoreCase(nombreLibro);

        if (libroBuscado.isPresent()) {
            System.out.println("\n¡El libro ya se encuentra en la base de datos!");
            System.out.println(libroBuscado.get());
        }else {
            DatosLibro datos = getDatosLibros(nombreLibro);

            if (datos != null) {
                Libro libroNuevo = new Libro(datos);
                String nombreAutor = libroNuevo.getAutor().getNombre();
                Optional<Autor> autorExiste = autorRepositorio.findByNombreContainsIgnoreCase(nombreAutor);

                if (autorExiste.isPresent()) {
                    Autor autorBD = autorExiste.get();
                    libroNuevo.setAutor(autorBD);
//                    libroNuevo.setAutor(autorExiste.get());
                }else {
                    autorRepositorio.save(libroNuevo.getAutor());
                }

                repositorio.save(libroNuevo);
                System.out.println("\nLibro encontrado y guardado exitosamente:");
                System.out.println(libroNuevo);
            }else {
                System.out.println("Libro no encontrado.");
            }
        }
    }


    private void mostrarLibrosRegistrados() {
        libros = repositorio.findAll();
        libros.forEach(System.out::println);
    }

    private void mostrarAutoresRegistrados() {
        List<Autor> autores = autorRepositorio.findAll();
        autores.forEach(System.out::println);
    }

    private void mostrarAutoresDeUnDeterminadoAnio() {
        System.out.println("Ingresa el año vivo de auto(es) que desea buscar: ");

        try {
            var anio = entrada.nextInt();
            entrada.nextLine();
            var autores = autorRepositorio.buscarAutoresVivosEnAnio(anio);

            if (autores.isEmpty()) {
                System.out.println("No se encontraron autores registrados que estuvieran vivos en el año " + anio);
            }else {
                System.out.println("\n--- Autores vivos en el año " + anio + " ---");
                autores.forEach(System.out::println);
            }

        }catch (InputMismatchException e) {
            System.out.println("ERROR: Ingrese año en formato numérico.");
            entrada.nextLine();
        }
    }

    private void mostrarLibrosPorIdioma() {
        System.out.println("Ingrese el código del idioma (es, en, fr, pt): ");
        var nombreIdioma = entrada.nextLine();

        try {
            Idioma idioma = Idioma.fromString(nombreIdioma);

            var libros = repositorio.buscarPorIdioma(idioma);

            if (libros.isEmpty()) {
                System.out.println("No hay libros registrados en ese idioma.");
            } else {
                libros.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Idioma no válido o no reconocido.");
        }
    }

    private void mostarLibrosPorCategoria() {
        System.out.println("¿Qué categoría buscas?");
        var categoria = entrada.nextLine();
        var libros = repositorio.buscarPorCategoria(categoria);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros para la categoría: " + categoria);
            System.out.println("Intenta con términos en inglés como 'Fiction' o 'Drama'.");
        } else {
            System.out.println("\n--- Libros encontrados ---");
            libros.forEach(System.out::println);
        }
    }
}































