import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Consejos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consejos frame = new Consejos();
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
	public Consejos() {
		setTitle("Consejos y Ayuda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Entrevista", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guias para Entrevista");
		lblNewLabel.setBounds(10, 22, 116, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Posturas y Gestos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("https://www.youtube.com/watch?v=bOA95h07isk&ab_channel=Sebasti%C3%A1nLora"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
			}
		});
		btnNewButton.setBounds(10, 51, 133, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Comunicacion");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("https://www.youtube.com/watch?v=0MtYRN5eA5c&ab_channel=ElBuscadordeEmpleo"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
			}
		});
		btnNewButton_1.setBounds(162, 51, 104, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Vestimenta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("https://www.youtube.com/watch?v=eknQIpJo6-o&ab_channel=ConsejosImagen"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
			}
		});
		btnNewButton_2.setBounds(288, 51, 104, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Hacer CV", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 116, 414, 94);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ayuda en CV");
		lblNewLabel_1.setBounds(10, 23, 110, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Guia #1");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("https://www.youtube.com/watch?v=0TBDXtOPdIs&ab_channel=VitoVlogs"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
	
			}
		});
		btnNewButton_3.setBounds(10, 48, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Guia #2");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("https://saberespoder.com/articles/education/10-pasos-para-hacer-un-curriculum-vitae-atractivo"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
			}
		});
		btnNewButton_3_1.setBounds(109, 48, 89, 23);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("Guia #3");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("https://www.youtube.com/watch?v=XjqLaneHGMQ&ab_channel=ElT%C3%ADoTech"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
			}
		});
		btnNewButton_3_1_1.setBounds(208, 48, 89, 23);
		panel_1.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_1_2 = new JButton("Guia #4");
		btnNewButton_3_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
				browser.browse(new URI("https://www.youtube.com/watch?v=eakjX8R1vOI&ab_channel=VitoVlogs"));
				}catch(IOException err) 
				{
					
				}
				catch(URISyntaxException err) {}
			}
		});
		btnNewButton_3_1_2.setBounds(307, 48, 89, 23);
		panel_1.add(btnNewButton_3_1_2);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado ventana = new Empleado();
				ventana.setVisible(true);
				ventana.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_4.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton_4);
	}

}
