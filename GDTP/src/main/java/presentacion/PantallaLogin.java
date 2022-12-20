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
	
	private static final long serialVersionUID = -6615512957360058706L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textContrasena;

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
		
		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 186, 94, 28);
		panel.add(lblNewLabel_5);
		
		textUsuario = new JTextField();
		textUsuario.setBackground(new Color(77, 77, 77));
		textUsuario.setForeground(new Color(255, 255, 255));
		textUsuario.setBounds(30, 212, 380, 33);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JComboBox<String> loginSwitch = new JComboBox<String>();
		loginSwitch.setModel(new DefaultComboBoxModel<String>(new String[] {"Empleado", "Jefe Gabinete", "Director", "Estudiante"}));
		loginSwitch.setToolTipText("");
		loginSwitch.setBounds(209, 66, 94, 22);
		panel.add(loginSwitch);
		
		JLabel lblNewLabel_3 = new JLabel("Contrasena");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 256, 124, 33);
		panel.add(lblNewLabel_3);
		
		textContrasena = new JPasswordField();
		textContrasena.setForeground(new Color(255, 255, 255));
		textContrasena.setBackground(new Color(77, 77, 77));
		textContrasena.setBounds(30, 285, 380, 33);
		panel.add(textContrasena);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char[] clave = textContrasena.getPassword();
				String claveFinal = new String(clave);
				
				if(textUsuario.getText().equals("admin") && claveFinal.equals("1234")) {
					JOptionPane.showMessageDialog(null, "Inicio de sesión correcto", "Ingreso correcto", 
							JOptionPane.INFORMATION_MESSAGE);
					
					switch(loginSwitch.getSelectedItem().toString()) {
						case "Empleado":
							dispose();
							PantallaEmpleadosVicerrectorado screen1 = new PantallaEmpleadosVicerrectorado(PantallaLogin.this);
							screen1.setVisible(true);
						break;
						case "Jefe Gabinete":
							dispose();
							PantallaJefeGabineteVicerrectorado screen2 = new PantallaJefeGabineteVicerrectorado (PantallaLogin.this);
							screen2.setVisible(true);
							
						break;
						case "Director":
							dispose();
							PantallaDireccionCursos screen3 = new PantallaDireccionCursos (PantallaLogin.this);
							screen3.setVisible(true);
						
						break;
						case "Estudiante":
							dispose();
							Matriculacion matricula = new Matriculacion(PantallaLogin.this);
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
		btnNewButton.setBounds(30, 351, 380, 40);
		panel.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Iniciar como:");
		lblNewLabel_7.setBounds(115, 70, 77, 14);
		panel.add(lblNewLabel_7);

	}
	
}
