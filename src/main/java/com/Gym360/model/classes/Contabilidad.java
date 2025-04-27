// cSpell:ignore egresos
package main.java.com.Gym360.model.classes;

public class Contabilidad {

	private int idContabilidad;
	private double ingresos;
	private double egresos;

	// Constructor
	public Contabilidad() {
	}

	public Contabilidad(int idContabilidad, double ingresos, double egresos) {
		this.idContabilidad = idContabilidad;
		this.ingresos = ingresos;
		this.egresos = egresos;
	}

	// Getters y Setters
	public int getIdContabilidad() {
		return idContabilidad;
	}

	public void setIdContabilidad(int idContabilidad) {
		this.idContabilidad = idContabilidad;
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

	public double getEgresos() {
		return egresos;
	}

	public void setEgresos(double egresos) {
		this.egresos = egresos;
	}

	@Override
	public String toString() {
		return "Contabilidad{"
			+ "idContabilidad=" + idContabilidad
			+ ", ingresos=" + ingresos
			+ ", egresos=" + egresos
			+ '}';
	}
}
