package Interfaz;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import AlbumMundial.Escenario1;
import AlbumMundial.Escenario2;
import AlbumMundial.Escenario3;
import AlbumMundial.Figuritas;

public class Simulacion extends SwingWorker<Integer, Integer>{

	
	private JProgressBar barraProgreso;
	private int cantSimulaciones;
	private String escenario;
	private JLabel resultado;
	private int cantUsuarios;
	
	public Simulacion(JProgressBar barra, int cantSimulaciones, String escenario,JLabel resultado, int cantUsuarios) {
	
		this.barraProgreso = barra;
		this.cantSimulaciones = cantSimulaciones;
		this.escenario = escenario;
		this.resultado = resultado;
		this.cantUsuarios = cantUsuarios;
		
	}
	
	
	
	@Override
	protected Integer doInBackground() throws Exception {

		barraProgreso.setIndeterminate(true);
		if (escenario.equals("Escenario1")) {
			
			Escenario1 escenario1 = new Escenario1();
			int acum = 0;
			for (int i=0; i<cantSimulaciones;i++) {
				escenario1.llenarAlbum();
				acum = acum + escenario1.getCantidadPaquetes();
				barraProgreso.setValue(acum);	
			}
			double promedio = acum / cantSimulaciones;
			String cadena = String.valueOf(promedio);
			this.resultado.setText("El promedio es: "+ cadena);
			this.resultado.setVisible(true);
		}
		
		if (escenario.equals("Escenario2")) {
			
			ArrayList<Escenario2> threads = new ArrayList<Escenario2>();
			
			
			for (int i=0;i<cantSimulaciones;i++) {
				Figuritas figuritas = new Figuritas();
				Escenario2 escenario = new Escenario2(figuritas,cantUsuarios);
				threads.add(escenario);
				escenario.start();					
			}
			
			int acum = 0;
			while (threads.size()!=0) {
				for(int i=0; i<threads.size() ;i++) {
					if(!threads.get(i).isAlive()) {
						acum = acum + threads.get(i).getPaquetes();
						barraProgreso.setValue(acum);
						threads.remove(i);
						
					}
				}
			}
			
			double promedio = acum / cantSimulaciones;
			String cadena = String.valueOf(promedio);
			resultado.setText("El promedio es: "+ cadena);
			resultado.setVisible(true);	
			
		}
		
		if (escenario.equals("Escenario3")) {
			
			ArrayList<Escenario3> threads = new ArrayList<Escenario3>(); 
			
			for (int i=0;i<cantSimulaciones;i++) {
				Escenario3 Escenario = new Escenario3(cantUsuarios);
				Escenario.start();
				threads.add(Escenario);
				
			}
			
			int acum = 0;
			while (threads.size()!=0) {
				for(int i=0; i<threads.size() ;i++) {
					if(!threads.get(i).isAlive()) {
						acum = acum + threads.get(i).getCantPaquetesUsados();
						barraProgreso.setValue(acum);
						threads.remove(i);
					}
				}
			}
			
			double promedio = acum / cantSimulaciones;
			String cadena = String.valueOf(promedio);
			resultado.setText("El promedio es: "+ cadena);
			resultado.setVisible(true);
			
		}
		return null;
	}
	
	@Override
	public void done() {
		if(this.isCancelled()==false) {
			this.barraProgreso.setIndeterminate(false);
			
		}
	}
	

}
