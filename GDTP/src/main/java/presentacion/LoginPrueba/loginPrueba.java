package presentacion.LoginPrueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginPrueba extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPrueba frame = new loginPrueba();
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
	public loginPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(230, 40, 450, 467);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon(loginPrueba.class.getResource("/presentacion/LoginPrueba/Card_Header.png")));
		lblNewLabel_2.setBounds(0, 0, 451, 112);
		panel.add(lblNewLabel_2);
		

		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(loginPrueba.class.getResource("/presentacion/LoginPrueba/Avatar_Container.png")));
		lblNewLabel_4.setBounds(-11, 84, 451, 103);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 186, 94, 28);
		panel.add(lblNewLabel_5);
		
		textUsuario = new JTextField();
		textUsuario.setBackground(new Color(77, 77, 77));
		textUsuario.setForeground(new Color(255, 255, 255));
		textUsuario.setBounds(20, 211, 380, 33);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contrasena");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(0, 256, 124, 33);
		panel.add(lblNewLabel_3);
		
		textContrasena = new JPasswordField();
		textContrasena.setForeground(new Color(255, 255, 255));
		textContrasena.setBackground(new Color(77, 77, 77));
		textContrasena.setBounds(20, 285, 380, 33);
		panel.add(textContrasena);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recuerdame");
		chckbxNewCheckBox.setBounds(18, 320, 106, 23);
		panel.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char[] clave = textContrasena.getPassword();
				String claveFinal = new String(clave);
				//COMPROBAR EN LA BBDD EN VEZ DE HARDCODEADO
				if(textUsuario.getText().equals("administrador") && claveFinal.equals("administrador")) {
					dispose();
					JOptionPane.showMessageDialog(null, "Inicio de sesión correcto", "INGRESO CORRECTO", 
							JOptionPane.INFORMATION_MESSAGE);
					
					ServiciosAdmin bienvenida = new ServiciosAdmin();
					bienvenida.setVisible(true);
				
					
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o Contrasena incorrectos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textUsuario.setText("");
					textContrasena.setText("");
					textUsuario.requestFocus();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(100, 177, 255));
		btnNewButton.setBounds(20, 351, 380, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(loginPrueba.class.getResource("/presentacion/LoginPrueba/Lock.png")));
		lblNewLabel_6.setBounds(101, 395, 27, 30);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("¿Has olvidado la contrasena?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecuperarContrasena recuperar = new RecuperarContrasena();
				recuperar.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(126, 402, 215, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registrarse");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuario registrar = new RegistrarUsuario();
				registrar.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(162, 433, 137, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(loginPrueba.class.getResource("/presentacion/LoginPrueba/Union.png")));
		lblNewLabel.setBounds(0, 0, 929, 573);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(loginPrueba.class.getResource("/presentacion/LoginPrueba/Ellipse 209.png")));
		lblNewLabel_1.setBounds(705, 316, 224, 257);
		contentPane.add(lblNewLabel_1);

	}
}
