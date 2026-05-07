Repositorio educativo para estudiar el paso desde una narrativa de problema hacia el diseño UML y la implementación Java de un sistema básico de biblioteca organizado bajo MVC.

# Sistema Biblioteca POO MVC

Proyecto educativo desarrollado en Java para ilustrar el análisis, diseño e implementación de un sistema básico de gestión de biblioteca utilizando Programación Orientada a Objetos y una organización basada en el patrón Modelo–Vista–Controlador (MVC).

## Descripción

El sistema permite gestionar libros, usuarios y préstamos de una biblioteca escolar mediante una aplicación de consola. El objetivo principal es mostrar cómo una narrativa de problema puede transformarse progresivamente en clases, relaciones, paquetes, reglas de negocio y código Java funcional.

## Funcionalidades principales

- Registro de libros con código, título, autor y estado de disponibilidad.
- Registro de usuarios con identificador, nombre y correo electrónico.
- Registro de préstamos de libros a usuarios.
- Validación de disponibilidad antes de realizar un préstamo.
- Registro de devoluciones.
- Consulta de libros registrados.
- Consulta de usuarios registrados.
- Consulta de préstamos activos.
- Listado de libros disponibles.
- Búsqueda de libros por título.

## Organización del proyecto

El proyecto está organizado siguiendo una estructura MVC:

- `modelo`: contiene las clases del dominio, como `Libro`, `Usuario`, `Prestamo`, `Biblioteca` y la interfaz `GestionBiblioteca`.
- `controlador`: contiene la clase `BibliotecaController`, responsable de coordinar las operaciones del sistema.
- `vista`: contiene la clase `BibliotecaVista`, encargada de la interacción por consola.
- `app`: contiene la clase `Main`, punto de entrada de la aplicación.
- `diagrama.puml`: contiene el diagrama UML del sistema desarrollado con PlantUML.

## Objetivo pedagógico

Este proyecto busca apoyar el aprendizaje de conceptos fundamentales de POO, tales como clases, objetos, encapsulamiento, asociaciones, dependencias, colecciones, reglas de negocio, separación de responsabilidades, organización de código mediante paquetes y uso básico de interfaces.

## Ejecución

Ejecutar la clase principal ubicada en:

`src/main/java/app/Main.java`

También se puede ejecutar desde terminal con Maven usando:

`mvn compile`

y luego:

`mvn exec:java -Dexec.mainClass="app.Main"`

## Menú del sistema

Al ejecutar el programa, se muestra el siguiente menú:

1. Registrar libro.
2. Registrar usuario.
3. Prestar libro.
4. Devolver libro.
5. Listar libros.
6. Listar usuarios.
7. Listar préstamos activos.
8. Listar libros disponibles.
9. Buscar libros por título.
0. Salir.

## Extensiones implementadas de la Sección 16

Además de replicar el caso base de la biblioteca, se implementaron dos extensiones mencionadas en la Sección 16 del apunte:

1. Validación de correo.
2. Uso de interfaces.

### Extensión 1: Validación de correo

Se agregó una validación básica al momento de registrar usuarios. Esta validación impide registrar usuarios con correos vacíos o con formato incorrecto.

La validación se implementó en la clase `Usuario`, mediante el método privado `correoValido(String correo)`.

Ejemplos de correos aceptados:

- `jonathan@gmail.com`
- `usuario@ufromail.cl`

Ejemplos de correos rechazados:

- `jonathangmail.com`
- `jonathan@`
- `@gmail.com`

Con esta extensión, si el usuario ingresa un correo inválido, el sistema muestra un mensaje de error y no registra el usuario.

### Extensión 2: Uso de interfaces

Se agregó la interfaz `GestionBiblioteca`, ubicada en el paquete `modelo`.

Esta interfaz define las operaciones principales que debe cumplir una biblioteca, por ejemplo:

- `agregarLibro(Libro libro)`
- `agregarUsuario(Usuario usuario)`
- `registrarPrestamo(String idUsuario, String codigoLibro)`
- `devolverLibro(String codigoLibro)`
- `listarLibros()`
- `listarUsuarios()`
- `listarPrestamosActivos()`
- `listarLibrosDisponibles()`
- `buscarLibrosPorTitulo(String tituloBuscado)`

La clase `Biblioteca` implementa esta interfaz mediante `implements GestionBiblioteca`.

Esto permite separar el contrato de operaciones de su implementación concreta. La interfaz define qué operaciones debe tener una biblioteca, mientras que la clase `Biblioteca` contiene la lógica real para ejecutar esas operaciones.

## Mejoras adicionales implementadas

Además de las dos extensiones principales de la Sección 16, se agregaron dos mejoras funcionales al sistema:

- Listar sólo libros disponibles.
- Buscar libros por título.

Estas mejoras se integraron al menú principal como opciones 8 y 9.

### Listar libros disponibles

Permite mostrar únicamente los libros que se encuentran disponibles para préstamo. Si un libro ya fue prestado, no aparece en este listado.

Métodos relacionados:

- `listarLibrosDisponibles()`
- `obtenerLibrosDisponibles()`
- `listarLibrosDisponibles()` en la vista.

### Buscar libros por título

Permite buscar libros registrados ingresando el título completo o sólo una parte del título. La búsqueda no distingue entre mayúsculas y minúsculas.

Métodos relacionados:

- `buscarLibrosPorTitulo(String tituloBuscado)` en `Biblioteca`.
- `buscarLibrosPorTitulo(String tituloBuscado)` en `BibliotecaController`.
- `buscarLibrosPorTitulo()` en `BibliotecaVista`.

## Respuestas Sección 15

### 1. ¿Qué ventaja tiene organizar el proyecto en paquetes?

Organizar el proyecto en paquetes permite separar las responsabilidades del sistema. De esta forma, las clases del modelo, la vista, el controlador y la aplicación principal quedan ordenadas según su función. Esto facilita la comprensión, mantención y extensión del código.

### 2. ¿Qué problema podría surgir si toda la lógica estuviera en la clase Main?

Si toda la lógica estuviera en la clase `Main`, el programa sería difícil de leer, modificar y mantener. Además, se mezclarían responsabilidades distintas, como registrar datos, aplicar reglas de negocio, mostrar mensajes y controlar la ejecución del sistema.

### 3. ¿Qué diferencia existe entre una clase del modelo y una clase controladora?

Una clase del modelo representa entidades y reglas del dominio, por ejemplo `Libro`, `Usuario`, `Prestamo` o `Biblioteca`. En cambio, una clase controladora coordina las operaciones entre la vista y el modelo. En este proyecto, `BibliotecaController` recibe las solicitudes de la vista y las deriva hacia la clase `Biblioteca`.

### 4. ¿Qué diferencia existe entre asociación y dependencia?

Una asociación es una relación más estable entre clases. Por ejemplo, un `Prestamo` se asocia con un `Usuario` y un `Libro`. Una dependencia ocurre cuando una clase utiliza a otra para realizar una acción, pero no necesariamente forma parte permanente de su estructura.

### 5. ¿Por qué Prestamo debe ser una clase independiente?

`Prestamo` debe ser una clase independiente porque representa una acción importante del sistema con información propia, como el usuario, el libro, la fecha de préstamo, la fecha de devolución y el estado del préstamo. No es sólo un dato del libro ni del usuario, sino una entidad con comportamiento propio.

### 6. ¿Qué regla impide prestar dos veces el mismo libro?

La regla que impide prestar dos veces el mismo libro es la validación de disponibilidad. Antes de registrar un préstamo, el sistema verifica si el libro está disponible. Si el libro ya fue prestado, no debe permitirse un nuevo préstamo sobre ese mismo libro.

### 7. ¿Qué clase debería encargarse de mostrar mensajes al usuario?

La clase que debe encargarse de mostrar mensajes al usuario es `BibliotecaVista`, porque pertenece a la vista y su responsabilidad es interactuar con el usuario mediante la consola.

### 8. ¿Qué clase debería encargarse de modificar el estado de un libro?

La modificación directa del estado del libro debe realizarse en la clase `Libro`, mediante métodos como `prestar()` y `devolver()`. Sin embargo, la coordinación de cuándo llamar a esos métodos ocurre a través de las reglas implementadas en `Biblioteca`.

### 9. ¿Qué cambios serían necesarios para agregar persistencia en archivos?

Para agregar persistencia en archivos sería necesario crear métodos para guardar y cargar la información de libros, usuarios y préstamos. También podría agregarse una clase encargada del manejo de archivos, para no mezclar esa responsabilidad directamente con la vista o con el `Main`.

### 10. ¿Qué cambios serían necesarios para transformar este sistema en una aplicación con interfaz gráfica?

Sería necesario reemplazar o complementar la vista por una interfaz gráfica, por ejemplo usando Swing o JavaFX. El modelo podría mantenerse casi igual, porque contiene las reglas del dominio. El controlador también podría reutilizarse, adaptando la forma en que recibe las solicitudes desde la nueva interfaz.

### 11. ¿Por qué la vista no debería acceder directamente a las listas internas de Biblioteca?

La vista no debería acceder directamente a las listas internas de `Biblioteca` porque eso rompería el encapsulamiento. Si la vista pudiera modificar las listas directamente, podría alterar los datos sin respetar las reglas del negocio.

### 12. ¿Qué ventajas tiene que Biblioteca retorne copias de sus listas?

Retornar copias de las listas protege los datos internos de la biblioteca. Así, otras clases pueden consultar la información, pero no modificar directamente las colecciones originales. Esto ayuda a mantener el control de las reglas del sistema dentro de la clase `Biblioteca`.

## Autor

Jonathan Manquel.