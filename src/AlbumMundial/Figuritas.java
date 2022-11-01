package AlbumMundial;

import java.util.ArrayList;
import java.util.Arrays;

public class Figuritas {
	
	
	private int figuritas[];
	private int cantXJugador;
	
	public Figuritas() {
		this.cantXJugador = 1000; //cantidad de figuritas por jugador
		this.figuritas = new int[638];
		
		for (int i=0; i<figuritas.length; i++) {
			figuritas[i]=cantXJugador;
		}
	}
	
	
	public int[] getFiguritas(){
		return figuritas;
	}
	
	public int revisarStock(int jugador){
		return figuritas[jugador];
	}
	
	public int tamaño() {
		return figuritas.length;
	}
	
	public void setDisminuirStock(int numJugador) {
		figuritas[numJugador]=figuritas[numJugador]-1;
	}
	
	
	
	
	
	
	
	
	
	
}
