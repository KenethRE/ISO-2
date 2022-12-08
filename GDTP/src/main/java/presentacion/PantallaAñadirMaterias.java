package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import negocio.entities.Materia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class PantallaAñadirMaterias extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	Date fechaComienzo;
	Date fechaFin;
	public PantallaAñadirMaterias() {
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
		fechaComienzo = new java.sql.Date(((java.util.Date) fechainicio.getModel().getValue()).getTime());
		fechaFin = new java.sql.Date(((java.util.Date) fechafin.getModel().getValue()).getTime());
		Materia aMateria = new Materia();
		aMateria.set_nombre(lblNewLabel.getText());
		aMateria.set_horas(Integer.parseInt((lblNewLabel.getText())));
		aMateria.set_fechaInicio(fechaComienzo);
		aMateria.set_fechaFin(fechaFin);
		JButton btnNewButton = new JButton("Añadir materia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(181, 264, 105, 23);
		panel.add(btnNewButton);
	}
}
