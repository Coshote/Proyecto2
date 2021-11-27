import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Metodos_sql.MetodosT_sql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListaTrabajador extends JFrame {

	private JPanel contentPane;
	JTextField txtNombre;
	private JTextField txtContacto;

	/**
	 * Launch the application.
	 */
	MetodosT_sql metodos= new MetodosT_sql();
	private JLabel lblNombre;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaTrabajador frame = new ListaTrabajador();
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
	public ListaTrabajador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 434, 261);
		contentPane.add(contentPane_1);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 11, 151, 34);
		contentPane_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 20, 217, 20);
		contentPane_1.add(txtNombre);
		
		JLabel lblNumeroDeContacto = new JLabel("Numero de Contacto");
		lblNumeroDeContacto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDeContacto.setBounds(10, 56, 151, 34);
		contentPane_1.add(lblNumeroDeContacto);
		
		txtContacto = new JTextField();
		txtContacto.setColumns(10);
		txtContacto.setBounds(173, 65, 217, 20);
		contentPane_1.add(txtContacto);
		
		JLabel lblDescripcion = new JLabel("Nivel de Estudios");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(10, 101, 151, 34);
		contentPane_1.add(lblDescripcion);
		JComboBox comboBoxEstu = new JComboBox();
		comboBoxEstu.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "B\u00E1sico", "Bachillerato", "Universitario"}));
		comboBoxEstu.setToolTipText("Seleccion");
		comboBoxEstu.setBounds(173, 109, 148, 22);
		contentPane_1.add(comboBoxEstu);
		

		
		JComboBox comboBoxProf = new JComboBox();
		comboBoxProf.setBounds(173, 154, 151, 22);
		contentPane_1.add(comboBoxProf);
		
		comboBoxProf.addItem("Profesion 1");
		comboBoxProf.addItem("Profesion 2");
		comboBoxProf.addItem("Profesion 3");
		
		
		
		JButton btnNewButton = new JButton("Grabar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nivel= (String) comboBoxEstu.getSelectedItem();
				String prof= (String) comboBoxProf.getSelectedItem();
				int i=metodos.guardar(txtNombre.getText(),txtContacto.getText(),nivel,prof);
				if(i>0) {
					JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
					
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo guardar los datos");
					
				}
				

			}
		});
		btnNewButton.setBounds(232, 227, 89, 23);
		contentPane_1.add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado obj = new Empleado();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnSalir.setBounds(331, 227, 89, 23);
		contentPane_1.add(btnSalir);
		
		JLabel lblProfesuon = new JLabel("Profesion");
		lblProfesuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfesuon.setBounds(10, 146, 151, 34);
		contentPane_1.add(lblProfesuon);
		
		
	}
	public JLabel getLblNombre() {
		return lblNombre;
	}
	public JTextField getTxtNombre() {

		return txtNombre;
	}
}
