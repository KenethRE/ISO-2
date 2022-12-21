package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import negocio.entities.CursoPropio;
import negocio.entities.Estudiante;
import negocio.entities.ModoPago;
import persistencia.EstudianteDAO;
import persistencia.MatriculaDAO;
import negocio.entities.Matricula;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Matriculacion extends JFrame {
	JFrame previousWindow;
	JFrame estaventana;
	private static final long serialVersionUID = -7592567473508560622L;
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	private boolean camposrellenos;
	private CursoPropio cursoPropio = new CursoPropio();
	private JCheckBox chckbxNewCheckBox = new JCheckBox("Pagado");
	private JButton btnNewButton_2 = new JButton("Finalizar Matricula");
	private ModoPago tipoPago;
	private boolean tarjeta=false;
	Date fechamatriculacionDate;
	
	public Matriculacion(JFrame previousWindow){
		estaventana= this;
		cursoPropio.set_id("");
		cursoPropio.set_nombre("");
		this.previousWindow = previousWindow;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 670, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matricula");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(127, 21, 228, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Alumno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(25, 80, 138, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dni");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(24, 127, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(25, 169, 82, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Apellidos");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(25, 216, 103, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Titulacion");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(25, 266, 82, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Cualificacion");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(24, 309, 83, 14);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Datos Matricula");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(361, 70, 140, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Fecha matriculacion");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1.setBounds(351, 112, 147, 14);
		contentPane.add(lblNewLabel_2_4_1);
		Properties propiedadesfecha = new Properties();
		propiedadesfecha.put("text.today","Hoy");
		propiedadesfecha.put("text.month","Mes");
		propiedadesfecha.put("text.year","Año");
		JDatePanelImpl panelfecha = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePickerImpl fecha = new JDatePickerImpl(panelfecha,new DateLabelFormatter());
		fecha.setBounds(21, 173, 134, 101);
		JPanel PanelFecha= new JPanel();
		PanelFecha.setBounds(351, 137, 222, 116);
		contentPane.add(PanelFecha);
		PanelFecha.add(fecha);
		fecha.getModel().setDate(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth());
		
		JButton btnNewButton = new JButton("Realizar pago");
		btnNewButton.setEnabled(false);
		// activacion de la ventana realizar pago siempre y cuando haya elegido un curso  y una fecha de matriculacion.
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()==false && fecha.getModel().getValue()!=null) {
				RealizarPago pago = new RealizarPago(estaventana);
				pago.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "debe elegir un curso para matricularse y fecha de matriculacion"
							+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(64, 432, 216, 48);
		contentPane.add(btnNewButton);
		
		txtDni = new JTextField();
		txtDni.setBounds(109, 126, 196, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		txtDni.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updated();
				
			}
			public void updated() {
				if (chequearcampos()==true) {
					btnNewButton.setEnabled(true);
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 168, 196, 20);
		contentPane.add(textField_1);
		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updated();
				
			}
			public void updated() {
				if (chequearcampos()==true) {
					btnNewButton.setEnabled(true);
				}
			}
		});
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 215, 196, 20);
		contentPane.add(textField_2);
		textField_2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updated();
				
			}
			public void updated() {
				if (chequearcampos()==true) {
					btnNewButton.setEnabled(true);
				}
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(109, 265, 196, 20);
		contentPane.add(textField_3);
		textField_3.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updated();
				
			}
			public void updated() {
				if (chequearcampos()==true) {
					btnNewButton.setEnabled(true);
				}
			}
		});
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(109, 308, 196, 20);
		contentPane.add(textField_4);
		textField_4.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updated();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updated();
				
			}
			public void updated() {
				if (chequearcampos()==true) {
					btnNewButton.setEnabled(true);
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaLogin frame = new PantallaLogin();
				frame.setResizable(false);
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(546, 21, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setBounds(310, 445, 72, 23);
		contentPane.add(chckbxNewCheckBox);
		
		//creacion de la matricula a partir del click al boton pagar matricula
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fechamatriculacionDate = new java.sql.Date(((java.util.Date) fecha.getModel().getValue()).getTime());
				Estudiante estudiante = new Estudiante();
				estudiante.set_dni(txtDni.getText());
				estudiante.set_nombre(textField_1.getText());
				estudiante.set_apellidos(textField_2.getText());
				estudiante.set_titulacion(textField_3.getText());
				estudiante.set_cualificacion(textField_4.getText());
				Matricula matricula = new Matricula();
				matricula.set_pagado(true);
				int idmatricula = (int)(Math.random()*9000+1);
				matricula.setiD(idmatricula);
				matricula.set_fecha(fechamatriculacionDate);
				matricula.setId_estudiante(estudiante.get_dni());
				matricula.setId_Curso(cursoPropio.get_id());
				if (tarjeta==false) {
					matricula.set_tipoPago(tipoPago.TRANSFERENCIA);
					
				}
				else {
					matricula.set_tipoPago(tipoPago.TARJETA_CREDITO);
				}
				try {
					estudiante.persist();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					matricula.persist();
				} catch (NullPointerException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Se ha creado la matricula con identificador: " + matricula.getiD(), "EXITO",
				JOptionPane.INFORMATION_MESSAGE);
				dispose();
				previousWindow.setVisible(true);
				
			}
		});
		
		
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(402, 432, 233, 48);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscar Curso");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busquedacurso busqueda = new Busquedacurso(estaventana);
				busqueda.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(402, 283, 138, 34);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setBounds(409, 361, 147, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Curso seleccionado");
		lblNewLabel_3.setBounds(412, 335, 114, 14);
		contentPane.add(lblNewLabel_3);
		textField.setText(cursoPropio.get_nombre());
	}
	// recoge el curso elegido de la pantalla elegir curso.
	public void setcursopropio(CursoPropio curso) {
		cursoPropio=curso;
		textField.setText(cursoPropio.get_nombre());
	}
	//chequea los campos para saber si estan completados
	public boolean chequearcampos() {
		if (txtDni.getText().length()>1 && textField_1.getText().length()>1 && textField_2.getText().length()>1 && textField_3.getText().length()>1
				&& textField_4.getText().length()>1) {
		camposrellenos=true;
		}
		return camposrellenos;
		
	}
	//recoge la activacion del pago desde la ventamna pago
	public void activarcasillapago() {
		chckbxNewCheckBox.setSelected(true);
		btnNewButton_2.setEnabled(true);
		
		
	}
	// si el pago ha sido con tarjeta en la venta pago se cambia aqui.
	public void setpagotarjeta() {
		tarjeta=true;
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Matriculacion frame = new  Matriculacion(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
