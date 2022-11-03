package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AlbumMundial.Album;
import AlbumMundial.Escenario1;
import AlbumMundial.Escenario2;
import AlbumMundial.Escenario3;
import AlbumMundial.Figuritas;
import AlbumMundial.ThreadEscenarios;

import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Interfaz {

	
	private JFrame frameInicio;
	private JTextField textSimulaciones;
	private Escenario1 escenario1;
	private Escenario2 escenario2;
	private Escenario3 escenario3;
	
	private double promedio = 0;
	private JTextField textCantUsuarios;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frameInicio.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		inicio();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
private void inicio() {
		
		frameInicio = new JFrame();
		frameInicio.getContentPane().setForeground(Color.LIGHT_GRAY);
		frameInicio.getContentPane().setBackground(SystemColor.controlHighlight);
		frameInicio.setBackground(SystemColor.controlHighlight);
		frameInicio.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameInicio.setBounds(100, 100, 455, 379);
		frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicio.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(196, 108, 166, 31);
		frameInicio.getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Escenario 1", "Escenario 2", "Escenario 3"}));
		
		JLabel labelResultado = new JLabel("Resultado");
		labelResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelResultado.setBounds(164, 197, 140, 24);
		frameInicio.getContentPane().add(labelResultado);
		
		textCantUsuarios = new JTextField();
		textCantUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCantUsuarios.setColumns(10);
		textCantUsuarios.setBounds(264, 11, 96, 31);
		frameInicio.getContentPane().add(textCantUsuarios);
		
		
		
		JButton btnNewButton_1 = new JButton("Resultado");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String escenario = (String) comboBox.getSelectedItem();
				Integer simulaciones = Integer.valueOf(textSimulaciones.getText());
				Integer cantUsuarios = Integer.valueOf(textCantUsuarios.getText());
				
				if(escenario.equals("Escenario 1")) {
					
					escenario1 = new Escenario1();
					
					for (int i=0; i<simulaciones;i++) {
						System.out.println(escenario1.llenarAlbum());
						
						//labelResultado.setText("El promedio es: "+ escenario1.llenarAlbum(figuritas));
					}	
				}
				if(escenario.equals("Escenario 2")) {
					 
					
					//ThreadEscenarios thread = new ThreadEscenarios(cantUsuarios, escenario);
					for (int i=0;i<simulaciones;i++) {
						Figuritas figuritas = new Figuritas();
						ArrayList<Escenario2> threads = new ArrayList<Escenario2>();
						Escenario2 Escenario = new Escenario2(figuritas,cantUsuarios);
						Escenario.start();
						threads.add(Escenario);
		
					}

					/*if(escenario.equals("Escenario3")) {
						for (int i=0;i<simulaciones;i++) {
							for (int j=0; j<cantUsuarios; j++) {
							    Escenario3 usuario = new Escenario3();
							    usuario.start();
							}
						}			
					}*/
					
					/*Escenario2 usuario1 = new Escenario2();
					usuario1.start();
					Escenario2 usuario2 = new Escenario2();
					usuario2.start();*/
					
				}
				if(escenario.equals("Escenario 3")) {
									 
									
									//ThreadEscenarios thread = new ThreadEscenarios(cantUsuarios, escenario);
									for (int i=0;i<simulaciones;i++) {
										
										ArrayList<Escenario3> threads = new ArrayList<Escenario3>();
										Escenario3 Escenario = new Escenario3(cantUsuarios);
										Escenario.start();
										threads.add(Escenario);
						
									}
							}
		}});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(153, 264, 140, 31);
		frameInicio.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Elegir escenario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(46, 111, 140, 24);
		frameInicio.getContentPane().add(lblNewLabel);
		
		JLabel lblCantidadDeSimulaciones = new JLabel("Cantidad de simulaciones");
		lblCantidadDeSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadDeSimulaciones.setBounds(46, 55, 205, 24);
		frameInicio.getContentPane().add(lblCantidadDeSimulaciones);
		
		textSimulaciones = new JTextField();
		textSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textSimulaciones.setBounds(264, 52, 96, 31);
		frameInicio.getContentPane().add(textSimulaciones);
		textSimulaciones.setColumns(10);
		
		
		
		
		
		
		



		
		
		
		
		
		
	
	}
}
