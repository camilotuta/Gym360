package main.java.com.Gym360.model.classes;

public class Usuario {

<<<<<<< HEAD
    private int idUsuario;
=======
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3
    private String nombreUsuario;
    private String contraseña;
    private String cargo;
    private String correo;
<<<<<<< HEAD
    private int idEmpleado;
=======
    private int idEmpleado; // clave primaria
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3

    // Constructor vacío
    public Usuario() {
    }

    // Constructor completo
<<<<<<< HEAD
    public Usuario(int idUsuario, String nombreUsuario, String contraseña, String cargo, String correo, int idEmpleado) {
        this.idUsuario = idUsuario;
=======
    public Usuario(int idEmpleado, String nombreUsuario, String contraseña, String cargo, String correo) {
        this.idEmpleado = idEmpleado;
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.cargo = cargo;
        this.correo = correo;
<<<<<<< HEAD
        this.idEmpleado = idEmpleado;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
=======
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3
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

<<<<<<< HEAD
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Usuario{"
                + "idUsuario=" + idUsuario
                + ", nombreUsuario='" + nombreUsuario + '\''
                + ", contraseña='" + contraseña + '\''
                + ", cargo='" + cargo + '\''
                + ", correo='" + correo + '\''
                + ", idEmpleado=" + idEmpleado
                + '}';
=======
    @Override
    public String toString() {
        return "Usuario{" + "idEmpleado=" + idEmpleado + ", nombreUsuario='" + nombreUsuario + '\'' + ", contraseña='"
                + contraseña + '\'' + ", cargo='" + cargo + '\'' + ", correo='" + correo + '\'' + '}';
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3
    }
}
