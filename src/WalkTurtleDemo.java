import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import sedgewick.Turtle;

/**
 * This example demos the Turtle graphics being used with a scheduled thread
 * 
 * @author Joseph Paul Cohen
 */
public class WalkTurtleDemo {

	public static void main(String[] args) {

		Util.makeStdDrawFullScreen();
		
		double x0 = 0.5;
		double y0 = 0.5;
		double a0 = 0.0;
		final Turtle turtle = new Turtle(x0, y0, a0);
		
		
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {

			double step = 0.002;

			@Override
			public void run() {

				turtle.goForward(step += 0.02);
				turtle.turnLeft(90);

			}
		}, 0, 1, TimeUnit.SECONDS);
		
	}
}
