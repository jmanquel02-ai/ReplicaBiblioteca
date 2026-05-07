package modelo;

public class Usuario {

    private String id;
    private String nombre;
    private String correo;

    public Usuario(String id, String nombre, String correo) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El id del usuario no puede estar vacio.");
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacio.");
        }

        if (!correoValido(correo)) {
            throw new IllegalArgumentException("El correo ingresado no es valido.");
        }

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    private boolean correoValido(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            return false;
        }

        String correoLimpio = correo.trim();

        return correoLimpio.contains("@")
                && correoLimpio.contains(".")
                && correoLimpio.indexOf("@") > 0
                && correoLimpio.indexOf("@") < correoLimpio.length() - 1;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " - " + correo;
    }
}