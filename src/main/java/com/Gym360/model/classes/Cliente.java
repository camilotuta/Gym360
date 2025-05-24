package main.java.com.Gym360.model.classes;

public class Cliente {

    private String id; // cédula
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String contraseña; // Nuevo campo
    private double saldo;
    private String tipoMembresia; // '1 año', '3 meses', '6 meses'
    private String estado; // 'Activo', 'Inactivo'

    // Constructor vacío
    public Cliente() {
    }

    // Constructor completo
    public Cliente(String id, String nombre, String apellido, String telefono, String email, String contraseña,
            double saldo, String tipoMembresia, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.contraseña = contraseña;
        this.saldo = saldo;
        this.tipoMembresia = tipoMembresia;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id='" + id + '\'' + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\''
                + ", telefono='" + telefono + '\'' + ", email='" + email + '\'' + ", contraseña='" + contraseña + '\''
                + ", saldo=" + saldo + ", tipoMembresia='" + tipoMembresia + '\'' + '}';
    }
}
