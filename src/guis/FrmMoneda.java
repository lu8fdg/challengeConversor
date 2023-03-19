package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;


public class FrmMoneda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1352520620509386652L;
	private JPanel contentPane;
	private JTextField cantidad;
	private JTextField resultado;
	
	private double arsToUsd = 0.00493d;
	private double usdToUsd = 1d;
	private double gbpToUsd = 1.21625d;
	private double jpyToUsd = 0.00752d;
	private double kpwToUsd = 0.00111d;
	
	private double usdToArs = 202.84d;
	private double usdToGbp = 0.8222d;
	private double usdToJpy = 133.018d;
	private double usdToKpw = 899.99d;
	
	private double valorEnUsd;
	
	private String[] monedas = { "ARS - Peso argentino", "USD - Dolar estadounidense", "GBP - Libra esterlina", "JPY - Yen japonés", "KPW - Won norcoreano" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMoneda frame = new FrmMoneda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public FrmMoneda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConversorDeMoneda = new JLabel("CONVERSOR DE MONEDA");
		lblConversorDeMoneda.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorDeMoneda.setBounds(135, 32, 148, 22);
		contentPane.add(lblConversorDeMoneda);
		
		JButton btnVolver = new JButton("Menú Principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver) {
					dispose();
					FrmPrincipal miFrmPrincipal = new FrmPrincipal();
					miFrmPrincipal.setVisible(true);
				}
			}
		});
		btnVolver.setBounds(248, 209, 126, 23);
		contentPane.add(btnVolver);
		
		JLabel lblCantidad = new JLabel("CANTIDAD :");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBounds(115, 65, 89, 22);
		contentPane.add(lblCantidad);
		
		JLabel lblDe = new JLabel("DE :");
		lblDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDe.setBounds(109, 98, 39, 22);
		contentPane.add(lblDe);
		
		JLabel lblA = new JLabel("A :");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(116, 127, 32, 22);
		contentPane.add(lblA);
		
		JLabel lblResultado = new JLabel("RESULTADO :");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(115, 160, 89, 22);
		contentPane.add(lblResultado);
		
		cantidad = new JTextField();
		cantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				int key = evt.getKeyChar();
			    boolean numeros = key >= 48 && key <= 57 || key == 46 ;
		        
			    if (!numeros)
			    {
			        evt.consume();
			    }
			}
		});
		cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		cantidad.setBounds(214, 66, 86, 20);
		contentPane.add(cantidad);
		cantidad.setColumns(10);

		
		JComboBox<String> boxDe = new JComboBox<String>();
		boxDe.setBounds(164, 98, 180, 22);
		contentPane.add(boxDe);
		boxDe.setModel(new DefaultComboBoxModel<>(monedas));
		
		JComboBox<String> boxA = new JComboBox<String>();
		boxA.setBounds(164, 127, 180, 22);
		contentPane.add(boxA);
		boxA.setModel(new DefaultComboBoxModel<>(monedas));
		
		resultado = new JTextField();
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setColumns(10);
		resultado.setBounds(214, 161, 86, 20);
		contentPane.add(resultado);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***************BOTON CALCULAR*********************/
				
				//*********LOGICA "DE"				 
				if(boxDe.getSelectedItem() == "ARS - Peso argentino") {
					String textTemp = cantidad.getText();
					double valorTemp = Double.parseDouble(textTemp);
					valorEnUsd = valorTemp * arsToUsd;
				}
				
				if(boxDe.getSelectedItem() == "USD - Dolar estadounidense") {
					String textTemp = cantidad.getText();
					double valorTemp = Double.parseDouble(textTemp);
					valorEnUsd = valorTemp * usdToUsd;
				}
				
				if(boxDe.getSelectedItem() == "GBP - Libra esterlina") {
					String textTemp = cantidad.getText();
					double valorTemp = Double.parseDouble(textTemp);
					valorEnUsd = valorTemp * gbpToUsd;
				}
				
				if(boxDe.getSelectedItem() == "JPY - Yen japonés") {
					String textTemp = cantidad.getText();
					double valorTemp = Double.parseDouble(textTemp);
					valorEnUsd = valorTemp * jpyToUsd;
				}
				
				if(boxDe.getSelectedItem() == "KPW - Won norcoreano") {
					String textTemp = cantidad.getText();
					double valorTemp = Double.parseDouble(textTemp);
					valorEnUsd = valorTemp * kpwToUsd;
				}
				
				//*********LOGICA "A"
				
				if(boxA.getSelectedItem() == "ARS - Peso argentino") {
					double valorDestino = valorEnUsd * usdToArs;
					String textTemp = String.valueOf(Math.round(valorDestino * 100.0)/100.0);
					resultado.setText(textTemp);
				}
				if(boxA.getSelectedItem() == "USD - Dolar estadounidense") {
					double valorDestino = valorEnUsd * usdToUsd;
					String textTemp = String.valueOf(Math.round(valorDestino * 100.0)/100.0);
					resultado.setText(textTemp);
				}
				if(boxA.getSelectedItem() == "GBP - Libra esterlina") {
					double valorDestino = valorEnUsd * usdToGbp;
					String textTemp = String.valueOf(Math.round(valorDestino * 100.0)/100.0);
					resultado.setText(textTemp);
				}
				if(boxA.getSelectedItem() == "JPY - Yen japonés") {
					double valorDestino = valorEnUsd * usdToJpy;
					String textTemp = String.valueOf(Math.round(valorDestino * 100.0)/100.0);
					resultado.setText(textTemp);
				}
				if(boxA.getSelectedItem() == "KPW - Won norcoreano") {
					double valorDestino = valorEnUsd * usdToKpw;
					String textTemp = String.valueOf(Math.round(valorDestino * 100.0)/100.0);
					resultado.setText(textTemp);
				}
					

			}
		});
		btnCalcular.setBounds(80, 209, 108, 23);
		contentPane.add(btnCalcular);
		
		setLocationRelativeTo(null);
	}
}
