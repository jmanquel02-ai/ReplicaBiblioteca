package vista;

import controlador.BibliotecaController;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaVista {

    private BibliotecaController controller;
    private Scanner scanner;

    public BibliotecaVista() {
        this.controller = new BibliotecaController();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            try {
                switch (opcion) {
                    case 1:
                        registrarLibro();
                        break;

                    case 2:
                        registrarUsuario();
                        break;

                    case 3:
                        prestarLibro();
                        break;

                    case 4:
                        devolverLibro();
                        break;

                    case 5:
                        listarLibros();
                        break;

                    case 6:
                        listarUsuarios();
                        break;

                    case 7:
                        listarPrestamosActivos();
                        break;

                    case 8:
                        listarLibrosDisponibles();
                        break;

                    case 9:
                        buscarLibrosPorTitulo();
                        break;

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();

        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("===== Sistema Biblioteca =====");
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar usuario");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("5. Listar libros");
        System.out.println("6. Listar usuarios");
        System.out.println("7. Listar prestamos activos");
        System.out.println("8. Listar libros disponibles");
        System.out.println("9. Buscar libros por titulo");
        System.out.println("0. Salir");
    }

    private void registrarLibro() {
        System.out.println("--- Registro de libro ---");

        String codigo = leerTexto("Ingrese codigo del libro: ");
        String titulo = leerTexto("Ingrese titulo del libro: ");
        String autor = leerTexto("Ingrese autor del libro: ");

        controller.registrarLibro(codigo, titulo, autor);

        System.out.println("Libro registrado correctamente.");
    }

    private void registrarUsuario() {
        System.out.println("--- Registro de usuario ---");

        String id = leerTexto("Ingrese id del usuario: ");
        String nombre = leerTexto("Ingrese nombre del usuario: ");
        String correo = leerTexto("Ingrese correo del usuario: ");

        controller.registrarUsuario(id, nombre, correo);

        System.out.println("Usuario registrado correctamente.");
    }

    private void prestarLibro() {
        System.out.println("--- Prestamo de libro ---");

        String idUsuario = leerTexto("Ingrese id del usuario: ");
        String codigoLibro = leerTexto("Ingrese codigo del libro: ");

        Prestamo prestamo = controller.prestarLibro(idUsuario, codigoLibro);

        System.out.println("Prestamo registrado correctamente.");
        System.out.println(prestamo);
    }

    private void devolverLibro() {
        System.out.println("--- Devolucion de libro ---");

        String codigoLibro = leerTexto("Ingrese codigo del libro: ");

        controller.devolverLibro(codigoLibro);

        System.out.println("Libro devuelto correctamente.");
    }

    private void listarLibros() {
        System.out.println("--- Libros registrados ---");

        ArrayList<Libro> libros = controller.obtenerLibros();

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    private void listarUsuarios() {
        System.out.println("--- Usuarios registrados ---");

        ArrayList<Usuario> usuarios = controller.obtenerUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private void listarPrestamosActivos() {
        System.out.println("--- Prestamos activos ---");

        ArrayList<Prestamo> prestamos = controller.obtenerPrestamosActivos();

        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos activos.");
            return;
        }

        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    private void listarLibrosDisponibles() {
        System.out.println("--- Libros disponibles ---");

        ArrayList<Libro> librosDisponibles = controller.obtenerLibrosDisponibles();

        if (librosDisponibles.isEmpty()) {
            System.out.println("No hay libros disponibles.");
            return;
        }

        for (Libro libro : librosDisponibles) {
            System.out.println(libro);
        }
    }

    private void buscarLibrosPorTitulo() {
        System.out.println("--- Buscar libros por titulo ---");

        String tituloBuscado = leerTexto("Ingrese titulo o parte del titulo: ");

        ArrayList<Libro> resultados = controller.buscarLibrosPorTitulo(tituloBuscado);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron libros con ese titulo.");
            return;
        }

        System.out.println("--- Resultados encontrados ---");

        for (Libro libro : resultados) {
            System.out.println(libro);
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }
}