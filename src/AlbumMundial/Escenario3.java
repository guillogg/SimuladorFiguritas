package AlbumMundial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import AlbumMundial.ThreadEscenarios;

public class Escenario3 extends Thread{
	
		//private int usuarios;
		private Figuritas figuritas;
		private Album albunes[]; 
		private int cantidadUsuarios;
		//Integer [][] repetidas = new Integer [cantidadUsuarios][];
		ArrayList<ArrayList<Integer>> repetidas = new ArrayList<ArrayList<Integer>>();
		int CantidadLlenos=0;
		public Escenario3(int cantidadUsuarios) {
			
			this.albunes = new Album[cantidadUsuarios];	
			this.cantidadUsuarios=cantidadUsuarios;
			
			for(int i=0; i<albunes.length;i++) {
				albunes[i]=new Album();	
			}
			for (int j=0;j<cantidadUsuarios;j++) {	 
				repetidas.add( new ArrayList<Integer>());
			}
		}
		
	
@Override
	public void run() {
		
			Figuritas figuritas = new Figuritas();
			int cantidadPaquetes=0;
			while(!EstadoAlbums(cantidadUsuarios)) {
				
			
			//itera en los albunes
			for (int i=0;i<albunes.length;i++) {
				
					
				
				Paquete paquete = new Paquete();
				paquete.cargarPaquete(figuritas);
				cantidadPaquetes++;
				//va abriendo 1 paquete por cada usuario
				for (int j=0;j<paquete.tamañoPaquete();j++) {
					if (!albunes[i].getFiguritas().contains(paquete.getFigu(j))) {
						albunes[i].getFiguritas().add(paquete.getFigu(j));
					}
					else if (!intercambiar(i,paquete.getFigu(j))){		
						
						repetidas.get(i).add(paquete.getFigu(j));				
					}
				}																								

				
			}
			}
			double total=cantidadPaquetes/cantidadUsuarios;
			System.out.print(total+"\n");
			
		}




	@SuppressWarnings("unlikely-arg-type")
	public boolean intercambiar(int usuario, int figurita) {
		for (int i=0;i<albunes.length;i++) {
			if (i!=usuario) {
				if (!albunes[i].getFiguritas().contains(figurita)) {//reviso que a otro usuario le falte mi figu
					for (int j=0; j<repetidas.get(i).size();j++) {//recorro sus repetidas
						if (!albunes[usuario].getFiguritas().contains(repetidas.get(i).get(j))) {
							albunes[usuario].agregarFigu(repetidas.get(i).get(j));
							repetidas.get(i).remove(j);
							albunes[i].agregarFigu(figurita);
							
							
							return true;
							
						}
					}
				}
				
			}						
		}
		return false;
	}
	
	public boolean EstadoAlbums(int cantidadUsuarios) {
		int total=0;
		for (int i=0;i<albunes.length;i++) {
			total=total+albunes[i].tamañoAlbum();
		}
		if (total==638*cantidadUsuarios) {
			return true;
		}
		else {
			return false;
		}
	}
	/*for (int i=0;i<repetidas.size();i++) {
			if (i!=usuario) {
				for (int j=0;j<repetidas.get(i).size();j++) {
					if (!albunes[usuario].equals(repetidas.get(i).get(j))) {
						//intercambiar(i,col,fila);
					}
				}
			}						
		}*/
	

		
		
		 
			
	}



	
	
	
	
	

