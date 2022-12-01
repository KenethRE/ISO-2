package presentacion.curso_matricula;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.LoginPrueba.ServiciosAdmin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealizarPropuestaCursos extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombreC;
	private JTextField txtECTS;
	private JTextField txtFechaIC;
	private JTextField txtFechaFC;
	private JTextField txtTasa;
	private JTextField txtEdicion;
	private JTextField txtNombreM;
	private JTextField txtHoras;
	private JTextField txtFechaIM;
	private JTextField txtFechaFM;
	private JTextField txtProfesorResponsable;
	private JTextField txtNombreCentro;
	private JTextField txtLocalizacion;
	private JTextField txtID2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarPropuestaCursos frame = new RealizarPropuestaCursos();
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
	public RealizarPropuestaCursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(56, 93, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Realizar propuesta cursos");
		lblNewLabel.setBounds(403, 11, 217, 24);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(56, 142, 49, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ECTS");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(56, 190, 49, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha Inicio");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(56, 244, 80, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Fecha fin");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(56, 299, 80, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Tasa");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4_1.setBounds(56, 351, 49, 14);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Edicion");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4_1_1.setBounds(56, 405, 49, 14);
		contentPane.add(lblNewLabel_1_4_1_1);
		
		txtID = new JTextField();
		txtID.setBounds(115, 92, 96, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNombreC = new JTextField();
		txtNombreC.setColumns(10);
		txtNombreC.setBounds(115, 141, 192, 20);
		contentPane.add(txtNombreC);
		
		txtECTS = new JTextField();
		txtECTS.setColumns(10);
		txtECTS.setBounds(115, 189, 192, 20);
		contentPane.add(txtECTS);
		
		txtFechaIC = new JTextField();
		txtFechaIC.setColumns(10);
		txtFechaIC.setBounds(144, 243, 163, 20);
		contentPane.add(txtFechaIC);
		
		txtFechaFC = new JTextField();
		txtFechaFC.setColumns(10);
		txtFechaFC.setBounds(126, 298, 181, 20);
		contentPane.add(txtFechaFC);
		
		txtTasa = new JTextField();
		txtTasa.setColumns(10);
		txtTasa.setBounds(126, 350, 181, 20);
		contentPane.add(txtTasa);
		
		txtEdicion = new JTextField();
		txtEdicion.setColumns(10);
		txtEdicion.setBounds(126, 404, 181, 20);
		contentPane.add(txtEdicion);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if((txtID.getText().length() != 0) && (txtNombreC.getText().length() != 0) && (txtHoras.getText().length() != 0)&& (txtECTS.getText().length() != 0)
						&& (txtFechaIC.getText().length() != 0)&& (txtFechaFC.getText().length() != 0)&& (txtTasa.getText().length() != 0)
						&& (txtEdicion.getText().length() != 0)&& (txtNombreM.getText().length() != 0)&& (txtFechaIM.getText().length() != 0)
						&& (txtFechaFM.getText().length() != 0)&& (txtProfesorResponsable.getText().length() != 0)&& (txtNombreCentro.getText().length() != 0)
						&& (txtLocalizacion.getText().length() != 0)&& (txtID2.getText().length() != 0)) {
					dispose();
					JOptionPane.showMessageDialog(null, "Propuesta realizada", "CURSO EN ESPERA DE APROBACION", 
							JOptionPane.INFORMATION_MESSAGE);
				
				}
				
				if((txtID.getText().length() == 0)&& (txtHoras.getText().length() != 0)&& (txtNombreC.getText().length() == 0)&& (txtECTS.getText().length() == 0)
						&& (txtFechaIC.getText().length() == 0)&& (txtFechaFC.getText().length() == 0)&& (txtTasa.getText().length() == 0)
						&& (txtEdicion.getText().length() == 0)&& (txtNombreM.getText().length() == 0)&& (txtFechaIM.getText().length() == 0)
						&& (txtFechaFM.getText().length() == 0)&& (txtProfesorResponsable.getText().length() == 0)&& (txtNombreCentro.getText().length() == 0)
						&& (txtLocalizacion.getText().length() == 0)&& (txtID2.getText().length() == 0)) {
					
					JOptionPane.showMessageDialog(null, "Verifique nuevamente que los datos introducidos sean correctos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					txtID.setText("");
					txtNombreC.setText("");
					txtECTS.setText("");
					txtFechaIC.setText("");
					txtFechaFC.setText("");
					txtTasa.setText("");
					txtEdicion.setText("");
					txtNombreM.setText("");
					txtHoras.setText("");
					txtFechaIM.setText("");
					txtFechaFM.setText("");
					txtProfesorResponsable.setText("");
					txtNombreCentro.setText("");
					txtLocalizacion.setText("");
					txtID2.setText("");
				
				}
				
				
				
				VistaPrevia_RealizarPropuestaCursos ventana = new VistaPrevia_RealizarPropuestaCursos();
				ventana.setVisible(true);

				ventana.ID=txtID.getText();
				ventana.nombreCurso=txtNombreC.getText();
				ventana.ECTS=txtECTS.getText();
				ventana.FechaInicio=txtFechaIC.getText();
				ventana.FechaFin=txtFechaFC.getText();
				ventana.Tasa=txtTasa.getText();
				ventana.Edicion=txtEdicion.getText();
				ventana.nombreMateria=txtNombreM.getText();
				ventana.Horas=txtHoras.getText();
				ventana.FechaInicioMateria=txtFechaIM.getText();
				ventana.FechaFinMateria=txtFechaFM.getText();
				ventana.profesorResponsable=txtProfesorResponsable.getText();
				ventana.nombreCentro=txtNombreCentro.getText();
				ventana.localizacion=txtLocalizacion.getText();
				ventana.ID2=txtID2.getText();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(428, 427, 134, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Datos Curso");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(41, 51, 126, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Datos Materia");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(371, 53, 126, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Nombre");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(371, 93, 49, 14);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Horas");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(371, 142, 49, 14);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Fecha Inicio");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7.setBounds(371, 190, 80, 14);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Fecha fin");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_8.setBounds(371, 246, 80, 14);
		contentPane.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("Profesor responsable");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_9.setBounds(371, 301, 139, 14);
		contentPane.add(lblNewLabel_1_9);
		
		txtNombreM = new JTextField();
		txtNombreM.setColumns(10);
		txtNombreM.setBounds(428, 92, 192, 20);
		contentPane.add(txtNombreM);
		
		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(430, 141, 192, 20);
		contentPane.add(txtHoras);
		
		txtFechaIM = new JTextField();
		txtFechaIM.setColumns(10);
		txtFechaIM.setBounds(453, 189, 192, 20);
		contentPane.add(txtFechaIM);
		
		txtFechaFM = new JTextField();
		txtFechaFM.setColumns(10);
		txtFechaFM.setBounds(453, 243, 192, 20);
		contentPane.add(txtFechaFM);
		
		txtProfesorResponsable = new JTextField();
		txtProfesorResponsable.setColumns(10);
		txtProfesorResponsable.setBounds(505, 298, 192, 20);
		contentPane.add(txtProfesorResponsable);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Datos Centro");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(707, 53, 126, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Nombre");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5_1.setBounds(707, 95, 49, 14);
		contentPane.add(lblNewLabel_1_5_1);
		
		txtNombreCentro = new JTextField();
		txtNombreCentro.setColumns(10);
		txtNombreCentro.setBounds(766, 92, 192, 20);
		contentPane.add(txtNombreCentro);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("Localizacion");
		lblNewLabel_1_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5_1_1.setBounds(707, 142, 80, 14);
		contentPane.add(lblNewLabel_1_5_1_1);
		
		txtLocalizacion = new JTextField();
		txtLocalizacion.setColumns(10);
		txtLocalizacion.setBounds(785, 141, 192, 20);
		contentPane.add(txtLocalizacion);
		
		JLabel lblNewLabel_1_10 = new JLabel("ID");
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_10.setBounds(707, 185, 49, 14);
		contentPane.add(lblNewLabel_1_10);
		
		txtID2 = new JTextField();
		txtID2.setColumns(10);
		txtID2.setBounds(766, 184, 96, 20);
		contentPane.add(txtID2);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiciosAdmin servicios = new ServiciosAdmin();
				servicios.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(930, 0, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
