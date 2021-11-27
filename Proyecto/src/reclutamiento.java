import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class reclutamiento extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reclutamiento frame = new reclutamiento();
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
	public reclutamiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Compa\u00F1ias de Reclutamiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(reclutamiento.class.getResource("/imagenes/descarga.jpg")));
		lblNewLabel.setBounds(10, 30, 138, 78);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Visitar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("https://www.tecoloco.com.gt/"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
			}
		});
		btnNewButton.setBounds(158, 30, 79, 78);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(reclutamiento.class.getResource("/imagenes/1568668824558.jpg")));
		lblNewLabel_1.setBounds(10, 130, 138, 78);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Visitar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("http://persotemp.com.gt/web/reclutamiento-y-seleccion/?http://persotemp.com.gt/web/reclutamiento-y-seleccion/&gclid=Cj0KCQiAhf2MBhDNARIsAKXU5GRmXn8uReZz5ka99zjIm2o8mKkGuow2TfJs_GMyXKmoSqbFZ2lM8UkaArktEALw_wcB#beneficios"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
				
			}
		});
		btnNewButton_1.setBounds(158, 130, 79, 78);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa doko= new Empresa();
				doko.setVisible(true);
				doko.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setBounds(304, 181, 89, 23);
		panel.add(btnNewButton_2);
	}

}
