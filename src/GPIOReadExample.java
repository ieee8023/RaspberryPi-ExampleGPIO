import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 * Here two pins are provisioned as input pins. One as the trigger that 
 * will launch a thread that will read and print another pins state.
 * 
 * @author Joseph Paul Cohen
 */
public class GPIOReadExample {

	public static void main(String[] args) throws Exception {
		
		final GpioController gpio = GpioFactory.getInstance();
		
		final GpioPinDigitalInput trigger = gpio.provisionDigitalInputPin(RaspiPin.GPIO_08, PinPullResistance.PULL_UP);
		final GpioPinDigitalInput input =   gpio.provisionDigitalInputPin(RaspiPin.GPIO_09, PinPullResistance.PULL_UP);
		
		trigger.setDebounce(100);
		
		trigger.addListener(new GpioPinListenerDigital(){
		
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				
				System.out.println(trigger.getPin() + " triggered!");
				
				PinState state = input.getState();
				
				if (state == PinState.HIGH)
					System.out.println(input.getPin() + " is high");
				else
					System.out.println(input.getPin() + " is low");
			}
			
		});
		
		System.out.println("Listening on " + trigger.getPin());
		
		while (true) Thread.sleep(500);
	
	}
}
