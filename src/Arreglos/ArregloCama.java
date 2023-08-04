package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Camass;

public class ArregloCama {
	
	//atrubuto arraylist
	public ArrayList<Camass> ca;
	//constructor
	public ArregloCama () {
		ca = new ArrayList<Camass>();
		cargar();
	}
	
	//operaciones publicas
	public int tamaño() {
		return ca.size();
	}
	public void adicionar(Camass x) {
		ca.add(x);
	}
	public void Eliminar(Camass x) {
		ca.remove(x);
	}
	public Camass obtener(int x) {
		return ca.get(x);
	}
	public Camass Buscar(int num) {
		for(int a=0;a<tamaño();a++)
			if(obtener(a).getNumeroCama()==num)
				return obtener(a);
		return null;
	}
	
	//guardar
	public void guardar() {
		try {
			PrintWriter pr;
			Camass c;
			String s;
			pr = new PrintWriter(new FileWriter("Cama.txt"));
			for(int a=0;a<tamaño();a++) {
				c= obtener(a);
				s= c.getNumeroCama()+";"+
					c.getCategoria()+";"+
				 c.getPrecioDia()+";"+
				 c.getEstado();
				pr.println(s);
			}
			pr.close();
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
			int num,cate,est;
			double pre;
			br = new BufferedReader(new FileReader("Cama.txt"));
			while((linea= br.readLine()) != null) {
				s= linea.split(";");
				num= Integer.parseInt(s[0].trim());
				cate= Integer.parseInt(s[1].trim());
				pre= Double.parseDouble(s[2].trim());
				est= Integer.parseInt(s[3].trim());
				adicionar(new Camass(num, cate, pre, est));
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int numeroCorrelativo() {
		if (tamaño() == 0)
			return 10001;
		else
			return obtener(tamaño()-1).getNumeroCama() + 1;
	}
	

}
