package paneles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import clases.conexionBD;

import paneles.ModificarClientes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarClientes extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTable table;

	private conexionBD conexionBD = new conexionBD();
	private JTextField TextFieldId;
	/**
	 * Create the frame.
	 */
	
	public MostrarClientes() {
		setTitle("Mostrar Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object a[][] = conexionBD.consultarEmpleados();
		
		table = new JTable();
		table.setBounds(384, 87, 486, 199);
		contentPane.add(table);
		table.setModel(new DefaultTableModel(
			
			a,
			new String [] {
					"Nombre", "Apellido", "Telefono", "Correo", "Membresia", "id",
			}
			
			
		));

		JScrollPane panel = new JScrollPane(table);
		panel.setBounds(12, 60, 1128, 334);
		contentPane.add(panel);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(12, 13, 85, 19);
		contentPane.add(lblClientes);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(1200, 79, 85, 19);
		contentPane.add(lblNewLabel);
		
		TextFieldId = new JTextField();
		TextFieldId.setBounds(1285, 77, 116, 22);
		contentPane.add(TextFieldId);
		TextFieldId.setColumns(10);
		
		JButton btnBuscar = new JButton("Modificar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String arra[]= new String [15];
				arra = conexionBD.consultarCodigo(TextFieldId.getText());
				ModificarClientes modificarClientes = new ModificarClientes(arra);
				modificarClientes.setVisible(true);
			}
		});
		btnBuscar.setBounds(1200, 115, 97, 25);
		contentPane.add(btnBuscar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAtras.setBounds(1200, 365, 97, 25);
		contentPane.add(btnAtras);
	}
}
