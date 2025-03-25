package main.java.com.Gym360.model.classes;

public class SaleDetail {
    private int idDetalleVenta;
    private String idVenta;
    private String producto;

    // Default constructor
    public SaleDetail() {
    }

    // Parameterized constructor
    public SaleDetail(int idDetalleVenta, String idVenta, String producto) {
        this.idDetalleVenta = idDetalleVenta;
        this.idVenta = idVenta;
        this.producto = producto;
    }

    // Getters and setters
    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
