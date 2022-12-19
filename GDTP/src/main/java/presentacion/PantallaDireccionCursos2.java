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
import java.sql.SQLDataException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.sound.midi.SysexMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class PantallaDireccionCursos2 extends JFrame{
	JFrame previousWindow;
	Date fechaComienzo;
	Date fechaFin;
	int contador = 0;
	private DefaultListModel modelo;
	DefaultListModel modelomaterias = new DefaultListModel();
	
	
	
	private DefaultListModel modelo2;
	//DefaultListModel modelomaterias = new DefaultListModel();
	
	
	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField txtNombreCurso;
	private JTextField txtECTS;
	private JTextField txtTasaMatricula;
	private JTextField txtEdicion;
	
	private JTextField txtnombre5;
	private JTextField txtects5;
	private JTextField txttasa5;
	private JTextField txtedicion5;
	private JTextField txtfechainicio5;
	private JTextField txtfechafin5;
	private JTextField txtidcurso5;
	
	
	private JTextField txtnom5;
	private JTextField txthoras5;
	private JTextField txtfecini5;
	private JTextField txtfecfin5;
	private JTextField txtidprofesor5;

	
	
	private CursoPropioDAO<CursoPropio> agenteCursoPropioDAO = new CursoPropioDAO();
	private MateriaDAO<Materia> agenteMateriaDAO=new MateriaDAO();
	private JTextField txtidmateria5;
	
	public PantallaDireccionCursos2(JFrame previousWindow) {
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
		setBounds(100, 100, 857, 626);
		setResizable(false);
		getContentPane().setLayout(new CardLayout(0, 0));
		JTabbedPane pestanas=new JTabbedPane();
		getContentPane().add(pestanas, "name_000");
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(25, 320, 59, 14);
		Properties propiedadesfecha = new Properties();
		propiedadesfecha.put("text.today","Hoy");
		propiedadesfecha.put("text.month","Mes");
		propiedadesfecha.put("text.year","AÃ±o");
		
		
		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
			}
		});
	
	
		JDatePanelImpl panelfechainicio = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePanelImpl panelfechafin = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		pestanas.addTab("Alta Curso",panel1);
		
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
		
		
		
		modelo2=new DefaultListModel<>();
		
		
		
		JButton btnNewButton = new JButton("AÃ±adir Materias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PantallaAnadirMaterias anadirMaterias = new PantallaAnadirMaterias(modelomaterias, previousWindow);
				//anadirMaterias.setVisible(true);
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
		pestanas.addTab("Editar Curso", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre");
		lblNewLabel_8.setBounds(21, 44, 49, 14);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setVisible(false);
		
		txtnombre5 = new JTextField();
		txtnombre5.setColumns(10);
		txtnombre5.setBounds(80, 41, 185, 20);
		panel.add(txtnombre5);
		txtnombre5.setVisible(false);
		
		JLabel lblNewLabel_3_1 = new JLabel("ECTS");
		lblNewLabel_3_1.setBounds(21, 76, 34, 14);
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setVisible(false);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tasa");
		lblNewLabel_4_1.setBounds(156, 79, 34, 14);
		panel.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setVisible(false);
		
		JLabel lblNewLabel_5_1 = new JLabel("Edicion");
		lblNewLabel_5_1.setBounds(21, 111, 49, 14);
		panel.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setVisible(false);
		
		
		JLabel lblfechainicio5 = new JLabel("FEcha de inicio");
		lblfechainicio5.setBounds(21, 139, 93, 14);
		panel.add(lblfechainicio5);
		lblfechainicio5.setVisible(false);
		
		JLabel lblfechafin5 = new JLabel("FEcha de fin");
		lblfechafin5.setBounds(184, 142, 78, 14);
		panel.add(lblfechafin5);
		lblfechafin5.setVisible(false);
		
		

		JLabel lblmateria = new JLabel("MATERIA");
		lblmateria.setBounds(11, 372, 73, 23);
		panel.add(lblmateria);
		lblmateria.setVisible(false);
		
		
		JLabel lblhoras = new JLabel("Horas");
		lblhoras.setBounds(11, 431, 59, 14);
		panel.add(lblhoras);
		lblhoras.setVisible(false);
		
		JLabel lblidprofesor = new JLabel("ID PROFESOR");
		lblidprofesor.setBounds(11, 406, 103, 14);
		panel.add(lblidprofesor);
		lblidprofesor.setVisible(false);
		
		
		JLabel lblfecini5 = new JLabel("FEcha de inicio");
		lblfecini5.setBounds(11, 456, 93, 14);
		panel.add(lblfecini5);
		lblfecini5.setVisible(false);
		
		JLabel lblfecfin5 = new JLabel("FEcha de fin");
		lblfecfin5.setBounds(11, 484, 113, 14);
		panel.add(lblfecfin5);
		lblfecfin5.setVisible(false);
		
		
		

		
		txtects5 = new JTextField();
		txtects5.setColumns(10);
		txtects5.setBounds(65, 73, 49, 20);
		panel.add(txtects5);
		txtects5.setVisible(false);
		
		txttasa5 = new JTextField();
		txttasa5.setColumns(10);
		txttasa5.setBounds(189, 73, 59, 20);
		panel.add(txttasa5);
		txttasa5.setVisible(false);
		
		txtedicion5 = new JTextField();
		txtedicion5.setColumns(10);
		txtedicion5.setBounds(65, 108, 59, 20);
		panel.add(txtedicion5);
		txtedicion5.setVisible(false);
		
		
		
		txtfechainicio5 = new JTextField();
		txtfechainicio5.setColumns(10);
		txtfechainicio5.setBounds(111, 136, 62, 20);
		panel.add(txtfechainicio5);
		txtfechainicio5.setVisible(false);
		
		txtfechafin5 = new JTextField();
		txtfechafin5.setColumns(10);
		txtfechafin5.setBounds(267, 139, 68, 20);
		panel.add(txtfechafin5);
		txtfechafin5.setVisible(false);
		
		
		
/*===*/
		txtnom5 = new JTextField();
		txtnom5.setColumns(10);
		txtnom5.setBounds(85, 373, 163, 20);
		panel.add(txtnom5);
		txtnom5.setVisible(false);
		
		txthoras5 = new JTextField();
		txthoras5.setColumns(10);
		txthoras5.setBounds(65, 428, 183, 20);
		panel.add(txthoras5);
		txthoras5.setVisible(false);
		
		txtidprofesor5 = new JTextField();
		txtidprofesor5.setColumns(10);
		txtidprofesor5.setBounds(111, 403, 137, 20);
		panel.add(txtidprofesor5);
		txtidprofesor5.setVisible(false);
		
		
		
		txtfecini5 = new JTextField();
		txtfecini5.setColumns(10);
		txtfecini5.setBounds(114, 453, 134, 20);
		panel.add(txtfecini5);
		txtfecini5.setVisible(false);
		
		txtfecfin5 = new JTextField();
		txtfecfin5.setColumns(10);
		txtfecfin5.setBounds(111, 481, 137, 20);
		panel.add(txtfecfin5);
		txtfecfin5.setVisible(false);
		
		JLabel lblidmateria = new JLabel("Id materia");
		lblidmateria.setBounds(11, 536, 59, 14);
		panel.add(lblidmateria);
		lblidmateria.setVisible(false);
		
		txtidmateria5 = new JTextField();
		txtidmateria5.setBounds(78, 533, 125, 20);
		panel.add(txtidmateria5);
		txtidmateria5.setColumns(10);
		txtidmateria5.setVisible(false);
		
		JLabel lblNewLabel_6_1 = new JLabel("Id Curso");
		lblNewLabel_6_1.setBounds(21, 11, 49, 14);
		panel.add(lblNewLabel_6_1);
		
		JList jlista1 = new JList();
		jlista1.setBounds(10, 175, 306, 140);
		panel.add(jlista1);
		jlista1.setVisible(false);

		DefaultListModel<String> modelo2=new DefaultListModel<>();
		jlista1.setModel(modelo2);
		
		txtidcurso5 = new JTextField();
		txtidcurso5.setBounds(76, 8, 48, 20);
		panel.add(txtidcurso5);
		txtidcurso5.setColumns(10);
		JButton btnNewButton_3_2 = new JButton("Registrar Materia");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if (txtidcurso5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "EL ID ESTA VACIO");
					txtidcurso5.requestFocus();
					
					}
					else {
						
						
					
						
						//modelo2.addElement("ID:"+" - Materia: ");
						
						String materia=txtnom5.getText().toString();
						String idprofesor=txtidprofesor5.getText().toString();
						String horas=txthoras5.getText().toString();
						
						
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
						
						String fechainis=txtfecini5.getText().toString();
						Date fechaini = null;
						
						try {
							fechaini = (Date) formato.parse(fechainis);
						} catch (ParseException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
						
						String fechafins=txtfecfin5.getText().toString();
						Date fechafin = null;
						
						try {
							fechafin = (Date) formato.parse(fechafins);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						String idcurso=txtidcurso5.getText().toString();
						String idmateria=txtidmateria5.getText().toString();
						
						
						
						/*===== PROCESO DE INSERCION =======*/
						
						try {
							Materia m=new Materia();
							//m.setId_Materia(idmateria);
							m.set_nombre(materia);
							m.setId_prof_responsable(idprofesor);
							m.set_horas(Double.parseDouble(horas));
							m.set_fechaInicio(fechaini);
							m.set_fechaFin(fechafin);
							m.setId_Curso(idcurso);
							
							int verificar = agenteMateriaDAO.crearNuevaMateria(m);
							
							if(verificar!=0)
							{
								JOptionPane.showMessageDialog(null, "SE REGISTRO LA MATERIA EN EL CURSO CON EL ID DE CURSO: "+idcurso);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR LA MATERIA EN EL CURSO CON ID: "+idcurso);
							}
							
							
							
							
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Curso no encontrados "
									+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
						
						
						/*===================================*/
						/*List<CursoPropio> Cursos = new ArrayList<CursoPropio>();*/
					 
						
						CursoPropio Curso = new CursoPropio();
						
						List<Materia> materias = new ArrayList<Materia>();
						
						modelo.removeAllElements();
						
						
						
						try {
							//Curso = agenteCursoPropioDAO.datosdecurso(idcurso);
							txtnombre5.setText(Curso.get_nombre());
							txtects5.setText(""+Curso.get_eCTS());
							txttasa5.setText(String.valueOf(Curso.get_tasaMatricula()));
							txtedicion5.setText(""+Curso.get_edicion());
							txtfechainicio5.setText(""+Curso.get_fechaInicio());
							txtfechafin5.setText(""+Curso.get_fechaFin());
							
							//materias = agenteMateriaDAO.listarMateriasCurso(idcurso);
							
							
							
							for (int i=0; i<materias.size();i++) {
								//modelocursos.addElement(Cursos.get(i));
								
								//System.out.println(Cursos.get(i));
								//modelo.addElement("ID:"+materias.get(i).getId_Materia()+" - Materia: "+materias.get(i).get_nombre());
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Curso no encontrados "
									+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
						
						
					 txtnom5.setText("");
						
					}
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_3_2.setBounds(31, 337, 142, 23);
		panel.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_3 = new JButton("Modificar Materia");
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				if (txtidcurso5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "EL ID ESTA VACIO");
					txtidcurso5.requestFocus();
					
					}else
					if (txtidmateria5.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "EL ID ESTA VACIO");
							txtidmateria5.requestFocus();
							
							}
					else {
						
						
					
						
						//modelo2.addElement("ID:"+" - Materia: ");
						
						String materia=txtnom5.getText().toString();
						String idprofesor=txtidprofesor5.getText().toString();
						String horas=txthoras5.getText().toString();
						
						
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
						
						String fechainis=txtfecini5.getText().toString();
						Date fechaini = null;
						
						try {
							fechaini = (Date) formato.parse(fechainis);
						} catch (ParseException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
						
						String fechafins=txtfecfin5.getText().toString();
						Date fechafin = null;
						
						try {
							fechafin = (Date) formato.parse(fechafins);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						String idcurso=txtidcurso5.getText().toString();
						String idmateria=txtidmateria5.getText().toString();
						
						
						
						/*===== PROCESO DE MODIFICAR =======*/
						
						try {
							Materia m=new Materia();
							//m.setId_Materia(idmateria);
							m.set_nombre(materia);
							m.setId_prof_responsable(idprofesor);
							m.set_horas(Double.parseDouble(horas));
							m.set_fechaInicio(fechaini);
							m.set_fechaFin(fechafin);
							m.setId_Curso(idcurso);
							
							int verificar = agenteMateriaDAO.editarMateria(m);
							
							if(verificar!=0)
							{
								JOptionPane.showMessageDialog(null, "SE MODIFICO LA MATERIA EN EL CURSO CON EL ID DE CURSO: "+idcurso);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICO LA MATERIA EN EL CURSO CON ID: "+idcurso);
							}
							
							
							
							
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Curso no encontrados "
									+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
						
						
						/*===================================*/
						/*List<CursoPropio> Cursos = new ArrayList<CursoPropio>();*/
					 
						
						CursoPropio Curso = new CursoPropio();
						
						List<Materia> materias = new ArrayList<Materia>();
						
						modelo.removeAllElements();
						
						
						
						try {
							//Curso = agenteCursoPropioDAO.datosdecurso(idcurso);
							txtnombre5.setText(Curso.get_nombre());
							txtects5.setText(""+Curso.get_eCTS());
							txttasa5.setText(String.valueOf(Curso.get_tasaMatricula()));
							txtedicion5.setText(""+Curso.get_edicion());
							txtfechainicio5.setText(""+Curso.get_fechaInicio());
							txtfechafin5.setText(""+Curso.get_fechaFin());
							
							//materias = agenteMateriaDAO.listarMateriasCurso(idcurso);
							
							
							
							for (int i=0; i<materias.size();i++) {
								//modelocursos.addElement(Cursos.get(i));
								
								//System.out.println(Cursos.get(i));
								//modelo.addElement("ID:"+materias.get(i).getId_Materia()+" - Materia: "+materias.get(i).get_nombre());
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Curso no encontrados "
									+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
						
						
					 txtnom5.setText("");
						
					}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_3_3.setBounds(285, 527, 150, 23);
		panel.add(btnNewButton_3_3);
		
		JButton btnNewButton_3_4 = new JButton("Eliminar Materia");
		btnNewButton_3_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			
					if (txtidmateria5.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "EL ID ESTA VACIO");
							txtidmateria5.requestFocus();
							
							}
					else {
						
						
					
						
						//modelo2.addElement("ID:"+" - Materia: ");
						
						String materia=txtnom5.getText().toString();
						String idprofesor=txtidprofesor5.getText().toString();
						String horas=txthoras5.getText().toString();
						
						
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
						
						String fechainis=txtfecini5.getText().toString();
						Date fechaini = null;
						
						try {
							fechaini = (Date) formato.parse(fechainis);
						} catch (ParseException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
						
						String fechafins=txtfecfin5.getText().toString();
						Date fechafin = null;
						
						try {
							fechafin = (Date) formato.parse(fechafins);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						String idcurso=txtidcurso5.getText().toString();
						String idmateria=txtidmateria5.getText().toString();
						
						
						
						/*===== PROCESO DE MODIFICAR =======*/
						
						try {
							Materia m=new Materia();
							//m.setId_Materia(idmateria);
							
							/*m.set_nombre(materia);
							m.setId_prof_responsable(idprofesor);
							m.set_horas(Double.parseDouble(horas));
							m.set_fechaInicio(fechaini);
							m.set_fechaFin(fechafin);
							m.setId_Curso(idcurso);*/
							
							//int verificar = agenteMateriaDAO.EliminarMateria(m);
							
							if(ABORT!=0)
							{
								JOptionPane.showMessageDialog(null, "SE ELIMINO LA MATERIA EN EL CURSO CON EL ID DE CURSO: "+idcurso);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR LA MATERIA EN EL CURSO CON ID: "+idcurso);
							}
							
							
							
							
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "MATERIA no encontrados "
									+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
						
						
						/*===================================*/
						/*List<CursoPropio> Cursos = new ArrayList<CursoPropio>();*/
					 
						
						CursoPropio Curso = new CursoPropio();
						
						List<Materia> materias = new ArrayList<Materia>();
						
						modelo.removeAllElements();
						
						
						
						try {
							/*Curso = agenteCursoPropioDAO.datosdecurso(idcurso);
							txtnombre5.setText(Curso.get_nombre());
							txtects5.setText(""+Curso.get_eCTS());
							txttasa5.setText(String.valueOf(Curso.get_tasaMatricula()));
							txtedicion5.setText(""+Curso.get_edicion());
							txtfechainicio5.setText(""+Curso.get_fechaInicio());
							txtfechafin5.setText(""+Curso.get_fechaFin());*/
							
							//materias = agenteMateriaDAO.listarMateriasCurso(idcurso);
							
							
							
							for (int i=0; i<materias.size();i++) {
								//modelocursos.addElement(Cursos.get(i));
								
								//System.out.println(Cursos.get(i));
								//modelo.addElement("ID:"+materias.get(i).getId_Materia()+" - Materia: "+materias.get(i).get_nombre());
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Curso no encontrados "
									+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
						
						
					 txtnom5.setText("");
						
					}
				
				
				
				
			}
		});
		btnNewButton_3_4.setBounds(473, 527, 163, 23);
		panel.add(btnNewButton_3_4);
		
		JButton btnNewButton_3_1 = new JButton("Buscar materia");
		
		btnNewButton_3_1.setBounds(3, 502, 111, 23);
		panel.add(btnNewButton_3_1);
	
		btnNewButton_3_2.setVisible(false);
		btnNewButton_3_3.setVisible(false);
		btnNewButton_3_4.setVisible(false);
		btnNewButton_3_1.setVisible(false);
		
		JButton btnNewButton_3 = new JButton("Buscar curso");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtidcurso5.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "EL ID ESTA VACIO");
				txtidcurso5.requestFocus();
				
				}
				else {
					//String id = textField_9.getText();
					//CursoPropio cp = new CursoPropio(id);
					//agenteCursoPropioDAO.seleccionarCurso(cp);
					//System.out.println("curso:"+cp);
					//List<CursoPropio> cp = agenteCursoPropioDAO.get(new CursoPropio(id));
					lblNewLabel_8.setVisible(true);
					txtnombre5.setVisible(true);
					lblfechainicio5.setVisible(true);
					lblfechafin5	.setVisible(true);
					lblNewLabel_3_1.setVisible(true);
					lblNewLabel_4_1.setVisible(true);
					lblNewLabel_5_1.setVisible(true);
					
				
					
					
					txtects5.setVisible(true);
					txttasa5.setVisible(true);
					txtedicion5.setVisible(true);
					
					txtfechainicio5.setVisible(true);
					txtfechafin5.setVisible(true);
					
					
					jlista1.setVisible(true);
					
					btnNewButton_3_1.setVisible(true);
					btnNewButton_3_2.setVisible(true);
					btnNewButton_3_3.setVisible(true);
					btnNewButton_3_4.setVisible(true);
					
					
					txtnom5.setVisible(true);
					txtidprofesor5.setVisible(true);
					txthoras5.setVisible(true);
					txtfecini5.setVisible(true);
					txtfecfin5.setVisible(true);
					txtidmateria5.setVisible(true);
					
					lblmateria.setVisible(true);
					lblidprofesor.setVisible(true);
					lblhoras.setVisible(true);
					lblfecini5.setVisible(true);
					lblfecfin5.setVisible(true);
					lblidmateria.setVisible(true);
					
					
					
					
					
					
					//modelo2.addElement("ID:"+" - Materia: ");
					
					
					
					
					String idcurso=txtidcurso5.getText().toString();
					
					/*List<CursoPropio> Cursos = new ArrayList<CursoPropio>();*/
				 
					CursoPropio Curso = new CursoPropio();
					
					
					List<Materia> materias = new ArrayList<Materia>();
					
					modelo.removeAllElements();
					
					
					
					try {
						//Curso = agenteCursoPropioDAO.datosdecurso(idcurso);
						txtnombre5.setText(Curso.get_nombre());
						txtects5.setText(""+Curso.get_eCTS());
						txttasa5.setText(String.valueOf(Curso.get_tasaMatricula()));
						txtedicion5.setText(""+Curso.get_edicion());
						txtfechainicio5.setText(""+Curso.get_fechaInicio());
						txtfechafin5.setText(""+Curso.get_fechaFin());
						
						//materias = agenteMateriaDAO.listarMateriasCurso(idcurso);
						
						
						
						for (int i=0; i<materias.size();i++) {
							//modelocursos.addElement(Cursos.get(i));
							
							//System.out.println(Cursos.get(i));
							//modelo.addElement("ID:"+materias.get(i).getId_Materia()+" - Materia: "+materias.get(i).get_nombre());
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Curso no encontrados "
								+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
					
					
					
					//textField_5.setText(cp.get_nombre());
					//textField_6.setText(cp.get_eCTS().toString());
					
				}
				
				
			
				
				
			}
			
			
			
		
			
			
		});
		
		
	
		
		
		btnNewButton_3.setBounds(205, 7, 111, 23);
		panel.add(btnNewButton_3);
		
		
		
	
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtidmateria5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "EL ID ESTA VACIO");
					txtidmateria5.requestFocus();
					
					}
					else {
						//String id = textField_9.getText();
						//CursoPropio cp = new CursoPropio(id);
						//agenteCursoPropioDAO.seleccionarCurso(cp);
						//System.out.println("curso:"+cp);
						//List<CursoPropio> cp = agenteCursoPropioDAO.get(new CursoPropio(id));
						
					
					
						
						
						//modelo2.addElement("ID:"+" - Materia: ");
						
						
						
						
						String idmateria=txtidmateria5.getText().toString();
						
						String idcurso=txtidcurso5.getText().toString();
						
						
						/*List<CursoPropio> Cursos = new ArrayList<CursoPropio>();*/
					 
						Materia materia = new Materia();
						
						
						List<Materia> materias = new ArrayList<Materia>();
						
						modelo.removeAllElements();
						
						
						
						try {
							//materia = agenteMateriaDAO.datosdemateria(idmateria);
							txtnom5.setText(materia.get_nombre());
							txtidprofesor5.setText(""+materia.getId_prof_responsable());
							txthoras5.setText(String.valueOf(materia.get_horas()));
							txtfecini5.setText(""+materia.get_fechaInicio());
							txtfechafin5.setText(""+materia.get_fechaFin());
							//txtidmateria5.setText(""+materia.getId_Materia());
							
							//materias = agenteMateriaDAO.listarMateriasCurso(idcurso);
							
							
							
							for (int i=0; i<materias.size();i++) {
								//modelocursos.addElement(Cursos.get(i));
								
								//System.out.println(Cursos.get(i));
								//modelo.addElement("ID:"+materias.get(i).getId_Materia()+" - Materia: "+materias.get(i).get_nombre());
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Curso no encontrados "
									+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
						
						
						//textField_5.setText(cp.get_nombre());
						//textField_6.setText(cp.get_eCTS().toString());
						
					}
				
				
			}
		});
		
		
		
		
		
		
	
		
		
		
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
		curso.persist();
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