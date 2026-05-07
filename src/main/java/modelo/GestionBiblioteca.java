package modelo;

import java.util.ArrayList;

public interface GestionBiblioteca {

    void agregarLibro(Libro libro);

    void agregarUsuario(Usuario usuario);

    Prestamo registrarPrestamo(String idUsuario, String codigoLibro);

    void devolverLibro(String codigoLibro);

    ArrayList<Libro> listarLibros();

    ArrayList<Usuario> listarUsuarios();

    ArrayList<Prestamo> listarPrestamosActivos();

    ArrayList<Libro> listarLibrosDisponibles();

    ArrayList<Libro> buscarLibrosPorTitulo(String tituloBuscado);
}