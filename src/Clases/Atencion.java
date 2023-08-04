package Clases;

public class Atencion {
	
//	Atributos privados
	public int codigoAtencion, codigoPaciente, estado;
	public String fechaAtencion, horaAtencion;
	public double aPagar;

	//constructor
	public Atencion(int codigoA, int codigoP, String fechaA,
	        String horaAt, double aPag, int est)  {
		codigoAtencion = codigoA;
		codigoPaciente = codigoP;
		fechaAtencion = fechaA;
		horaAtencion = horaAt;
		aPagar = aPag;
		estado = est;
	}

	public int getCodigoAtencion() {
		return codigoAtencion;
	}

	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}

	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getHoraAtencion() {
		return horaAtencion;
	}

	public void setHoraAtencion(String horaAtencion) {
		this.horaAtencion = horaAtencion;
	}

	public double getaPagar() {
		return aPagar;
	}

	public void setaPagar(double aPagar) {
		this.aPagar = aPagar;
	}
	
	
}
