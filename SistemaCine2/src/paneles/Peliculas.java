package paneles;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.conexionPeliculas;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Peliculas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private conexionPeliculas conexionPeliculas = new conexionPeliculas();

	/**
	 * Create the frame.
	 */
	
	public Peliculas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Peliculas.class.getResource("/imagenes/LogoIcon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		setTitle("Systemovie(Cartelera)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
		setBounds(0, 0, screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String a[][] = conexionPeliculas.consultarPeliculas();
		
		int cont = conexionPeliculas.contadorRegistros(), mid = (cont%2 == 0) ? cont/2 : cont/2+1;
		int posX, posY;
		JLabel lblPeliculasDisponibles = new JLabel("Peliculas disponibles: " + String.valueOf(cont) ); 
		lblPeliculasDisponibles.setBounds(10, 11, 159, 14);
		contentPane.add(lblPeliculasDisponibles);
		int escalaBotonX = ((new Dimension(Toolkit.getDefaultToolkit().getScreenSize()).width - cont*10)/mid) +7;
		
		JButton jmi[] = new JButton[cont];
		ImageIcon ic[] = new ImageIcon[cont];
		for(int i = 1; i <= cont; i++) {
			
			if(i <= mid) {
				posY = 36;
				posX = ((i*10)+escalaBotonX*(i - 1));
			}else {
				posY = 383;
				posX = (((i-(mid ))*10)+(escalaBotonX*(i-(mid+1))));
			}
			ic[i-1] = new ImageIcon(new ImageIcon(a[i-1][6]).getImage().getScaledInstance(escalaBotonX, 337, Image.SCALE_DEFAULT) );			
			jmi[i-1] = new JButton(a[i-1][0],ic[i-1]);
			jmi[i-1].setBounds(posX,posY,escalaBotonX,337);
			jmi[i-1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//DetallesPelicula.setVisible(true);
					//dispose();
				}
			});
			
		}
		for(int i = 0; i < conexionPeliculas.contadorRegistros(); i++) {
			contentPane.add(jmi[i]);
		}
		JButton btnVolver = new JButton("Volver");
		btnVolver.setLocation(222, 6);
		btnVolver.setSize(97, 25);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnVolver);
		/*		
		JComboBox<Object> list = new JComboBox<Object>();
		list.setBounds(10, 36, 905, 307);
		Object obj[][] = new Object[2][10];
		for(int i = 0; i < 10; i++) {
			list.add(a[i]);
		}
		contentPane.add(list);
		*/
	}

}
