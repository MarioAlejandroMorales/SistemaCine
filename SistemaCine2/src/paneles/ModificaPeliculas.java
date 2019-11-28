package paneles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.conexionPeliculas;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ModificaPeliculas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private conexionPeliculas conexionBD = new conexionPeliculas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaPeliculas frame = new ModificaPeliculas();
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
	public ModificaPeliculas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaPeliculas.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemovie(Modificar pelicula)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombrePeli = new JLabel("Nombre de la pelicula: ");
		lblNombrePeli.setBounds(10, 11, 154, 28);
		contentPane.add(lblNombrePeli);
		
		JTextField tfNombrePeli = new JTextField();
		tfNombrePeli.setEnabled(false);
		tfNombrePeli.setEditable(false);
		tfNombrePeli.setBounds(174, 15, 333, 20);
		contentPane.add(tfNombrePeli);
		tfNombrePeli.setColumns(10);
		
		JLabel lblProtagonista = new JLabel("Protagonista: ");
		lblProtagonista.setBounds(10, 50, 118, 20);
		contentPane.add(lblProtagonista);
		
		JTextField tfProtagonista = new JTextField();
		tfProtagonista.setEnabled(false);
		tfProtagonista.setEditable(false);
		tfProtagonista.setBounds(138, 46, 369, 20);
		contentPane.add(tfProtagonista);
		tfProtagonista.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(10, 81, 93, 20);
		contentPane.add(lblDirector);
		
		JTextField tfDirector = new JTextField();
		tfDirector.setEnabled(false);
		tfDirector.setEditable(false);
		tfDirector.setBounds(113, 81, 394, 20);
		contentPane.add(tfDirector);
		tfDirector.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero: ");
		lblGenero.setBounds(10, 112, 93, 14);
		contentPane.add(lblGenero);
		
		JTextField tfGenero = new JTextField();
		tfGenero.setEnabled(false);
		tfGenero.setEditable(false);
		tfGenero.setBounds(113, 109, 394, 20);
		contentPane.add(tfGenero);
		tfGenero.setColumns(10);
		
		JLabel lbDuracion = new JLabel("Duracion: ");
		lbDuracion.setBounds(10, 137, 93, 14);
		contentPane.add(lbDuracion);
		
		JTextField tfDuracion = new JTextField();
		tfDuracion.setEnabled(false);
		tfDuracion.setEditable(false);
		tfDuracion.setBounds(113, 134, 394, 20);
		contentPane.add(tfDuracion);
		tfDuracion.setColumns(10);
		
		JLabel lblClasificacion = new JLabel("Clasificacion: ");
		lblClasificacion.setBounds(10, 162, 118, 14);
		contentPane.add(lblClasificacion);
		
		JTextField tfClasificacion = new JTextField();
		tfClasificacion.setEnabled(false);
		tfClasificacion.setEditable(false);
		tfClasificacion.setBounds(138, 159, 369, 20);
		contentPane.add(tfClasificacion);
		tfClasificacion.setColumns(10);
		
		JLabel lblDirImg = new JLabel("Direccion de la imagen: ");
		lblDirImg.setBounds(10, 187, 154, 14);
		contentPane.add(lblDirImg);
		
		JTextField tfDirImg = new JTextField();
		tfDirImg.setEnabled(false);
		tfDirImg.setEditable(false);
		tfDirImg.setText("ejemplo: \"C:\\Users\\Cine\\Foto.png\"");
		tfDirImg.setBounds(174, 184, 333, 20);
		contentPane.add(tfDirImg);
		tfDirImg.setColumns(10);
		
		TextField tfCodBusca = new TextField();
		tfCodBusca.setText("  ingrese el codigo de la pelicula");
		tfCodBusca.setBounds(513, 17, 181, 22);
		contentPane.add(tfCodBusca);
		
		Button btnGuardar = new Button("Guardar Cambios");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = tfNombrePeli.getText();
				String protagonista = tfProtagonista.getText();
				String director = tfDirector.getText();
				String genero = tfGenero.getText();
				String duracion = tfDuracion.getText();
				String clasificacion = tfClasificacion.getText();
				String dirImg = tfDirImg.getText();
				String id = tfCodBusca.getText();
				try {
					conexionBD.actualizaPelicula(nombre, protagonista, director, genero, duracion, clasificacion,dirImg, id);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(531, 93, 163, 108);
		contentPane.add(btnGuardar);
		
		Button btnBuscar = new Button("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = conexionBD.buscaCodigo(tfCodBusca.getText());
				if(a != null) {
					tfNombrePeli.setEnabled(true);
					tfNombrePeli.setEditable(true);
					tfNombrePeli.setText(a[0]);
					tfProtagonista.setEnabled(true);
					tfProtagonista.setEditable(true);
					tfProtagonista.setText(a[1]);
					tfDirector.setEnabled(true);
					tfDirector.setEditable(true);
					tfDirector.setText(a[2]);
					tfGenero.setEnabled(true);
					tfGenero.setEditable(true);
					tfGenero.setText(a[3]);
					tfDuracion.setEnabled(true);
					tfDuracion.setEditable(true);
					tfDuracion.setText(a[4]);
					tfClasificacion.setEnabled(true);
					tfClasificacion.setEditable(true);
					tfClasificacion.setText(a[5]);
					tfDirImg.setEnabled(true);
					tfDirImg.setEditable(true);
					tfDirImg.setText(a[6]);
					btnGuardar.setEnabled(true);
				}else {
					JOptionPane.showInternalMessageDialog(contentPane, "EL CODIGO NO EXISTE EN LA BASE DE DATOS!");
				}
					
			}
		});
		btnBuscar.setBounds(561, 44, 70, 22);
		contentPane.add(btnBuscar);
		
	}
}
