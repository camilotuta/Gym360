package main.java.com.Gym360.model.classes;

public class Employee {
    private String idEmpleado;
    private String nombre;
    private String apellido;
    private double salario;
    private String fechaContratacion;
    private String cargo;
    private String telefono;
    private String email;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String idEmpleado, String nombre, String apellido, double salario,
            String fechaContratacion, String cargo, String telefono, String email) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.cargo = cargo;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters and setters
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
}
