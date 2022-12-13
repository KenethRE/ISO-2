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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class PantallaEmpleadosVicerrectorado extends JFrame{
	JFrame previousWindow;
	DefaultListModel<CursoPropio> listModel = new DefaultListModel();
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
		panel1.setLayout(null);
		
		//Jlist 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 573, 406);
		panel1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nombre", "ECTS", "FechaInicio", "FechaFin", "TasaMatriculacion", "Edicion"
			}
		));
		scrollPane.setViewportView(table);
		
		
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("ECTs");
		model.addColumn("FechaInicio");
		model.addColumn("FechaFin");
		model.addColumn("TasaMatriculacion");
		model.addColumn("Edicion");	
		
		JButton btnAprobarSel = new JButton("Aprobar curso seleccionado");
		btnAprobarSel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Aqui cambiar a curso aprobado
				
				GestorPropuestasCursos gestor=new GestorPropuestasCursos();
				try {
					
				
				String id =((String)model.getValueAt(table.getSelectedRow(), 0));				
				
				//Consulta a BBDD
				List<CursoPropio> data = new ArrayList<CursoPropio>();
				data =  gestor.listaCursoAprobado();
				for(CursoPropio curso:data) {
					if(id.equals(curso.get_id())) {
						if(gestor.editarPropuestaCurso(curso)) {
							JOptionPane.showMessageDialog(null, curso.get_nombre()+" : Curso aprobado", "Aprobar Cursos", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Ningun curso aprobado", "Aprobar Cursos", JOptionPane.INFORMATION_MESSAGE);
						}	
						
					}
				}
				model.removeRow(table.getSelectedRow());
				}
				
				catch(Exception ex) {
					 JOptionPane.showMessageDialog(null, "Ningun curso seleccionado", "Aprobar curso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		btnAprobarSel.setBounds(212, 26, 203, 23);
		panel1.add(btnAprobarSel);
		btnAprobarSel.setVisible(false);
		
		JButton btnListarPropuestas = new JButton("Listar propuestas");
		btnListarPropuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<CursoPropio> data = new ArrayList<CursoPropio>();
				GestorPropuestasCursos gestor = new GestorPropuestasCursos();
				
				//Consulta a BBDD
				
				data =  gestor.listaCursoAprobado();
				
				//Añadir datos a JTable
				
				int contador=0;
				for(CursoPropio curso : data) {
					Object[] col = new Object[7];
					curso=data.get(contador);
					col[0]=curso.get_id();
					col[1]=curso.get_nombre();
					col[2]=curso.get_eCTS();
					col[3]=curso.get_fechaInicio();
					col[4]=curso.get_fechaFin();
					col[5]=curso.get_tasaMatricula();
					col[6]=curso.get_edicion();
					model.addRow(col);
					contador++;
				}
				if(contador==0) {
					Object[] col = new Object[7];
					col[0]="No";
					col[1]="hay";
					col[2]="datos";
					model.addRow(col);
				}
				
				if(contador==0) {
					JOptionPane.showMessageDialog(null, "No hay cursos propuestos", "Listar cursos propuestos", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					//Activar boton aprobar sel
					btnAprobarSel.setVisible(true);
				}	
			}
		});
		btnListarPropuestas.setBounds(29, 26, 149, 23);
		panel1.add(btnListarPropuestas);
		
		JButton btnVaciar = new JButton("Reset");
		btnVaciar.setBounds(450, 26, 99, 23);
		panel1.add(btnVaciar);
		
		btnVaciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            DefaultTableModel modelo=(DefaultTableModel) table.getModel();
			            int filas=table.getRowCount();
			            for (int i = 0;filas>i; i++) {
			                modelo.removeRow(0);
			            }
			        } catch (Exception ex) {
			            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
			        }
				
			}
		});
	}

	
	private static final long serialVersionUID = -573691530275935302L;
	private JTable table;
	
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