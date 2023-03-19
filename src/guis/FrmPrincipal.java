package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5066107811845720346L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		

		setAutoRequestFocus(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSalir) {
					System.exit(0);
				}
			}
		});
		btnSalir.setBounds(170, 188, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblConversorDeUnidades = new JLabel("CONVERSOR DE UNIDADES");
		lblConversorDeUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorDeUnidades.setBounds(118, 33, 187, 22);
		contentPane.add(lblConversorDeUnidades);
		
		JButton btnMoneda = new JButton("");
		btnMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnMoneda) {
					dispose();
					FrmMoneda miFrmMoneda = new FrmMoneda();
					miFrmMoneda.setVisible(true);
				}
			}
		});
		btnMoneda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes60/monetario60.jpg")));
		btnMoneda.setBounds(99, 81, 60, 60);
		contentPane.add(btnMoneda);
		
		JButton btnTemperatura = new JButton("");
		btnTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnTemperatura) {
					dispose();
					FrmTemperatura miFrmTemperatura = new FrmTemperatura();
					miFrmTemperatura.setVisible(true);
				}
			}
		});
		btnTemperatura.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes60/temperature60.jpg")));
		btnTemperatura.setBounds(269, 81, 60, 60);
		contentPane.add(btnTemperatura);
		
		
		setLocationRelativeTo(null);
	}

}
