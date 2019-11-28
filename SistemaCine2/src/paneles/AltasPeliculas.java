package paneles;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.conexionPeliculas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Button;

public class AltasPeliculas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombrePeli;
	private JTextField tfProtagonista;
	private JTextField tfDirector;
	private JTextField tfGenero;
	private JTextField tfDuracion;
	private JTextField tfClasificacion;
	private JTextField tfDirImg;
	private conexionPeliculas conexionPeliculas = new conexionPeliculas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltasPeliculas frame = new AltasPeliculas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltasPeliculas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombrePeli = new JLabel("Nombre de la pelicula: ");
		lblNombrePeli.setBounds(10, 11, 154, 28);
		contentPane.add(lblNombrePeli);
		
		tfNombrePeli = new JTextField();
		tfNombrePeli.setBounds(174, 15, 333, 20);
		contentPane.add(tfNombrePeli);
		tfNombrePeli.setColumns(10);
		
		JLabel lblProtagonista = new JLabel("Protagonista: ");
		lblProtagonista.setBounds(10, 50, 118, 20);
		contentPane.add(lblProtagonista);
		
		tfProtagonista = new JTextField();
		tfProtagonista.setBounds(138, 46, 369, 20);
		contentPane.add(tfProtagonista);
		tfProtagonista.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(10, 81, 93, 20);
		contentPane.add(lblDirector);
		
		tfDirector = new JTextField();
		tfDirector.setBounds(113, 81, 394, 20);
		contentPane.add(tfDirector);
		tfDirector.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero: ");
		lblGenero.setBounds(10, 112, 93, 14);
		contentPane.add(lblGenero);
		
		tfGenero = new JTextField();
		tfGenero.setBounds(113, 109, 394, 20);
		contentPane.add(tfGenero);
		tfGenero.setColumns(10);
		
		JLabel lbDuracion = new JLabel("Duracion: ");
		lbDuracion.setBounds(10, 137, 93, 14);
		contentPane.add(lbDuracion);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(113, 134, 394, 20);
		contentPane.add(tfDuracion);
		tfDuracion.setColumns(10);
		
		JLabel lblClasificacion = new JLabel("Clasificacion: ");
		lblClasificacion.setBounds(10, 162, 118, 14);
		contentPane.add(lblClasificacion);
		
		tfClasificacion = new JTextField();
		tfClasificacion.setBounds(138, 159, 369, 20);
		contentPane.add(tfClasificacion);
		tfClasificacion.setColumns(10);
		
		JLabel lblDirImg = new JLabel("Direccion de la imagen: ");
		lblDirImg.setBounds(10, 187, 154, 14);
		contentPane.add(lblDirImg);
		
		tfDirImg = new JTextField();
		tfDirImg.setText("ejemplo: \"C:\\Users\\Cine\\Foto.png\"");
		tfDirImg.setBounds(174, 184, 333, 20);
		contentPane.add(tfDirImg);
		tfDirImg.setColumns(10);
		
		Button btnGuardar = new Button("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = tfNombrePeli.getText();
				String protagonista = tfProtagonista.getText();
				String director = tfDirector.getText();
				String genero = tfGenero.getText();
				String duracion = tfDuracion.getText();
				String clasificacion = tfClasificacion.getText();
				String dirImg = tfDirImg.getText();
				
				try {
					conexionPeliculas.insertarPelicula(nombre, protagonista, director, genero, duracion, clasificacion,dirImg);
					JOptionPane.showInternalMessageDialog(contentPane, "El id pelicula es: " + conexionPeliculas.contadorRegistros() + 1);
					dispose();
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(524, 11, 170, 90);
		contentPane.add(btnGuardar);
		
		JLabel lblNewLabel = new JLabel("Para cancelar solo cierre la ventana");
		lblNewLabel.setBounds(419, 296, 262, 14);
		contentPane.add(lblNewLabel);
		
		
	}
}
