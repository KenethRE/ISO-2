package presentacion;

import java.awt.event.ActionEvent;
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
import javax.swing.JLabel;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

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
		setBounds(100, 100, 943, 610);
		setResizable(false);
		getContentPane().setLayout(new CardLayout(0, 0));
		JTabbedPane pestañas=new JTabbedPane();
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		pestañas.addTab("Alta Curso",panel1);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 38, 49, 14);
		panel1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(69, 35, 185, 20);
		panel1.add(textField);
		textField.setColumns(10);
		getContentPane().add(pestañas, "name_26133981429000");
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(25, 320, 59, 14);
		Properties propiedadesfecha = new Properties();
		propiedadesfecha.put("text.today","Hoy");
		propiedadesfecha.put("text.month","Mes");
		propiedadesfecha.put("text.year","Año");
	
		JDatePanelImpl panelfechainicio = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePickerImpl fechainicio = new JDatePickerImpl(panelfechainicio,new DateLabelFormatter());
		fechainicio.setBounds(52, 262, 134, 101);
		JDatePanelImpl panelfechafin = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePickerImpl fechafin = new JDatePickerImpl(panelfechafin,new DateLabelFormatter());
		fechafin.setBounds(263, 262, 134, 101);
		panel1.add(fechainicio);
		panel1.add(fechafin);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
		lblNewLabel_1.setBounds(61, 237, 93, 14);
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Fin");
		lblNewLabel_2.setBounds(262, 237, 49, 14);
		panel1.add(lblNewLabel_2);
		JPanel panel = new JPanel();
		pestañas.addTab("Editar Curso", null, panel, null);
		
		
		
	}

	
	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField textField;

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