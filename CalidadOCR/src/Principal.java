import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;

public class Principal extends javax.swing.JFrame{

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		
		this.setLocationRelativeTo(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 967, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tesseract");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 0, 91, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(504, 33, 437, 525);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 417, 503);
		panel_1.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 33, 460, 525);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelImagen = new JPanel();
		panelImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelImagen.setBackground(Color.WHITE);
		panelImagen.setBounds(23, 45, 411, 435);
		panel.add(panelImagen);
		panelImagen.setLayout(null);
		
		JButton subirImagen = new JButton("Subir Imagen");
		subirImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            Imagen Imagen = new Imagen();
	            panelImagen.add(Imagen);
	            panelImagen.repaint();
			}
		});
		subirImagen.setBounds(158, 491, 116, 23);
		panel.add(subirImagen);
		
		JButton Grises = new JButton("Grises");
		Grises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		Grises.setBounds(23, 11, 89, 23);
		panel.add(Grises);
		
		JButton btnNewButton_2 = new JButton("Tess4j");
		btnNewButton_2.setBounds(158, 11, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton Reconstruccion = new JButton("Reconstruccion");
		Reconstruccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				reconocimientoOCR ocr= new reconocimientoOCR();
				String result=ocr.getResultados().toString();
				textArea.setText(result);;
				
				
			}
		});
		Reconstruccion.setBounds(296, 11, 138, 23);
		panel.add(Reconstruccion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/429165.jpg")));
		lblNewLabel.setBounds(0, 0, 951, 581);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public class Imagen extends javax.swing.JPanel {
		 
	    public Imagen() {
	    this.setSize(411, 435); //se selecciona el tamaño del panel
	    }
	    //Se crea un método cuyo parámetro debe ser un objeto Graphics
	    public void paint(Graphics grafico) {
	    Dimension height = getSize();
	    //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
	    ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/4.jpeg")); 
	    //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
	    grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
	    setOpaque(false);
	    super.paintComponent(grafico);
	    }
	}
}
