package Clases;

public class Medicina {
	
	//variables
	public int codigoMedicina, stock;
	public String nombre, laboratorio;
	public double precioUnitario;
	
	//constructor
	public Medicina(int codi,String nom,String labo,int sto,double pre) {
		codigoMedicina = codi;
		nombre = nom;
		laboratorio = labo;
		stock = sto;
		precioUnitario = pre;
	}

	public int getCodigoMedicina() {
		return codigoMedicina;
	}

	public void setCodigoMedicina(int codigoMedicina) {
		this.codigoMedicina = codigoMedicina;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
