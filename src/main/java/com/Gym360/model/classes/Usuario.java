package main.java.com.Gym360.model.classes;


public class Usuario {

	private int idUsuario;
	private String nombreUsuario;
	private String contraseña;
	private String cargo;
	private int idEmpleado;

	// Constructor
	public Usuario() {
	}

	public Usuario(int idUsuario, String nombreUsuario, String contraseña, String cargo, int idEmpleado) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.cargo = cargo;
		this.idEmpleado = idEmpleado;
	}

	// Getters y Setters
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "Usuario{"
			+ "idUsuario=" + idUsuario
			+ ", nombreUsuario='" + nombreUsuario + '\''
			+ ", contraseña='" + contraseña + '\''
			+ ", cargo='" + cargo + '\''
			+ ", idEmpleado=" + idEmpleado
			+ '}';
	}
}
