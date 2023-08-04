package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Paciente;

public class ArregloPaciente {
	
	//variable de tipo Arraylist
	public ArrayList<Paciente> pa;
	
	public ArregloPaciente() {
		pa = new ArrayList<Paciente>();
		cargar();
	}
    //operaciones basicas
	public int tamaño() {
		return pa.size();
	}
	public void eliminar(Paciente x) {
		 pa.remove(x);
	}
	public void adicionar(Paciente x) {
		pa.add(x);
	}
	public Paciente obtener(int a) {
		return pa.get(a);
	}
	public Paciente buscar(int codi) {
		for(int a=0;a<tamaño();a++)
			if(obtener(a).getCodigo()==codi)
				return obtener(a);
		       return null;
	}
	
	//guardar
	public void guardar() {
		try {
			PrintWriter pw;
			String s;
			Paciente x;
			pw = new PrintWriter(new FileWriter("Paciente.txt"));
			for(int a=0;a<tamaño();a++) {
				x = obtener(a);
				s = x.getCodigo()+";"+
					x.getNombre()+";"+
					x.getApellido()+";"+
					x.getTelefono()+";"+
					x.getDni();
				pw.println(s);
			}
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargar() {
		try {
			BufferedReader br;
			String linea;
			String [] s;
			int codigo,dni,telefono;
			String nombre,apellido;
			
			br = new BufferedReader(new FileReader("Paciente.txt"));
			while((linea=br.readLine()) !=null) {
				s= linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				apellido = s[2].trim();
				telefono = Integer.parseInt(s[3].trim());
				dni = Integer.parseInt(s[4].trim());
				adicionar(new Paciente(codigo, nombre, apellido, telefono, dni));
			}
			br.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int numeroCorrelativo() {
		if(tamaño()==0)
			return 20001;
		else
			return obtener(tamaño()-1).getCodigo()+1;
	}
	
}
