package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import AlbumMundial.Figuritas;
import AlbumMundial.Paquete;

public class PaqueteTest {
	
	@Test
	public void corroborarPaqueteCargado() {
		
		Figuritas figuritas = new Figuritas();
		Paquete paquete = new Paquete();
		int paquetelleno = paquete.cargarPaquete(figuritas).size();
		assertEquals(5, paquetelleno);
		
	}

}
