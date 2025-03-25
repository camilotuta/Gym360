package main.java.com.Gym360.model.classes;

public class Accounting {
    private int idContabilidad;
    private double ingresos;
    private double egresos;

    // Default constructor
    public Accounting() {
    }

    // Parameterized constructor
    public Accounting(int idContabilidad, double ingresos, double egresos) {
        this.idContabilidad = idContabilidad;
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    // Getters and setters
    public int getIdContabilidad() {
        return idContabilidad;
    }

    public void setIdContabilidad(int idContabilidad) {
        this.idContabilidad = idContabilidad;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    public double getEgresos() {
        return egresos;
    }

    public void setEgresos(double egresos) {
        this.egresos = egresos;
    }
}
