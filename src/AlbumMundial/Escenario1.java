package AlbumMundial;

public class Escenario1 {

	//private Album album = new Album();
	//private boolean lleno=false;
	
	public int llenarAlbum() {
		 Figuritas figuritas= new Figuritas();
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
					
				}
				if (album.tamañoAlbum()==album.getCantidadFigus()) {
					lleno=true;
				}
				
			}
				
	
		}
		
		return cantidadPaquetes;

	}
	

}
