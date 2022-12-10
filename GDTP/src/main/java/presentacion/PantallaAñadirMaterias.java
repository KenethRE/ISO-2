package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import negocio.entities.Materia;
import negocio.entities.Profesor;
import persistencia.ProfesorDAO;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PantallaAñadirMaterias extends JFrame{
	JFrame previousWindow;
	private JTextField textField;
	private JTextField textField_1;
	Date fechaComienzo2;
	Date fechaFin2;
	private ProfesorDAO<Profesor> agenteProfesorDAO = new ProfesorDAO<>();
	public PantallaAñadirMaterias(DefaultListModel modelomaterias, JFrame previousWindow) {
		this.previousWindow = previousWindow;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		if (previousWindow != null) {
			
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					previousWindow.setVisible(true);
				}
			});
		}
		setTitle("Pantalla Añadir Materias");
		setBounds(100, 100, 500, 384);
		getContentPane().setLayout(null);
		Properties propiedadesfecha = new Properties();
		propiedadesfecha.put("text.today","Hoy");
		propiedadesfecha.put("text.month","Mes");
		propiedadesfecha.put("text.year","Año");
		JDatePanelImpl panelfechainicio = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePanelImpl panelfechafin = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 471, 314);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Materia");
		lblNewLabel.setBounds(27, 28, 79, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Horas");
		lblNewLabel_1.setBounds(26, 62, 49, 14);
		panel.add(lblNewLabel_1);
		
		JDatePickerImpl fechainicio = new JDatePickerImpl(panelfechainicio,new DateLabelFormatter());
		fechainicio.setBounds(21, 173, 134, 101);
		JDatePickerImpl fechafin = new JDatePickerImpl(panelfechafin,new DateLabelFormatter());
		fechafin.setBounds(232, 173, 134, 101);
		JPanel PanelFechaComienzo = new JPanel();
		PanelFechaComienzo.setBounds(10, 112, 212, 130);
		JPanel PanelFechaFin = new JPanel();
		PanelFechaFin.setBounds(232, 112, 212, 130);
		panel.add(PanelFechaComienzo);
		panel.add(PanelFechaFin);
		PanelFechaComienzo.add(fechainicio);
		PanelFechaFin.add(fechafin);
		JLabel lblNewLabel_2 = new JLabel("Fecha Inicio");
		lblNewLabel_2.setBounds(27, 98, 79, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(237, 98, 49, 14);
		panel.add(lblFechaFin);
		
		textField = new JTextField();
		textField.setBounds(115, 25, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 59, 96, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		List<Profesor> Profesores = new ArrayList<Profesor>();
		Profesores = agenteProfesorDAO.listarProfesores();
		for (int i=0; i<Profesores.size();i++) {
			comboBox.addItem(Profesores.get(i));
		}
		comboBox.setBounds(314, 24, 105, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Añadir materia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Materia materia = new Materia();
				fechaComienzo2 = new java.sql.Date(((java.util.Date) fechainicio.getModel().getValue()).getTime());
				fechaFin2 = new java.sql.Date(((java.util.Date) fechafin.getModel().getValue()).getTime());
				materia.set_nombre(textField.getText());
				materia.set_horas(Double.parseDouble((textField_1.getText())));
				materia.set_fechaInicio(fechaComienzo2);
				materia.set_fechaFin(fechaFin2);
				materia.setId_prof_responsable(comboBox.getSelectedItem().toString());
				modelomaterias.addElement(materia);
				dispose();
			}
		});
		btnNewButton.setBounds(181, 264, 105, 23);
		panel.add(btnNewButton);
		
		JLabel lblDniProfesor = new JLabel("Dni Profesor");
		lblDniProfesor.setBounds(237, 28, 67, 14);
		panel.add(lblDniProfesor);
		
		
	}
}
