package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import AlbumMundial.Album;
import AlbumMundial.Escenario1;

public class Escenario1Test {
	
	@Test
	public void albumLleno() {
		
		Escenario1 escenario = new Escenario1();
		Album album = escenario.llenarAlbum();
			
		assertEquals(album.getFiguritas().size(),album.getCantidadFigus());	
	}
	
}
