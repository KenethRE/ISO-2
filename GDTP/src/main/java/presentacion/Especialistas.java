package presentacion;

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

public class Especialistas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Especialistas frame = new Especialistas();
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
	public Especialistas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos del curso");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(20, 22, 132, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 56, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 76, 219, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 107, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextArea txtrTecnologiaDeRedes = new JTextArea();
		txtrTecnologiaDeRedes.setText("Tecnologia de redes");
		txtrTecnologiaDeRedes.setBounds(20, 119, 219, 22);
		contentPane.add(txtrTecnologiaDeRedes);
		
		JLabel lblNewLabel_3 = new JLabel("ECTS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(20, 152, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextArea txtrCreditos = new JTextArea();
		txtrCreditos.setText("90 creditos");
		txtrCreditos.setBounds(20, 164, 219, 22);
		contentPane.add(txtrCreditos);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha inicio");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(20, 205, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextArea txtrCreditos_1 = new JTextArea();
		txtrCreditos_1.setText("07-09-2022");
		txtrCreditos_1.setBounds(20, 217, 219, 22);
		contentPane.add(txtrCreditos_1);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha fin");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(20, 250, 73, 14);
		contentPane.add(lblNewLabel_5);
		
		JTextArea txtrCreditos_2 = new JTextArea();
		txtrCreditos_2.setText("12-05-2023");
		txtrCreditos_2.setBounds(20, 264, 219, 22);
		contentPane.add(txtrCreditos_2);
		
		JLabel lblDatosDelCentro_1 = new JLabel("Datos del centro");
		lblDatosDelCentro_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDatosDelCentro_1.setBounds(20, 333, 155, 23);
		contentPane.add(lblDatosDelCentro_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Nombre");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(20, 357, 49, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JTextArea txtrFacultadDeCiencias_1 = new JTextArea();
		txtrFacultadDeCiencias_1.setText("Facultad de Ciencias y Tecnologicas");
		txtrFacultadDeCiencias_1.setBounds(20, 370, 284, 23);
		contentPane.add(txtrFacultadDeCiencias_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Localizacion");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(20, 404, 73, 14);
		contentPane.add(lblNewLabel_2_2_1);
		
		JTextArea txtrTalaveraDeLa = new JTextArea();
		txtrTalaveraDeLa.setText("Talavera de la Reina");
		txtrTalaveraDeLa.setBounds(20, 419, 284, 23);
		contentPane.add(txtrTalaveraDeLa);
		
		JLabel lblComisionAcademica = new JLabel("Comision academica");
		lblComisionAcademica.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblComisionAcademica.setBounds(495, 22, 211, 23);
		contentPane.add(lblComisionAcademica);
		
		JLabel lblNewLabel_2_3 = new JLabel("Nombre");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(495, 57, 49, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JTextArea txtrJoseAntonioBallesteros = new JTextArea();
		txtrJoseAntonioBallesteros.setText("Maria ");
		txtrJoseAntonioBallesteros.setBounds(495, 74, 211, 23);
		contentPane.add(txtrJoseAntonioBallesteros);
		
		JLabel lblNewLabel_2_4 = new JLabel("Apellidos");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(495, 108, 73, 14);
		contentPane.add(lblNewLabel_2_4);
		
		JTextArea txtrGutierrezDelPino = new JTextArea();
		txtrGutierrezDelPino.setText("Gutierrez del Pino");
		txtrGutierrezDelPino.setBounds(495, 130, 211, 23);
		contentPane.add(txtrGutierrezDelPino);
		
		JLabel lblNewLabel_2_5 = new JLabel("Doctor");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(495, 152, 49, 14);
		contentPane.add(lblNewLabel_2_5);
		
		JTextArea txtrCatedratico = new JTextArea();
		txtrCatedratico.setText("Catedratico");
		txtrCatedratico.setBounds(495, 164, 211, 23);
		contentPane.add(txtrCatedratico);
		
		JLabel lblOrganizaciionDocente = new JLabel("Organizacion docente");
		lblOrganizaciionDocente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblOrganizaciionDocente.setBounds(497, 214, 230, 23);
		contentPane.add(lblOrganizaciionDocente);
		
		JLabel lblNewLabel_2_6 = new JLabel("Nombre materia");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_6.setBounds(498, 245, 108, 14);
		contentPane.add(lblNewLabel_2_6);
		
		JTextArea txtrRedes = new JTextArea();
		txtrRedes.setText("Redes");
		txtrRedes.setBounds(498, 258, 284, 23);
		contentPane.add(txtrRedes);
		
		JLabel lblNewLabel_2_7 = new JLabel("Numero de horas");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_7.setBounds(498, 292, 108, 14);
		contentPane.add(lblNewLabel_2_7);
		
		JTextArea txtrHoras = new JTextArea();
		txtrHoras.setText("192 horas");
		txtrHoras.setBounds(498, 306, 284, 23);
		contentPane.add(txtrHoras);
		
		JLabel lblNewLabel_4_1 = new JLabel("Fecha inicio");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(498, 340, 73, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JTextArea txtrFacultadDeCiencias_3 = new JTextArea();
		txtrFacultadDeCiencias_3.setText("08-09-2022");
		txtrFacultadDeCiencias_3.setBounds(498, 353, 284, 23);
		contentPane.add(txtrFacultadDeCiencias_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("Fecha fin");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(498, 387, 73, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JTextArea txtrFacultadDeCiencias_4 = new JTextArea();
		txtrFacultadDeCiencias_4.setText("30-01-2023");
		txtrFacultadDeCiencias_4.setBounds(498, 400, 284, 23);
		contentPane.add(txtrFacultadDeCiencias_4);
		
		JLabel lblNewLabel_6 = new JLabel("Tasa");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(20, 292, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		JTextArea txtrCreditos_1_1 = new JTextArea();
		txtrCreditos_1_1.setText("3.550");
		txtrCreditos_1_1.setBounds(20, 313, 180, 22);
		contentPane.add(txtrCreditos_1_1);
		
		JButton btnNewButton = new JButton("Realizar matricula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matricula matricula = new Matricula();
				matricula.setVisible(true);
			}
		});
		btnNewButton.setBounds(320, 460, 155, 39);
		contentPane.add(btnNewButton);
	}
}
