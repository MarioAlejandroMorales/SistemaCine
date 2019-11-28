package paneles;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import clases.conexionPeliculas;

public class confirmacion_asientos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private javax.swing.JTable table;
	private conexionPeliculas conexionPeliculas= new conexionPeliculas();
	
    private JFrame getFrame(){
        return this;
    }

	/**
	 * Create the frame.
	 */
	public confirmacion_asientos(String id, String asientos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 347, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String a[] = conexionPeliculas.consultarPeliculasId(id);
		table = new javax.swing.JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(
			new Object[][] {
				{"Numero de ticket", null},
				{"Pelicula", a[1]},
				{"Sala", null},
				{"Asciento", asientos},
				{"Hora", null},
				{"Fecha", null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(25, 89, 281, 96);
		contentPane.add(table);
		
		ImageIcon icoPeli = new ImageIcon(a[7]);
		Image imgPeli = icoPeli.getImage(); //convertimos icon en una imagen
		Image otraimg = imgPeli.getScaledInstance(202,227,java.awt.Image.SCALE_SMOOTH);
		ImageIcon otroico = new ImageIcon(otraimg);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel(otroico);
		lblLogo.setBounds(131, 14, 74, 64);
		contentPane.add(lblLogo);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(131, 216, 89, 23);
		contentPane.add(btnComprar);
		//String ruta = C:\Users\Silvia\Documents\FN;
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileOutputStream archivo;
				String ruta="C:\\Users\\Mario\\Desktop\\ticket";

				Document doc = new Document();
				try {
					archivo=new FileOutputStream(ruta+".pdf");
					String contenido=a[1]+"\n\r"+asientos;
					doc.open();
					PdfWriter.getInstance(doc, archivo);
					doc.add(new Paragraph(contenido));
					doc.close();
				} catch (FileNotFoundException | DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
	});
	}
}
