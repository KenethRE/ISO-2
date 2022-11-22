package presentacion.LoginPrueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JTextField textContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarUsuario frame = new RegistrarUsuario();
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
	public RegistrarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 592);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 189, 189));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 189, 189));
		panel.setBounds(212, 62, 452, 465);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(111, 20, 103, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(RegistrarUsuario.class.getResource("/presentacion/LoginPrueba/Avatar_Container.png")));
		lblNewLabel_2.setBounds(0, 11, 130, 72);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(30, 94, 77, 23);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Apellidos");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(30, 159, 77, 23);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Email");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(30, 220, 77, 23);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Teléfono");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(30, 281, 77, 23);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Contrasena");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(30, 346, 109, 23);
		panel.add(lblNewLabel_3_4);
		
		textNombre = new JTextField();
		textNombre.setBounds(30, 117, 336, 31);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(30, 182, 336, 31);
		panel.add(textApellidos);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(30, 243, 336, 31);
		panel.add(textEmail);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(30, 304, 336, 31);
		panel.add(textTelefono);
		
		textContrasena = new JTextField();
		textContrasena.setColumns(10);
		textContrasena.setBounds(30, 369, 336, 31);
		panel.add(textContrasena);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textNombre.getText().length() != 0) && (textApellidos.getText().length() != 0) && (textEmail.getText().length() != 0)
						&& (textContrasena.getText().length() != 0) && (textTelefono.getText().length() != 0)) {
					dispose();
					JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "INGRESO CORRECTO", 
							JOptionPane.INFORMATION_MESSAGE);
					//AÑADIR USUARIO A LA BBDD
					
				}else {
					JOptionPane.showMessageDialog(null, "Usuario no registrado, datos incorrectos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textNombre.setText("");
					textContrasena.setText("");
					textEmail.setText("");
					textApellidos.setText("");
					textTelefono.setText("");
					textNombre.requestFocus();
				}
			}
		});
		btnGuardar.setBounds(156, 420, 140, 34);
		panel.add(btnGuardar);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setBackground(new Color(255, 128, 128));
		lblNewLabel.setIcon(new ImageIcon(RegistrarUsuario.class.getResource("/presentacion/LoginPrueba/cont.png")));
		lblNewLabel.setBounds(0, 0, 915, 555);
		contentPane.add(lblNewLabel);
		
		
	}

}
