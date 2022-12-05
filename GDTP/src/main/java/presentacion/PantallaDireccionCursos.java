package presentacion;

import java.awt.event.ActionEvent;

import org.apache.derby.iapi.sql.dictionary.TupleDescriptor;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.swing.JLabel;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JTable;

public class PantallaDireccionCursos extends JFrame{
	JFrame previousWindow;
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
		getContentPane().add(pestañas, "name_26133981429000");
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(25, 320, 59, 14);
		Properties propiedadesfecha = new Properties();
		propiedadesfecha.put("text.today","Hoy");
		propiedadesfecha.put("text.month","Mes");
		propiedadesfecha.put("text.year","Año");
	
		JDatePanelImpl panelfechainicio = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePanelImpl panelfechafin = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		pestañas.addTab("Alta Curso",panel1);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(21, 44, 49, 14);
		panel1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(75, 41, 185, 20);
		panel1.add(textField);
		textField.setColumns(10);
		JDatePickerImpl fechainicio = new JDatePickerImpl(panelfechainicio,new DateLabelFormatter());
		fechainicio.setBounds(21, 173, 134, 101);
		JDatePickerImpl fechafin = new JDatePickerImpl(panelfechafin,new DateLabelFormatter());
		fechafin.setBounds(232, 173, 134, 101);
		panel1.add(fechainicio);
		panel1.add(fechafin);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
		lblNewLabel_1.setBounds(30, 148, 93, 14);
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Fin");
		lblNewLabel_2.setBounds(231, 148, 49, 14);
		panel1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ECTS");
		lblNewLabel_3.setBounds(21, 76, 49, 14);
		panel1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tasa");
		lblNewLabel_4.setBounds(161, 76, 49, 14);
		panel1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Edicion");
		lblNewLabel_5.setBounds(21, 103, 49, 14);
		panel1.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(55, 73, 49, 20);
		panel1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(191, 72, 49, 20);
		panel1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(55, 100, 49, 20);
		panel1.add(textField_4);
		
		JButton btnNewButton = new JButton("Añadir Materias");
		btnNewButton.setBounds(30, 314, 111, 23);
		panel1.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Id Curso");
		lblNewLabel_6.setBounds(21, 11, 49, 14);
		panel1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ID");
		lblNewLabel_7.setBounds(75, 11, 49, 14);
		panel1.add(lblNewLabel_7);
		
		JList list = new JList();
		list.setBounds(178, 317, 188, 140);
		panel1.add(list);
		
		JButton btnNewButton_1 = new JButton("Guardar Curso");
		btnNewButton_1.setBounds(417, 382, 121, 23);
		panel1.add(btnNewButton_1);
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
					lblNewLabel_2_1.setVisible(true);
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
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	

	public void altaCurso() {
		throw new UnsupportedOperationException();
	}

	public void edicionCurso() {
		throw new UnsupportedOperationException();
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