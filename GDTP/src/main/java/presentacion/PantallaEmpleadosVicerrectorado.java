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
import javax.swing.JComboBox;

public class PantallaEmpleadosVicerrectorado extends JFrame{
	JFrame previousWindow;
	public PantallaEmpleadosVicerrectorado(JFrame previousWindow) {
		this.previousWindow = previousWindow;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		if (previousWindow != null) {
			
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					previousWindow.setVisible(true);
				}
			});
		}
		setTitle("Pantalla Empleados Vicerrectorado");
		setBounds(100, 100, 610, 547);
		setResizable(false);
		getContentPane().setLayout(new CardLayout(0, 0));
		JTabbedPane pestañas=new JTabbedPane();
		getContentPane().add(pestañas, "name_001");
		
		JPanel panel1 = new JPanel();
		pestañas.addTab("Evaluar propuesta",panel1);
		
		JButton listarPopuestasBtn = new JButton("Listar propuestas");
		listarPopuestasBtn.setBounds(0, 2, 593, 60);
		

		listarPopuestasBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel1.setLayout(null);
		panel1.add(listarPopuestasBtn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 62, 593, 60);
		panel1.add(comboBox);
		
		JButton btnNewButton = new JButton("Aprobar seleccionadas");
		btnNewButton.setBounds(212, 450, 169, 23);
		panel1.add(btnNewButton);
		
		
	}

	
	private static final long serialVersionUID = -573691530275935302L;
	

	public void evaluarCurso() {
		CursoPropio curso = new CursoPropio();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaEmpleadosVicerrectorado frame = new PantallaEmpleadosVicerrectorado(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}