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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecuperarContrasena extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3638398564729238573L;
	private JPanel contentPane;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperarContrasena frame = new RecuperarContrasena();
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
	public RecuperarContrasena() {
		
	
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 934, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(217, 109, 537, 335);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("  Para recuperar su contrasena es necesario que introduzca su email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 72, 517, 54);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(25, 127, 49, 14);
		panel.add(lblNewLabel_2);
		
		textEmail = new JTextField();
		textEmail.setBounds(25, 152, 482, 31);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textEmail.getText().length() != 0) {
					dispose();
					JOptionPane.showMessageDialog(null, "Verifique su correo electronico", "INGRESO CORRECTO", 
							JOptionPane.INFORMATION_MESSAGE);
				
				}
				
				if(textEmail.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Email incorrecto", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textEmail.setText("");
				
				}
			}
		});
		btnEnviar.setForeground(new Color(0, 0, 0));
		btnEnviar.setBackground(new Color(192, 192, 192));
		btnEnviar.setBounds(25, 246, 482, 45);
		panel.add(btnEnviar);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(RecuperarContrasena.class.getResource("/presentacion/LoginPrueba/Avatar_Container.png")));
		lblNewLabel_3.setBounds(191, 11, 152, 72);
		panel.add(lblNewLabel_3);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RecuperarContrasena.class.getResource("/presentacion/LoginPrueba/cont.png")));
		lblNewLabel.setBounds(0, 0, 920, 529);
		contentPane.add(lblNewLabel);
		

	}
}
