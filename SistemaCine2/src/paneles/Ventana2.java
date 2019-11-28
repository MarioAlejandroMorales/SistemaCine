package paneles;

import paneles.Altas;
import paneles.MostrarEmpleados;
import paneles.AltasClientes;
import paneles.MostrarClientes;
import paneles.AltasPeliculas;
import paneles.Peliculas;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dulceria.ventanaCompra;
import dulceria.ventanaDulceria;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;


@SuppressWarnings("serial")
public class Ventana2 extends JFrame {

	private JPanel contentPane;
	
    private JFrame getFrame(){
        return this;
    }
    
	/**
	 * Create the frame.
	 */
	public Ventana2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana2.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemovie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		ImageIcon icoPeli = new ImageIcon(Ventana2.class.getResource("/imagenes/LogoIcon.png"));
		Image imgPeli = icoPeli.getImage(); //convertimos icon en una imagen
		Image otraimg = imgPeli.getScaledInstance(202,227,java.awt.Image.SCALE_SMOOTH);
		ImageIcon otroico = new ImageIcon(otraimg);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel(otroico);
		lblLogo.setBounds(10, 39, 287, 277);
		contentPane.add(lblLogo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 310, 26);
		contentPane.add(menuBar);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmAltas = new JMenuItem("Altas");
		mntmAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Altas altas = new Altas(){
			        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
				altas.setVisible(true);
			}
		});
		mnEmpleados.add(mntmAltas);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MostrarEmpleados mostrarEmpleados = new MostrarEmpleados(){
			        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
				mostrarEmpleados.setVisible(true);
			}
		});
		mnEmpleados.add(mntmMostrar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmAltas_1 = new JMenuItem("Altas");
		mntmAltas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AltasClientes altasClientes = new AltasClientes(){
			        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
				altasClientes.setVisible(true);
			}
		});
		mnClientes.add(mntmAltas_1);
		
		JMenuItem mntmMostrar_1 = new JMenuItem("Mostrar");
		mntmMostrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MostrarClientes mostrarClientes = new MostrarClientes(){
			    	//Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
				mostrarClientes.setVisible(true);
			}
		});
		mnClientes.add(mntmMostrar_1);
		
		JMenu mnPeliculas = new JMenu("Peliculas");
		menuBar.add(mnPeliculas);
		
		JMenuItem mntmAltas_2 = new JMenuItem("Altas");
		mntmAltas_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AltasPeliculas altasPeliculas = new AltasPeliculas(){
			    	//Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
			    altasPeliculas.setVisible(true);
			}
		});
		mnPeliculas.add(mntmAltas_2);
		
		JMenuItem mntmCartelera = new JMenuItem("Cartelera");
		mnPeliculas.add(mntmCartelera);
		
		JMenu mnDulceria = new JMenu("Dulceria");
		menuBar.add(mnDulceria);
		
		JMenuItem mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaCompra ventanaCompra = new ventanaCompra(){
			    	//Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
			    ventanaCompra.setVisible(true);	
			}
			
		});
		mnDulceria.add(mntmVender);
		
		JMenuItem mntmAdministrar = new JMenuItem("Administrar");
		mntmAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ventanaDulceria ventanaDulceria = new ventanaDulceria(){
			    	//Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
			    ventanaDulceria.setVisible(true);
			}
		});
		mnDulceria.add(mntmAdministrar);
		
		mntmCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Peliculas peliculas = new Peliculas(){
			    	//Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
			    peliculas.setVisible(true);
			}
		});
		
		
	}
}
