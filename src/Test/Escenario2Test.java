package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import AlbumMundial.Escenario2;
import AlbumMundial.Figuritas;

public class Escenario2Test {
	
	
	@Test
	public void albumesLlenos() {
		Figuritas figuritas = new Figuritas();
		int usuarios = 5;
		int totalLlenos = 0;
		Escenario2 escenario = new Escenario2(figuritas,usuarios);
		escenario.run();
		for (int i=0; i < escenario.getAlbumes().size();i++) {
			if(escenario.getAlbumes().get(i).tamañoAlbum()==escenario.getAlbumes().get(i).getCantidadFigus()) {
				totalLlenos++;
			}
		}	
		assertEquals(5,totalLlenos);
		
	}

}
