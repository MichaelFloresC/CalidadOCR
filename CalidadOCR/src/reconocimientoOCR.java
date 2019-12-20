

import static org.opencv.highgui.Highgui.imread;
import static org.opencv.highgui.Highgui.imwrite;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;
import static org.opencv.imgproc.Imgproc.MORPH_RECT;
import static org.opencv.imgproc.Imgproc.cvtColor;
import static org.opencv.imgproc.Imgproc.dilate;
import static org.opencv.imgproc.Imgproc.erode;
import static org.opencv.imgproc.Imgproc.getStructuringElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class reconocimientoOCR {
	
	private static final int
    CV_MOP_CLOSE = 3,
    CV_THRESH_OTSU = 8,
    CV_THRESH_BINARY = 0,
    CV_ADAPTIVE_THRESH_GAUSSIAN_C  = 1,
    CV_ADAPTIVE_THRESH_MEAN_C = 0,
    CV_THRESH_BINARY_INV  = 1;
	// Source path content images
	static String SRC_PATH = "";
	static String TESS_DATA = "C:/Program Files/Tesseract-OCR/tessdata";
	
	// Create tess obj
	static Tesseract tesseract = new Tesseract();
	
	// Load OPENCV
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		tesseract.setDatapath(TESS_DATA);
	}
	public reconocimientoOCR(String SRC) {
		this.SRC_PATH=SRC;
	}
	
	String extractTextFromImage(Mat inputMat) {
		String result = "";
		Mat gray = new Mat();
		
		// Convert to gray scale
		cvtColor(inputMat, gray, COLOR_BGR2GRAY);
		imwrite(SRC_PATH + "gray.png", gray);
		
		//  Apply closing, opening
		//Mat element = getStructuringElement(MORPH_RECT, new Size(2, 2), new Point(1, 1));
		//dilate(gray, gray, element);
		//erode(gray, gray, element);

		//imwrite(SRC_PATH + "closeopen.png", gray);

		try {
			// Recognize text with OCR
			result = tesseract.doOCR(new File(SRC_PATH + "gray.png"));
		} catch (TesseractException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public String getResultados() {
		System.out.println("Start recognize text from image");
		long start = System.currentTimeMillis();
	
		// Read image
		Mat origin = imread(SRC_PATH);
		
		String result = new reconocimientoOCR(SRC_PATH).extractTextFromImage(origin);
		System.out.println(result);
		
		System.out.println("Time");
		System.out.println(System.currentTimeMillis() - start);
		System.out.println("Done");
		
		return result;

	}
	
	
	public void getReconstruccion() {
		 
		String result="";
		Mat img = new Mat();
	        Mat imgGray = new Mat();
	        Mat imgGaussianBlur = new Mat();  
	        Mat imgSobel = new Mat();
	        Mat imgThreshold = new Mat();
	        Mat imgAdaptiveThreshold = new Mat();
	        Mat imgAdaptiveThreshold_forCrop = new Mat();
	        Mat imgMoprhological = new Mat();   
	        Mat imgContours = new Mat();
	        Mat imgMinAreaRect = new Mat();
	        Mat imgDetectedPlateCandidate = new Mat();
	        Mat imgDetectedPlateTrue = new Mat();
	        
	        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
	        
	        img = imread(SRC_PATH); 
	        //Imgcodecs.imwrite("changes/st/1_True_Image.png", img);
	        
	        Imgproc.cvtColor(img, imgGray, Imgproc.COLOR_BGR2GRAY);
	        imwrite( "C:/Users/Michael/Documents/gray1.png", imgGray);
	        
	        Imgproc.GaussianBlur(imgGray,imgGaussianBlur, new Size(3, 3),0); 
	        //Imgcodecs.imwrite("changes/st/3_imgGaussianBlur.png", imgGray);
	        
	        Imgproc.Sobel(imgGaussianBlur, imgSobel, -1, 1, 0);
	        //Imgcodecs.imwrite("changes/st/4_imgSobel.png", imgSobel);
	        
	        Imgproc.threshold(imgSobel, imgThreshold, 0, 255,  CV_THRESH_OTSU + CV_THRESH_BINARY);
	        //Imgcodecs.imwrite("changes/st/5_imgThreshold.png", imgThreshold);
	        
	        Imgproc.adaptiveThreshold(imgSobel, imgAdaptiveThreshold, 255, CV_ADAPTIVE_THRESH_GAUSSIAN_C, CV_THRESH_BINARY_INV, 75, 35);
	        //imwrite(SRC_PATH + "gray2.png", imgAdaptiveThreshold);
	        
	        Imgproc.adaptiveThreshold(imgGaussianBlur, imgAdaptiveThreshold_forCrop, 255, CV_ADAPTIVE_THRESH_MEAN_C, CV_THRESH_BINARY, 99, 4);
	        imwrite("C:/Users/Michael/Documents/gray2.png", imgAdaptiveThreshold_forCrop);
	        
	        Mat element = getStructuringElement(MORPH_RECT, new Size(17, 3));
	        Imgproc.morphologyEx(imgAdaptiveThreshold, imgMoprhological, CV_MOP_CLOSE, element); //или imgThreshold
	        //imwrite(SRC_PATH + "gray.png", imgMoprhological);
		
	        imgContours = imgAdaptiveThreshold_forCrop.clone();
	        Imgproc.findContours(imgContours,
	                contours,
	                new Mat(),
	                Imgproc.RETR_LIST,
	                Imgproc.CHAIN_APPROX_SIMPLE);
	        Imgproc.drawContours(imgContours, contours, -10, new Scalar(255,0,0));
	        imwrite("C:/Users/Michael/Documents/gray3.png", imgContours); 
	        
	        
	}
	
	public static void main(String[] args) {
		/*
		Mat img = new Mat();
		img = imread(SRC_PATH); 
		imwrite("gray.png", img);
		
		Mat imgGray = new Mat();
		cvtColor(img, imgGray, COLOR_BGR2GRAY);
		imwrite("gray.png", imgGray);
		
		Mat imgGaussianBlur = new Mat(); 
		Imgproc.GaussianBlur(imgGray,imgGaussianBlur,new Size(3, 3),0);
		
		Mat imgAdaptiveThreshold = new Mat();
		Imgproc.adaptiveThreshold(imgGaussianBlur, imgAdaptiveThreshold, 255, CV_ADAPTIVE_THRESH_MEAN_C ,CV_THRESH_BINARY, 99, 4);
		imwrite("gray.png", imgAdaptiveThreshold);
		*/
	}
	
}