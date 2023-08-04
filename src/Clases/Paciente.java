package Clases;

public class Paciente {
	
	//variables
	int codigo,dni,telefono;
	String nombre,apellido;
	//constructor
	public Paciente(int co,String nom,String ape,int tele,int dn) {
		codigo= co;
		nombre= nom;
		apellido = ape;
		telefono =tele;
		dni = dn;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
