package paneles;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class asientos_f extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String asi="";
	public asientos_f(String id) {

		
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(245, 298, 89, 23);
		getContentPane().add(btnComprar);
		
		
		JCheckBox chckbxA1 = new JCheckBox("A1");
		chckbxA1.setBounds(62, 95, 86, 23);
		getContentPane().add(chckbxA1);
		
		JCheckBox chckbxA2 = new JCheckBox("A2");
		chckbxA2.setBounds(150, 95, 99, 23);
		getContentPane().add(chckbxA2);
		
		JCheckBox chckbxA3 = new JCheckBox("A3");
		chckbxA3.setBounds(251, 95, 99, 23);
		getContentPane().add(chckbxA3);
		
		JCheckBox chckbxA4 = new JCheckBox("A4");
		chckbxA4.setBounds(352, 95, 99, 23);
		getContentPane().add(chckbxA4);
		
		JCheckBox chckbxA5 = new JCheckBox("A5");
		chckbxA5.setBounds(453, 95, 99, 23);
		getContentPane().add(chckbxA5);
		
		JCheckBox chckbxB1 = new JCheckBox("B1");
		chckbxB1.setBounds(62, 121, 86, 23);
		getContentPane().add(chckbxB1);
		
		JCheckBox chckbxB2 = new JCheckBox("B2");
		chckbxB2.setBounds(150, 121, 99, 23);
		getContentPane().add(chckbxB2);
		
		JCheckBox chckbxB3 = new JCheckBox("B3");
		chckbxB3.setBounds(251, 121, 99, 23);
		getContentPane().add(chckbxB3);
		
		JCheckBox chckbxB4 = new JCheckBox("B4");
		chckbxB4.setBounds(352, 121, 99, 23);
		getContentPane().add(chckbxB4);
		
		JCheckBox chckbxB5 = new JCheckBox("B5");
		chckbxB5.setBounds(453, 121, 99, 23);
		getContentPane().add(chckbxB5);
		
		JCheckBox chckbxC1 = new JCheckBox("C1");
		chckbxC1.setBounds(62, 147, 86, 23);
		getContentPane().add(chckbxC1);
		
		JCheckBox chckbxC2 = new JCheckBox("C2");
		chckbxC2.setBounds(150, 147, 99, 23);
		getContentPane().add(chckbxC2);
		
		JCheckBox chckbxC3 = new JCheckBox("C3");
		chckbxC3.setBounds(251, 147, 99, 23);
		getContentPane().add(chckbxC3);
		
		JCheckBox chckbxC4 = new JCheckBox("C4");
		chckbxC4.setBounds(352, 147, 99, 23);
		getContentPane().add(chckbxC4);
		
		JCheckBox chckbxC5 = new JCheckBox("C5");
		chckbxC5.setBounds(453, 147, 99, 23);
		getContentPane().add(chckbxC5);
		
		JCheckBox chckbxD1 = new JCheckBox("D1");
		chckbxD1.setBounds(62, 173, 86, 23);
		getContentPane().add(chckbxD1);
		
		JCheckBox chckbxD2 = new JCheckBox("D2");
		chckbxD2.setBounds(150, 173, 99, 23);
		getContentPane().add(chckbxD2);
		
		JCheckBox chckbxD3 = new JCheckBox("D3");
		chckbxD3.setBounds(251, 173, 99, 23);
		getContentPane().add(chckbxD3);
		
		JCheckBox chckbxD4 = new JCheckBox("D4");
		chckbxD4.setBounds(352, 173, 99, 23);
		getContentPane().add(chckbxD4);
		
		JCheckBox chckbxD5 = new JCheckBox("D5");
		chckbxD5.setBounds(453, 173, 99, 23);
		getContentPane().add(chckbxD5);
		
		JCheckBox chckbxE1 = new JCheckBox("E1");
		chckbxE1.setBounds(62, 199, 86, 23);
		getContentPane().add(chckbxE1);
		
		JCheckBox chckbxE2 = new JCheckBox("E2");
		chckbxE2.setBounds(150, 199, 99, 23);
		getContentPane().add(chckbxE2);
		
		JCheckBox chckbxE3 = new JCheckBox("E3");
		chckbxE3.setBounds(251, 199, 99, 23);
		getContentPane().add(chckbxE3);
		
		JCheckBox chckbxE4 = new JCheckBox("E4");
		chckbxE4.setBounds(352, 199, 99, 23);
		getContentPane().add(chckbxE4);
		
		JCheckBox chckbxE5 = new JCheckBox("E5");
		chckbxE5.setBounds(453, 199, 99, 23);
		getContentPane().add(chckbxE5);
		
		JLabel lblSeleccionaTusAscientos = new JLabel("selecciona tus asientos");
		lblSeleccionaTusAscientos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSeleccionaTusAscientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaTusAscientos.setBounds(145, 11, 275, 40);
		getContentPane().add(lblSeleccionaTusAscientos);
		

		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxA1.isSelected())
					asi+="A1";
				if(chckbxA2.isSelected())
					asi+="A2";
				if(chckbxA3.isSelected())
					asi+="A3";
				if(chckbxA4.isSelected())
					asi+="A4";
				if(chckbxA5.isSelected())
					asi+="A5";

				if(chckbxB1.isSelected())
					asi+="B1";
				if(chckbxB2.isSelected())
					asi+="B2";
				if(chckbxB3.isSelected())
					asi+="B3";
				if(chckbxB4.isSelected())
					asi+="B4";
				if(chckbxB5.isSelected())
					asi+="B5";
				
				if(chckbxC1.isSelected())
					asi+="C1";
				if(chckbxC2.isSelected())
					asi+="C2";
				if(chckbxC3.isSelected())
					asi+="C3";
				if(chckbxC4.isSelected())
					asi+="C4";
				if(chckbxC5.isSelected())
					asi+="C5";

				if(chckbxD1.isSelected())
					asi+="D1";
				if(chckbxD2.isSelected())
					asi+="D2";
				if(chckbxD3.isSelected())
					asi+="D3";
				if(chckbxD4.isSelected())
					asi+="D4";
				if(chckbxD5.isSelected())
					asi+="D5";

				if(chckbxE1.isSelected())
					asi+="E1";
				if(chckbxE2.isSelected())
					asi+="E2";
				if(chckbxE3.isSelected())
					asi+="E3";
				if(chckbxE4.isSelected())
					asi+="E4";
				if(chckbxE5.isSelected())
					asi+="E5";
				confirmacion_asientos view = new confirmacion_asientos(id, asi);
				view.setVisible(true);
			}
		});
	}
}
