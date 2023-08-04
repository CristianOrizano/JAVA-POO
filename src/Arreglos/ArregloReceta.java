package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Receta;

public class ArregloReceta {
	//atributos
	public ArrayList<Receta> receta;
	public String numeroReceta;
	//constructor
    public ArregloReceta(String numeroR) {
    	numeroReceta = numeroR;
    	receta = new ArrayList <Receta> ();
		cargarReceta(); 
    }   
//  Operaciones publicas basicas
	public void adicionar(Receta x) {
		receta.add(x);
	}
    public int tamaño() {
		return receta.size();
	}
	public Receta obtener(int i) {
		return receta.get(i);
	}
	public Receta buscar(int codigoMedicina) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodigoMedicina() == codigoMedicina)
				return obtener(i);
		  return null;
	}
	public void eliminar(Receta x) {
		receta.remove(x);
	}
	//grabar
	public void grabarReceta() {
		try {
			PrintWriter pw;
			String linea;
			Receta x;
			pw = new PrintWriter(new FileWriter(numeroReceta + ".txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoMedicina() + ";" +
						x.getCantidad() + ";" +
						x.getPrecioUnitario();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	//cargar
	private void cargarReceta() {
		try {
			BufferedReader br;
			String linea; 
			String[] s;
			int codigoMedicina, cantidad;
			double precioUnitario;
			br = new BufferedReader(new FileReader(numeroReceta + ".txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoMedicina = Integer.parseInt(s[0].trim());
				cantidad = Integer.parseInt(s[1].trim());
				precioUnitario = Double.parseDouble(s[2].trim());
				
				adicionar(new Receta(codigoMedicina, cantidad, precioUnitario));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}

}
