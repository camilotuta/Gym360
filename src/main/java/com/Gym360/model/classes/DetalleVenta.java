package main.java.com.Gym360.model.classes;


public class DetalleVenta {

	private int idDetalleVenta;
	private int idVenta;
	private int idProducto;
	private int cantidad;
	private double precioUnitario;

	// Constructor
	public DetalleVenta() {
	}

	public DetalleVenta(int idDetalleVenta, int idVenta, int idProducto, int cantidad, double precioUnitario) {
		this.idDetalleVenta = idDetalleVenta;
		this.idVenta = idVenta;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	// Getters y Setters
	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
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
		return "DetalleVenta{"
			+ "idDetalleVenta=" + idDetalleVenta
			+ ", idVenta=" + idVenta
			+ ", idProducto=" + idProducto
			+ ", cantidad=" + cantidad
			+ ", precioUnitario=" + precioUnitario
			+ '}';
	}
}
