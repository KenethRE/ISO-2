package presentacion.LoginPrueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Bienvenida extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
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
	public Bienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(76, 76, 76));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(257, 113, 443, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("¡ Bienvenido al sistema !");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Rockwell Condensed", Font.BOLD, 26));
		lblNewLabel_2.setBounds(36, 127, 366, 65);
		panel.add(lblNewLabel_2);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Bienvenida.class.getResource("/presentacion/LoginPrueba/Unio2.png")));
		lblNewLabel.setBounds(-10, 0, 940, 520);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Bienvenida.class.getResource("/presentacion/LoginPrueba/Ellipse 209.png")));
		lblNewLabel_1.setBounds(670, 220, 260, 300);
		contentPane.add(lblNewLabel_1);
		

	}
}
