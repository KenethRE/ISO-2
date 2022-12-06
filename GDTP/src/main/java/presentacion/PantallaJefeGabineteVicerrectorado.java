package presentacion;

import org.apache.derby.iapi.sql.dictionary.TupleDescriptor;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import negocio.controllers.*;
import negocio.entities.*;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class PantallaJefeGabineteVicerrectorado extends JFrame {
	
	JFrame previousWindow;
	Date fechaComienzo;
	Date fechaFin;
	TipoCurso tipoCurso;
	GestorConsultas GestorConsultas = new GestorConsultas();
	
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	public PantallaJefeGabineteVicerrectorado(JFrame previousWindow) {

			this.previousWindow = previousWindow;
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			if (previousWindow != null) {
				
				this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						previousWindow.setVisible(true);
					}
				});
			}
			setTitle("Pantalla Jefe Gabinete Vicerrectorado");
			setBounds(100, 100, 610, 547);
			setResizable(false);
			getContentPane().setLayout(new CardLayout(0, 0));
			JTabbedPane pestañas=new JTabbedPane();
			getContentPane().add(pestañas, "name_002");
			
			
			UtilDateModel model1 = new UtilDateModel();
			Properties propiedadesfecha = new Properties();
			propiedadesfecha.put("text.today","Hoy");
			propiedadesfecha.put("text.month","Mes");
			propiedadesfecha.put("text.year","Año");
			
			
			
			JPanel panel1 = new JPanel();
			panel1.setLayout(null);
			pestañas.addTab("Consultar ingresos", panel1);
			
				
				
			
			
			JLabel lblNewLabel = new JLabel("Tipo de Curso:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setBounds(10, 11, 89, 14);
			panel1.add(lblNewLabel);
			
			JComboBox<TipoCurso> comboBoxTipoCurso = new JComboBox<TipoCurso>();
			comboBoxTipoCurso.setModel(new DefaultComboBoxModel<TipoCurso>(TipoCurso.values()));
			comboBoxTipoCurso.setBounds(10, 25, 200, 22);
			panel1.add(comboBoxTipoCurso);
			
			JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
			lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFechaInicio.setBounds(10, 50, 200, 14);
			panel1.add(lblFechaInicio);
		
			JPanel PanelFechaInicio = new JPanel();
			PanelFechaInicio.setBounds(261, 99, 212, 135);
			panel1.add(PanelFechaInicio);
			JDatePanelImpl panelfechainicio = new JDatePanelImpl(model1, propiedadesfecha);
			JDatePickerImpl pickerFechaInicio = new JDatePickerImpl(panelfechainicio, new DateLabelFormatter());
			PanelFechaInicio.add(pickerFechaInicio);
			
			
			JPanel PanelFechaFin = new JPanel();
			PanelFechaFin.setBounds(256, 66, 212, 135);
			PanelFechaInicio.setBounds(10, 64, 212, 135);
			panel1.add(PanelFechaFin);
			UtilDateModel model2 = new UtilDateModel();
			JDatePanelImpl panelfechafin = new JDatePanelImpl(model2,propiedadesfecha);
			JLabel lblFechaFin = new JLabel("Fecha Finalizacion:");
			lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFechaFin.setBounds(256, 50, 200, 14);
			panel1.add(lblFechaFin);
			JDatePickerImpl pickerFechaFin = new JDatePickerImpl(panelfechafin, new DateLabelFormatter());
			pickerFechaFin.setBounds(128, 304, 202, 23);
			PanelFechaFin.add(pickerFechaFin);
			
			
			
			
			JPanel panelMostrarResultadosConsulta = new JPanel();
			panelMostrarResultadosConsulta.setBounds(10, 229, 569, 240);
			panel1.add(panelMostrarResultadosConsulta);
			panelMostrarResultadosConsulta.setLayout(null);
			
			table = new JTable();
			table.setBounds(157, 107, 150, 64);
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"Nombre del Curso", "Cantidad de Matriculados"
				}
			));
			panelMostrarResultadosConsulta.add(table);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setBounds(160, 40, 150, 14);
			panelMostrarResultadosConsulta.add(lblNewLabel_1);
			
			
			JButton btnConsultarIngresos = new JButton("Consultar Ingresos");
			btnConsultarIngresos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PantallaJefeGabineteVicerrectorado.this.fechaComienzo = new java.sql.Date(model1.getValue().getTime());
					PantallaJefeGabineteVicerrectorado.this.fechaFin = new java.sql.Date(model2.getValue().getTime());
					PantallaJefeGabineteVicerrectorado.this.tipoCurso = (TipoCurso) comboBoxTipoCurso.getSelectedItem();
					
					
				}
			});
			
			btnConsultarIngresos.setBounds(426, 25, 123, 23);
			panel1.add(btnConsultarIngresos);
			
			JPanel panel2 = new JPanel();
			panel2.setLayout(null);
			pestañas.addTab("Consultar estado cursos",panel2);
			
			JPanel panel3 = new JPanel();
			panel3.setLayout(null);
			pestañas.addTab("Listar ediciones",panel3);
		
	}

	private static final long serialVersionUID = -3497561384085455302L;
	
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
	private JTable table;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaJefeGabineteVicerrectorado frame = new PantallaJefeGabineteVicerrectorado(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}