import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VerTrabajadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerTrabajadores frame = new VerTrabajadores();
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
	public VerTrabajadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTrabajadoresDisponibles = new JLabel("Empresas Disponibles");
		lblTrabajadoresDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTrabajadoresDisponibles.setBounds(10, 11, 303, 17);
		contentPane.add(lblTrabajadoresDisponibles);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 51, 303, 199);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Mostrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String datos="";
				ContenidoEmpresas conexion = new ContenidoEmpresas();
				ArrayList<String> Datos= conexion.Leer();
				for(String elemento: Datos) {
					datos= datos + elemento + "\n";
				}
				textArea.setText(datos);
			}
		});
		btnNewButton_1.setBounds(323, 52, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado obj= new Empleado();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
