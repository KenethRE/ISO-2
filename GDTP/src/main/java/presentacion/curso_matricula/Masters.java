package presentacion.curso_matricula;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Masters extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Masters frame = new Masters();
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
	public Masters() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos del curso");
		lblNewLabel.setBounds(20, 68, 132, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 102, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 122, 219, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 153, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextArea txtrMasterDeProgramacion = new JTextArea();
		txtrMasterDeProgramacion.setText("Master de programacion web");
		txtrMasterDeProgramacion.setBounds(20, 165, 219, 22);
		contentPane.add(txtrMasterDeProgramacion);
		
		JLabel lblNewLabel_3 = new JLabel("ECTS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(20, 198, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextArea txtrCreditos = new JTextArea();
		txtrCreditos.setText("60 creditos");
		txtrCreditos.setBounds(20, 210, 219, 22);
		contentPane.add(txtrCreditos);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha inicio");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(20, 251, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextArea txtrCreditos_1 = new JTextArea();
		txtrCreditos_1.setText("07-09-2022");
		txtrCreditos_1.setBounds(20, 263, 219, 22);
		contentPane.add(txtrCreditos_1);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha fin");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(20, 296, 73, 14);
		contentPane.add(lblNewLabel_5);
		
		JTextArea txtrCreditos_2 = new JTextArea();
		txtrCreditos_2.setText("12-05-2023");
		txtrCreditos_2.setBounds(20, 310, 219, 22);
		contentPane.add(txtrCreditos_2);
		
		JLabel lblDatosDelCentro_1 = new JLabel("Datos del centro");
		lblDatosDelCentro_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDatosDelCentro_1.setBounds(20, 387, 155, 23);
		contentPane.add(lblDatosDelCentro_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Nombre");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(20, 421, 49, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JTextArea txtrFacultadDeCiencias = new JTextArea();
		txtrFacultadDeCiencias.setText("Facultad de Ciencias y TecnologÃ­as");
		txtrFacultadDeCiencias.setBounds(20, 433, 284, 23);
		contentPane.add(txtrFacultadDeCiencias);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Localizacion");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(20, 467, 73, 14);
		contentPane.add(lblNewLabel_2_2_1);
		
		JTextArea txtrTalaveraDeLa = new JTextArea();
		txtrTalaveraDeLa.setText("Talavera de la Reina");
		txtrTalaveraDeLa.setBounds(20, 478, 284, 23);
		contentPane.add(txtrTalaveraDeLa);
		
		JButton btnNewButton = new JButton("Realizar matricula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matricula matricula = new Matricula();
				matricula.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(290, 533, 211, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblComisionAcademica = new JLabel("Comision academica");
		lblComisionAcademica.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblComisionAcademica.setBounds(495, 68, 211, 23);
		contentPane.add(lblComisionAcademica);
		
		JLabel lblNewLabel_2_3 = new JLabel("Nombre");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(495, 103, 49, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JTextArea txtrJosAntonioBallesteros = new JTextArea();
		txtrJosAntonioBallesteros.setText("JosÃ© Antonio Ballesteros ");
		txtrJosAntonioBallesteros.setBounds(495, 120, 211, 23);
		contentPane.add(txtrJosAntonioBallesteros);
		
		JLabel lblNewLabel_2_4 = new JLabel("Apellidos");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(495, 154, 73, 14);
		contentPane.add(lblNewLabel_2_4);
		
		JTextArea txtrBallesterosGarrido = new JTextArea();
		txtrBallesterosGarrido.setText("Ballesteros Garrido");
		txtrBallesterosGarrido.setBounds(495, 176, 211, 23);
		contentPane.add(txtrBallesterosGarrido);
		
		JLabel lblNewLabel_2_5 = new JLabel("Doctor");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(495, 198, 49, 14);
		contentPane.add(lblNewLabel_2_5);
		
		JTextArea txtrCatedratico = new JTextArea();
		txtrCatedratico.setText("Catedratico");
		txtrCatedratico.setBounds(495, 210, 211, 23);
		contentPane.add(txtrCatedratico);
		
		JLabel lblOrganizaciionDocente = new JLabel("Organizacion docente");
		lblOrganizaciionDocente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblOrganizaciionDocente.setBounds(497, 260, 230, 23);
		contentPane.add(lblOrganizaciionDocente);
		
		JLabel lblNewLabel_2_6 = new JLabel("Nombre materia");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_6.setBounds(498, 291, 108, 14);
		contentPane.add(lblNewLabel_2_6);
		
		JTextArea txtrDesarrolloWeb = new JTextArea();
		txtrDesarrolloWeb.setText("Desarrollo web");
		txtrDesarrolloWeb.setBounds(498, 304, 284, 23);
		contentPane.add(txtrDesarrolloWeb);
		
		JLabel lblNewLabel_2_7 = new JLabel("Numero de horas");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_7.setBounds(498, 338, 108, 14);
		contentPane.add(lblNewLabel_2_7);
		
		JTextArea txtrHoras = new JTextArea();
		txtrHoras.setText("192 horas");
		txtrHoras.setBounds(498, 352, 284, 23);
		contentPane.add(txtrHoras);
		
		JLabel lblNewLabel_4_1 = new JLabel("Fecha inicio");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(498, 386, 73, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JTextArea txtrFacultadDeCiencias_3 = new JTextArea();
		txtrFacultadDeCiencias_3.setText("09-09-2022");
		txtrFacultadDeCiencias_3.setBounds(498, 399, 284, 23);
		contentPane.add(txtrFacultadDeCiencias_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("Fecha fin");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(498, 433, 73, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JTextArea txtrFacultadDeCiencias_4 = new JTextArea();
		txtrFacultadDeCiencias_4.setText("30-01-2023");
		txtrFacultadDeCiencias_4.setBounds(498, 446, 284, 23);
		contentPane.add(txtrFacultadDeCiencias_4);
		
		JLabel lblNewLabel_6 = new JLabel("Tasa");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(20, 343, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		JTextArea txtrCreditos_1_1 = new JTextArea();
		txtrCreditos_1_1.setText("2.800");
		txtrCreditos_1_1.setBounds(20, 364, 180, 22);
		contentPane.add(txtrCreditos_1_1);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
			}
		});
		btnNewButton_1.setBounds(781, 0, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}