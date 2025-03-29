package main.java.com.Gym360.model.classes;


public class InventarioCompra {

	private int idCompra;
	private String fecha;
	private double totalCompras;
	private int idClienteProveedor;

	// Constructor
	public InventarioCompra() {
	}

	public InventarioCompra(int idCompra, String fecha, double totalCompras, int idClienteProveedor) {
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.totalCompras = totalCompras;
		this.idClienteProveedor = idClienteProveedor;
	}

	// Getters y Setters
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
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

	public int getIdClienteProveedor() {
		return idClienteProveedor;
	}

	public void setIdClienteProveedor(int idClienteProveedor) {
		this.idClienteProveedor = idClienteProveedor;
	}

	@Override
	public String toString() {
		return "InventarioCompras{"
			+ "idCompra=" + idCompra
			+ ", fecha='" + fecha + '\''
			+ ", totalCompras=" + totalCompras
			+ ", idClienteProveedor=" + idClienteProveedor
			+ '}';
	}
}
