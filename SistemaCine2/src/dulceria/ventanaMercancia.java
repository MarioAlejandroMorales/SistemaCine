package dulceria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.conexionDulceria;
import java.awt.Toolkit;



public class ventanaMercancia extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textDescripcion;
	private JTextField textCantidad;
	
	private conexionDulceria conexion = new conexionDulceria();
	
	String nombre;
	int cantidad;
	String descripcion;
	float precio;
	boolean visible=true;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaMercancia frame = new ventanaMercancia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ventanaMercancia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaMercancia.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemovie(Agregar)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 369, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(105, 10, 230, 20);
		panel_1.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 10, 86, 20);
		panel_1.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 50, 86, 20);
		panel_1.add(lblPrecio);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 90, 86, 20);
		panel_1.add(lblDescripcion);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 130, 86, 20);
		panel_1.add(lblCantidad);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(105, 50, 230, 20);
		panel_1.add(textPrecio);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(105, 90, 230, 20);
		panel_1.add(textDescripcion);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(105, 130, 230, 20);
		panel_1.add(textCantidad);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//boton aceptar
				//setVisible(false);
				try{
					String name;
					float price;
					String desc;
					int cant;
					//setVisible(false);
					name=textNombre.getText();
					price=Float.parseFloat(textPrecio.getText());
					desc=textDescripcion.getText();
					cant=Integer.parseInt(textCantidad.getText());
					
					conexion.insertarMercancia(name, price, desc, cant);
					dispose();
				}
				catch(Exception rr)
				{
					JOptionPane.showMessageDialog(null, "Por favor ingrese datos validos");
				}
				
				
				
			}
		});
		panel_3.add(btnNewButton);
	}
}
