package main.java.com.Gym360.model.classes;

public class DetalleVenta {
	private int idDetalleVenta;
	private int idVenta;
	private int idProducto;

	public DetalleVenta() {
	}

	public DetalleVenta(int idDetalleVenta, int idVenta, int idProducto) {
		this.idDetalleVenta = idDetalleVenta;
		this.idVenta = idVenta;
		this.idProducto = idProducto;
	}

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
}
