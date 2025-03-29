package main.java.com.Gym360.model.classes;

public class Venta {

	private int idVenta;
	private String fecha;
	private double total;
	private int idEmpleado;
	private int idClienteProveedor;

	// Constructor
	public Venta() {
	}

	public Venta(int idVenta, String fecha, double total, int idEmpleado, int idClienteProveedor) {
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.total = total;
		this.idEmpleado = idEmpleado;
		this.idClienteProveedor = idClienteProveedor;
	}

	// Getters y Setters
	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
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

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdClienteProveedor() {
		return idClienteProveedor;
	}

	public void setIdClienteProveedor(int idClienteProveedor) {
		this.idClienteProveedor = idClienteProveedor;
	}

	@Override
	public String toString() {
		return "Venta{"
			+ "idVenta=" + idVenta
			+ ", fecha='" + fecha + '\''
			+ ", total=" + total
			+ ", idEmpleado=" + idEmpleado
			+ ", idClienteProveedor=" + idClienteProveedor
			+ '}';
	}
}
