package main.java.com.Gym360.model.classes;


public class Transaccion {

	private int idTransaccion;
	private int idContabilidad;
	private String descripcion;

	// Constructor
	public Transaccion() {
	}

	public Transaccion(int idTransaccion, int idContabilidad, String descripcion) {
		this.idTransaccion = idTransaccion;
		this.idContabilidad = idContabilidad;
		this.descripcion = descripcion;
	}

	// Getters y Setters
	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public int getIdContabilidad() {
		return idContabilidad;
	}

	public void setIdContabilidad(int idContabilidad) {
		this.idContabilidad = idContabilidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Transaccion{"
			+ "idTransaccion=" + idTransaccion
			+ ", idContabilidad=" + idContabilidad
			+ ", descripcion='" + descripcion + '\''
			+ '}';
	}
}
