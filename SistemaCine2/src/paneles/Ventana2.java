package paneles;

import paneles.Altas;
import paneles.MostrarEmpleados;
import paneles.AltasClientes;
import paneles.MostrarClientes;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class Ventana2 extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Altas altas = new Altas(){
        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
        @Override
        public void dispose(){
            //Hacemos visible la principal
            getFrame().setVisible(true);
            //Cerramos vNueva
            super.dispose();
        }
    };
    
	private AltasClientes altasClientes = new AltasClientes(){
        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
        @Override
        public void dispose(){
            //Hacemos visible la principal
            getFrame().setVisible(true);
            //Cerramos vNueva
            super.dispose();
        }
    };
    
	private MostrarEmpleados mostrarEmpleados = new MostrarEmpleados(){
        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
        @Override
        public void dispose(){
            //Hacemos visible la principal
            getFrame().setVisible(true);
            //Cerramos vNueva
            super.dispose();
        }
    };
    
    private MostrarClientes mostrarClientes = new MostrarClientes(){
    	//Con esto cuando llamemos a dispose de vNueva abrimos la principal
        @Override
        public void dispose(){
            //Hacemos visible la principal
            getFrame().setVisible(true);
            //Cerramos vNueva
            super.dispose();
        }
    };

    private JFrame getFrame(){
        return this;
    }
    
	/**
	 * Create the frame.
	 */
	public Ventana2() {
		setTitle("Systemovie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		ImageIcon icoPeli = new ImageIcon("D:\\Biblioteca\\Documentos\\Java\\Cine\\src\\imagenes\\Polimex.png");
		Image imgPeli = icoPeli.getImage(); //convertimos icon en una imagen
		Image otraimg = imgPeli.getScaledInstance(202,227,java.awt.Image.SCALE_SMOOTH);
		ImageIcon otroico = new ImageIcon(otraimg);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel(otroico);
		lblLogo.setBounds(10, 39, 287, 277);
		contentPane.add(lblLogo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 206, 26);
		contentPane.add(menuBar);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmAltas = new JMenuItem("Altas");
		mntmAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altas.setVisible(true);
				dispose();
			}
		});
		mnEmpleados.add(mntmAltas);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarEmpleados.setVisible(true);
				dispose();
			}
		});
		mnEmpleados.add(mntmMostrar);
		
		JMenuItem mntmCartelera = new JMenuItem("Cartelera");
		mntmCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmAltas_1 = new JMenuItem("Altas");
		mntmAltas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				altasClientes.setVisible(true);
			}
		});
		mnClientes.add(mntmAltas_1);
		
		JMenuItem mntmMostrar_1 = new JMenuItem("Mostrar");
		mntmMostrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				mostrarClientes.setVisible(true);
			}
		});
		mnClientes.add(mntmMostrar_1);
		menuBar.add(mntmCartelera);
		
		
	}
}
