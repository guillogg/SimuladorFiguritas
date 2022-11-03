package AlbumMundial;

import java.util.ArrayList;

public class Escenario2 extends Thread {
	
	private Figuritas figuritas;
	private ArrayList<Integer> repetidas = new ArrayList <Integer>();
	private Integer cantidadusuarios;
	public Escenario2( Figuritas figuritas, Integer Cantidadusuarios) {
		this.figuritas=figuritas;
		this.cantidadusuarios=Cantidadusuarios;
		
	}
	
	



	@Override	
	public void run() {
		int cantidadPaquetes=0;
	for (int i=0;i<cantidadusuarios;i++) {
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
						//agregar metodo para ver y agregar las figuritas repetidas de otras personas
					}
				}
				}
				if (album.tamañoAlbum()==album.getCantidadFigus()) {
					lleno=true;
				}
				
			}
		}
		
	}
	System.out.print(cantidadPaquetes+" ");
	
}

	/*Album album = new Album();
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
			if (!album.getFiguritas().contains(repetidas.get(i)) && repetidas.get(i)!=-1) {
				album.getFiguritas().add(repetidas.get(i));
				repetidas.set(i,-1);
				//agregar metodo para ver y agregar las figuritas repetidas de otras personas
			}
		}
		if (album.tamañoAlbum()==album.getCantidadFigus()) {
			lleno=true;
		}
		
		
		
	}
	
	System.out.println(cantidadPaquetes);
	
	*/
}
