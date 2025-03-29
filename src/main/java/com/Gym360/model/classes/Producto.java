package main.java.com.Gym360.model.classes;


public class Producto {

	private int idProducto;
	private String nombre;
	private String descripcion;
	private double precioUnitario;
	private int stock;
	private String categoria;
	private String codigoBarras;

	// Constructor
	public Producto() {
	}

	public Producto(int idProducto, String nombre, String descripcion, double precioUnitario,
		int stock, String categoria, String codigoBarras) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
		this.categoria = categoria;
		this.codigoBarras = codigoBarras;
	}

	// Getters y Setters
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	@Override
	public String toString() {
		return "Producto{"
			+ "idProducto=" + idProducto
			+ ", nombre='" + nombre + '\''
			+ ", descripcion='" + descripcion + '\''
			+ ", precioUnitario=" + precioUnitario
			+ ", stock=" + stock
			+ ", categoria='" + categoria + '\''
			+ ", codigoBarras='" + codigoBarras + '\''
			+ '}';
	}
}
