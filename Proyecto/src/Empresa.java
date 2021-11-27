import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Metodos_sql.ConexionBDT;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Empresa extends JFrame {
	ConexionBDT enlace= new ConexionBDT();
	Connection conect = enlace.conectar();
	

	private JPanel contentPane;
	private JTextField campoBE;
	private JTable tableUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresa frame = new Empresa();
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
	public Empresa() {
		setTitle("Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Opciones");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblNewLabel.setBounds(0, -1, 133, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proyecto obj= new Proyecto();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 175, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Habilitar Plaza");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEmpresa list= new ListaEmpresa();
				list.setVisible(true);
				list.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 36, 133, 29);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Aplicantes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(153, 11, 430, 239);
		contentPane.add(panel);

		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 410, 49);
		panel.add(panel_1);
		
		JComboBox comboBP = new JComboBox();
		comboBP.setModel(new DefaultComboBoxModel(new String[] {"Mostrar Todo", "Nivel", "Profesion"}));
		comboBP.setBounds(10, 16, 128, 22);
		panel_1.add(comboBP);
		
		campoBE = new JTextField();
		campoBE.setColumns(10);
		campoBE.setBounds(148, 17, 153, 20);
		panel_1.add(campoBE);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion= comboBP.getSelectedIndex();
				String valorbus= campoBE.getText();
				mostrarDatos(opcion,valorbus);
				
			}
		});
		btnBuscar.setBounds(311, 16, 89, 23);
		panel_1.add(btnBuscar);
		
		tableUsuarios = new JTable();
		tableUsuarios.setBounds(10, 75, 320, 150);
		tableUsuarios.setLocation(10, 75);
		tableUsuarios.setSize(380,150);
		panel.add(tableUsuarios);
		
	
		
		JButton Visualizar = new JButton("Ver Correo");
		Visualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("https://mail.google.com/mail/u/1/#inbox"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
			}
		});
		Visualizar.setBounds(10, 76, 133, 29);
		contentPane.add(Visualizar);
		
		JButton btnNewButton_2 = new JButton("Contactar Reclutamiento");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reclutamiento horebore= new reclutamiento();
				horebore.setVisible(true);
				horebore.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_2.setBounds(10, 124, 133, 23);
		contentPane.add(btnNewButton_2);
		mostrarDatos(0,null);
	}
	public  void mostrarDatos(int opbuscar, String valor) {
		DefaultTableModel tabla= new DefaultTableModel();
		
		tabla.addColumn("Nombre");
		tabla.addColumn("Telefono");
		tabla.addColumn("Nivel");
		tabla.addColumn("Profesion");
		tableUsuarios.setModel(tabla);
		
		String codsql;
		if(opbuscar == 0 && valor== null) {
			codsql= "SELECT * FROM LISTA_TRABAJADORES";
		}else{
			if(opbuscar==1 && valor != null) {
				codsql= "SELECT * FROM LISTA_TRABAJADORES WHERE Nivel='"+valor+"'";
			}else{
				if(opbuscar==2 && valor != null) {
					codsql= "SELECT * FROM LISTA_TRABAJADORES WHERE Profesion='"+valor+"'";
				}else {
					codsql="SELECT * FROM LISTA_TRABAJADORES";
				}
			}
		}
		

		
		String []datos= new String[4];
		try {
			Statement leer= conect.createStatement();
			ResultSet resultado = leer.executeQuery(codsql);
			while(resultado.next()) {
				datos[0]=resultado.getString(1);
				datos[1]=resultado.getString(2);
				datos[2]=resultado.getString(3);
				datos[3]=resultado.getString(4);
				tabla.addRow(datos);
			}
			tableUsuarios.setModel(tabla);
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e + "Error en la consulta");
		}
}
}
