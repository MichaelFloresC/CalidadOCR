import java.awt.EventQueue;
import javax.swing.filechooser.FileFilter;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;

public class Principal extends javax.swing.JFrame{
	static String SRC_PATH = "";
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
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
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
		
		JLabel imagen = new JLabel("");
		imagen.setBounds(40, 11, 330, 395);
		panelImagen.add(imagen);
		
		JButton Grises = new JButton("Grises");
		Grises.setForeground(SystemColor.text);
		Grises.setBackground(SystemColor.activeCaption);
		Grises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser fc =new JFileChooser();
				fc.setDialogTitle("Buscar Imagen");
			
				if(fc.showOpenDialog(fc)==JFileChooser.APPROVE_OPTION) {
					//File archivo =new File(fc.getSelectedFile().toString());
					
					rsscalelabel.RSScaleLabel.setScaleLabel(imagen, fc.getSelectedFile().toString());
					System.out.println(fc.getSelectedFile().toString());
					
				}
				
				
			}
		});
		Grises.setBounds(23, 11, 104, 23);
		panel.add(Grises);
		
		JButton bordes = new JButton("Bordes");
		bordes.setForeground(SystemColor.text);
		bordes.setBackground(SystemColor.activeCaption);
		bordes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser fc =new JFileChooser();
				fc.setDialogTitle("Buscar Imagen");
			
				if(fc.showOpenDialog(fc)==JFileChooser.APPROVE_OPTION) {
					//File archivo =new File(fc.getSelectedFile().toString());
					
					rsscalelabel.RSScaleLabel.setScaleLabel(imagen, fc.getSelectedFile().toString());
					System.out.println(fc.getSelectedFile().toString());
					
				}
				
			}
		});
		bordes.setBounds(251, 11, 104, 23);
		panel.add(bordes);
		
		JButton subir = new JButton("Subir Imagen");
		subir.setForeground(SystemColor.text);
		subir.setBackground(SystemColor.activeCaption);
		subir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc =new JFileChooser();
				fc.setDialogTitle("Buscar Imagen");
			
				if(fc.showOpenDialog(fc)==JFileChooser.APPROVE_OPTION) {
					//File archivo =new File(fc.getSelectedFile().toString());
					
					rsscalelabel.RSScaleLabel.setScaleLabel(imagen, fc.getSelectedFile().toString());
					System.out.println(fc.getSelectedFile().toString());
				}
				
				SRC_PATH=fc.getSelectedFile().toString();
				reconocimientoOCR ocr= new reconocimientoOCR(SRC_PATH);
				ocr.getReconstruccion();
				
			}
			
		});
		subir.setBounds(137, 491, 181, 23);
		panel.add(subir);
		
		JButton Umbral = new JButton("Umbral");
		Umbral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc =new JFileChooser();
				fc.setDialogTitle("Buscar Imagen");
			
				if(fc.showOpenDialog(fc)==JFileChooser.APPROVE_OPTION) {
					//File archivo =new File(fc.getSelectedFile().toString());
					
					rsscalelabel.RSScaleLabel.setScaleLabel(imagen, fc.getSelectedFile().toString());
					SRC_PATH=fc.getSelectedFile().toString();
					
				}
			}
		});
		Umbral.setForeground(SystemColor.text);
		Umbral.setBackground(SystemColor.activeCaption);
		Umbral.setBounds(137, 11, 104, 23);
		panel.add(Umbral);
		
		JButton Reconstruccion = new JButton("Reconstruccion");
		Reconstruccion.setBounds(365, 11, 73, 23);
		panel.add(Reconstruccion);
		Reconstruccion.setForeground(SystemColor.text);
		Reconstruccion.setBackground(SystemColor.activeCaption);
		Reconstruccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				reconocimientoOCR ocr= new reconocimientoOCR(SRC_PATH);
				String result=ocr.getResultados().toString();
				textArea.setText(result);
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/429165.jpg")));
		lblNewLabel.setBounds(0, 0, 951, 581);
		frame.getContentPane().add(lblNewLabel);
	}
	
	/*public class Imagen extends javax.swing.JPanel {
		int indice; 
	    public Imagen(int indice) {
	    this.setSize(411, 435); //se selecciona el tamaño del panel
	    this.indice=indice;
	    }
	    //Se crea un método cuyo parámetro debe ser un objeto Graphics
	    public void paint(Graphics grafico) {
	    Dimension height = getSize();
	    //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
	    ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/gray"+indice+".png")); 
	    //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
	    grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
	    setOpaque(false);
	    super.paintComponent(grafico);
	    }
	}*/
}
