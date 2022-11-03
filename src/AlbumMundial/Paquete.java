package AlbumMundial;

import java.util.ArrayList;
import java.util.Random;
//import AlbumMundial.Figurita;




public class Paquete {
	private int cantidadFigus;
	private   ArrayList<Integer> figuritas = new ArrayList<Integer>();
	
	
	public Paquete() {
		this.cantidadFigus = 5;
		this.figuritas = figuritas;
		
	}
	
	public  ArrayList<Integer> cargarPaquete (Figuritas figuritas){
		Random r= new Random();

		while (this.figuritas.size()<=cantidadFigus) {
			int jugador = r.nextInt(figuritas.tamaño());// si no se completa revisar esto
			//this.figuritas.add(jugador);
			
			if(figuritas.revisarStock(jugador)>0) {
				if(!this.figuritas.contains(jugador)) {
					this.figuritas.add(jugador);
					figuritas.setDisminuirStock(jugador);
				}
			}	
		}
		return this.figuritas;
		
	}
	public Integer getFigu(int i) {
		return figuritas.get(i);
	}
	
	public int tamañoPaquete() {
		return figuritas.size();
		
	}
	
	
}
