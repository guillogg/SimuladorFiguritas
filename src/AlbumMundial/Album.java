package AlbumMundial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Album {
	private int plata;
	//protected static boolean lleno;
	private int cantidadFigus;
	//protected int cantidadPaquetes=0;
	private Set<Integer> figuritas; // = new HashSet<Integer>()
	private boolean intercambiar;
	//protected ArrayList<Integer> repetidas; // = new ArrayList<Integer>();
	
	public Album() {
		//this.lleno = false;
		this.cantidadFigus=638;
		this.figuritas = new HashSet<Integer>();
		this.intercambiar = false;
		//this.repetidas = new ArrayList<Integer>();
	}
	public int getCantidadFigus() {
		return this.cantidadFigus;
	}
	public int tamañoAlbum() {
		return figuritas.size();
	}
	public Set<Integer> getFiguritas() {
		return figuritas;
	}

	
	public void setFiguritas(Set<Integer> figuritas) {
		this.figuritas = figuritas;
	}
	




}
