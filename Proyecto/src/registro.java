

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Metodos_sql.Metodos_sql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	Metodos_sql metodos= new Metodos_sql();
	private JPasswordField txtContraseña;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro frame = new registro();
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
	public registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(33, 38, 134, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(33, 100, 134, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Inicie Secion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(165, 13, 134, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(152, 46, 134, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String busqueda_usuario= metodos.buscarUsuarioRegistrado(txtCorreo.getText(),txtContraseña.getText());
				if(txtCorreo.getText().equals("root")&& txtContraseña.getText().equals("root")) {
					JOptionPane.showMessageDialog(null, "Bienvenido iniciaste secion como root(Administrador)");					
					}else if(busqueda_usuario.equals("usuario encontrado")) {
						String busqueda_nombre=metodos.buscarNombre(txtCorreo.getText());
						JOptionPane.showMessageDialog(null, "Bienvenido \n"+busqueda_nombre);
						Proyecto ventana = new Proyecto();
						ventana.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Usuario no encontrado, por favor registrarse");
					}
				
				
				}
		});
		btnEntrar.setBounds(108, 202, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu ventana= new menu();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(239, 202, 89, 23);
		contentPane.add(btnRegresar);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(152, 114, 134, 20);
		contentPane.add(txtContraseña);
	}
}
