package AlbumMundial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ThreadEscenarios extends Thread{
	protected static ArrayList<Integer> repetidas;
	private int usuarios;
	protected static Figuritas figuritas= new Figuritas();
	int cantidadUsuarios;
	String escenario;
	
	
	
	public ThreadEscenarios(int cantidadUsuarios, String escenario) {
		this.cantidadUsuarios=cantidadUsuarios;
		this.escenario=escenario;
	}
	

	public ThreadEscenarios() {
		
		if(escenario.equals("Escenario2")) {
			for (int i=0; i<cantidadUsuarios; i++) {
			    Escenario2 usuario = new Escenario2();
			    usuario.start();
			}
			
		}
	
		if(escenario.equals("Escenario3")) {
			for (int i=0; i<cantidadUsuarios; i++) {
			    Escenario2 usuario = new Escenario2();
			    usuario.start();
			}
			
		}
		
	}
	
	public ArrayList<Integer> getRepetidas(){
		return repetidas;
	}

	public void setRepetidas(int repetidas) {
		this.repetidas.add(repetidas);
	}

	
	
	
}
