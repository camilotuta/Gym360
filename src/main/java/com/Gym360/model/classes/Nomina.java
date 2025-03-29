package main.java.com.Gym360.model.classes;


public class Nomina {

	private int idNomina;
	private String fecha;
	private double salarioBase;
	private double deducciones;
	private double bonificaciones;
	private int idEmpleado;

	// Constructor
	public Nomina() {
	}

	public Nomina(int idNomina, String fecha, double salarioBase, double deducciones,
		double bonificaciones, int idEmpleado) {
		this.idNomina = idNomina;
		this.fecha = fecha;
		this.salarioBase = salarioBase;
		this.deducciones = deducciones;
		this.bonificaciones = bonificaciones;
		this.idEmpleado = idEmpleado;
	}

	// Getters y Setters
	public int getIdNomina() {
		return idNomina;
	}

	public void setIdNomina(int idNomina) {
		this.idNomina = idNomina;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getDeducciones() {
		return deducciones;
	}

	public void setDeducciones(double deducciones) {
		this.deducciones = deducciones;
	}

	public double getBonificaciones() {
		return bonificaciones;
	}

	public void setBonificaciones(double bonificaciones) {
		this.bonificaciones = bonificaciones;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "Nomina{"
			+ "idNomina=" + idNomina
			+ ", fecha='" + fecha + '\''
			+ ", salarioBase=" + salarioBase
			+ ", deducciones=" + deducciones
			+ ", bonificaciones=" + bonificaciones
			+ ", idEmpleado=" + idEmpleado
			+ '}';
	}
}
