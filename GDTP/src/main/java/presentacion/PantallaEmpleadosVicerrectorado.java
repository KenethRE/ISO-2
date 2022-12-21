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

public class PantallaEmpleadosVicerrectorado extends JFrame {
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
		JTabbedPane pestañas = new JTabbedPane();
		getContentPane().add(pestañas, "name_001");
		
		JPanel panel1 = new JPanel();
		pestañas.addTab("Evaluar propuesta", panel1);
		panel1.setLayout(null);
		
		//Button Logout
		
		JButton btnLogout1 = new JButton("Logout");
		btnLogout1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaLogin frame = new PantallaLogin();
				frame.setResizable(false);
				frame.setVisible(true);
				
			}
		});
		btnLogout1.setBounds(494, 11, 89, 23);
		panel1.add(btnLogout1);

		// Jlist

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 573, 375);
		panel1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "Id", "Nombre", "ECTS", "FechaInicio", "FechaFin", "TasaMatriculacion", "Edicion" }));
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

		JButton btnVaciar = new JButton("Reset");
		btnVaciar.setBounds(464, 60, 99, 23);
		panel1.add(btnVaciar);
		btnVaciar.setVisible(false);
		
		JButton btnEvaluarPropuesta = new JButton("Evaluar propuesta");
		btnEvaluarPropuesta.setBounds(248, 60, 170, 23);
		panel1.add(btnEvaluarPropuesta);
		btnEvaluarPropuesta.setVisible(false);
		
		JComboBox cbEstadoCurso = new JComboBox();
		cbEstadoCurso.setBounds(248, 26, 170, 22);
		panel1.add(cbEstadoCurso);
		cbEstadoCurso.setVisible(false);
	
		cbEstadoCurso.addItem(EstadoCurso.EN_MATRICULACION);
		cbEstadoCurso.addItem(EstadoCurso.EN_IMPARTIZICION);
		cbEstadoCurso.addItem(EstadoCurso.TERMINADO);
		cbEstadoCurso.addItem(EstadoCurso.PROPUESTA_RECHAZADA);
		cbEstadoCurso.addItem(EstadoCurso.TERMINADO);
		cbEstadoCurso.addItem(EstadoCurso.VALIDADO);

		JButton btnListarPropuestas = new JButton("Listar propuestas");
		btnListarPropuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<CursoPropio> data = new ArrayList<CursoPropio>();
				GestorPropuestasCursos gestor = new GestorPropuestasCursos();

				// Consulta a BBDD

				data = gestor.listaCursoAprobado();

				// Añadir datos a JTable

				int contador = 0;
				for (CursoPropio curso : data) {
					Object[] col = new Object[7];
					col[0] = curso.get_id();
					col[1] = curso.get_nombre();
					col[2] = curso.get_eCTS();
					col[3] = curso.get_fechaInicio();
					col[4] = curso.get_fechaFin();
					col[5] = curso.get_tasaMatricula();
					col[6] = curso.get_edicion();
					model.addRow(col);
					contador++;
				}
				if (contador == 0) {
					Object[] col = new Object[7];
					col[0] = "No";
					col[1] = "hay";
					col[2] = "datos";
					model.addRow(col);
					btnVaciar.setVisible(false);
					btnEvaluarPropuesta.setVisible(false);
				}

				if (contador == 0) {
					JOptionPane.showMessageDialog(null, "No hay cursos propuestos", "Listar cursos propuestos",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// Activar botones
					btnVaciar.setVisible(true);
					btnEvaluarPropuesta.setVisible(true);
					cbEstadoCurso.setVisible(true);
				}
			}
		});
		btnListarPropuestas.setBounds(29, 26, 149, 23);
		panel1.add(btnListarPropuestas);
		

		btnEvaluarPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Aqui cambiar a curso aprobado

				GestorPropuestasCursos gestor = new GestorPropuestasCursos();
				try {

					String id = ((String) model.getValueAt(table.getSelectedRow(), 0));

					// Consulta a BBDD
					List<CursoPropio> data = new ArrayList<CursoPropio>();
					data = gestor.listaCursoAprobado();
					for (CursoPropio curso : data) {
						if (id.equals(curso.get_id())) {
							EstadoCurso estado = (EstadoCurso) cbEstadoCurso.getSelectedItem();
							if (gestor.evaluarPropuestaCurso(curso,estado)) {
								JOptionPane.showMessageDialog(null, curso.get_nombre() + " : Propuesta evaluada",
										"Evaluar Propuesta", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Ninguna propuesta evaluada", "Evaluar propuesta",
										JOptionPane.INFORMATION_MESSAGE);
							}

						}
					}
					model.removeRow(table.getSelectedRow());
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ninguna propuesta evaluada", "Evaluar propuesta",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnVaciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					int filas = table.getRowCount();
					for (int i = 0; filas > i; i++) {
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