import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;

public class Proyecto extends JFrame {

	private JPanel contentPane;
	public Object lblNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto frame = new Proyecto();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proyecto() {
		setTitle("Proyecto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Aplicacion Trabajos");
		lblNewLabel.setBounds(133, 0, 167, 52);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Proyecto.class.getResource("/imagenes/man-2758615_960_720.png")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(255, 63, 156, 115);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Trabajador");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado obj = new Empleado();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(285, 187, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Empresa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa obj = new Empresa();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
					
			}
		});
		btnNewButton.setBounds(66, 187, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Proyecto.class.getResource("/imagenes/3891710232323.png")));
		lblNewLabel_1.setBounds(55, 64, 139, 115);
		contentPane.add(lblNewLabel_1);
	}
	



}
