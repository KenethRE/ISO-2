package presentacion;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PantallaEmpleadosVicerrectorado extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaEmpleadosVicerrectorado frame = new PantallaEmpleadosVicerrectorado();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaEmpleadosVicerrectorado() {
		setBounds(100,100,800,600);
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(5, 3, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
	}

	public void evaluarCurso() {
		throw new UnsupportedOperationException();
	}
}