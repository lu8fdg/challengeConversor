package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTemperatura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8421361466567727961L;
	private JPanel contentPane;
	private JTextField campo;
	private JTextField resultado;

	private String[] unidades = { "°C", "°F", "K", "°R" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTemperatura frame = new FrmTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public FrmTemperatura() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblConversorDeLongitud = new JLabel("CONVERSOR DE TEMPERATURA");
		lblConversorDeLongitud.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorDeLongitud.setBounds(119, 22, 187, 22);
		contentPane.add(lblConversorDeLongitud);

		JLabel lblCantidad = new JLabel("Grados Centígrados :");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBounds(92, 63, 129, 22);
		contentPane.add(lblCantidad);

		JLabel lblDe = new JLabel("convertir a :");
		lblDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDe.setBounds(130, 96, 95, 22);
		contentPane.add(lblDe);

		JLabel lblResultado = new JLabel("RESULTADO :");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(132, 143, 89, 22);
		contentPane.add(lblResultado);

		JButton btnSalir = new JButton("Menú Principal");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSalir) {
					dispose();
					FrmPrincipal miFrmPrincipal = new FrmPrincipal();
					miFrmPrincipal.setVisible(true);
				}
			}
		});
		btnSalir.setBounds(245, 210, 124, 23);
		contentPane.add(btnSalir);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(231, 96, 86, 22);
		contentPane.add(comboBox);

		comboBox.setModel(new DefaultComboBoxModel<>(unidades));

		campo = new JTextField();
		campo.setColumns(10);
		campo.setBounds(231, 64, 86, 20);
		contentPane.add(campo);

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/**********LOGICA BOTON ****************************/
				if(comboBox.getSelectedItem() == "°C") {
					String textTemp = campo.getText();
					resultado.setText(textTemp);
					
				}
				/*************GRADOS CENTÍGRADOS A KELVIN*************/
				if (comboBox.getSelectedItem() == "K") {
					float valorTemp = Float.parseFloat(campo.getText());
					float tempConvert = valorTemp + 273.15f;
					String textTemp = Float.toString(tempConvert);
					resultado.setText(textTemp);
					
				}
				/*************GRADOS CENTÍGRADOS A FARENHEIT*************/
				if (comboBox.getSelectedItem() == "°F") {
					float valorTemp = Float.parseFloat(campo.getText());
					float tempConvert = (valorTemp*1.8f) + 32f;
					String textTemp = Float.toString(tempConvert);
					resultado.setText(textTemp);
					
				}
				/*************GRADOS CENTÍGRADOS A RANKINE*************/
				if (comboBox.getSelectedItem() == "°R") {
					float valorTemp = Float.parseFloat(campo.getText());
					float tempConvert = (valorTemp*1.8f) + 491.67f;
					String textTemp = Float.toString(tempConvert);
					resultado.setText(textTemp);
				}
			}
		});
		btnCalcular.setBounds(77, 210, 124, 23);
		contentPane.add(btnCalcular);

		resultado = new JTextField();
		resultado.setColumns(10);
		resultado.setBounds(231, 144, 86, 20);
		contentPane.add(resultado);

		setLocationRelativeTo(null);
	}

}
