package main.java.com.Gym360.model.classes;

public class Usuario {

    private String nombreUsuario;
    private String contraseña;
    private String cargo;
    private String correo;
    private int idEmpleado; // clave primaria

    // Constructor vacío
    public Usuario() {
    }

    // Constructor completo
    public Usuario(int idEmpleado, String nombreUsuario, String contraseña, String cargo, String correo) {
        this.idEmpleado = idEmpleado;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.cargo = cargo;
        this.correo = correo;
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idEmpleado=" + idEmpleado + ", nombreUsuario='" + nombreUsuario + '\'' + ", contraseña='"
                + contraseña + '\'' + ", cargo='" + cargo + '\'' + ", correo='" + correo + '\'' + '}';
    }
}
