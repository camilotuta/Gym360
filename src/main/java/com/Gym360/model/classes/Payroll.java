package main.java.com.Gym360.model.classes;

public class Payroll {
    private String idNomina;
    private String fecha;
    private double salarioBase;
    private double deducciones;
    private double bonificaciones;
    private String idEmpleado;

    // Default constructor
    public Payroll() {
    }

    // Parameterized constructor
    public Payroll(String idNomina, String fecha, double salarioBase, double deducciones, double bonificaciones,
            String idEmpleado) {
        this.idNomina = idNomina;
        this.fecha = fecha;
        this.salarioBase = salarioBase;
        this.deducciones = deducciones;
        this.bonificaciones = bonificaciones;
        this.idEmpleado = idEmpleado;
    }

    // Getters and setters
    public String getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(String idNomina) {
        this.idNomina = idNomina;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(double deducciones) {
        this.deducciones = deducciones;
    }

    public double getBonificaciones() {
        return bonificaciones;
    }

    public void setBonificaciones(double bonificaciones) {
        this.bonificaciones = bonificaciones;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
