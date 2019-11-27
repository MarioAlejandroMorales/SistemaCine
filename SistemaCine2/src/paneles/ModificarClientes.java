package paneles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.conexionClientes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ModificarClientes extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTel;
	private JTextField textFieldCorreo;
	/**
	 * Create the frame.
	 */
	public ModificarClientes(String[] arra) {
		setTitle("Systemovie (Modificar clientes)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarClientes = new JLabel("MODIFICAR CLIENTES");
		lblModificarClientes.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblModificarClientes.setBounds(134, 13, 262, 36);
		contentPane.add(lblModificarClientes);
		
		JLabel label_1 = new JLabel("Datos personales");
		label_1.setBounds(12, 93, 120, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setBounds(12, 122, 120, 16);
		contentPane.add(label_2);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setText(arra[0]);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(147, 122, 116, 22);
		contentPane.add(textFieldNombre);
		
		JLabel label_3 = new JLabel("Apellido:");
		label_3.setBounds(275, 125, 120, 16);
		contentPane.add(label_3);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setText(arra[1]);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(404, 122, 116, 22);
		contentPane.add(textFieldApellido);
		
		JLabel label_4 = new JLabel("Telefono:");
		label_4.setBounds(12, 154, 120, 16);
		contentPane.add(label_4);
		
		textFieldTel = new JTextField();
		textFieldTel.setText(arra[2]);
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(147, 151, 116, 22);
		contentPane.add(textFieldTel);
		
		JLabel label_5 = new JLabel("Correo:");
		label_5.setBounds(272, 154, 120, 16);
		contentPane.add(label_5);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setText(arra[3]);
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(404, 151, 116, 22);
		contentPane.add(textFieldCorreo);
		
		JLabel label_9 = new JLabel("Membresia:");
		label_9.setBounds(275, 221, 120, 16);
		contentPane.add(label_9);
		
		JRadioButton radioButtonF = new JRadioButton("F");
		radioButtonF.setBounds(404, 214, 45, 25);
		contentPane.add(radioButtonF);
		
		JRadioButton radioButtonS = new JRadioButton("SF");
		radioButtonS.setBounds(466, 214, 45, 25);
		contentPane.add(radioButtonS);
		
		if(arra[4].equals("F"))
			radioButtonF.setSelected(true);
		else
			radioButtonS.setSelected(true);
		
		//System.out.println(dias.charAt(i));
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				conexionClientes conexionClientes = new conexionClientes();
				
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String telefono=textFieldTel.getText();
				String correo=textFieldCorreo.getText();
				String membresia="";
				if(radioButtonF.isSelected()) {
					membresia="F";
				}else{
					if(radioButtonS.isSelected()) {
						membresia="SF";
					}
				}
				
				try {
					conexionClientes.modificarClientes(nombre, apellido, telefono, correo, membresia, arra[5]);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModificar.setBounds(202, 312, 126, 25);
		contentPane.add(btnModificar);
	}

}
