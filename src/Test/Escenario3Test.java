package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import AlbumMundial.Album;
import AlbumMundial.Escenario3;

public class Escenario3Test {


	
	@Test 
	public void intercambia() {
		
		Album albumes[] = new Album[2];
		ArrayList<ArrayList<Integer>> repetidas = new ArrayList<ArrayList<Integer>>();
		Escenario3 escenario = new Escenario3(2);
		
		escenario.run();
		for(int i=0; i<albumes.length; i++) {
			Album album = new Album();
			albumes[i]=album;
		}
		
		for (int j=0;j<albumes.length;j++) {	 
			repetidas.add( new ArrayList<Integer>());
		}
		//cargo album
		albumes[0].agregarFigu(5);
		albumes[0].agregarFigu(3);
		albumes[1].agregarFigu(1);
		albumes[1].agregarFigu(6);
		//cargo repetidas
		repetidas.get(0).add(5);
		repetidas.get(1).add(1);
		
		boolean ret = escenario.intercambiar(0, 3,albumes,repetidas);
		assertTrue(ret);
			
	}
	
	@Test 
	public void noIntercambia() {
		
		Album albumes[] = new Album[2];
		ArrayList<ArrayList<Integer>> repetidas = new ArrayList<ArrayList<Integer>>();
		Escenario3 escenario = new Escenario3(2);
		
		
		for(int i=0; i<albumes.length; i++) {
			Album album = new Album();
			albumes[i]=album;
		}
		
		for (int j=0;j<albumes.length;j++) {	 
			repetidas.add( new ArrayList<Integer>());
		}
		//cargo album
		albumes[0].agregarFigu(5);
		albumes[0].agregarFigu(3);
		albumes[1].agregarFigu(1);
		albumes[1].agregarFigu(6);
		//cargo repetidas
		repetidas.get(0).add(5);
		repetidas.get(1).add(5);
		
		boolean ret = escenario.intercambiar(0, 3,albumes,repetidas);
		assertFalse(ret);
			
	}
		

	
	@Test
	public void estadoAlbumes() {
		
		Album albumes[] = new Album[3];
		
		for(int i=0; i<albumes.length; i++) {
			Album album = new Album();
			for(int j=0; j<album.getCantidadFigus();j++) {
				album.agregarFigu(j);
			}
			albumes[i]=album;
		}
		
		Escenario3 escenario = new Escenario3(0);
		boolean estado = escenario.estadoAlbumes(3,albumes);
		assertTrue(estado);
	}
	
	@Test
	public void noTodosCompletos() {
		
		Album albumes[] = new Album[3];
		
		for(int i=0; i<albumes.length; i++) {
			Album album = new Album();
			albumes[i]=album;
		}
		
		albumes[0].agregarFigu(1);
		albumes[0].agregarFigu(2);
		albumes[0].agregarFigu(3);
		albumes[1].agregarFigu(1);
		albumes[1].agregarFigu(2);
		albumes[1].agregarFigu(3);
		albumes[2].agregarFigu(1);
		albumes[2].agregarFigu(2);
		albumes[2].agregarFigu(3);
			
			
		Escenario3 escenario = new Escenario3(0);
		boolean estado = escenario.estadoAlbumes(3,albumes);
		assertFalse(estado);
	}
	
	
}
