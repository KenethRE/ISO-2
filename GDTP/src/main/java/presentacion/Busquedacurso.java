package presentacion;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.derby.iapi.sql.dictionary.FileInfoDescriptor;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Profesor;
import persistencia.CursoPropioDAO;
import persistencia.ProfesorDAO;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Busquedacurso extends JFrame{
	
	private JPanel contentPane;
	Date fechaComienzo;
	Date fechaFin;
	private DefaultListModel modelo;
	private Matriculacion ventanMatricula;
	DefaultListModel<CursoPropio> modelocursos = new DefaultListModel<CursoPropio>();

	private JFrame frame;
	private CursoPropioDAO<CursoPropio> agenteCursoPropioDAO = new CursoPropioDAO();
	
	public Busquedacurso(JFrame previousWindow) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		if (previousWindow != null) {
			
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					previousWindow.setVisible(true);
				}
			});
			this.ventanMatricula= (Matriculacion) previousWindow;
		}
		setBounds(100, 100, 647, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Properties propiedadesfecha = new Properties();
		propiedadesfecha.put("text.today","Hoy");
		propiedadesfecha.put("text.month","Mes");
		propiedadesfecha.put("text.year","Año");
		JDatePanelImpl panelfecha = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePickerImpl fecha = new JDatePickerImpl(panelfecha,new DateLabelFormatter());
		fecha.setBounds(21, 173, 134, 101);
		JPanel PanelFecha= new JPanel();
		PanelFecha.setBounds(36, 56, 212, 130);
		contentPane.add(PanelFecha);
		PanelFecha.add(fecha);
		
		JDatePanelImpl panelfecha2 = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePickerImpl fecha2 = new JDatePickerImpl(panelfecha2,new DateLabelFormatter());
		fecha2.setBounds(30, 173, 134, 101);
		JPanel PanelFecha2= new JPanel();
		PanelFecha2.setBounds(331, 56, 212, 130);
		contentPane.add(PanelFecha2);
		PanelFecha2.add(fecha2);
		
		JLabel lblNewLabel = new JLabel("Fecha inicio curso");
		lblNewLabel.setBounds(26, 31, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha fin curso");
		lblNewLabel_1.setBounds(337, 31, 88, 14);
		contentPane.add(lblNewLabel_1);
		JList <CursoPropio> listacursos = new JList<CursoPropio> ();
		
		JButton btnNewButton_1 = new JButton("Seleccionar Curso");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursoPropio cursoPropio;
				cursoPropio = (CursoPropio) listacursos.getSelectedValue();
				ventanMatricula.setcursopropio(cursoPropio);
			dispose();
			}
		});
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(62, 285, 125, 23);
		contentPane.add(btnNewButton_1);
		
		
		listacursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listacursos.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnNewButton_1.setEnabled(true);
				
			}
		});
		listacursos.setBounds(225, 197, 200, 164);
		listacursos.setModel(modelocursos);
		contentPane.add(listacursos);
		
		
		JButton btnNewButton = new JButton("Buscar Curso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fecha.getModel().getValue()==null || fecha2.getModel().getValue()==null) {
					JOptionPane.showMessageDialog(null, "debe elegir dos fecha",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					fechaComienzo = new java.sql.Date(((java.util.Date) fecha.getModel().getValue()).getTime());
					fechaFin = new java.sql.Date(((java.util.Date) fecha2.getModel().getValue()).getTime());
					if(fechaFin.before(fechaComienzo)) {
						JOptionPane.showMessageDialog(null, "Rango de fechas incorrecto "
								+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else {
						List<CursoPropio> Cursos = new ArrayList<CursoPropio>();
						try {
							Cursos = agenteCursoPropioDAO.listarCursosPorEstado(EstadoCurso.PROPUESTO, fechaComienzo,fechaFin);
							for (int i=0; i<Cursos.size();i++) {
								modelocursos.addElement(Cursos.get(i));
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Cursos no encontrados "
									+ "intentelo nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}

				}
				
				
			}
		});
		btnNewButton.setBounds(62, 233, 125, 23);
		contentPane.add(btnNewButton);
		
		
	}

}
