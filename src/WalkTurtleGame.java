import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.*;

import sedgewick.Turtle;

/**
 * In this example you complete the two sections. First you will
 * configure the pins to read input. Then you will read the 
 * pins inside the scheduled thread to alter the game.
 * 
 * @author Joseph Paul Cohen
 */
public class WalkTurtleGame {

	public static void main(String[] args) {

		//Util.makeStdDrawFullScreen();
		
		double x0 = 0.5, y0 = 0.5, a0 = 0.0;
		final Turtle turtle = new Turtle(x0, y0, a0);
		final double step = 0.002, turn = 90;
		
		///////////////////////////////////////
		// Configure GPIO pins here
		
		
		
		
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
		
			double rot = 0, spd = 0;
		
			@Override
			public void run() {
		
				///////////////////////////////
				// read GPIO pins and set new rotation and speed here
				
				if (true /*check if GPIO is 1*/)
					rot = (rot + turn)%360;
			    else
			    	rot = 0;
					
				if (true /*check if GPIO is 1*/)
					spd += step;
			    else
			    	spd = 0;
					
				System.out.println("rot=" + rot + ", spd=" + spd);
				
				turtle.goForward(spd);
				turtle.turnLeft(rot);
		
			}
		}, 0, 500, TimeUnit.MILLISECONDS);
	}
}
