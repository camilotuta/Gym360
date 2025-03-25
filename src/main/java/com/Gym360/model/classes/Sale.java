package main.java.com.Gym360.model.classes;

public class Sale {
    private String idVenta;
    private String fecha;
    private double total;
    private String idEmpleado;
    private String idClienteProveedor;

    // Default constructor
    public Sale() {
    }

    // Parameterized constructor
    public Sale(String idVenta, String fecha, double total, String idEmpleado, String idClienteProveedor) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.idEmpleado = idEmpleado;
        this.idClienteProveedor = idClienteProveedor;
    }

    // Getters and setters
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdClienteProveedor() {
        return idClienteProveedor;
    }

    public void setIdClienteProveedor(String idClienteProveedor) {
        this.idClienteProveedor = idClienteProveedor;
    }
}
