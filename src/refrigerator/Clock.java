
package refrigerator;

public class Clock implements Runnable {
    private static Refrigrator refrigrator;

	/**
	 * Creates the Microwave instance and start the thread
	 */
	public Clock() {
		refrigrator = refrigrator.instance();
		new Thread(this).start();
	}

	/**
	 * Keep ticking every second and call the microwave's clockTicked method
	 * 
	 */
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				refrigrator.clockTicked();
			}
		} catch (InterruptedException ie) {
		}
	}
}