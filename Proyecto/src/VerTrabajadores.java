import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import java.sql.*;

import javax.swing.table.DefaultTableModel;

import Metodos_sql.ConexiconBDE;
import Metodos_sql.ConexionBDT;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;


public class VerTrabajadores extends JFrame {
	
	
	ConexionBDT enlace= new ConexionBDT();
	Connection conect = enlace.conectar();
	
	private JPanel contentPane;
	private JTable tableUsuarios;
	private JTextField campoBuscar;

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
		setTitle("Trabajadores Disponibles");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa obj= new Empresa();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(370, 270, 89, 23);
		contentPane.add(btnNewButton);
		
		tableUsuarios = new JTable();
		tableUsuarios.setSurrendersFocusOnKeystroke(true);
		tableUsuarios.setToolTipText("");
		tableUsuarios.setFillsViewportHeight(true);
		tableUsuarios.setColumnSelectionAllowed(true);
		tableUsuarios.setCellSelectionEnabled(true);
		tableUsuarios.setBounds(10, 98, 350, 198);
		tableUsuarios.setLocation(10, 66);
		tableUsuarios.setSize(350,230);
		
		
		contentPane.add(tableUsuarios);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar Por", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Buscar Por: ");
		panel.setBounds(10, 11, 396, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboOpcion = new JComboBox();
		comboOpcion.setModel(new DefaultComboBoxModel(new String[] {"Mostrar todos", "Nivel", "Profesion"}));
		comboOpcion.setBounds(10, 18, 139, 22);
		panel.add(comboOpcion);
		
		campoBuscar = new JTextField();
		campoBuscar.setBounds(159, 19, 115, 20);
		panel.add(campoBuscar);
		campoBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion= comboOpcion.getSelectedIndex();
				String valorbus= campoBuscar.getText();
				mostrarDatos(opcion,valorbus);
			}
		});
		btnBuscar.setBounds(286, 18, 89, 23);
		panel.add(btnBuscar);
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
