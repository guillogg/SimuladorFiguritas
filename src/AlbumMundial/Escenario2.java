package AlbumMundial;

import java.util.ArrayList;

public class Escenario2 extends Thread {
	
	private Figuritas figuritas;
	private ArrayList<Integer> repetidas = new ArrayList <Integer>();
	private int cantidadUsuarios;
	private int paquetes;
	private ArrayList<Album> albumes = new ArrayList<Album>();
	
	public Escenario2( Figuritas figuritas, Integer Cantidadusuarios) {
		this.figuritas=figuritas;
		this.cantidadUsuarios=Cantidadusuarios;
		this.paquetes = 0;
	}

	
	@Override
	public void run() {
		int cantidadPaquetes=0;
		for (int i=0;i<cantidadUsuarios;i++) {
			Album album = new Album();
			boolean lleno=false;
		
			while(!lleno) {
				Paquete paquete = new Paquete();
				paquete.cargarPaquete(figuritas);
				cantidadPaquetes++;
			
				for (int j=0;j<paquete.tamañoPaquete();j++) {
				
					if (!album.getFiguritas().contains(paquete.getFigu(j))) {
						album.getFiguritas().add(paquete.getFigu(j));
					}
					if (repetidas.size()>0) {
					
						for (int k=0; i<repetidas.size(); k++) {
							if (!album.getFiguritas().contains(repetidas.get(k)) && repetidas.get(k)!=-1) {
								album.getFiguritas().add(repetidas.get(k));
								repetidas.set(k,-1);
							}
						}
					}
					if (album.tamañoAlbum()==album.getCantidadFigus()) {
						lleno=true;
					}
				}
			}
			albumes.add(album);
		}
		this.paquetes = cantidadPaquetes/cantidadUsuarios;
		
	}
	
	
	public ArrayList<Album> getAlbumes() {
		return albumes;
	}


	public int getPaquetes() {
		return paquetes;
	}
	
	public Integer getCantidadUsuarios() {
		return cantidadUsuarios;
	}


	
}
