package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Properties;

public class RealizarPago extends JFrame {

	private JPanel contentPane;
	private JTextField txtIban;
	private JTextField txtNombre;
	private JTextField txtNumTargeta;
	Date fechacaducidad;
	private JTextField txtCvv;
	private ButtonGroup bg = new ButtonGroup();

	public RealizarPago(JFrame previousWindow) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			if (previousWindow != null) {
			
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					previousWindow.setVisible(true);
				}
			});
		}
		setBounds(100, 100, 930, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnTransferenciaBancaria = new JRadioButton("Transferencia bancaria");
		
		Properties propiedadesfecha = new Properties();
		propiedadesfecha.put("text.today","Hoy");
		propiedadesfecha.put("text.month","Mes");
		propiedadesfecha.put("text.year","Año");
		JDatePanelImpl panelfecha = new JDatePanelImpl(new UtilDateModel(),propiedadesfecha);
		JDatePickerImpl fecha = new JDatePickerImpl(panelfecha,new DateLabelFormatter());
		fecha.setBounds(21, 173, 134, 101);
		JPanel PanelFecha= new JPanel();
		PanelFecha.setBounds(627, 322, 212, 130);
		contentPane.add(PanelFecha);
		PanelFecha.add(fecha);
		
		JLabel lblNewLabel_1 = new JLabel("IBAN :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(42, 182, 58, 14);
		contentPane.add(lblNewLabel_1);
		bg.add(rdbtnTransferenciaBancaria);
		txtIban = new JTextField();
		txtIban.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtIban.getText().length() > 24)
			    {
			        e.consume();
			    }
			}
		});
		txtIban.setBounds(110, 176, 470, 30);
		contentPane.add(txtIban);
		txtIban.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Titular:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(66, 303, 102, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Numero tarjeta");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(66, 340, 113, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha de caducidad:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(627, 297, 140, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("CVV:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(110, 403, 58, 14);
		contentPane.add(lblNewLabel_1_4);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(187, 297, 316, 30);
		contentPane.add(txtNombre);
		
		txtNumTargeta = new JTextField();
		txtNumTargeta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNumTargeta.getText().length() > 18)
			    {
			        e.consume();
			    }
			}
		});
		txtNumTargeta.setColumns(10);
		txtNumTargeta.setBounds(187, 341, 316, 30);
		contentPane.add(txtNumTargeta);
		
		txtCvv = new JTextField();
		txtCvv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 if(txtCvv.getText().length() >= 3)
				    {
				        e.consume();
				    }
			}
		});
		txtCvv.setColumns(10);
		txtCvv.setBounds(187, 397, 140, 30);
		contentPane.add(txtCvv);
		txtNombre.setVisible(false);
		txtNumTargeta.setVisible(false);
		txtCvv.setVisible(false);;
		txtNombre.setText("");
		txtNumTargeta.setText("");
		txtCvv.setText("");
		PanelFecha.setVisible(false);
		
		rdbtnTransferenciaBancaria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombre.setVisible(false);
				txtNumTargeta.setVisible(false);
				txtCvv.setVisible(false);;
				txtNombre.setText("");
				txtNumTargeta.setText("");
				txtCvv.setText("");
				PanelFecha.setVisible(false);
				txtIban.setVisible(true);
				lblNewLabel_1.setVisible(true);
				
			}
		});
		rdbtnTransferenciaBancaria.setSelected(true);
		rdbtnTransferenciaBancaria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnTransferenciaBancaria.setBounds(42, 129, 232, 23);
		contentPane.add(rdbtnTransferenciaBancaria);
		
		JLabel lblNewLabel = new JLabel("Pago Matricula");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(361, 11, 180, 44);
		contentPane.add(lblNewLabel);
		
		
		JRadioButton rdbtnTargetaDeCredito = new JRadioButton("Targeta de credito");
		rdbtnTargetaDeCredito.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtNombre.setVisible(true);
				txtNumTargeta.setVisible(true);;
				PanelFecha.setVisible(true);
				txtCvv.setVisible(true);
				txtIban.setVisible(false);
				txtIban.setText("");
				lblNewLabel_1_1.setVisible(true);
				lblNewLabel_1_2.setVisible(true);
			}
		});
		rdbtnTargetaDeCredito.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnTargetaDeCredito.setBounds(42, 252, 232, 23);
		contentPane.add(rdbtnTargetaDeCredito);
		
		
		JButton btnNewButton = new JButton("Pagar ahora ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fechacaducidad = new java.sql.Date(((java.util.Date) fecha.getModel().getValue()).getTime());
				if((txtIban.getText().length() != 0) || (txtNombre.getText().length() != 0) && (txtNumTargeta.getText().length() != 0)
						 && (fechacaducidad.toString().length() !=0) && (txtCvv.getText().length() != 0)) {
					dispose();
					
					JOptionPane.showMessageDialog(null, "Pago realizado con exito", 
						"PAGO CORRECTO", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Pago incorrecto, vuelva a intentarlo",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					txtIban.setText("");
					txtNombre.setText("");
					txtNumTargeta.setText("");
					fecha.getModel().setValue(null);
					txtCvv.setText("");
					txtIban.requestFocus();
				}		
			}
		});
		bg.add(rdbtnTargetaDeCredito);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(374, 480, 167, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(817, 11, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
}
