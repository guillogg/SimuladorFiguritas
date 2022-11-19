package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz {
	private JFrame frameInicio;
	private JFrame frameEscenario1;
	private JFrame frameEscenario2;
	private JFrame frameEscenario3;
	private JProgressBar progreso;
	private Simulacion simulacion;
	
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
		Escenario1();
		Escenario2();
		Escenario3();
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
		frameInicio.setBounds(100, 100, 436, 379);
		frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicio.getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				frameInicio.dispose();
				
			}});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalir.setBounds(158, 275, 107, 31);
		frameInicio.getContentPane().add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("Elegir escenario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(144, 27, 140, 24);
		frameInicio.getContentPane().add(lblNewLabel);
		
		JButton btnEscenario_2 = new JButton("Escenario 3");
		btnEscenario_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escenario3();
				frameEscenario3.setVisible(true);
				frameEscenario3.toFront();
				frameInicio.setVisible(false);
			}
		});
		btnEscenario_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEscenario_2.setBounds(144, 191, 140, 31);
		frameInicio.getContentPane().add(btnEscenario_2);
		
		JButton btnEscenario_1 = new JButton("Escenario 2");
		btnEscenario_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escenario2();
				frameEscenario2.setVisible(true);
				frameEscenario2.toFront();
				frameInicio.setVisible(false);
			}
		});
		btnEscenario_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEscenario_1.setBounds(144, 141, 140, 31);
		frameInicio.getContentPane().add(btnEscenario_1);
		
		JButton btnEscenario = new JButton("Escenario 1");
		btnEscenario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frameEscenario1.remove(frameEscenario1);
				Escenario1();
				frameEscenario1.setVisible(true);
				frameEscenario1.toFront();
				frameInicio.setVisible(false);
			}
		});
		btnEscenario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEscenario.setBounds(144, 85, 140, 31);
		frameInicio.getContentPane().add(btnEscenario);
		
		
	
	}
	
	private void Escenario1() {
		
		frameEscenario1 = new JFrame();
		frameEscenario1.getContentPane().setForeground(Color.LIGHT_GRAY);
		frameEscenario1.getContentPane().setBackground(SystemColor.controlHighlight);
		frameEscenario1.setBackground(SystemColor.controlHighlight);
		frameEscenario1.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameEscenario1.setBounds(100, 100, 436, 385);
		frameEscenario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEscenario1.getContentPane().setLayout(null);
		
		JLabel labelResultado = new JLabel("El promedio es: 000.00");
		labelResultado.setVisible(false);
		labelResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelResultado.setBounds(119, 216, 214, 24);
		frameEscenario1.getContentPane().add(labelResultado);
		
		JTextField textSimulaciones = new JTextField();
		textSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textSimulaciones.setBounds(266, 41, 96, 31);
		frameEscenario1.getContentPane().add(textSimulaciones);
		textSimulaciones.setColumns(10);
		
		progreso = new JProgressBar();
		progreso.setBounds(43, 165, 329, 13);
		frameEscenario1.getContentPane().add(progreso);
		
		
		
		JButton btnPromedio = new JButton("Simular");
		btnPromedio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
				if(textSimulaciones.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar la cantidd de simulaciones","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					Integer simulaciones = Integer.valueOf(textSimulaciones.getText());
					simulacion = new Simulacion(progreso, simulaciones, "Escenario1",labelResultado,1);
					simulacion.execute();	
				}
			}});
		btnPromedio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPromedio.setBounds(144, 98, 140, 31);
		frameEscenario1.getContentPane().add(btnPromedio);
		
		JLabel lblCantidadDeSimulaciones = new JLabel("Cantidad de simulaciones");
		lblCantidadDeSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadDeSimulaciones.setBounds(43, 44, 205, 24);
		frameEscenario1.getContentPane().add(lblCantidadDeSimulaciones);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEscenario1.dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalir.setBounds(287, 293, 96, 31);
		frameEscenario1.getContentPane().add(btnSalir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEscenario1.dispose();
				frameInicio.setVisible(true);	
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(44, 293, 96, 31);
		frameEscenario1.getContentPane().add(btnVolver);
	}
	
	
	private void Escenario2() {
		
		frameEscenario2 = new JFrame();
		frameEscenario2.getContentPane().setForeground(Color.LIGHT_GRAY);
		frameEscenario2.getContentPane().setBackground(SystemColor.controlHighlight);
		frameEscenario2.setBackground(SystemColor.controlHighlight);
		frameEscenario2.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameEscenario2.setBounds(100, 100, 436, 391);
		frameEscenario2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEscenario2.getContentPane().setLayout(null);
		
		JLabel labelUsuarios = new JLabel("Cantidad de usuarios");
		labelUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelUsuarios.setBounds(46, 56, 205, 24);
		frameEscenario2.getContentPane().add(labelUsuarios);

		JLabel labelResultado = new JLabel("");
		labelResultado.setVisible(false);
		labelResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelResultado.setBounds(117, 225, 212, 24);
		frameEscenario2.getContentPane().add(labelResultado);
		
		JTextField textCantUsuarios = new JTextField();
		textCantUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCantUsuarios.setColumns(10);
		textCantUsuarios.setBounds(266, 53, 96, 31);
		frameEscenario2.getContentPane().add(textCantUsuarios);
		
		JTextField textSimulaciones = new JTextField();
		textSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textSimulaciones.setBounds(266, 19, 96, 31);
		frameEscenario2.getContentPane().add(textSimulaciones);
		textSimulaciones.setColumns(10);
		
		progreso = new JProgressBar();
		progreso.setBounds(46, 166, 329, 13);
		frameEscenario2.getContentPane().add(progreso);

		
		JButton btnSimular = new JButton("Simular");
		btnSimular.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
			
				labelResultado.setVisible(true);
				if(textSimulaciones.getText().isEmpty() || textCantUsuarios.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los datos","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					Integer simulaciones = Integer.valueOf(textSimulaciones.getText());
					Integer cantUsuarios = Integer.valueOf(textCantUsuarios.getText());
					
					simulacion = new Simulacion(progreso, simulaciones,"Escenario2",labelResultado,cantUsuarios);
					simulacion.execute();
				}}});
		btnSimular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSimular.setBounds(144, 106, 140, 31);
		frameEscenario2.getContentPane().add(btnSimular);
		
		JLabel lblCantidadDeSimulaciones = new JLabel("Cantidad de simulaciones");
		lblCantidadDeSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadDeSimulaciones.setBounds(46, 22, 205, 24);
		frameEscenario2.getContentPane().add(lblCantidadDeSimulaciones);	
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEscenario2.dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalir.setBounds(278, 299, 96, 31);
		frameEscenario2.getContentPane().add(btnSalir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEscenario2.dispose();
				frameInicio.setVisible(true);	
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(46, 299, 96, 31);
		frameEscenario2.getContentPane().add(btnVolver);
	
	}
	
	private void Escenario3() {
		
		frameEscenario3 = new JFrame();
		frameEscenario3.getContentPane().setForeground(Color.LIGHT_GRAY);
		frameEscenario3.getContentPane().setBackground(SystemColor.controlHighlight);
		frameEscenario3.setBackground(SystemColor.controlHighlight);
		frameEscenario3.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameEscenario3.setBounds(100, 100, 436, 379);
		frameEscenario3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEscenario3.getContentPane().setLayout(null);
		
		JLabel labelUsuarios = new JLabel("Cantidad de usuarios");
		labelUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelUsuarios.setBounds(46, 55, 205, 24);
		frameEscenario3.getContentPane().add(labelUsuarios);

		JLabel labelResultado = new JLabel("El promedio es: 000.00");
		labelResultado.setVisible(false);
		labelResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelResultado.setBounds(115, 220, 212, 24);
		frameEscenario3.getContentPane().add(labelResultado);
		
		JTextField textCantUsuarios = new JTextField();
		textCantUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCantUsuarios.setColumns(10);
		textCantUsuarios.setBounds(266, 52, 96, 31);
		frameEscenario3.getContentPane().add(textCantUsuarios);
		
		JTextField textSimulaciones = new JTextField();
		textSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textSimulaciones.setBounds(266, 18, 96, 31);
		frameEscenario3.getContentPane().add(textSimulaciones);
		textSimulaciones.setColumns(10);
		
		progreso = new JProgressBar();
		progreso = new JProgressBar();
		progreso.setBounds(46, 166, 329, 13);
		frameEscenario3.getContentPane().add(progreso);
		
		JButton btnPromedio = new JButton("Simular");
		btnPromedio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
				
				if(textSimulaciones.getText().isEmpty() || textCantUsuarios.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los datos","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					Integer simulaciones = Integer.valueOf(textSimulaciones.getText());
					Integer cantUsuarios = Integer.valueOf(textCantUsuarios.getText());
					simulacion = new Simulacion(progreso, simulaciones,"Escenario3",labelResultado,cantUsuarios);
					simulacion.execute();
				}
		
		}});
		btnPromedio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPromedio.setBounds(144, 104, 140, 31);
		frameEscenario3.getContentPane().add(btnPromedio);
		
		JLabel lblCantidadDeSimulaciones = new JLabel("Cantidad de simulaciones");
		lblCantidadDeSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadDeSimulaciones.setBounds(46, 21, 205, 24);
		frameEscenario3.getContentPane().add(lblCantidadDeSimulaciones);	
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEscenario3.dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalir.setBounds(289, 284, 96, 31);
		frameEscenario3.getContentPane().add(btnSalir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEscenario3.dispose();
				frameInicio.setVisible(true);		
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(46, 284, 96, 31);
		frameEscenario3.getContentPane().add(btnVolver);	
	}	
		
}
