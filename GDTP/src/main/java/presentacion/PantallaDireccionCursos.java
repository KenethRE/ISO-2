package presentacion;

import java.awt.event.ActionEvent;
import persistencia.*;
import org.apache.derby.iapi.sql.dictionary.TupleDescriptor;
import org.apache.derby.impl.store.access.sort.MergeScanRowSource;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Materia;
import negocio.entities.TipoCurso;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.swing.JLabel;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class PantallaDireccionCursos extends JFrame{
	JFrame previousWindow;
	Date fechaComienzo;
	Date fechaFin;
	int contador = 0;
	private DefaultListModel modelo;
	private JScrollPane scrollLista;
	
	public PantallaDireccionCursos(JFrame previousWindow) {
		this.previousWindow = previousWindow;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		if (previousWindow != null) {
			
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					previousWindow.setVisible(true);
				}
			});
		}
		setTitle("Pantalla Director Cursos");
		setBounds(100, 100, 610, 547);
		setResizable(false);
		getContentPane().setLayout(new CardLayout(0, 0));
		JTabbedPane pestañas=new JTabbedPane();
		getContentPane().add(pestañas, "name_000");
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(25, 320, 59, 14);
		Properties propiedadesfecha = new Properties();
		propiedadesfecha.put("text.today","Hoy");
		propiedadesfecha.put("text.month","Mes");
		propiedadesfecha.put("text.year","Año");
		
		
		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
			}
		});
		
	
		JDatePanelImpl panelfechainicio = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePanelImpl panelfechafin = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		pestañas.addTab("Alta Curso",panel1);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(31, 44, 49, 14);
		panel1.add(lblNewLabel);
		
		txtNombreCurso = new JTextField();
		txtNombreCurso.setBounds(85, 41, 382, 20);
		panel1.add(txtNombreCurso);
		txtNombreCurso.setColumns(10);
		JDatePickerImpl fechainicio = new JDatePickerImpl(panelfechainicio,new DateLabelFormatter());
		fechainicio.setBounds(21, 173, 134, 101);
		JDatePickerImpl fechafin = new JDatePickerImpl(panelfechafin,new DateLabelFormatter());
		fechafin.setBounds(232, 173, 134, 101);
		JPanel PanelFechaComienzo = new JPanel();
		PanelFechaComienzo.setBounds(10, 173, 212, 130);
		JPanel PanelFechaFin = new JPanel();
		PanelFechaFin.setBounds(255, 173, 212, 130);
		panel1.add(PanelFechaComienzo);
		panel1.add(PanelFechaFin);
		PanelFechaComienzo.add(fechainicio);
		PanelFechaFin.add(fechafin);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
		lblNewLabel_1.setBounds(10, 159, 93, 14);
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Fin");
		lblNewLabel_2.setBounds(255, 159, 49, 14);
		panel1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ECTS");
		lblNewLabel_3.setBounds(31, 76, 49, 14);
		panel1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tasa");
		lblNewLabel_4.setBounds(255, 76, 49, 14);
		panel1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Edicion");
		lblNewLabel_5.setBounds(31, 103, 49, 14);
		panel1.add(lblNewLabel_5);
		
		txtECTS = new JTextField();
		txtECTS.setBounds(85, 73, 49, 20);
		panel1.add(txtECTS);
		txtECTS.setColumns(10);
		
		txtTasaMatricula = new JTextField();
		txtTasaMatricula.setColumns(10);
		txtTasaMatricula.setBounds(346, 73, 121, 20);
		panel1.add(txtTasaMatricula);
		
		txtEdicion = new JTextField();
		txtEdicion.setColumns(10);
		txtEdicion.setBounds(85, 100, 49, 20);
		panel1.add(txtEdicion);
		scrollLista = new JScrollPane();
		scrollLista.setBounds(30, 348,174, 119);
		modelo=new DefaultListModel<>();
		panel1.add(scrollLista);
		
		
		
		JList <Materia> listamaterias = new JList();
		scrollLista.setViewportView(listamaterias);
		//listamaterias.setBounds(41, 348, 145, 119);
		listamaterias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listamaterias.setModel(modelo);
		
		JButton btnNewButton = new JButton("Añadir Materias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Materia> Materias = new ArrayList<Materia>();
				Materias=cargarMaterias();
				
				for(int i = 0;i<Materias.size();i++)
				{
					Materia materia1 = new Materia();
					materia1 = Materias.get(i);
					String nombremateria=materia1.get_nombre();
				    modelo.addElement(nombremateria);
				}
				
				
			}
		});
		btnNewButton.setBounds(181, 314, 111, 23);
		panel1.add(btnNewButton);
		
		JComboBox <TipoCurso> cbTipoCurso = new JComboBox<TipoCurso>();
		cbTipoCurso.setModel(new DefaultComboBoxModel<TipoCurso>(TipoCurso.values()));
		cbTipoCurso.setBounds(346, 99, 121, 22);
		panel1.add(cbTipoCurso);
		
		JButton btnNewButton_1 = new JButton("Guardar Curso");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDCurso = txtNombreCurso.getText().substring(0, 8) + contador++;
				
				fechaComienzo = new java.sql.Date(((java.util.Date) fechainicio.getModel().getValue()).getTime());
				fechaFin = new java.sql.Date(((java.util.Date) fechafin.getModel().getValue()).getTime());
				altaCurso(IDCurso, txtNombreCurso.getText(), Integer.valueOf(txtECTS.getText()), 
						fechaFin, fechaFin, Double.valueOf(txtTasaMatricula.getText()), Integer.valueOf(txtEdicion.getText()), (TipoCurso) cbTipoCurso.getSelectedItem());
				JOptionPane.showMessageDialog(null, "Se ha creado un curso con identificador: " + IDCurso, "EXITO",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(389, 382, 121, 23);
		panel1.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Tipo de Curso:");
		lblNewLabel_6.setBounds(255, 103, 80, 14);
		panel1.add(lblNewLabel_6);
		
		JList list_2 = new JList();
		list_2.setBounds(247, 348, 132, 119);
		panel1.add(list_2);
		JPanel panel = new JPanel();
		pestañas.addTab("Editar Curso", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre");
		lblNewLabel_8.setBounds(21, 44, 49, 14);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setVisible(false);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(75, 41, 185, 20);
		panel.add(textField_5);
		textField_5.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha Inicio");
		lblNewLabel_1_1.setBounds(30, 148, 93, 14);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setVisible(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fecha Fin");
		lblNewLabel_2_1.setBounds(231, 148, 49, 14);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setVisible(false);
		
		JLabel lblNewLabel_3_1 = new JLabel("ECTS");
		lblNewLabel_3_1.setBounds(21, 76, 34, 14);
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setVisible(false);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tasa");
		lblNewLabel_4_1.setBounds(161, 76, 34, 14);
		panel.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setVisible(false);
		
		JLabel lblNewLabel_5_1 = new JLabel("Edicion");
		lblNewLabel_5_1.setBounds(21, 103, 49, 14);
		panel.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setVisible(false);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(85, 72, 49, 20);
		panel.add(textField_6);
		textField_6.setVisible(false);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(211, 72, 49, 20);
		panel.add(textField_7);
		textField_7.setVisible(false);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(80, 100, 49, 20);
		panel.add(textField_8);
		textField_8.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("Añadir Materias");
		btnNewButton_2.setBounds(30, 314, 111, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
		JLabel lblNewLabel_6_1 = new JLabel("Id Curso");
		lblNewLabel_6_1.setBounds(21, 11, 49, 14);
		panel.add(lblNewLabel_6_1);
		
		JList list_1 = new JList();
		list_1.setBounds(178, 317, 188, 140);
		panel.add(list_1);
		list_1.setVisible(false);
		
		JButton btnNewButton_1_1 = new JButton("Guardar Curso");
		btnNewButton_1_1.setBounds(417, 382, 121, 23);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.setVisible(false);
		
		textField_9 = new JTextField();
		textField_9.setBounds(75, 10, 48, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Buscar curso");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_9.getText().isEmpty()) {
				
					
				}
				else {
					lblNewLabel_8.setVisible(true);
					textField_5.setVisible(true);
					lblNewLabel_1_1.setVisible(true);
					lblNewLabel_2_1	.setVisible(true);
					lblNewLabel_3_1.setVisible(true);
					lblNewLabel_4_1.setVisible(true);
					lblNewLabel_5_1.setVisible(true);
					textField_6.setVisible(true);
					textField_7.setVisible(true);
					textField_8.setVisible(true);
					btnNewButton_2.setVisible(true);
					list_1.setVisible(true);
					btnNewButton_1_1.setVisible(true);
					
				}
			}
		});
		btnNewButton_3.setBounds(205, 7, 111, 23);
		panel.add(btnNewButton_3);
		
		
		
	}

	
	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField txtNombreCurso;
	private JTextField txtECTS;
	private JTextField txtTasaMatricula;
	private JTextField txtEdicion;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	

	public void altaCurso(String idCurso, String nombreCurso, int ECTS, Date fechaInicio, Date fechaFin, double TasaMatricula, int Edicion, TipoCurso tipoCurso) {
		CursoPropio curso = new CursoPropio();
		curso.set_id(idCurso);
		curso.set_nombre(nombreCurso);
		curso.set_eCTS(ECTS);
		curso.set_fechaInicio(fechaInicio);
		curso.set_fechaFin(fechaFin);
		curso.set_tasaMatricula(TasaMatricula);
		curso.set_edicion(Edicion);
		curso.setId_secretario("01");
		curso.setId_director("02");
		curso.set_estado(EstadoCurso.PROPUESTO);
		curso.set_tipo(tipoCurso);
		curso.setId_centro(1);
		curso.persist();
	}

	public void edicionCurso() {
		throw new UnsupportedOperationException();
	}
	
	public List<Materia> cargarMaterias() {
		
		MateriaDAO <Materia> MateriaDAO = new MateriaDAO <Materia>();
		List<Materia> Materias = new ArrayList<Materia>();
		Materias=MateriaDAO.listarMaterias();
		return Materias;
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDireccionCursos frame = new PantallaDireccionCursos(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}