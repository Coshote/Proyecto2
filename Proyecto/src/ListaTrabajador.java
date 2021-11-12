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

public class ListaTrabajador extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtContacto;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	MetodosT_sql metodos= new MetodosT_sql();
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
		
		JLabel lblNombre = new JLabel("Nombre");
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
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(10, 101, 151, 34);
		contentPane_1.add(lblDescripcion);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 130, 398, 61);
		contentPane_1.add(textField_2);
		
		JButton btnNewButton = new JButton("Grabar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=metodos.guardar(txtNombre.getText(),txtContacto.getText());
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
	}
}
