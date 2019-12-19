import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class pruebaTess4j {

	
	public static void main(String[] args) throws TesseractException {
		
		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");
		System.out.println(tesseract.doOCR(new File("D:/Imagenes/gray.png")));
		
		
		
	}
}
