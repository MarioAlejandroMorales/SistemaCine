package dulceria;

import clases.conexionDulceria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
//import javax.swing.JList;
//import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


//import clases.conexionBD;

//import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;

public class ventanaDulceria extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnInsertar;
	private JButton btnModificar;
	private JButton btnMostrarProductos;
	private JButton btnComprar;
	
	private conexionDulceria conexion = new conexionDulceria();
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ventanaDulceria() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaDulceria.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemovie(Administrar productos)");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		Panel panel = new Panel();
		
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {//boton buscar
					
					int id=0;
					DefaultTableModel model = new DefaultTableModel(){
						boolean[] columnEditables = new boolean[] {
								false, true, true, true, true
							};
							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						};
					model.setRowCount(0);
					
					table.setModel(model);
					
				try
				{
					
					id=Integer.parseInt(textField.getText());
					Object ax[]= conexion.mostrarMercancia(id);
					
					if(ax[0]!=null)
					{
						
						
						model.addColumn("Id");
						model.addColumn("Nombre");
						model.addColumn("Precio");
						model.addColumn("Descripcion");
						model.addColumn("Cantidad");
						model.addRow(ax);
						table.setModel(model);
						table.getColumnModel().getColumn(0).setResizable(false);
						table.getColumnModel().getColumn(0).setPreferredWidth(35);
						table.getColumnModel().getColumn(1).setResizable(false);
						table.getColumnModel().getColumn(1).setPreferredWidth(50);
						table.getColumnModel().getColumn(2).setResizable(false);
						table.getColumnModel().getColumn(2).setPreferredWidth(50);
						table.getColumnModel().getColumn(3).setResizable(false);
						table.getColumnModel().getColumn(3).setPreferredWidth(225);
						table.getColumnModel().getColumn(4).setResizable(false);
						table.getTableHeader().setReorderingAllowed(false);
					}
					
				}
				catch(Exception r)
				{
					
				}
				
			}
		});
		panel.add(btnBuscar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//boton insertar
				
				ventanaMercancia vm=new ventanaMercancia();
				vm.setVisible(true);
				///insert=true;
			}
		});
		panel.add(btnInsertar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		

		btnModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {//boton modificar
				String str;
				String nombre;
				float precio;
				String descripcion;
				int cantidad;
				//Object a[]=new Object[5];
				int idm;
				idm=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				nombre=table.getValueAt(table.getSelectedRow(), 1).toString();
				precio=Float.parseFloat(table.getValueAt(table.getSelectedRow(), 2).toString());
				descripcion=table.getValueAt(table.getSelectedRow(), 3).toString();
				cantidad=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString());
				//System.out.println (idm);
				//System.out.println (str);
				ventanaMercanciaMod vmm=new ventanaMercanciaMod(idm,nombre,precio,descripcion,cantidad);
				vmm.setVisible(true);
				
			}
		});
		panel.add(btnModificar);
		
		btnMostrarProductos = new JButton("Mostrar Productos");
		btnMostrarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//boton mostrarproductos
				
				Object a[][]=conexion.mostrarMercancias();
				table.setModel(new DefaultTableModel(
						a,
						new String [] {
								"Id", "Nombre", "Precio", "Descripcion", "Cantidad",}
					){
					boolean[] columnEditables = new boolean[] {
							false, true, true, true, true
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(0).setPreferredWidth(35);
				//table.getColumnModel().getColumn(0).ed
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(50);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(50);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(3).setPreferredWidth(225);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getTableHeader().setReorderingAllowed(false);
				
			}
		});
		panel.add(btnMostrarProductos);
		
		btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//boton comprar
				
				ventanaCompra vc = new ventanaCompra();
				vc.setVisible(true);
				
				
			}
		});
		panel.add(btnComprar);
		ListSelectionModel seleccion=table.getSelectionModel();
		seleccion.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				
				if(!seleccion.isSelectionEmpty())
					btnModificar.setEnabled(true);
				else
					btnModificar.setEnabled(false);
				
				
				
			}
			
		});
		

		
		
	}

}
