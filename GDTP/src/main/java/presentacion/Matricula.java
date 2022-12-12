package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

import javax.swing.JCheckBox;
import javax.swing.JList;

public class Matricula extends JFrame {
	JFrame previousWindow;
	private static final long serialVersionUID = -7592567473508560622L;
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	public Matricula(JFrame previousWindow){
		this.previousWindow = previousWindow;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 670, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matricula");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(127, 21, 228, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Alumno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(25, 80, 138, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dni");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(24, 127, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(25, 169, 82, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Apellidos");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(25, 216, 103, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Titulacion");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(25, 266, 82, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Cualificacion");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(24, 309, 83, 14);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Datos Matricula");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(361, 70, 140, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Fecha matriculacion");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1.setBounds(351, 112, 147, 14);
		contentPane.add(lblNewLabel_2_4_1);
		
		JButton btnNewButton = new JButton("Realizar pago");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarPago pago = new RealizarPago(previousWindow);
				pago.setVisible(true);
			}
		});
		btnNewButton.setBounds(64, 432, 216, 48);
		contentPane.add(btnNewButton);
		
		txtDni = new JTextField();
		txtDni.setBounds(109, 126, 196, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 168, 196, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 215, 196, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(109, 265, 196, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(109, 308, 196, 20);
		contentPane.add(textField_4);
		Properties propiedadesfecha = new Properties();
		propiedadesfecha.put("text.today","Hoy");
		propiedadesfecha.put("text.month","Mes");
		propiedadesfecha.put("text.year","Año");
		JDatePanelImpl panelfecha = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePickerImpl fecha = new JDatePickerImpl(panelfecha,new DateLabelFormatter());
		fecha.setBounds(21, 173, 134, 101);
		JPanel PanelFecha= new JPanel();
		PanelFecha.setBounds(351, 137, 222, 116);
		contentPane.add(PanelFecha);
		PanelFecha.add(fecha);
		fecha.getModel().setDate(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth());
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(546, 21, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Pagado");
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setBounds(310, 445, 72, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton_2 = new JButton("Finalizar Matricula");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(402, 432, 233, 48);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscar Curso");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busquedacurso busqueda = new Busquedacurso(previousWindow);
				busqueda.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(402, 283, 138, 34);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setBounds(409, 361, 147, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Curso seleccionado");
		lblNewLabel_3.setBounds(412, 335, 114, 14);
		contentPane.add(lblNewLabel_3);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Matricula frame = new  Matricula(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
