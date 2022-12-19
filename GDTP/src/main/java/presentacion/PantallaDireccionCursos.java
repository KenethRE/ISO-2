package presentacion;

import java.awt.event.ActionEvent;

import persistencia.*;
import org.apache.derby.iapi.sql.dictionary.TupleDescriptor;
import org.apache.derby.impl.store.access.sort.MergeScanRowSource;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import negocio.controllers.GestorConsultas;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Materia;
import negocio.entities.TipoCurso;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class PantallaDireccionCursos extends JFrame{
	JFrame previousWindow;
	Date fechaComienzo;
	Date fechaFin;
	int contador;
	private DefaultListModel modelo;
	DefaultListModel modelomaterias = new DefaultListModel();
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
	private GestorConsultas gestorConsultas = new GestorConsultas();
	
	public PantallaDireccionCursos(JFrame previousWindow) {
		contador= (int)(Math.random()*90+1);
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
		setBounds(100, 100, 544, 547);
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
		PanelFechaComienzo.setBounds(10, 145, 212, 130);
		JPanel PanelFechaFin = new JPanel();
		PanelFechaFin.setBounds(255, 145, 212, 130);
		panel1.add(PanelFechaComienzo);
		panel1.add(PanelFechaFin);
		PanelFechaComienzo.add(fechainicio);
		PanelFechaFin.add(fechafin);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
		lblNewLabel_1.setBounds(10, 131, 93, 14);
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Fin");
		lblNewLabel_2.setBounds(255, 131, 49, 14);
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
		modelo=new DefaultListModel<>();
		
		JButton btnNewButton = new JButton("Añadir Materias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAñadirMaterias añadirMaterias = new PantallaAñadirMaterias(modelomaterias, previousWindow);
				añadirMaterias.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 306, 124, 23);
		panel1.add(btnNewButton);
		
		JComboBox <TipoCurso> cbTipoCurso = new JComboBox<TipoCurso>();
		cbTipoCurso.setModel(new DefaultComboBoxModel<TipoCurso>(TipoCurso.values()));
		cbTipoCurso.setBounds(346, 99, 121, 22);
		panel1.add(cbTipoCurso);
		JList listamaterias = new JList();
		listamaterias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton Elimnarmaterias = new JButton("Eliminar Materia");
		Elimnarmaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelomaterias.removeElementAt(listamaterias.getSelectedIndex());
			}
			
		});
		Elimnarmaterias.setBounds(10, 340, 124, 23);
		panel1.add(Elimnarmaterias);
		Elimnarmaterias.setVisible(false);
		
		
		listamaterias.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Elimnarmaterias.setVisible(true);
				
			}
		});
		listamaterias.setModel(modelomaterias);
		listamaterias.setBounds(161, 309, 156, 128);
		panel1.add(listamaterias);
		// el boton guardar curso realiza las lamadas a los gestores de bd para guardar elk curso y las materias
		JButton btnNewButton_1 = new JButton("Guardar Curso");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNombreCurso.getText().length() < 3)
					JOptionPane.showMessageDialog(null, "El nombre del curso es muy corto. Por favor "
						+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE); 
				else {
					if (controldeerroresguardarcurso()== false) {
						JOptionPane.showMessageDialog(null, "Algun campo no posee la longitud correcta o el tipo correcto de dato "
								+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE); 
					}
					else {
						String IDCurso = txtNombreCurso.getText().substring(0, 3) + contador++;
						fechaComienzo = new java.sql.Date(((java.util.Date) fechainicio.getModel().getValue()).getTime());
						fechaFin = new java.sql.Date(((java.util.Date) fechafin.getModel().getValue()).getTime());
						if(fechaFin.before(fechaComienzo)) {
							JOptionPane.showMessageDialog(null, "Rango de fechas incorrecto "
									+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						else {
							altaCurso(IDCurso, txtNombreCurso.getText(), Integer.valueOf(txtECTS.getText()), 
									fechaFin, fechaFin, Double.valueOf(txtTasaMatricula.getText()), 
									Integer.valueOf(txtEdicion.getText()), (TipoCurso) cbTipoCurso.getSelectedItem());
							altamaterias(modelomaterias,IDCurso);
							JOptionPane.showMessageDialog(null, "Se ha creado un curso con identificador: " + IDCurso, "EXITO",
							JOptionPane.INFORMATION_MESSAGE);}
							modelomaterias.removeAllElements();
							txtNombreCurso.setText("");
							txtECTS.setText("");
							txtTasaMatricula.setText("");
							txtEdicion.setText("");
							fechafin.getModel().setValue(null);
							fechainicio.getModel().setValue(null);
						}
				
						}
			}
		});
		btnNewButton_1.setBounds(196, 448, 121, 23);
		panel1.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Tipo de Curso:");
		lblNewLabel_6.setBounds(255, 103, 80, 14);
		panel1.add(lblNewLabel_6);
		
		
		
		
		
		
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
		lblNewLabel_1_1.setBounds(10, 128, 93, 14);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setVisible(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fecha Fin");
		lblNewLabel_2_1.setBounds(255, 128, 49, 14);
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
		textField_6.setBounds(74, 73, 49, 20);
		panel.add(textField_6);
		textField_6.setVisible(false);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(211, 72, 49, 20);
		panel.add(textField_7);
		textField_7.setVisible(false);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(74, 100, 49, 20);
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
		btnNewButton_1_1.setBounds(27, 361, 121, 23);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		List<CursoPropio> listaCursos = new ArrayList<>();
		listaCursos = gestorConsultas.listartodolosCursoPropios();
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
		for (int i=0; i<listaCursos.size();i++) {
			CursoPropio cursoPropio = new CursoPropio();
			cursoPropio= listaCursos.get(i);
			modelo.addElement(cursoPropio.get_id());;
		}
		comboBox.setModel(modelo);
		comboBox.setBounds(75, 8, 73, 22);
		panel.add(comboBox);
		JDatePickerImpl fechainicio2 = new JDatePickerImpl(panelfechainicio,new DateLabelFormatter());
		fechainicio2.setBounds(21, 173, 134, 101);
		JDatePickerImpl fechafin2 = new JDatePickerImpl(panelfechafin,new DateLabelFormatter());
		fechafin2.setBounds(232, 173, 134, 101);
		JPanel PanelFechaComienzo2 = new JPanel();
		PanelFechaComienzo2.setBounds(10, 145, 212, 130);
		JPanel PanelFechaFin2 = new JPanel();
		PanelFechaFin2.setBounds(255, 145, 212, 130);
		panel.add(PanelFechaComienzo2);
		panel.add(PanelFechaFin2);
		PanelFechaComienzo2.add(fechainicio2);
		PanelFechaFin2.add(fechafin2);
		
		// esta accion hay que realizarla todavia
		JButton btnNewButton_3 = new JButton("Buscar curso");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
					CursoPropio cursoPropio = new CursoPropio();
					cursoPropio.set_id(comboBox.getSelectedItem().toString());
					List<CursoPropio> listaCursos = new ArrayList<>();
					cursoPropio= gestorConsultas.seleccionarCursoPropio(cursoPropio);
					textField_5.setText(cursoPropio.get_nombre());
					textField_6.setText(Integer.toString(cursoPropio.get_eCTS()));
					textField_7.setText(Double.toString(cursoPropio.get_tasaMatricula()));
					textField_8.setText(Integer.toString(cursoPropio.get_edicion()));
					Calendar calendar = Calendar.getInstance();
					Date fechaDateinicioDate = (Date) cursoPropio.get_fechaInicio();
					calendar.setTime(fechaDateinicioDate);
					Integer yearInteger = calendar.get(Calendar.YEAR);
					Integer mes= calendar.get(calendar.MONTH);
					Integer day = calendar.get(calendar.DAY_OF_MONTH);
					fechainicio2.getModel().setDate(yearInteger, mes, day);
					
						
				
			}
		});
		btnNewButton_3.setBounds(205, 7, 111, 23);
		panel.add(btnNewButton_3);
		
		
		
		
		
	}

	
	
	
	// metodo para dar de alta el curso en la base de datos.
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
		try {
			curso.persist();
		} catch (SQLDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// metodo para guardar la materia creada en la base de datos
	public void altamaterias(DefaultListModel modelo,String idcurso) {
		for (int i=0; i < modelo.getSize(); i++) {
			Materia aMateria = new Materia();
			aMateria=(Materia) modelo.getElementAt(i);
			aMateria.setId_Curso(idcurso);
			aMateria.persist();
		}
		
	}

	public void edicionCurso() {
		throw new UnsupportedOperationException();
	}
	// carga de materias de la tabla materias.
	public List<Materia> cargarMaterias() {
		
		MateriaDAO <Materia> MateriaDAO = new MateriaDAO <Materia>();
		List<Materia> Materias = new ArrayList<Materia>();
		Materias=MateriaDAO.listarMaterias();
		return Materias;
		
	}
	//contro de que en cada campo este el tipo correcto.
	public boolean controldeerroresguardarcurso() {
		boolean control = true;
		if (txtNombreCurso.getText().length() < 3) {
			control = false;
		}
		if  (txtECTS.getText().length()<1 || txtECTS.getText().chars().allMatch(Character::isDigit)==false){
			control = false;
		}
		if  (txtTasaMatricula.getText().length()<1 || txtTasaMatricula.getText().chars().allMatch(Character::isDigit)==false){
			control = false;
		}
		if (txtEdicion.getText().isEmpty()|| txtEdicion.getText().length() < 1) {
			control = false;
		}
		return control;
		
		
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