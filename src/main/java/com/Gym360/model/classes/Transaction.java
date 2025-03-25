package main.java.com.Gym360.model.classes;

public class Transaction {
    private int idTransaccion;
    private int idContabilidad;
    private String descripcion;

    // Default constructor
    public Transaction() {
    }

    // Parameterized constructor
    public Transaction(int idTransaccion, int idContabilidad, String descripcion) {
        this.idTransaccion = idTransaccion;
        this.idContabilidad = idContabilidad;
        this.descripcion = descripcion;
    }

    // Getters and setters
    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdContabilidad() {
        return idContabilidad;
    }

    public void setIdContabilidad(int idContabilidad) {
        this.idContabilidad = idContabilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
