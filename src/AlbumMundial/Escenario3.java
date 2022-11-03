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
		Integer [][] repetidas = new Integer [cantidadUsuarios][];
		int CantidadLlenos=0;
		public Escenario3(int cantidadUsuarios) {
			
			this.albunes = new Album[cantidadUsuarios];	
			this.cantidadUsuarios=cantidadUsuarios;
			
			for(int i=0; i<albunes.length;i++) {
				albunes[i]=new Album();	
			}			
		}
		
	
@Override
	public void run() {
			Figuritas figuritas = new Figuritas();
			int cantidadPaquetes=0;
			//Integer [][] repetidas = new Integer [cantidadUsuarios][];
			while(CantidadLlenos!=cantidadUsuarios) {
				
			
			//itera en los albunes
			for (int i=0;i<albunes.length;i++) {
				int posicionRepe=0;				 
				Paquete paquete = new Paquete();
				paquete.cargarPaquete(figuritas);
				cantidadPaquetes++;
				//va abriendo 1 paquete por cada usuario
				for (int j=0;j<paquete.tamañoPaquete();j++) {
					if (!albunes[i].getFiguritas().contains(paquete.getFigu(j))) {
						albunes[i].getFiguritas().add(paquete.getFigu(j));
					}
					else {
						
						repetidas[i][posicionRepe]=paquete.getFigu(j);
						posicionRepe++;
					}
				}
				//me fijo si hay alguna repetida en la lista de los demas albunes
				for (int fila=0;fila<repetidas.length;fila++) {	
						if (repetidas[fila].length>0) {											
					for (int col=0;col<repetidas[fila].length;col++) {
						if (!albunes[i].getFiguritas().contains(repetidas[fila][col]) && repetidas[fila][col]!=-1) {
							intercambiar(i,col,fila);
						}					
					}
					}
					
				}
				if (albunes[i].tamañoAlbum()==albunes[i].getCantidadFigus()) {
					CantidadLlenos++;
				}
				}
			}
			
			System.out.print(cantidadPaquetes+" ");
			
		}
	
	
	public void intercambiar(int FilaR,int columnaR,  int ListaRepetidasE) {
		boolean listo=false;
		for (int i=0;i<repetidas[ListaRepetidasE].length;i++) {
			if (!albunes[FilaR].getFiguritas().contains(repetidas[ListaRepetidasE][i]) && listo==false) {
				albunes[FilaR].getFiguritas().add(repetidas[ListaRepetidasE][i]);
				albunes[ListaRepetidasE].getFiguritas().add(repetidas[FilaR][columnaR]);
				repetidas[ListaRepetidasE][i]=-1;
				repetidas[FilaR][columnaR]=-1;
				listo=true;
			}
		}
		
		

		
		
		 
			
	}



	
	
	
	
	

}
