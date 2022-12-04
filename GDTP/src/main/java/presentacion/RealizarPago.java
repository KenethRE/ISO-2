package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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

public class RealizarPago extends JFrame {

	private JPanel contentPane;
	private JTextField txtIban;
	private JTextField txtNombre;
	private JTextField txtNumTargeta;
	private JTextField txtFecha;
	private JTextField txtCvv;
	private ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarPago frame = new RealizarPago();
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
	public RealizarPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnTransferenciaBancaria = new JRadioButton("Transferencia bancaria");
		rdbtnTransferenciaBancaria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombre.setEnabled(false);
				txtNumTargeta.setEnabled(false);
				txtFecha.setEnabled(false);
				txtCvv.setEnabled(false);
				txtNombre.setText("");
				txtNumTargeta.setText("");
				txtFecha.setText("");
				txtCvv.setText("");
				
				txtIban.setEnabled(true);
				
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
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombre.setEnabled(true);
				txtNumTargeta.setEnabled(true);
				txtFecha.setEnabled(true);
				txtCvv.setEnabled(true);
				
				txtIban.setEnabled(false);
				txtIban.setText("");
			}
		});
		rdbtnTargetaDeCredito.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnTargetaDeCredito.setBounds(42, 252, 232, 23);
		contentPane.add(rdbtnTargetaDeCredito);
		
		JLabel lblNewLabel_1 = new JLabel("IBAN :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(42, 182, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		bg.add(rdbtnTransferenciaBancaria);
		bg.add(rdbtnTargetaDeCredito);
		
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre titular:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(42, 303, 102, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Numero de la targeta");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(42, 342, 149, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha de caducidad:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(42, 385, 140, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("CVV:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(42, 424, 58, 14);
		contentPane.add(lblNewLabel_1_4);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(187, 297, 470, 30);
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
		txtNumTargeta.setBounds(187, 341, 470, 30);
		contentPane.add(txtNumTargeta);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(187, 384, 193, 30);
		contentPane.add(txtFecha);
		
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
		txtCvv.setBounds(94, 423, 140, 30);
		contentPane.add(txtCvv);
		
		JButton btnNewButton = new JButton("Pagar ahora ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((txtIban.getText().length() != 0) || (txtNombre.getText().length() != 0) && (txtNumTargeta.getText().length() != 0)
						 && (txtFecha.getText().length() != 0) && (txtCvv.getText().length() != 0)) {
					dispose();
					
					JOptionPane.showMessageDialog(null, "Pago realizado con exito", 
						"PAGO CORRECTO", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Pago incorrecto, vuelva a intentarlo",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					txtIban.setText("");
					txtNombre.setText("");
					txtNumTargeta.setText("");
					txtFecha.setText("");
					txtCvv.setText("");
					txtIban.requestFocus();
				}		
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(374, 480, 167, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matricula volver = new Matricula();
				volver.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(817, 11, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
}
