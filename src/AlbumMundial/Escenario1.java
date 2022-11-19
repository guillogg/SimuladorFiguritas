package AlbumMundial;

public class Escenario1 {

	private int cantidadPaquetes=0;
	private Album album;
	private Figuritas figuritas;
	
	public Album llenarAlbum() {
		 figuritas= new Figuritas();
		 album = new Album();
		 boolean lleno=false;
		 cantidadPaquetes=0;
		
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
		
		return album;

	}

	public int getCantidadPaquetes() {
		return cantidadPaquetes;
	}
	
	
	

}
