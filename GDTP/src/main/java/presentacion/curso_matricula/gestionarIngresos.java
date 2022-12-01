package presentacion.curso_matricula;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.LoginPrueba.ServiciosAdmin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionarIngresos extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCurso;
	private JTextField textTipo;
	private JTextField textFechaI;
	private JTextField textFechaF;
	private JTextField textTasa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionarIngresos frame = new gestionarIngresos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gestionarIngresos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 16));
		lblNewLabel.setBounds(53, 82, 102, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 16));
		lblCurso.setBounds(53, 136, 102, 14);
		contentPane.add(lblCurso);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 16));
		lblTipo.setBounds(53, 190, 102, 14);
		contentPane.add(lblTipo);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 16));
		lblFechaInicio.setBounds(53, 245, 102, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 16));
		lblFechaFin.setBounds(53, 302, 102, 14);
		contentPane.add(lblFechaFin);
		
		JLabel lblTasaIngreso = new JLabel("Tasa ingreso");
		lblTasaIngreso.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 16));
		lblTasaIngreso.setBounds(53, 360, 102, 14);
		contentPane.add(lblTasaIngreso);
		
		JLabel lblGestion = new JLabel("Gestion");
		lblGestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestion.setFont(new Font("Verdana Pro Cond", Font.BOLD, 21));
		lblGestion.setBounds(188, 11, 144, 38);
		contentPane.add(lblGestion);
		
		textNombre = new JTextField();
		textNombre.setBounds(144, 82, 312, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textCurso = new JTextField();
		textCurso.setColumns(10);
		textCurso.setBounds(144, 130, 312, 20);
		contentPane.add(textCurso);
		
		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBounds(144, 190, 312, 20);
		contentPane.add(textTipo);
		
		textFechaI = new JTextField();
		textFechaI.setColumns(10);
		textFechaI.setBounds(144, 245, 312, 20);
		contentPane.add(textFechaI);
		
		textFechaF = new JTextField();
		textFechaF.setColumns(10);
		textFechaF.setBounds(144, 302, 312, 20);
		contentPane.add(textFechaF);
		
		textTasa = new JTextField();
		textTasa.setColumns(10);
		textTasa.setBounds(144, 360, 312, 20);
		contentPane.add(textTasa);
		
		JButton btnGestionar = new JButton("Gestionar");
		btnGestionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textNombre.getText().length() != 0) && (textCurso.getText().length() != 0) && (textTipo.getText().length() != 0)
						&& (textFechaI.getText().length() != 0) && (textFechaF.getText().length() != 0)&& (textTasa.getText().length() != 0)) {
					dispose();
					JOptionPane.showMessageDialog(null, "Gestion correcta", "INGRESO CORRECTO", 
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Gestion incorrecta", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textNombre.setText("");
					textCurso.setText("");
					textTipo.setText("");
					textFechaI.setText("");
					textFechaF.setText("");
					textTasa.requestFocus();
				}
			}
		});
		btnGestionar.setBounds(224, 453, 108, 38);
		contentPane.add(btnGestionar);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiciosAdmin servicios = new ServiciosAdmin();
				servicios.setVisible(true);
			}
		});
		btnNewButton.setBounds(462, 0, 89, 23);
		contentPane.add(btnNewButton);
	}
}
