package presentacion.LoginPrueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.curso_matricula.VistaPrevia_RealizarPropuestaCursos;
import presentacion.curso_matricula.RealizarPropuestaCursos;
import presentacion.curso_matricula.VerPropuestaCursos;
import presentacion.curso_matricula.gestionarIngresos;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServiciosAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiciosAdmin frame = new ServiciosAdmin();
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
	public ServiciosAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(76, 76, 76));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(62, 50, 787, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Servicios");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Rockwell Condensed", Font.BOLD, 26));
		lblNewLabel_2.setBounds(209, 11, 366, 65);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrevia_RealizarPropuestaCursos ver = new VistaPrevia_RealizarPropuestaCursos();
				ver.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(537, 123, 67, 14);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gestionar Ingresos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionarIngresos gestionar = new gestionarIngresos();
				gestionar.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(276, 123, 230, 87);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Realizar propuesta cursos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarPropuestaCursos realizar = new RealizarPropuestaCursos();
				realizar.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(537, 123, 224, 87);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Ver propuesta cursos");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerPropuestaCursos ver = new VerPropuestaCursos();
				ver.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(10, 123, 230, 87);
		panel.add(btnNewButton_1_1);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ServiciosAdmin.class.getResource("/presentacion/LoginPrueba/Unio2.png")));
		lblNewLabel.setBounds(-10, 0, 940, 520);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ServiciosAdmin.class.getResource("/presentacion/LoginPrueba/Ellipse 209.png")));
		lblNewLabel_1.setBounds(670, 220, 260, 300);
		contentPane.add(lblNewLabel_1);
		

	}
}
