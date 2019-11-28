package paneles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.conexionClientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class AltasClientes extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private conexionClientes conexionClientes = new conexionClientes();
	private JTextField textFieldApellido;
	private JLabel lblTelefono;
	private JTextField textFieldTelefono;
	private JLabel lblCorreo;
	private JTextField textFieldCorreo;
	private JLabel label;
	private JLabel label_1;
	private JButton btnAtras;
	
	/**
	 * Create the frame.
	 */
	public AltasClientes() {
		setTitle("Systemovey (Altas Clientes)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,599,650);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("ALTAS DE CLIENTES");
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label.setBounds(167, 13, 246, 36);
		contentPane.add(label);
		
		label_1 = new JLabel("Datos personales");
		label_1.setBounds(12, 93, 120, 16);
		contentPane.add(label_1);
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 122, 120, 16);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(147, 122, 116, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApelido = new JLabel("Apellido:");
		lblApelido.setBounds(275, 125, 120, 16);
		contentPane.add(lblApelido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(404, 122, 116, 22);
		contentPane.add(textFieldApellido);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(12, 160, 120, 16);
		contentPane.add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(147, 157, 116, 22);
		contentPane.add(textFieldTelefono);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(272, 160, 120, 16);
		contentPane.add(lblCorreo);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(404, 157, 116, 22);
		contentPane.add(textFieldCorreo);
		
		JLabel lblMembresia = new JLabel("Membresia:");
		lblMembresia.setBounds(275, 227, 120, 16);
		contentPane.add(lblMembresia);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(404, 220, 45, 25);
		contentPane.add(rdbtnF);
		
		JRadioButton rdbtnM = new JRadioButton("SF");
		rdbtnM.setBounds(466, 220, 45, 25);
		contentPane.add(rdbtnM);
		
		
		JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String telefono=textFieldTelefono.getText();
				String correo=textFieldCorreo.getText();
				String membresia="";
				if(rdbtnF.isSelected()) {
					membresia="F";
				}else{
					if(rdbtnM.isSelected()) {
						membresia="SF";
					}
				}
				
				try {
					conexionClientes.insertClientes(nombre, apellido, telefono, correo, membresia);
					//Thread.sleep(2000);
					String id = conexionClientes.consultarUltimo();
					JOptionPane.showInternalMessageDialog(contentPane, "El ID es: "+id);
					dispose();
				} catch (SQLException | IOException /*| InterruptedException*/ e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDarDeAlta.setBounds(227, 541, 126, 25);
		contentPane.add(btnDarDeAlta);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAtras.setBounds(423, 542, 97, 25);
		contentPane.add(btnAtras);
		
	}
}
