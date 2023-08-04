package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Atencion;

public class ArregloAtencion {
	
	//atributo
	ArrayList<Atencion> ate;
	//constructor
	public ArregloAtencion() {
		ate = new ArrayList<Atencion>();
		cargar();
	}
	
	//operaciones basicas
	public int tamaño() {
		return ate.size();
	}
	public void eliminar(Atencion x) {
		ate.remove(x);
	}
	public void adicionar(Atencion x) {
		ate.add(x);
	}
	public Atencion obtener(int a) {
		return ate.get(a);
	}
	public Atencion buscar(int codi) {
		for(int a=0;a<tamaño();a++)
			if(obtener(a).getCodigoAtencion()==codi)
				return obtener(a);
		        return null;
	}
	
	//Guardar
	public void Guardar() {
		try {
			PrintWriter pw;
			String s;
			Atencion x;
			pw = new  PrintWriter(new FileWriter("Atenciones.txt"));
			for(int a=0;a<tamaño();a++) {
				x = obtener(a);
				s=      x.getCodigoAtencion() + ";" +
						x.getCodigoPaciente() + ";" +
						x.getFechaAtencion() + ";" +
						x.getHoraAtencion() + ";" +
						x.getaPagar() + ";" +
						x.getEstado();
				pw.println(s);
			}
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//cargar
	public void cargar() {
		try {
			BufferedReader br;
			String linea;
			String s[];
			int codigoAte, codigoPac, esta;
			 String fechaAte, horaAten;
			 double aPaga;
		br = new BufferedReader(new FileReader("Atenciones.txt"));
		while( (linea= br.readLine()) != null) {
			s = linea.split(";");
			codigoAte = Integer.parseInt(s[0].trim());
			codigoPac = Integer.parseInt(s[1].trim());
			fechaAte = s[2].trim();
			horaAten = s[3].trim();
			aPaga = Double.parseDouble(s[4].trim());
			esta = Integer.parseInt(s[5].trim());
			adicionar(new Atencion(codigoAte, codigoPac, fechaAte, horaAten, aPaga, esta));
		}
			 br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
       //  Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 40001;
		else
			return obtener(tamaño()-1).getCodigoAtencion() + 1;
	}
	//
	public boolean procedeCodigoPacientes(int codigoPaciente) {
		for (int i=tamaño()-1; i>=0; i--)
			if (obtener(i).getCodigoPaciente() == codigoPaciente  &&  obtener(i).getEstado() == 0)
				return false;
		return true;
	}
	

}
