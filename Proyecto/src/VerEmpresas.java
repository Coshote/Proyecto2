import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Metodos_sql.ConexiconBDE;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class VerEmpresas extends JFrame {
	
	ConexiconBDE enlace = new ConexiconBDE();
	Connection conect= enlace.conectar();

	private JPanel contentPane;
	private JTable tableEmpresas;
	private JPanel panel;
	private JButton btnBuscar;
	private JComboBox comboBox;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerEmpresas frame = new VerEmpresas();
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
	public VerEmpresas() {
		setTitle("Empresas Registradas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado obj= new Empleado();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnSalir.setBounds(340, 227, 89, 23);
		contentPane.add(btnSalir);
		
		tableEmpresas = new JTable();
		tableEmpresas.setFillsViewportHeight(true);
		tableEmpresas.setSurrendersFocusOnKeystroke(true);
		tableEmpresas.setColumnSelectionAllowed(true);
		tableEmpresas.setCellSelectionEnabled(true);
		tableEmpresas.setBounds(10, 56, 320, 194);
		tableEmpresas.setLocation(10, 56);
		tableEmpresas.setSize(320,194);
		contentPane.add(tableEmpresas);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 419, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnBuscar.setBounds(320, 16, 89, 23);
		panel.add(btnBuscar);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mostrar Todos", "Nivel", "Profesion"}));
		comboBox.setBounds(10, 16, 122, 22);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(155, 17, 133, 20);
		panel.add(textField);
		textField.setColumns(10);
		mostrarDatosEmpresas(0,null);
	}
	
	public void addCheckBox(int column, DefaultTableModel tabla) {
		TableColumn tc= ((JTable) tableEmpresas).getColumnModel().getColumn(column);
		tc.setCellEditor(((JTable) tableEmpresas).getDefaultEditor(Boolean.class));
		tc.setCellRenderer(((JTable) tableEmpresas).getDefaultRenderer(Boolean.class));
		
	}
	public boolean IsSelected(int row,int column, DefaultTableModel tabla) {
		return ((JTable) tableEmpresas).getValueAt(row, column) !=null;
	}
	

	public void mostrarDatosEmpresas(int opbuscar, String valor) {
		DefaultTableModel tabla= new DefaultTableModel();
		tabla.addColumn("EMPRESAS");
		tabla.addColumn("Telefono");
		tabla.addColumn("Req Nivel");
		tabla.addColumn("Req Prof");
		tabla.addColumn("Seleccionado");
		
		tableEmpresas.setModel(tabla);
		addCheckBox(4,tabla);
		
		String codsql;
		if(opbuscar == 0 && valor== null) {
			codsql= "SELECT * FROM LISTA_EMPRESAS";
		}else{
			if(opbuscar==1 && valor != null) {
				codsql= "SELECT * FROM LISTA_EMPRESAS WHERE Nivel='"+valor+"'";
			}else{
				if(opbuscar==2 && valor != null) {
					codsql= "SELECT * FROM LISTA_EMPRESAS WHERE Profesion='"+valor+"'";
				}else {
					codsql="SELECT * FROM LISTA_EMPRESAS";
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
			tableEmpresas.setModel(tabla);
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e + "Error en la consulta");
		}
		
	}
	
	
	
}
