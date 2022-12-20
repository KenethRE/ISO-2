package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaPrevia_RealizarPropuestaCursos extends JFrame {

	private JPanel contentPane;
	protected String ID;
	protected String nombreCurso;
	protected String ECTS;
	protected String FechaInicio;
	protected String FechaFin;
	protected String Tasa;
	protected String Edicion;
	protected String nombreMateria;
	protected String Horas;
	protected String FechaInicioMateria;
	protected String FechaFinMateria;
	protected String profesorResponsable;
	protected String nombreCentro;
	protected String localizacion;
	protected String ID2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrevia_RealizarPropuestaCursos frame = new VistaPrevia_RealizarPropuestaCursos();
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
	public VistaPrevia_RealizarPropuestaCursos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(42, 69, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(42, 94, 71, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEcts = new JLabel("ECTS:");
		lblEcts.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEcts.setBounds(42, 119, 49, 14);
		contentPane.add(lblEcts);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaInicio.setBounds(42, 144, 99, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha fin:");
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaFin.setBounds(42, 169, 71, 14);
		contentPane.add(lblFechaFin);
		
		JLabel lblTasa = new JLabel("Tasa:");
		lblTasa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTasa.setBounds(42, 194, 49, 14);
		contentPane.add(lblTasa);
		
		JLabel lblEdicion = new JLabel("Edicion:");
		lblEdicion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdicion.setBounds(42, 219, 60, 14);
		contentPane.add(lblEdicion);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre_1.setBounds(330, 69, 76, 14);
		contentPane.add(lblNombre_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Horas:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(330, 94, 49, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fecha inicio:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(330, 119, 90, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Fecha fin:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(330, 144, 90, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Profesor responsable:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(330, 169, 178, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Nombre:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(607, 69, 90, 14);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Localizacion:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(607, 94, 114, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblID2 = new JLabel("ID:");
		lblID2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID2.setBounds(607, 119, 49, 14);
		contentPane.add(lblID2);
		
		JLabel lblDatosCurso = new JLabel("Datos Curso");
		lblDatosCurso.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDatosCurso.setBounds(42, 37, 120, 14);
		contentPane.add(lblDatosCurso);
		
		JLabel lblDatosMateria = new JLabel("Datos Materia");
		lblDatosMateria.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDatosMateria.setBounds(303, 40, 144, 14);
		contentPane.add(lblDatosMateria);
		
		JLabel lblDatosCentro = new JLabel("Datos Centro");
		lblDatosCentro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDatosCentro.setBounds(601, 40, 120, 14);
		contentPane.add(lblDatosCentro);
		
		JLabel lblid = new JLabel("New label");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblid.setBounds(101, 71, 49, 14);
		contentPane.add(lblid);
		
		JLabel lblNom = new JLabel("New label");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNom.setBounds(113, 96, 189, 14);
		contentPane.add(lblNom);
		
		JLabel lblECTS = new JLabel("New label");
		lblECTS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblECTS.setBounds(113, 119, 114, 14);
		contentPane.add(lblECTS);
		
		JLabel lblFechaI = new JLabel("New label");
		lblFechaI.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaI.setBounds(136, 144, 114, 14);
		contentPane.add(lblFechaI);
		
		JLabel lblFechaF = new JLabel("New label");
		lblFechaF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaF.setBounds(123, 169, 104, 14);
		contentPane.add(lblFechaF);
		
		JLabel lblT = new JLabel("New label");
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblT.setBounds(101, 194, 104, 14);
		contentPane.add(lblT);
		
		JLabel lblE = new JLabel("New label");
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblE.setBounds(112, 221, 49, 14);
		contentPane.add(lblE);
		
		JLabel lblNomM = new JLabel("New label");
		lblNomM.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomM.setBounds(403, 69, 194, 14);
		contentPane.add(lblNomM);
		
		JLabel lblH = new JLabel("New label");
		lblH.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblH.setBounds(389, 94, 90, 14);
		contentPane.add(lblH);
		
		JLabel lblFechaIM = new JLabel("New label");
		lblFechaIM.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaIM.setBounds(430, 121, 137, 14);
		contentPane.add(lblFechaIM);
		
		JLabel lblFechaFM = new JLabel("New label");
		lblFechaFM.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaFM.setBounds(403, 146, 164, 14);
		contentPane.add(lblFechaFM);
		
		JLabel lblResponsable = new JLabel("New label");
		lblResponsable.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblResponsable.setBounds(488, 171, 197, 14);
		contentPane.add(lblResponsable);
		
		JLabel lblNomC = new JLabel("New label");
		lblNomC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomC.setBounds(679, 71, 156, 14);
		contentPane.add(lblNomC);
		
		JLabel lblLocal = new JLabel("New label");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocal.setBounds(704, 96, 178, 14);
		contentPane.add(lblLocal);
		
		JLabel lblid22 = new JLabel("New label");
		lblid22.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblid22.setBounds(636, 121, 49, 14);
		contentPane.add(lblid22);
		
		addWindowListener(new WindowAdapter() {
			
			/*
			String ID, nombreCurso, ECTS, FechaInicio, FechaFin, Tasa, Edicion,
			nombreMateria, Horas, FechaInicioMateria, FechaFinMateria, profesorResponsable, 
			nombreCentro, localizacion, ID2;
			*/
			public void windowActivated(WindowEvent e) {
				lblid.setText(ID);
				lblNom.setText(nombreCurso);
				lblECTS.setText(ECTS);
				lblFechaI.setText(FechaInicio);
				lblFechaF.setText(FechaFin);
				lblT.setText(Tasa);
				lblE.setText(Edicion);
				
				lblNomM.setText(nombreMateria);
				lblH.setText(Horas);
				lblFechaIM.setText(FechaInicioMateria);
				lblFechaFM.setText(FechaFinMateria);
				lblResponsable.setText(profesorResponsable);
				
				lblNomC.setText(nombreCentro);
				lblLocal.setText(localizacion);
				lblid22.setText(ID2);
				
				
			}
		});
	}

}
