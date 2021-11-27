import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Metodos_sql.MetodosE_sql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListaEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtContacto;

	/**
	 * Launch the application.
	 */
	MetodosE_sql metodos= new MetodosE_sql();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaEmpresa frame = new ListaEmpresa();
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
	public ListaEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Empresa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 151, 34);
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(173, 20, 217, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNumeroDeContacto = new JLabel("Correo de Contacto");
		lblNumeroDeContacto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDeContacto.setBounds(10, 56, 151, 34);
		contentPane.add(lblNumeroDeContacto);
		
		txtContacto = new JTextField();
		txtContacto.setColumns(10);
		txtContacto.setBounds(173, 65, 217, 20);
		contentPane.add(txtContacto);
		
		JLabel lblDescripcion = new JLabel("Requisito de Nivel");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(10, 101, 151, 34);
		contentPane.add(lblDescripcion);
		
		JComboBox comboBoxN = new JComboBox();
		comboBoxN.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "B\u00E1sico", "Bachillerato", "Universidad"}));
		comboBoxN.setBounds(173, 109, 217, 22);
		contentPane.add(comboBoxN);
		
		JComboBox comboBoxP = new JComboBox();
		comboBoxP.setModel(new DefaultComboBoxModel(new String[] {"Profesion 1", "Profesion 2", "Profesion 3"}));
		comboBoxP.setBounds(173, 154, 217, 22);
		contentPane.add(comboBoxP);
		
		JButton btnNewButton = new JButton("Grabar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String req_n= (String) comboBoxN.getSelectedItem();
				String req_p= (String) comboBoxP.getSelectedItem();
				
				int i=metodos.guardar(txtNombre.getText(),txtContacto.getText(),req_n,req_p);
				if(i>0) {
					JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
					
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo guardar los datos");
					
				}

				
			}
		});
		btnNewButton.setBounds(232, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa obj= new Empresa();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnSalir.setBounds(331, 227, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblPlazaHabilitada = new JLabel("Plaza Habilitada");
		lblPlazaHabilitada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlazaHabilitada.setBounds(10, 146, 151, 34);
		contentPane.add(lblPlazaHabilitada);
		

	}
}
