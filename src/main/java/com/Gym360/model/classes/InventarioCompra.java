package main.java.com.Gym360.model.classes;

public class InventarioCompra {

	private int idCompra;
	private String fecha;
	private double totalCompras;

	// Constructor vacío
	public InventarioCompra() {
	}

	// Constructor con parámetros
	public InventarioCompra(int idCompra, String fecha, double totalCompras) {
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.totalCompras = totalCompras;
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

	@Override
	public String toString() {
		return "InventarioCompra{" + "idCompra=" + idCompra + ", fecha='" + fecha + '\'' + ", totalCompras="
				+ totalCompras + '}';
	}
}
