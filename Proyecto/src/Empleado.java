import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Metodos_sql.ConexiconBDE;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Empleado extends JFrame {
	ConexiconBDE enlace = new ConexiconBDE();
	Connection conect= enlace.conectar();

	private JPanel escritorio;
	private final Action action = new SwingAction();
	private JTextField campoBuscar;
	private JTable tableEmpresas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleado frame = new Empleado();
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
	public Empleado() {
		setTitle("Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 349);
		escritorio = new JPanel();
		escritorio.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(escritorio);
		escritorio.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Opciones");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 11, 101, 37);
		escritorio.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proyecto obj= new Proyecto();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 133, 89, 23);
		escritorio.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ofrecer servicios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaTrabajador obj= new ListaTrabajador();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			
			}
		});
		btnNewButton_1.setBounds(10, 51, 135, 23);
		escritorio.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ayuda");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consejos ventana = new Consejos();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setBounds(10, 85, 121, 23);
		escritorio.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Empresas Registradas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(155, 11, 424, 239);
		escritorio.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 403, 49);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBP = new JComboBox();
		comboBP.setModel(new DefaultComboBoxModel(new String[] {"Mostrar Todos", "Nivel", "Profesion"}));
		comboBP.setBounds(10, 16, 120, 22);
		panel_1.add(comboBP);
		
		campoBuscar = new JTextField();
		campoBuscar.setBounds(151, 17, 127, 20);
		panel_1.add(campoBuscar);
		campoBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion= comboBP.getSelectedIndex();
				String valorbus= campoBuscar.getText();
				mostrarDatosEmpresas(opcion,valorbus);
			}
		});
		btnBuscar.setBounds(288, 16, 89, 23);
		panel_1.add(btnBuscar);
		
		tableEmpresas = new JTable();
		tableEmpresas.setBounds(10, 68, 1, 1);
		tableEmpresas.setLocation(10, 75);
		tableEmpresas.setSize(380,150);
		panel.add(tableEmpresas);
		
		JButton btnNewButton_3 = new JButton("Enviar Informacion");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviar jodan= new enviar();
				jodan.setVisible(true);
				jodan.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_3.setBounds(165, 261, 159, 23);
		escritorio.add(btnNewButton_3);
		mostrarDatosEmpresas(0,null);
	}
	
	public void addCheckBox(int column, DefaultTableModel tabla) {
		TableColumn tc= ((JTable) tableEmpresas).getColumnModel().getColumn(column);
		tc.setCellEditor(((JTable) tableEmpresas).getDefaultEditor(Boolean.class));
		tc.setCellRenderer(((JTable) tableEmpresas).getDefaultRenderer(Boolean.class));
		
	}
	

	public void mostrarDatosEmpresas(int opbuscar, String valor) {
		DefaultTableModel tabla= new DefaultTableModel();
		tabla.addColumn("EMPRESAS");
		tabla.addColumn("Contacto");
		tabla.addColumn("Req Nivel");
		tabla.addColumn("Req Prof");

		

		
	
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
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
