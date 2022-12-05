package presentacion;

import java.awt.event.ActionEvent;

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

public class PantallaJefeGabineteVicerrectorado extends JFrame {
	
	JFrame previousWindow;
	
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
			pestañas.addTab("Consultar ingresos",panel1);
			
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
	
	public void realizarConsulta() {
		GestorConsultas gestor = new GestorConsultas();
		
		
	}
}