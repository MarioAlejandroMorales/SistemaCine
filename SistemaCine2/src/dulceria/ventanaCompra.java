package dulceria;

import clases.conexionDulceria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import net.miginfocom.swing.MigLayout;
//import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.CardLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
//import javax.swing.SwingConstants;

public class ventanaCompra extends JFrame {
	private conexionDulceria conexion = new conexionDulceria();
	private JPanel contentPane;
	private ButtonGroup bg=new ButtonGroup();
	private JTable tablaVenta;
	private JTable tablaCompra;

	float total=0f;
	

	/**
	 * Launch the application.
	*/
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaCompra frame = new ventanaCompra();
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
	public ventanaCompra() {
		setTitle("Systemovie(Dulceria)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaCompra.class.getResource("/imagenes/LogoIcon.png"))); 
		
		JLabel lblTotal = new JLabel("Total:");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tablaVenta = new JTable();
		scrollPane.setViewportView(tablaVenta);
		
		JRadioButton rdbtnNORMAL = new JRadioButton("NORMAL");
		JRadioButton rdbtnFanatico = new JRadioButton("FANATICO");
		JRadioButton rdbtnSuperFanatico = new JRadioButton("SUPER FANATICO");
		rdbtnNORMAL.setSelected(true);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		tablaCompra = new JTable();
		scrollPane_1.setViewportView(tablaCompra);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//boton agregar
				try {
					DefaultTableModel model2 = (DefaultTableModel)tablaCompra.getModel();
			     	TableModel model1 = tablaVenta.getModel();
			        int indexs[] = tablaVenta.getSelectedRows();
			        //tablaCompra.setModel(model1);
			        Object[] row = new Object[5];
			        
			        boolean bandera;
			        
			        for(int i = 0; i < indexs.length; i++)
			        {
			        	bandera=false;
			            row[0] = model1.getValueAt(indexs[i], 0);
			            row[1] = model1.getValueAt(indexs[i], 1);
			            row[2] = model1.getValueAt(indexs[i], 2);
			            row[3] = model1.getValueAt(indexs[i], 3);
			            
			            for(int j = 0; j < model2.getRowCount(); j++) {
			            	if(row[0]== model2.getValueAt(j, 0))
			            		bandera=true;
			            }
			            if(bandera==false)
			            model2.addRow(row);
			        }
				
			}
			catch(Exception mal) {
				
			}
			}
		});
		panel_1.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//boton eliminar
				DefaultTableModel model2 = (DefaultTableModel)tablaCompra.getModel();
				//int rowSelect = tablaCompra.getSelectedRow();
				/*if(rowSelect>=0)
				{
					model2.removeRow(rowSelect);
				}*/
				try {
				int indexs[] = tablaCompra.getSelectedRows();
		        //tablaCompra.setModel(model1);
		       // Object[] row = new Object[5];
		        
		        //boolean bandera;
		        
		        for(int i = (indexs.length)-1; i >= 0; i--)
		        {
		        	model2.removeRow(indexs[i]);
		        }
				}
				catch(Exception w) {
					
				}
				
			}
		});
		panel_1.add(btnEliminar);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//boton generar
				String ruta="";
				String contenido="";
				int cantidad;
				int id;
				String nombre;
				float precio;
				String descripcion;
				 
				float totales[]=new float[tablaCompra.getRowCount()];
				//contenido del ticket
				Date dates =new Date();
				DateFormat fechaHora = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				contenido+="+++++++++++++++++++++TICKET DE COMPRA++++++++++++++++++++++++++++\r\n"+ 
						"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n" + 
						"BIENVENIDO A NUESTRA DULCERIA RECUERDE QUE AL COMPRAR EN LA \r\n" + 
						"DULCERIA Y MOSTRAR SU TARGETA DE CLIENTE VIP OBTENDRA\r\nDESCUENTOS" + 
						"EN SUS COMPRAS\r\n"+ 
						"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n"+
						"                                            "+fechaHora.format(dates)+
						"\r\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n";
				//boolean bandera=false;
				//COMPROBAR SI LA COLUMNA CANTIDAD SE A LLENADO
				if(tablaCompra.getRowCount()>0)
				try
				{
					int cant=0;
					 for(int i=0;i<tablaCompra.getRowCount();i++){
						cantidad=Integer.parseInt(tablaCompra.getValueAt(i, 4).toString());
					 }
						
						for(int i1=0;i1<tablaCompra.getRowCount();i1++)
						{
							totales[i1]=Float.parseFloat(tablaCompra.getValueAt(i1, 2).toString())*Integer.parseInt(tablaCompra.getValueAt(i1, 4).toString());
							//JOptionPane.showMessageDialog(null, totales[i1]);
							total+=totales[i1];
							//contenido+="";
							
							contenido+=tablaCompra.getValueAt(i1, 4).toString()+
									"\t articulo(s)\t"+
							tablaCompra.getValueAt(i1, 1).toString()+"\t"+
							tablaCompra.getValueAt(i1, 2).toString()+"\t Subtotal\t"+
							String.valueOf(totales[i1]+"\r\n");
							
						}
						//JOptionPane.showMessageDialog(null, total);
						Object objetos[][]=new Object[tablaCompra.getRowCount()][5];
						boolean band=false;
						for(int i=0;i<tablaCompra.getRowCount();i++)
						{
							for(int j=0;j<tablaVenta.getRowCount();j++)
							{
								if(tablaVenta.getValueAt(j, 0)==tablaCompra.getValueAt(i, 0))
								{
									id=Integer.parseInt(tablaVenta.getValueAt(j, 0).toString());
									objetos[i][0]=id;
									nombre=tablaVenta.getValueAt(j, 1).toString();
									objetos[i][1]=nombre;
									precio=Float.parseFloat(tablaVenta.getValueAt(j, 2).toString());
									objetos[i][2]=precio;
									descripcion=tablaVenta.getValueAt(j, 3).toString();
									objetos[i][3]=descripcion;
									cant=Integer.parseInt(tablaVenta.getValueAt(j, 4).toString())-
											Integer.parseInt(tablaCompra.getValueAt(i, 4).toString());
									objetos[i][4]=cant;
									
									if(cant<0)
									{
										band=true;	
									}		
								}
							}
							
						}
						if(band)
						{
							JOptionPane.showMessageDialog(null,"Asegurate que la compra no exeda la cantidad en STOCK");	
						}
						if(!band)
							for(int w=0;w<tablaCompra.getRowCount();w++)
								conexion.actualizarMercancia((int)objetos[w][0], objetos[w][1].toString()
										, Float.valueOf(objetos[w][2].toString()), objetos[w][3].toString(), (int)objetos[w][4]);
						
						//mostrar total
						if(!band)
						try {
							String tot="Total: ";
							String tott=String.format("%.2f",total);
							tot+=tott;
							if(rdbtnNORMAL.isSelected())//total normal
							{
								lblTotal.setText(tot);///
								contenido+="\r\nSUBTOTAL "+
								String.format("%.2f",total)+"\r\n"+
										"Cliente NORMAL\t PAGA: "+
								String.format("%.2f",total)+"\r\n";
							}
							if(rdbtnFanatico.isSelected())//total fanatico
							{
								 tot="Total: ";
								 tott=String.format("%.2f",total*0.95f);
								tot+=tott;
								lblTotal.setText((tot));
								contenido+="\r\nSUBTOTAL "+
										String.format("%.2f",total)+"\r\n"+
												"Cliente FANATICO\t PAGA: "+
										String.format("%.2f",total*0.95f)+"\r\n";
							}
								
							if(rdbtnSuperFanatico.isSelected())//total superfanatico
							{
								tot="Total: ";
								tott=String.format("%.2f",total*0.90f);
								tot+=tott;
								lblTotal.setText(tot);
								contenido+="\r\nSUBTOTAL "+
										String.format("%.2f",total)+"\r\n"+
												"Cliente SUPER FANATICO\t PAGA: "+
										String.format("%.2f",total*0.90f)+"\r\n";
							}
								
								
							}
							catch(Exception ert) {
								
							}
						//generar ticket
						if(!band)
						try
						{
							FileOutputStream archivo = new FileOutputStream(ruta+"TICKET.pdf");
							Document doc= new Document();
							PdfWriter.getInstance(doc, archivo);
							doc.open();
							doc.add(new Paragraph(contenido));
							doc.close();
							//Object cReemp[]=new Object[5];
							
							
						}
							
						catch(Exception pp)
						{
							JOptionPane.showMessageDialog(null, "no se pudo generar tiket");
						}
				}
				catch(Exception ww) {
					JOptionPane.showMessageDialog(null, "no se pudo convertir a entero");
				}
				total=0;
				DefaultTableModel model2 = (DefaultTableModel)tablaCompra.getModel();
				model2.setRowCount(0);
				//
				Object a[][]=conexion.mostrarMercancias();
				tablaVenta.setModel(new DefaultTableModel(
						a,
						new String [] {
								"Id", "Nombre", "Precio", "Descripcion", "Cantidad",}
					){
					boolean[] columnEditables = new boolean[] {
							false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
				tablaVenta.getColumnModel().getColumn(0).setResizable(false);
				tablaVenta.getColumnModel().getColumn(0).setPreferredWidth(35);
				//table.getColumnModel().getColumn(0).ed
				tablaVenta.getColumnModel().getColumn(1).setResizable(false);
				tablaVenta.getColumnModel().getColumn(1).setPreferredWidth(50);
				tablaVenta.getColumnModel().getColumn(2).setResizable(false);
				tablaVenta.getColumnModel().getColumn(2).setPreferredWidth(50);
				tablaVenta.getColumnModel().getColumn(3).setResizable(false);
				tablaVenta.getColumnModel().getColumn(3).setPreferredWidth(225);
				tablaVenta.getColumnModel().getColumn(4).setResizable(false);
				tablaVenta.getTableHeader().setReorderingAllowed(false);
				//dispose();
			}
		
		});
		panel_1.add(btnComprar);
		
		
		panel_1.add(lblTotal);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		panel_2.add(rdbtnNORMAL);
		
		panel_2.add(rdbtnFanatico);
		
		panel_2.add(rdbtnSuperFanatico);
		
		bg.add(rdbtnNORMAL);
		bg.add(rdbtnFanatico);
		bg.add(rdbtnSuperFanatico);
		
		
		//ListSelectionModel seleccion=tablaCompra.getSelectionModel();
		/*tablaCompra.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent e) {
				
					
			}
		});*/
		
		try
		{
			Object a[][]=conexion.mostrarMercancias();
			tablaVenta.setModel(new DefaultTableModel(
					a,
					new String [] {
							"Id", "Nombre", "Precio", "Descripcion", "Cantidad",}
				){
				boolean[] columnEditables = new boolean[] {
						false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
			tablaVenta.getColumnModel().getColumn(0).setResizable(false);
			tablaVenta.getColumnModel().getColumn(0).setPreferredWidth(35);
			//table.getColumnModel().getColumn(0).ed
			tablaVenta.getColumnModel().getColumn(1).setResizable(false);
			tablaVenta.getColumnModel().getColumn(1).setPreferredWidth(50);
			tablaVenta.getColumnModel().getColumn(2).setResizable(false);
			tablaVenta.getColumnModel().getColumn(2).setPreferredWidth(50);
			tablaVenta.getColumnModel().getColumn(3).setResizable(false);
			tablaVenta.getColumnModel().getColumn(3).setPreferredWidth(225);
			tablaVenta.getColumnModel().getColumn(4).setResizable(false);
			tablaVenta.getTableHeader().setReorderingAllowed(false);
		}
		catch(Exception ee)
		{
			
		}
		try
		{
			//Object a[][]=new Object[0][0];
			tablaCompra.setModel(new DefaultTableModel(
					new Object[0][0],
					new String [] {
							"Id", "Nombre", "Precio", "Descripcion", "Cantidad",}
				){
				boolean[] columnEditables = new boolean[] {
						false, false, false, false, true
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
			tablaCompra.getColumnModel().getColumn(0).setResizable(false);
			tablaCompra.getColumnModel().getColumn(0).setPreferredWidth(35);
			//table.getColumnModel().getColumn(0).ed
			tablaCompra.getColumnModel().getColumn(1).setResizable(false);
			tablaCompra.getColumnModel().getColumn(1).setPreferredWidth(50);
			tablaCompra.getColumnModel().getColumn(2).setResizable(false);
			tablaCompra.getColumnModel().getColumn(2).setPreferredWidth(50);
			tablaCompra.getColumnModel().getColumn(3).setResizable(false);
			tablaCompra.getColumnModel().getColumn(3).setPreferredWidth(225);
			tablaCompra.getColumnModel().getColumn(4).setResizable(false);
			tablaCompra.getTableHeader().setReorderingAllowed(false);
			
		}catch(Exception ee){
			
		}
		
		
	}

}
