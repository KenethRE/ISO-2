package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PantallaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6615512957360058706L;
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
					PantallaLogin frame = new PantallaLogin();
					frame.setResizable(false);
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
	public PantallaLogin() {
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
		lblNewLabel_2.setIcon(new ImageIcon(PantallaLogin.class.getResource("/presentacion/Card_Header.png")));
		lblNewLabel_2.setBounds(0, 0, 451, 103);
		panel.add(lblNewLabel_2);
		

		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(PantallaLogin.class.getResource("/presentacion/Avatar_Container.png")));
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
		
		JComboBox<String> loginSwitch = new JComboBox<String>();
		loginSwitch.setModel(new DefaultComboBoxModel<String>(new String[] {"Vicerrector", "Gabinete", "Director", "Estudiante"}));
		loginSwitch.setToolTipText("");
		loginSwitch.setBounds(306, 152, 94, 22);
		panel.add(loginSwitch);
		
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
				
				
				if(textUsuario.getText().equals("admin") && claveFinal.equals("1234")) {
					JOptionPane.showMessageDialog(null, "Inicio de sesión correcto", "INGRESO CORRECTO", 
							JOptionPane.INFORMATION_MESSAGE);
					
					switch(loginSwitch.getSelectedItem().toString()) {
						case "Vicerrector":
						//llamar a la clase PantallaJefeGabineteVicerrectorado //TODO
							PantallaJefeGabineteVicerrectorado screen1 = new PantallaJefeGabineteVicerrectorado(PantallaLogin.this);
							PantallaLogin.this.setVisible(false);
							screen1.setVisible(true);
						break;
						case "Gabinete":
						//llamar a la clase PantallaEmpleadosVicerrectorado //TODO
							
						break;
						case "Director":
						//llamar a la clase PantallaDireccionCursos //TODO
							PantallaDireccionCursos screen2 = new PantallaDireccionCursos (PantallaLogin.this);
							PantallaLogin.this.setVisible(false);
							screen2.setVisible(true);
						
						break;
						case "Estudiante":
							Matricula matricula = new Matricula(PantallaLogin.this);
							matricula.setVisible(true);
							
						break;
					}
				
					
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
		lblNewLabel_6.setIcon(new ImageIcon(PantallaLogin.class.getResource("/presentacion/Lock.png")));
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
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Iniciar como:");
		lblNewLabel_7.setBounds(323, 128, 77, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaLogin.class.getResource("/presentacion/Union.png")));
		lblNewLabel.setBounds(0, 0, 929, 573);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(PantallaLogin.class.getResource("/presentacion/Ellipse 209.png")));
		lblNewLabel_1.setBounds(705, 316, 224, 257);
		contentPane.add(lblNewLabel_1);

	}
	
}
