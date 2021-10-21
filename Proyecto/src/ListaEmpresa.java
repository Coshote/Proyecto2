import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
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
		
		textField = new JTextField();
		textField.setBounds(173, 20, 217, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumeroDeContacto = new JLabel("Numero de Contacto");
		lblNumeroDeContacto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDeContacto.setBounds(10, 56, 151, 34);
		contentPane.add(lblNumeroDeContacto);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(173, 65, 217, 20);
		contentPane.add(textField_1);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(10, 101, 151, 34);
		contentPane.add(lblDescripcion);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 130, 398, 61);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Grabar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContenidoEmpresas conexion = new ContenidoEmpresas();
				conexion.Grabar(textField.getText().toString());
				
			}
		});
		btnNewButton.setBounds(232, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(331, 227, 89, 23);
		contentPane.add(btnSalir);
	}
}
