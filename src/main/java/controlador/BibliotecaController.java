package controlador;

import modelo.Biblioteca;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;

import java.util.ArrayList;

public class BibliotecaController {

    private Biblioteca biblioteca;

    public BibliotecaController() {
        this.biblioteca = new Biblioteca();
    }

    public void registrarLibro(String codigo, String titulo, String autor) {
        Libro libro = new Libro(codigo, titulo, autor);
        biblioteca.agregarLibro(libro);
    }

    public void registrarUsuario(String id, String nombre, String correo) {
        Usuario usuario = new Usuario(id, nombre, correo);
        biblioteca.agregarUsuario(usuario);
    }

    public Prestamo prestarLibro(String idUsuario, String codigoLibro) {
        return biblioteca.registrarPrestamo(idUsuario, codigoLibro);
    }

    public void devolverLibro(String codigoLibro) {
        biblioteca.devolverLibro(codigoLibro);
    }

    public ArrayList<Libro> obtenerLibros() {
        return biblioteca.listarLibros();
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        return biblioteca.listarUsuarios();
    }

    public ArrayList<Prestamo> obtenerPrestamosActivos() {
        return biblioteca.listarPrestamosActivos();
    }

    public ArrayList<Libro> obtenerLibrosDisponibles() {
        return biblioteca.listarLibrosDisponibles();
    }

    public ArrayList<Libro> buscarLibrosPorTitulo(String tituloBuscado) {
        return biblioteca.buscarLibrosPorTitulo(tituloBuscado);
    }
}