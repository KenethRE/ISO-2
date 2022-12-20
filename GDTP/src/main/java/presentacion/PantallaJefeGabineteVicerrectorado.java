package presentacion;

import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import negocio.controllers.*;
import negocio.entities.*;
import persistencia.CursoPropioDAO;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

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
		JTabbedPane pestañas = new JTabbedPane();
		getContentPane().add(pestañas, "name_002");

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		pestañas.addTab("Consultar ingresos", panel1);

		// JComboBox TipoCurso Panel1

		JLabel tipoCurso = new JLabel("Tipo de Curso:");
		tipoCurso.setFont(new Font("Tahoma", Font.BOLD, 11));
		tipoCurso.setBounds(10, 11, 200, 14);
		panel1.add(tipoCurso);

		JComboBox<TipoCurso> comboBoxTipoCurso = new JComboBox<TipoCurso>();
		comboBoxTipoCurso.setModel(new DefaultComboBoxModel<TipoCurso>(TipoCurso.values()));
		comboBoxTipoCurso.setBounds(15, 25, 200, 22);
		panel1.add(comboBoxTipoCurso);

		// Date FechaInicio Panel1

		UtilDateModel fInicio1 = new UtilDateModel();
		Properties pInicio1 = new Properties();
		pInicio1.put("text.today", "Hoy");
		pInicio1.put("text.month", "Mes");
		pInicio1.put("text.year", "Año");

		JLabel lblInicio = new JLabel("Fecha Inicio:");
		lblInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInicio.setBounds(10, 50, 200, 14);
		panel1.add(lblInicio);

		JPanel PanelFechaInicio = new JPanel();
		PanelFechaInicio.setBounds(10, 64, 212, 33);
		panel1.add(PanelFechaInicio);
		JDatePanelImpl panelfechainicio = new JDatePanelImpl(fInicio1, pInicio1);
		JDatePickerImpl pickerFechaInicio = new JDatePickerImpl(panelfechainicio, new DateLabelFormatter());
		PanelFechaInicio.add(pickerFechaInicio);

		// Date FechaFin Panel1

		UtilDateModel fFin1 = new UtilDateModel();
		Properties pFin1 = new Properties();
		pFin1.put("text.today", "Hoy");
		pFin1.put("text.month", "Mes");
		pFin1.put("text.year", "Año");

		JPanel PanelFechaFin = new JPanel();
		PanelFechaFin.setBounds(256, 66, 212, 33);
		panel1.add(PanelFechaFin);
		JDatePanelImpl panelfechafin = new JDatePanelImpl(fFin1, pFin1);
		JLabel lblFechaFin = new JLabel("Fecha Finalizacion:");
		lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaFin.setBounds(256, 50, 200, 14);
		panel1.add(lblFechaFin);
		JDatePickerImpl pickerFechaFin = new JDatePickerImpl(panelfechafin, new DateLabelFormatter());
		pickerFechaFin.setBounds(128, 304, 202, 23);
		PanelFechaFin.add(pickerFechaFin);

		// Tabla

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 573, 241);
		panel1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Matriculados", "Ingresos", "idCurso" }));
		scrollPane.setViewportView(table);

		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Nº Matriculados");
		model.addColumn("IngresosTotales");
		model.addColumn("idCurso");
		
		//Button Logout Panel 1
		
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

		// Button ConsultarIngresos Panel1

		JButton btnConsultarIngresos = new JButton("Consultar Ingresos");
		btnConsultarIngresos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PantallaJefeGabineteVicerrectorado.this.fechaComienzo = new java.sql.Date(
							fInicio1.getValue().getTime());
					try {
						PantallaJefeGabineteVicerrectorado.this.fechaFin = new java.sql.Date(
								fFin1.getValue().getTime());
						PantallaJefeGabineteVicerrectorado.this.tipoCurso = (TipoCurso) comboBoxTipoCurso
								.getSelectedItem();

						// Consulta a BBDD

						GestorConsultas gestor = new GestorConsultas();
						List<List<String>> data = new ArrayList<>();
						data = gestor.consultarIngresos(PantallaJefeGabineteVicerrectorado.this.tipoCurso,
								PantallaJefeGabineteVicerrectorado.this.fechaComienzo,
								PantallaJefeGabineteVicerrectorado.this.fechaFin);
						int contador = 0;

						// Colocando el Jpanlel
						for (List<String> ingreso : data) {
							Object[] col = new Object[3];
							col[0] = ingreso.get(0);
							col[1] = ingreso.get(1);
							col[2] = ingreso.get(2);

							model.addRow(col);
							contador++;
						}
						if (contador == 0) {
							Object[] col = new Object[3];
							col[0] = "No";
							col[1] = "hay";
							col[2] = "datos";
							model.addRow(col);
						}

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Campo fecha fin vacío ", "Fecha fin",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Campo fecha inicio vacío ", "Fecha incio",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		panel1.add(btnConsultarIngresos);
		btnConsultarIngresos.setBounds(10, 198, 174, 23);

		JButton btnVaciar = new JButton("Reset");
		btnVaciar.setBounds(210, 198, 99, 23);
		panel1.add(btnVaciar);

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

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		pestañas.addTab("Consultar estado cursos", panel2);

		// JComboBox TipoCurso Panel2

		JLabel tipoCurso2 = new JLabel("Estado de Curso:");
		tipoCurso2.setFont(new Font("Tahoma", Font.BOLD, 11));
		tipoCurso2.setBounds(10, 11, 200, 14);
		panel2.add(tipoCurso2);

		JComboBox<EstadoCurso> comboBoxEstadoCurso = new JComboBox<EstadoCurso>();
		comboBoxEstadoCurso.setModel(new DefaultComboBoxModel<EstadoCurso>(EstadoCurso.values()));
		comboBoxEstadoCurso.setBounds(15, 25, 200, 22);
		panel2.add(comboBoxEstadoCurso);

		// Date FechaInicio Panel2

		UtilDateModel fInicio2 = new UtilDateModel();
		Properties pInicio2 = new Properties();
		pInicio2.put("text.today", "Hoy");
		pInicio2.put("text.month", "Mes");
		pInicio2.put("text.year", "Año");

		JLabel lblFechaInicio2 = new JLabel("Fecha Inicio:");
		lblFechaInicio2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaInicio2.setBounds(10, 50, 200, 14);
		panel2.add(lblFechaInicio2);

		JPanel PanelFechaInicio2 = new JPanel();
		PanelFechaInicio2.setBounds(10, 64, 212, 33);
		panel2.add(PanelFechaInicio2);
		JDatePanelImpl panelfechainicio2 = new JDatePanelImpl(fInicio2, pInicio2);
		JDatePickerImpl pickerFechaInicio2 = new JDatePickerImpl(panelfechainicio2, new DateLabelFormatter());
		PanelFechaInicio2.add(pickerFechaInicio2);

		// Date FechaFin Panel2

		UtilDateModel fFin2 = new UtilDateModel();
		Properties pFin2 = new Properties();
		pFin2.put("text.today", "Hoy");
		pFin2.put("text.month", "Mes");
		pFin2.put("text.year", "Año");

		JPanel PanelFechaFin2 = new JPanel();
		PanelFechaFin2.setBounds(256, 66, 212, 33);
		panel2.add(PanelFechaFin2);

		JDatePanelImpl panelfechafin2 = new JDatePanelImpl(fFin2, pFin2);
		JLabel lblFechaFin2 = new JLabel("Fecha Finalizacion:");
		lblFechaFin2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaFin2.setBounds(256, 50, 200, 14);
		panel2.add(lblFechaFin2);
		JDatePickerImpl pickerFechaFin2 = new JDatePickerImpl(panelfechafin2, new DateLabelFormatter());
		pickerFechaFin2.setBounds(128, 304, 202, 23);
		PanelFechaFin2.add(pickerFechaFin2);

		// Tabla2

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 232, 573, 241);
		panel2.add(scrollPane2);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "Id", "Nombre", "ECTS", "FechaInicio", "FechaFin", "TasaMatriculacion", "Edicion" }));
		scrollPane2.setViewportView(table_1);

		DefaultTableModel model2 = new DefaultTableModel();
		table_1.setModel(model2);
		model2.addColumn("ID");
		model2.addColumn("Nombre");
		model2.addColumn("ECTs");
		model2.addColumn("FechaInicio");
		model2.addColumn("FechaFin");
		model2.addColumn("TasaMatriculacion");
		model2.addColumn("Edicion");
		
		//Button Logout Panel 2
		
				JButton btnLogout2 = new JButton("Logout");
				btnLogout2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						PantallaLogin frame = new PantallaLogin();
						frame.setResizable(false);
						frame.setVisible(true);
						
					}
				});
				btnLogout2.setBounds(494, 11, 89, 23);
				panel2.add(btnLogout2);

		// Boton Reset panel2

		JButton btnVaciar2 = new JButton("Reset");
		btnVaciar2.setBounds(210, 198, 99, 23);
		panel2.add(btnVaciar2);

		btnVaciar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
					int filas = table_1.getRowCount();
					for (int i = 0; filas > i; i++) {
						modelo.removeRow(0);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
				}

			}
		});

		// Botón ConsultarEstados Panel2

		JButton btnConsultarEstados = new JButton("Consultar Estados");
		btnConsultarEstados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PantallaJefeGabineteVicerrectorado.this.fechaComienzo = new java.sql.Date(
							fInicio2.getValue().getTime());
					try {
						PantallaJefeGabineteVicerrectorado.this.fechaFin = new java.sql.Date(
								fFin2.getValue().getTime());
						PantallaJefeGabineteVicerrectorado.this.estadoCurso = (EstadoCurso) comboBoxEstadoCurso
								.getSelectedItem();

						// consultarEstadoCurso
						GestorConsultas gestor = new GestorConsultas();
						List<CursoPropio> data = new ArrayList<CursoPropio>();
						data = gestor.consultarEstadoCursos(estadoCurso, fechaComienzo, fechaFin);
						int contador = 0;

						// Jpanlel
						for (CursoPropio curso : data) {
							Object[] col = new Object[7];
							col[0] = curso.get_id();
							col[1] = curso.get_nombre();
							col[2] = curso.get_eCTS();
							col[3] = curso.get_fechaInicio();
							col[4] = curso.get_fechaFin();
							col[5] = curso.get_tasaMatricula();
							col[6] = curso.get_edicion();

							model2.addRow(col);
							contador++;
						}
						if (contador == 0) {
							Object[] col = new Object[7];
							col[0] = "No";
							col[1] = "hay";
							col[2] = "datos";
							model2.addRow(col);
						}

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Campo fecha fin vacío ", "Fecha fin",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Campo fecha inicio vacío ", "Fecha incio",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		btnConsultarEstados.setBounds(10, 198, 174, 23);
		panel2.add(btnConsultarEstados);

		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		pestañas.addTab("Listar ediciones", panel3);

		// Date FechaInicio Panel3

		UtilDateModel fInicio3 = new UtilDateModel();
		Properties pInicio3 = new Properties();
		pFin2.put("text.today", "Hoy");
		pFin2.put("text.month", "Mes");
		pFin2.put("text.year", "Año");

		JLabel lblFechaInicio3 = new JLabel("Fecha Inicio:");
		lblFechaInicio3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaInicio3.setBounds(10, 11, 200, 14);
		panel3.add(lblFechaInicio3);

		JPanel PanelFechaInicio3 = new JPanel();
		PanelFechaInicio3.setBounds(10, 25, 212, 33);
		panel3.add(PanelFechaInicio3);
		JDatePanelImpl panelfechainicio3 = new JDatePanelImpl(fInicio3, pInicio3);
		JDatePickerImpl pickerFechaInicio3 = new JDatePickerImpl(panelfechainicio3, new DateLabelFormatter());
		PanelFechaInicio3.add(pickerFechaInicio3);

		// Date FechaFin Panel3

		UtilDateModel fFin3 = new UtilDateModel();
		Properties pFin3 = new Properties();
		pFin3.put("text.today", "Hoy");
		pFin3.put("text.month", "Mes");
		pFin3.put("text.year", "Año");

		JPanel PanelFechaFin3 = new JPanel();
		PanelFechaFin3.setBounds(256, 25, 212, 33);
		panel3.add(PanelFechaFin3);

		JDatePanelImpl panelfechafin3 = new JDatePanelImpl(fFin3, pFin3);
		JLabel lblFechaFin3 = new JLabel("Fecha Finalizacion:");
		lblFechaFin3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaFin3.setBounds(256, 11, 200, 14);
		panel3.add(lblFechaFin3);
		JDatePickerImpl pickerFechaFin3 = new JDatePickerImpl(panelfechafin3, new DateLabelFormatter());
		pickerFechaFin3.setBounds(128, 304, 202, 23);
		PanelFechaFin3.add(pickerFechaFin3);

		// Tabla 3

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 153, 573, 320);
		panel3.add(scrollPane_1);

		table_3 = new JTable();

		table_3.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "Id", "Nombre", "ECTS", "FechaInicio", "FechaFin", "TasaMatriculacion", "Edicion" }));

		scrollPane_1.setViewportView(table_3);

		DefaultTableModel model3 = new DefaultTableModel();
		table_3.setModel(model3);
		model3.addColumn("ID");
		model3.addColumn("Nombre");
		model3.addColumn("ECTs");
		model3.addColumn("FechaInicio");
		model3.addColumn("FechaFin");
		model3.addColumn("TasaMatriculacion");
		model3.addColumn("Edicion");

		//Button Logout Panel 3
		
				JButton btnLogout3 = new JButton("Logout");
				btnLogout3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						PantallaLogin frame = new PantallaLogin();
						frame.setResizable(false);
						frame.setVisible(true);
						
					}
				});
				btnLogout3.setBounds(494, 11, 89, 23);
				panel3.add(btnLogout3);
		
		// Botón ListarEdiciones Panel3

		JButton btnListarEdiciones = new JButton("Listar Ediciones");
		btnListarEdiciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PantallaJefeGabineteVicerrectorado.this.fechaComienzo = new java.sql.Date(
							fInicio3.getValue().getTime());
					try {
						PantallaJefeGabineteVicerrectorado.this.fechaFin = new java.sql.Date(
								fFin3.getValue().getTime());

						// Consulta a BBDD
						GestorConsultas gestor = new GestorConsultas();
						List<CursoPropio> data = new ArrayList<CursoPropio>();
						data = gestor.listarEdicionesCursos(fechaComienzo, fechaFin);
						int contador = 0;

						// Jpanlel
						for (CursoPropio curso : data) {
							Object[] col = new Object[7];
							col[0] = curso.get_id();
							col[1] = curso.get_nombre();
							col[2] = curso.get_eCTS();
							col[3] = curso.get_fechaInicio();
							col[4] = curso.get_fechaFin();
							col[5] = curso.get_tasaMatricula();
							col[6] = curso.get_edicion();

							model3.addRow(col);
							contador++;
						}
						if (contador == 0) {
							Object[] col = new Object[7];
							col[0] = "No";
							col[1] = "hay";
							col[2] = "datos";
							model3.addRow(col);
						}

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Campo fecha fin vacío ", "Fecha fin",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Campo fecha inicio vacío ", "Fecha incio",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		btnListarEdiciones.setBounds(20, 99, 174, 23);
		panel3.add(btnListarEdiciones);

		// Boton Reset

		JButton btnVaciar3 = new JButton("Reset");
		btnVaciar3.setSize(143, 23);
		btnVaciar3.setLocation(263, 99);
		btnVaciar2.setBounds(210, 198, 99, 23);
		panel3.add(btnVaciar3);

		btnVaciar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo = (DefaultTableModel) table_3.getModel();
					int filas = table_3.getRowCount();
					for (int i = 0; filas > i; i++) {
						modelo.removeRow(0);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
				}

			}
		});

	}

	private static final long serialVersionUID = -3497561384085455302L;

	private JTable table;
	private JTable table_1;
	private JTable table_3;

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