package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Medicina;
import Clases.Paciente;

public class ArregloMedicina {

	//Variable de tipo Arraylist
	public ArrayList<Medicina> me ;
	//constructor
	public ArregloMedicina() {
		me = new ArrayList<Medicina>();
		Cargar();
		
	}
	//operacions basicas
	public int tamaño() {
		return me.size();
	}
	public void eliminar(Medicina x) {
		me.remove(x);
	}
	public void adicionar(Medicina x) {
		me.add(x);
	}
	public Medicina obtener(int x) {
		return me.get(x);
	}
	public Medicina buscar(int codi) {
		for(int a=0;a<tamaño();a++)
			if(obtener(a).getCodigoMedicina()==codi)
				return obtener(a);
		        return null;
	}
	
	//guardar
	
	public void Guardar() {
		try {
			PrintWriter pw ;
			String s;
			Medicina x;
			pw = new PrintWriter(new FileWriter("Medicina.txt"));
			for(int a=0;a<tamaño();a++) {
				x=obtener(a);
				s = x.getCodigoMedicina()+";"+ 
						x.getNombre()+";"+ 
						x.getLaboratorio()+";"+ 
						x.getStock()+";"+
						x.getPrecioUnitario();
				pw.println(s);
			}
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//cargar
	public void Cargar() {
		try {
			BufferedReader br;
			String linea;
			String []s;
		 int codigoMedicina, stock;
		 String nombre, laboratorio;
	      double precioUnitario;
	      
	      br = new BufferedReader( new FileReader("Medicina.txt"));
			while((linea= br.readLine()) != null ) {
				s = linea.split(";");
				codigoMedicina = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				laboratorio = s[2].trim();
				stock = Integer.parseInt(s[3].trim());
				precioUnitario = Double.parseDouble(s[4].trim());
				
				adicionar(new Medicina(codigoMedicina, nombre, laboratorio, stock, precioUnitario));
			}
	      br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int correlativi() {
		
		if(tamaño()==0)
			return 30001;
		else 
			return obtener(tamaño()-1).getCodigoMedicina()+1;
	}
	
}
