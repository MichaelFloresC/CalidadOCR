import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 861, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 270, 502);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTesseractOcr = new JLabel("Tesseract OCR");
		lblTesseractOcr.setForeground(SystemColor.textHighlight);
		lblTesseractOcr.setFont(new Font("Cambria", Font.BOLD, 24));
		lblTesseractOcr.setBounds(44, 87, 173, 30);
		panel.add(lblTesseractOcr);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Principal window = new Principal();
				window.frame.setVisible(true);
				
				frame.setVisible(false);
				
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(33, 251, 184, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/Contactenos.png")));
		lblNewLabel_1.setBounds(44, 375, 173, 92);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/fondo2.png")));
		lblNewLabel.setBounds(269, 0, 576, 502);
		frame.getContentPane().add(lblNewLabel);
	}
}
