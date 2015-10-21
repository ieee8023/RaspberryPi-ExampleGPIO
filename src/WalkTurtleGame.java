import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
		
		double x0 = 0.5;
		double y0 = 0.5;
		double a0 = 0.0;
		final Turtle turtle = new Turtle(x0, y0, a0);
		final double step = 0.002;
		final double turn = 90;
		
		///////////////////////////////////////
		// Configure GPIO pins here
		
		
		
		
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {

			double rotation = 0;
			double speed = 0;

			@Override
			public void run() {

				///////////////////////////////
				// read GPIO pins and set new rotation and speed here
				
				if (true /*check if GPIO is 1*/)
					rotation = (rotation + turn)%360;
					
				if (true /*check if GPIO is 1*/)
					speed = speed + step;
					
				System.out.println("rotation=" + rotation + ", speed=" + speed);
				
				turtle.goForward(speed);
				turtle.turnLeft(rotation);

			}
		}, 0, 500, TimeUnit.MILLISECONDS);
		
	}
}
