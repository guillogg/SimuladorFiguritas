package AlbumMundial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import AlbumMundial.ThreadEscenarios;

public class Escenario3 extends Thread{
	
		//private int usuarios;
		private ArrayList<Integer> repetidas;
		private Album albumes[]; 
		
		
		public Escenario3(int cantidadUsuarios) {
			
			this.repetidas = new ArrayList<Integer>();
			this.albumes = new Album[cantidadUsuarios];	
			for(int i=0; i<albumes.length;i++) {
				albumes[i]=new Album();	
			}
			
		}
	
	
		public int llenarAlbum(Figuritas figuritas, Album album, int posicionAlbum) {
		
			while (!album.lleno) {
				Paquete paquete = new Paquete();
				paquete.cargarPaquete(figuritas);
				album.cantidadPaquetes++;
		
				for (int i=0;i<paquete.tamañoPaquete();i++) {
			
					if (!album.album.contains(paquete.getFigu(i))) {
						album.album.add(paquete.getFigu(i));
					//agregar metodo para ver y agregar las figuritas repetidas de otras personas
					}
				
					else  {
						album.intercambiar=true;
						
						if(!intercambiar(paquete.getFigu(i), posicionAlbum, album)) {
							repetidas.add(paquete.getFigu(i));
						}
					}
				}
			}	
		return album.cantidadPaquetes;
		
	}

	
	
	
	public boolean intercambiar(int figurita,int posicionAlbum, Album album) {
		
		for (int j=0; j<albumes.length; j++) {
			if(albumes[j].intercambiar==true && j!=posicionAlbum && 
					!albumes[j].album.contains(figurita)) {
				albumes[j].album.add(figurita);
				return true;
			}
		}
		return false;
		
		 
			
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
