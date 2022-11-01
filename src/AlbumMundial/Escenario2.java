package AlbumMundial;

import java.util.ArrayList;

public class Escenario2 extends Thread {
	
	private Figuritas figuritas;
	private ArrayList<Integer> repetidas;
	public Escenario2( Figuritas figuritas, ArrayList<Integer> repetidas) {
		this.figuritas=figuritas;
		this.repetidas=repetidas;
		
	}
	
	



	@Override
	public void run() {
		Album album = new Album();
		boolean lleno=false;
		int cantidadPaquetes=0;
		
		while (!lleno) {
			Paquete paquete = new Paquete();
			paquete.cargarPaquete(figuritas);
			cantidadPaquetes++;
			
			for (int i=0;i<paquete.tamañoPaquete();i++) {
				if (!album.getFiguritas().contains(paquete.getFigu(i))) {
					album.getFiguritas().add(paquete.getFigu(i));
					//agregar metodo para ver y agregar las figuritas repetidas de otras personas
				}
				
				else  {
					 repetidas.add(paquete.getFigu(i));	
				}
			}

			for (int i=0; i<repetidas.size(); i++) {
				if (!album.getFiguritas().contains(repetidas.get(i))) {
					album.getFiguritas().add(repetidas.get(i));
					//agregar metodo para ver y agregar las figuritas repetidas de otras personas
				}
			}
			if (album.tamañoAlbum()==album.getCantidadFigus()) {
				lleno=true;
			}
			
			
			
		}
		
		System.out.println(cantidadPaquetes);
		
		
	}
	

	
	
	
	/*public boolean donar(int figurita) {
		
		for(int i=0; i<albumes.length; i++) {
			if(!albumes[i].album.contains(figurita)) {
				albumes[i].album.add(figurita);
				return true;
			}
		
		}
		return false;
			
	}*/
	
	
	
	
		
	
	
}

