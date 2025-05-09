package main.java.com.Gym360.model.classes;


public class DetalleCompra {

	private int idDetalleCompra;
	private int idCompra;
	private int idProducto;
	private int cantidad;
	private double precioUnitario;

	// Constructor
	public DetalleCompra() {
	}

	public DetalleCompra(int idDetalleCompra, int idCompra, int idProducto, int cantidad, double precioUnitario) {
		this.idDetalleCompra = idDetalleCompra;
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	// Getters y Setters
	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "DetalleCompra{"
			+ "idDetalleCompra=" + idDetalleCompra
			+ ", idCompra=" + idCompra
			+ ", idProducto=" + idProducto
			+ ", cantidad=" + cantidad
			+ ", precioUnitario=" + precioUnitario
			+ '}';
	}
}
