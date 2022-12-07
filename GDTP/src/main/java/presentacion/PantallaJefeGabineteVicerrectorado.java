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
import javax.swing.JOptionPane;
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
	EstadoCurso estadoCurso;
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
			
				
				
			//JComboBox TipoCurso Panel1
			
			JLabel tipoCurso = new JLabel("Tipo de Curso:");
			tipoCurso.setFont(new Font("Tahoma", Font.BOLD, 11));
			tipoCurso.setBounds(10, 11, 200, 14);
			panel1.add(tipoCurso);
			
			JComboBox<TipoCurso> comboBoxTipoCurso = new JComboBox<TipoCurso>();
			comboBoxTipoCurso.setModel(new DefaultComboBoxModel<TipoCurso>(TipoCurso.values()));
			comboBoxTipoCurso.setBounds(15, 25, 200, 22);
			panel1.add(comboBoxTipoCurso);
			
			//Date FechaInicio Panel1
			
			JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
			lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFechaInicio.setBounds(10, 50, 200, 14);
			panel1.add(lblFechaInicio);
		
			JPanel PanelFechaInicio = new JPanel();
			PanelFechaInicio.setBounds(10, 64, 212, 33);
			panel1.add(PanelFechaInicio);
			JDatePanelImpl panelfechainicio = new JDatePanelImpl(model1, propiedadesfecha);
			JDatePickerImpl pickerFechaInicio = new JDatePickerImpl(panelfechainicio, new DateLabelFormatter());
			PanelFechaInicio.add(pickerFechaInicio);
			
			//Date FechaFin Panel1
			
			JPanel PanelFechaFin = new JPanel();
			PanelFechaFin.setBounds(256, 66, 212, 33);
			panel1.add(PanelFechaFin);
			JDatePanelImpl panelfechafin = new JDatePanelImpl(model1,propiedadesfecha);
			JLabel lblFechaFin = new JLabel("Fecha Finalizacion:");
			lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFechaFin.setBounds(256, 50, 200, 14);
			panel1.add(lblFechaFin);
			JDatePickerImpl pickerFechaFin = new JDatePickerImpl(panelfechafin, new DateLabelFormatter());
			pickerFechaFin.setBounds(128, 304, 202, 23);
			PanelFechaFin.add(pickerFechaFin);
			
			JPanel panelMostrarResultadosConsulta = new JPanel();
			panelMostrarResultadosConsulta.setBounds(10, 268, 569, 201);
			panel1.add(panelMostrarResultadosConsulta);
			panelMostrarResultadosConsulta.setLayout(null);
			
			JList list = new JList();
			list.setBounds(0, 69, 569, 51);
			panelMostrarResultadosConsulta.add(list);
			
			//Botón ConsultarIngresos Panel1
			
			JButton btnConsultarIngresos = new JButton("Consultar Ingresos");
			btnConsultarIngresos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						PantallaJefeGabineteVicerrectorado.this.fechaComienzo = new java.sql.Date(model1.getValue().getTime());
					}
					catch(Exception ex) {
						 JOptionPane.showMessageDialog(null, "Campo fecha inicio vacío ", "Fecha incio", JOptionPane.INFORMATION_MESSAGE);
					}
					try {
						PantallaJefeGabineteVicerrectorado.this.fechaFin = new java.sql.Date(model1.getValue().getTime());
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Campo fecha fin vacío ", "Fecha fin", JOptionPane.INFORMATION_MESSAGE);
					}
			
					PantallaJefeGabineteVicerrectorado.this.tipoCurso = (TipoCurso) comboBoxTipoCurso.getSelectedItem();
					
					
				}
			});
			
			btnConsultarIngresos.setBounds(36, 219, 174, 23);
			panel1.add(btnConsultarIngresos);
			
			JPanel panel2 = new JPanel();
			panel2.setLayout(null);
			pestañas.addTab("Consultar estado cursos",panel2);
			
			//JComboBox TipoCurso Panel2
			
			JLabel tipoCurso2 = new JLabel("Estado de Curso:");
			tipoCurso2.setFont(new Font("Tahoma", Font.BOLD, 11));
			tipoCurso2.setBounds(10, 11, 200, 14);
			panel2.add(tipoCurso2);
			
			JComboBox<EstadoCurso> comboBoxTipoCurso2 = new JComboBox<EstadoCurso>();
			comboBoxTipoCurso2.setModel(new DefaultComboBoxModel<EstadoCurso>(EstadoCurso.values()));
			comboBoxTipoCurso2.setBounds(15, 25, 200, 22);
			panel2.add(comboBoxTipoCurso2);
			
			//Date FechaInicio Panel2
			
			UtilDateModel model2 = new UtilDateModel();
			JLabel lblFechaInicio2 = new JLabel("Fecha Inicio:");
			lblFechaInicio2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFechaInicio2.setBounds(10, 50, 200, 14);
			panel2.add(lblFechaInicio2);
		
			JPanel PanelFechaInicio2 = new JPanel();
			PanelFechaInicio2.setBounds(10, 64, 212, 33);
			panel2.add(PanelFechaInicio2);
			JDatePanelImpl panelfechainicio2 = new JDatePanelImpl(model2, propiedadesfecha);
			JDatePickerImpl pickerFechaInicio2 = new JDatePickerImpl(panelfechainicio2, new DateLabelFormatter());
			PanelFechaInicio2.add(pickerFechaInicio2);
			
			//Date FechaFin Panel2
			
			JPanel PanelFechaFin2 = new JPanel();
			PanelFechaFin2.setBounds(256, 66, 212, 33);
			panel2.add(PanelFechaFin2);
			
			JDatePanelImpl panelfechafin2 = new JDatePanelImpl(model2,propiedadesfecha);
			JLabel lblFechaFin2 = new JLabel("Fecha Finalizacion:");
			lblFechaFin2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFechaFin2.setBounds(256, 50, 200, 14);
			panel2.add(lblFechaFin2);
			JDatePickerImpl pickerFechaFin2 = new JDatePickerImpl(panelfechafin2, new DateLabelFormatter());
			pickerFechaFin2.setBounds(128, 304, 202, 23);
			PanelFechaFin2.add(pickerFechaFin2);
			
			//Botón ConsultarEstados Panel2
			
			JButton btnConsultarEstados = new JButton("Consultar Estados");
			btnConsultarEstados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						PantallaJefeGabineteVicerrectorado.this.fechaComienzo = new java.sql.Date(model2.getValue().getTime());
					}
					catch(Exception ex) {
						 JOptionPane.showMessageDialog(null, "Campo fecha inicio vacío ", "Fecha incio", JOptionPane.INFORMATION_MESSAGE);
					}
					try {
						PantallaJefeGabineteVicerrectorado.this.fechaFin = new java.sql.Date(model2.getValue().getTime());
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Campo fecha fin vacío ", "Fecha fin", JOptionPane.INFORMATION_MESSAGE);
					}
			
					PantallaJefeGabineteVicerrectorado.this.estadoCurso = (EstadoCurso) comboBoxTipoCurso.getSelectedItem();
					
					
				}
			});
			
			btnConsultarEstados.setBounds(36, 219, 174, 23);
			panel2.add(btnConsultarEstados);
			
			
			JPanel panel3 = new JPanel();
			panel3.setLayout(null);
			pestañas.addTab("Listar ediciones",panel3);
			
			//Date FechaInicio Panel3
			
			UtilDateModel model3 = new UtilDateModel();
			JLabel lblFechaInicio3 = new JLabel("Fecha Inicio:");
			lblFechaInicio3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFechaInicio3.setBounds(10, 11, 200, 14);
			panel3.add(lblFechaInicio3);
		
			JPanel PanelFechaInicio3 = new JPanel();
			PanelFechaInicio3.setBounds(10, 25, 212, 33);
			panel3.add(PanelFechaInicio3);
			JDatePanelImpl panelfechainicio3 = new JDatePanelImpl(model3, propiedadesfecha);
			JDatePickerImpl pickerFechaInicio3 = new JDatePickerImpl(panelfechainicio3, new DateLabelFormatter());
			PanelFechaInicio3.add(pickerFechaInicio3);
			
			//Date FechaFin Panel3
			
			JPanel PanelFechaFin3= new JPanel();
			PanelFechaFin3.setBounds(256, 25, 212, 33);
			panel3.add(PanelFechaFin3);
			
			JDatePanelImpl panelfechafin3 = new JDatePanelImpl(model3,propiedadesfecha);
			JLabel lblFechaFin3 = new JLabel("Fecha Finalizacion:");
			lblFechaFin3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFechaFin3.setBounds(256, 11, 200, 14);
			panel3.add(lblFechaFin3);
			JDatePickerImpl pickerFechaFin3 = new JDatePickerImpl(panelfechafin3, new DateLabelFormatter());
			pickerFechaFin3.setBounds(128, 304, 202, 23);
			PanelFechaFin3.add(pickerFechaFin3);
			
			//Botón ListarEdiciones Panel3
			
			JButton btnListarEdiciones = new JButton("Listar Ediciones");
			btnListarEdiciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						PantallaJefeGabineteVicerrectorado.this.fechaComienzo = new java.sql.Date(model3.getValue().getTime());
					}
					catch(Exception ex) {
						 JOptionPane.showMessageDialog(null, "Campo fecha inicio vacío ", "Fecha incio", JOptionPane.INFORMATION_MESSAGE);
					}
					try {
						PantallaJefeGabineteVicerrectorado.this.fechaFin = new java.sql.Date(model3.getValue().getTime());
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Campo fecha fin vacío ", "Fecha fin", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
			});
			
			btnListarEdiciones.setBounds(26, 179, 174, 23);
			panel3.add(btnListarEdiciones);
		
	}

	private static final long serialVersionUID = -3497561384085455302L;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	
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