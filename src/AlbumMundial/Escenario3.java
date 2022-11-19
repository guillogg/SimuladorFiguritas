package AlbumMundial;

import java.util.ArrayList;



public class Escenario3 extends Thread{
	
		private Album albumes[]; 
		private int cantidadUsuarios;
		private ArrayList<ArrayList<Integer>> repetidas = new ArrayList<ArrayList<Integer>>();
		private int cantPaquetesUsados;
		private Figuritas figuritas;


		public Escenario3(int cantidadUsuarios) {
			
			this.albumes = new Album[cantidadUsuarios];	
			this.cantidadUsuarios=cantidadUsuarios;
			this.cantPaquetesUsados = 0;
			
			for(int i=0; i<albumes.length;i++) {
				albumes[i]=new Album();	
			}
			for (int j=0;j<cantidadUsuarios;j++) {	 
				repetidas.add( new ArrayList<Integer>());
			}
		}
		
	
	@Override
	public void run() {
		
			figuritas = new Figuritas();
			int cantidadPaquetes=0;
			while(!estadoAlbumes(cantidadUsuarios,albumes)) {
				
			
			//itera en los albumes
			for (int i=0;i<albumes.length;i++) {	
				
				Paquete paquete = new Paquete();
				paquete.cargarPaquete(figuritas);
				cantidadPaquetes++;
				//va abriendo 1 paquete por cada usuario
				for (int j=0;j<paquete.tamañoPaquete();j++) {
					if (!albumes[i].getFiguritas().contains(paquete.getFigu(j))) {
						albumes[i].getFiguritas().add(paquete.getFigu(j));
					}
					else if (!intercambiar(i,paquete.getFigu(j),albumes,repetidas)){		
						
						repetidas.get(i).add(paquete.getFigu(j));				
					}
				}																								

				
			}
			}
			cantPaquetesUsados =cantidadPaquetes/cantidadUsuarios;
			
			
		}


	public boolean intercambiar(int usuario, int figurita, Album albumes[],ArrayList<ArrayList<Integer>> repetidas) {
		for (int i=0;i<albumes.length;i++) {
			if (i!=usuario) {
				if (!albumes[i].getFiguritas().contains(figurita)) {//reviso que a otro usuario le falte mi figu
					for (int j=0; j<repetidas.get(i).size();j++) {//recorro sus repetidas
						if (!albumes[usuario].getFiguritas().contains(repetidas.get(i).get(j))) {
							albumes[usuario].agregarFigu(repetidas.get(i).get(j));
							repetidas.get(i).remove(j);
							albumes[i].agregarFigu(figurita);
							
							return true;	
						}
					}
				}
				
			}						
		}
		return false;
	}
	
	public boolean estadoAlbumes(int cantidadUsuarios, Album albumes[]) {
		int total=0;
		for (int i=0;i<albumes.length;i++) {
			total=total+albumes[i].tamañoAlbum();
		}
		Album album = new Album();
		if (total== album.getCantidadFigus()*cantidadUsuarios) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public int getCantPaquetesUsados() {
		return cantPaquetesUsados;
	}
	
	public Album[] getAlbumes() {
		return albumes;
	}
			
}



	
	
	
	
	

