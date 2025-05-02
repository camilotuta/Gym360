package main.java.com.Gym360.model.classes;

public class Cliente {

    private String id; // Cambiado a String
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private double saldo;
    private String tipoMembresia; // Tipo de membresía ('1 año', '3 meses', '6 meses')

    // Constructor
    public Cliente() {
    }

    public Cliente(String id, String nombre, String apellido, String telefono, String email, double saldo,
            String tipoMembresia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.saldo = saldo;
        this.tipoMembresia = tipoMembresia;
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
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", saldo=" + saldo +
                ", tipoMembresia='" + tipoMembresia + '\'' +
                '}';
    }
}
