package Clases;

public class Receta {
      // Atributos privados
	public int codigoMedicina, cantidad;
	public double precioUnitario;	
	
	public Receta(int codigoMedici, int cantid, double precioUni) {
		codigoMedicina = codigoMedici;
		cantidad = cantid;
		precioUnitario = precioUni;
	}

	public int getCodigoMedicina() {
		return codigoMedicina;
	}

	public void setCodigoMedicina(int codigoMedicina) {
		this.codigoMedicina = codigoMedicina;
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

	
}
