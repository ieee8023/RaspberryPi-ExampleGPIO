import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


/**
 * Here one pin is provisioned. A scheduled task causes the output 
 * to flip between high and low.
 * 
 * @author Joseph Paul Cohen
 */
public class GPIOWriteExample {

	public static void main(String[] args) throws Exception {
		
    final GpioController gpio = GpioFactory.getInstance();
    
    final GpioPinDigitalOutput output = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);

	ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
	exec.scheduleAtFixedRate(new Runnable() {

		@Override
		public void run() {

			if (output.getState() != PinState.LOW)
				output.setState(PinState.LOW);
			else
				output.setState(PinState.HIGH);

		}
	}, 0, 100, TimeUnit.MILLISECONDS);
	    
	System.out.println("Writing to " + output.getPin());
	
	}
}
