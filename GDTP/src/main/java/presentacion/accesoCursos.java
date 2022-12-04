package presentacion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DropMode;
import javax.swing.JTextPane;

public class accesoCursos {

	private JComboBox combo1;

	private JComboBox combo2;
	
	private JComboBox combo3;
	private final JButton btnContinuar = new JButton("Continuar");
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;

	public static void main(String[] args) {
		new accesoCursos();
	}

	public accesoCursos() {
		JFrame v = new JFrame();
		v.getContentPane().setLayout(new FlowLayout());
		
		combo1 = new JComboBox();
		rellenaCombo1();
		combo1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				rellenaCombo2((String) combo1.getSelectedItem());
			}

		});

		combo2 = new JComboBox();
		rellenaCombo2((String) combo1.getSelectedItem());
		combo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rellenaCombo3((String) combo2.getSelectedItem());
			}
		});


		combo3 = new JComboBox();
		combo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String newcurso = (String)combo3.getSelectedItem();
				if(combo3.equals("Master en programacion web")) {
					
					
				}
			}
		});
		rellenaCombo3((String) combo2.getSelectedItem());
		
		lblNewLabel = new JLabel("Nivel:");
		v.getContentPane().add(lblNewLabel);
		
		
		v.getContentPane().add(combo1);
		
		lblNewLabel_1 = new JLabel("Tipo:");
		v.getContentPane().add(lblNewLabel_1);
		v.getContentPane().add(combo2);
		
		lblNewLabel_2 = new JLabel("Curso:");
		v.getContentPane().add(lblNewLabel_2);
		v.getContentPane().add(combo3);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Masters master = new Masters();
				master.setVisible(true);
				
			}
		});
		v.getContentPane().add(btnContinuar);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		v.getContentPane().add(btnNewButton);
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	protected void rellenaCombo3(String selectedItem) {
		combo3.removeAllItems();
		if (selectedItem.equals("Master")) {
			combo3.addItem("Master de programacion web");
			combo3.addItem("-");
			combo3.addItem("-");
		} else if (selectedItem.equals("Especialistas")) {
			combo3.addItem("Tecnologia de redes");
			combo3.addItem("-");
			combo3.addItem("-");
		} else if (selectedItem.equals("Expertos")) {
			combo3.addItem("Experto en tecnicas de analisis de datos");
			combo3.addItem("-");
			combo3.addItem("-");
		}  else if (selectedItem.equals("Cursos de formacion avanzada")) {
			combo3.addItem("Curso en diseño de videojuegos");
			combo3.addItem("-");
			combo3.addItem("-");
		}  else if (selectedItem.equals("Cursos de formacion continua")) {
			combo3.addItem("Tecnico en informatica");
			combo3.addItem("-");
			combo3.addItem("-");
		}  else if (selectedItem.equals("Microcredenciales")) {
			combo3.addItem("Micosoft dynamics bussines central");
			combo3.addItem("-");
			combo3.addItem("-");
		} else if (selectedItem.equals("Actividades de corta duracion")) {
			combo3.addItem("Semana de la informatica");
			combo3.addItem("-");
			combo3.addItem("-");
		} else if (selectedItem.equals("Cursos de verano y estension universitaria")) {
			combo3.addItem("Curso de verano RobotCraft");
			combo3.addItem("-");
			combo3.addItem("-");
		} else if (selectedItem.equals("Formacion de mayores")) {
			combo3.addItem("aprendizaje de sistemas informaticos");
			combo3.addItem("-");
			combo3.addItem("-");
		} 		
	}

	private void rellenaCombo1() {//ERROR
		combo1.addItem("Cursos con titulacion universitaria");
		combo1.addItem("Cursos sin titulacion universitaria"); 
		this.combo1.addItem("Ensenanzas propias");
	}

	private void rellenaCombo2(String seleccionEnCombo1) {
		combo2.removeAllItems();
		if (seleccionEnCombo1.equals("Cursos con titulacion universitaria")) {
			combo2.addItem("Master");
			combo2.addItem("Especialistas");
			combo2.addItem("Expertos");
			
		} else if (seleccionEnCombo1.equals("Cursos sin titulacion universitaria")) {
			combo2.addItem("Cursos de formacion avanzada");
			combo2.addItem("Cursos de formacion continua");
			combo2.addItem("-");
					
		} else if (seleccionEnCombo1.equals("Ensenanzas propias")) {
			combo2.addItem("Microcredenciales");
			combo2.addItem("Actividades de corta duracion");
			combo2.addItem("Cursos de verano y estension universitaria");
			combo2.addItem("Formacion de mayores");
		} 
	}
}