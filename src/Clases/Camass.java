package Clases;

public class Camass {
	//atributos
		public int numeroCama, categoria, estado;
		public double precioDia;
		
		public Camass(int num,int cat,double pre,int est) {
			numeroCama = num;
			categoria = cat;
			precioDia = pre;
			estado = est;
			
		}

		public int getNumeroCama() {
			return numeroCama;
		}

		public void setNumeroCama(int numeroCama) {
			this.numeroCama = numeroCama;
		}

		public int getCategoria() {
			return categoria;
		}

		public void setCategoria(int categoria) {
			this.categoria = categoria;
		}

		public int getEstado() {
			return estado;
		}

		public void setEstado(int estado) {
			this.estado = estado;
		}

		public double getPrecioDia() {
			return precioDia;
		}

		public void setPrecioDia(double precioDia) {
			this.precioDia = precioDia;
		}

}
