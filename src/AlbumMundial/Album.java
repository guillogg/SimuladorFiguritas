package AlbumMundial;

import java.util.HashSet;
import java.util.Set;

public class Album {
	
	private int cantidadFigus;
	private Set<Integer> figuritas;
	
	
	public Album() {

		this.cantidadFigus=638;
		this.figuritas = new HashSet<Integer>();
		
	}
	public int getCantidadFigus() {
		return this.cantidadFigus;
	}
	
	public void setCantidadFigus(int cantidadFigus) {
		this.cantidadFigus = cantidadFigus;
	}
	
	public int tamañoAlbum() {
		return figuritas.size();
	}
	public Set<Integer> getFiguritas() {
		return figuritas;
	}

	public void agregarFigu(int i) {
		figuritas.add(i);
	}
	
	public void setFiguritas(Set<Integer> figuritas) {
		this.figuritas = figuritas;
	}
	




}
