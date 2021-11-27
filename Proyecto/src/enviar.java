import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.awt.event.ActionEvent;


public class enviar extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField txtContra;
	private JTextField txtDesti;
	private JTextField txtAdjunto;
	private JLabel txtNombre;
	private JTextField intento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enviar frame = new enviar();
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
	public enviar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Envio de Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 493, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Destinatario = new JLabel("Destinatario");
		Destinatario.setBounds(10, 93, 104, 21);
		panel.add(Destinatario);
		
		JLabel contra = new JLabel("Contrase\u00F1a");
		contra.setBounds(10, 58, 104, 21);
		panel.add(contra);
		
		JLabel correo = new JLabel("Correo");
		correo.setBounds(10, 24, 104, 21);
		panel.add(correo);
		
		JLabel Adjunto = new JLabel("Nombre del Archivo");
		Adjunto.setBounds(10, 157, 131, 21);
		panel.add(Adjunto);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(124, 24, 247, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtContra = new JPasswordField();
		txtContra.setBounds(124, 58, 247, 20);
		panel.add(txtContra);
		
		txtDesti = new JTextField();
		txtDesti.setBounds(124, 93, 247, 20);
		panel.add(txtDesti);
		txtDesti.setColumns(10);
		
		txtAdjunto = new JTextField();
		txtAdjunto.setBounds(151, 157, 247, 20);
		panel.add(txtAdjunto);
		txtAdjunto.setColumns(10);
		
		JButton btnNewButton = new JButton("Adjuntar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();

		        int respuesta = fc.showOpenDialog(null);

		        if (respuesta == JFileChooser.APPROVE_OPTION) {

		            File archivoElegido = fc.getSelectedFile();
		            txtAdjunto.setText(archivoElegido.getName());
		            intento.setText(archivoElegido.getAbsolutePath());
		        }

			}
		});
		btnNewButton.setBounds(10, 125, 89, 23);
		panel.add(btnNewButton);
		
		intento = new JTextField();
		intento.setBounds(151, 188, 247, 20);
		panel.add(intento);
		intento.setColumns(10);
		
		JLabel Adjunto_1 = new JLabel("Direccion del Archivo");
		Adjunto_1.setBounds(10, 191, 131, 21);
		panel.add(Adjunto_1);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String correo= txtCorreo.getText();
				String contra= txtContra.getText();
				String destinatario= txtDesti.getText();
				String archivo= intento.getText();
				String noar= txtAdjunto.getText();

				
				Properties p = new Properties();
				p.put("mail.smtp.host", "smtp.gmail.com");
				p.setProperty("mail.smtp.starttls.enable", "true");
				p.put("mail.smtp.ssl.trust","smtp.gmail.com");
				p.put("mail.smtp.ssl.protocols", "TLSv1.2");
				p.setProperty("mail.smtp.port","587");
				p.setProperty("mail.smtp.user", correo);
				p.setProperty("mail.smtp.auth","true");

				
				Session s= Session.getDefaultInstance(p);
				s.getProperties().put("mail.smtp.starttls.enable", "true");	
		

				MimeMessage mensaje= new MimeMessage(s);
				try {
					BodyPart text= new MimeBodyPart();
					text.setText("Adjunto Informacion del Aspirante a la plaza");
					BodyPart adjunto = new MimeBodyPart();
					adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
					adjunto.setFileName(noar);
					MimeMultipart m= new MimeMultipart();
					m.addBodyPart(text);
					m.addBodyPart(adjunto);
					
					mensaje.setFrom(new InternetAddress(correo));
					mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
					mensaje.setSubject("Aplicacion Empleo");
					mensaje.setContent(m);
					
					
					
					Transport t= s.getTransport("smtp");
					t.connect(correo,contra);
					t.sendMessage(mensaje, mensaje.getAllRecipients());
					t.close();
					JOptionPane.showMessageDialog(null,"Mensaje Enviado con Exito ");
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				


				

				
			}
		});
		btnEnviar.setBounds(59, 265, 89, 23);
		contentPane.add(btnEnviar);
		
		txtNombre = new JLabel("");
		txtNombre.setBounds(244, 279, 219, 24);
		contentPane.add(txtNombre);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado tada= new Empleado();
				tada.setVisible(true);
				tada.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(384, 265, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	public JLabel getTxtNombre() {
		return txtNombre;
	}
}
