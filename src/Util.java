import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JFrame;

import sedgewick.StdDraw;

/**
 * This Util class contains helpful functions for the examples.
 * 
 * @author Joseph Paul Cohen
 */
public class Util {

	public static void makeStdDrawFullScreen(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		StdDraw.setCanvasSize(width,height);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		GraphicsDevice gd = ge.getScreenDevices()[0];
		
		// I had to modify StdDraw to expose this JFrame
		// Don't tell Robert Sedgewick that I broke encapsulation!
		gd.setFullScreenWindow(StdDraw.frame);
	}
	
	public static void wakeScreen(JFrame frame){
		
		try{
		
	        Robot robot = new Robot();
	        // to the left
	        robot.mouseMove(0, frame.getHeight());
	        Thread.sleep(1);
	        // to the right
	        robot.mouseMove(frame.getWidth(), frame.getHeight());
	        
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
