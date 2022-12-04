package presentacion;

import javax.swing.*;

import negocio.controllers.*;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PantallaJefeGabineteVicerrectorado extends JFrame {
	
	JFrame previousWindow;
	
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
		setBounds(100, 100, 943, 610);
		setResizable(false);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(481, Short.MAX_VALUE))
		);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton consultarIngresosBtn = new JButton("Consultar Ingresos");
		consultarIngresosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(consultarIngresosBtn);
		
		JButton consultarEstadosCursosBtn = new JButton("Consultar Estado de los Cursos");
		panel.add(consultarEstadosCursosBtn);
		
		JButton listarEdicionesCursos = new JButton("Listar Ediciones Cursos");
		panel.add(listarEdicionesCursos);
		getContentPane().setLayout(groupLayout);
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3497561384085455302L;
	
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
	
	public void realizarConsulta() {
		GestorConsultas gestor = new GestorConsultas();
		
		
	}
}