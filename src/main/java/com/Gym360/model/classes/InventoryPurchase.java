package main.java.com.Gym360.model.classes;

public class InventoryPurchase {
    private String idCompra;
    private String fecha;
    private double totalCompras;
    private String idClienteProveedor;

    // Default constructor
    public InventoryPurchase() {
    }

    // Parameterized constructor
    public InventoryPurchase(String idCompra, String fecha, double totalCompras, String idClienteProveedor) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.totalCompras = totalCompras;
        this.idClienteProveedor = idClienteProveedor;
    }

    // Getters and setters
    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(double totalCompras) {
        this.totalCompras = totalCompras;
    }

    public String getIdClienteProveedor() {
        return idClienteProveedor;
    }

    public void setIdClienteProveedor(String idClienteProveedor) {
        this.idClienteProveedor = idClienteProveedor;
    }
}
