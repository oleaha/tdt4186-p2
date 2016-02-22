/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
public class Barber implements Runnable {

	private Gui gui;
	private CustomerQueue queue;
	private int pos;
    private Thread thread;
	/**
	 * Creates a new barber.
	 * @param queue		The customer queue.
	 * @param gui		The GUI.
	 * @param pos		The position of this barber's chair
	 */
	public Barber(CustomerQueue queue, Gui gui, int pos) {
		this.queue = queue;
		this.gui = gui;
		this.pos = pos;
        this.thread = new Thread(this, "Barber");

        this.gui.println("Barber #" + Integer.toString(pos) + " created");
	}

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
		this.gui.println("Barber #" + Integer.toString(pos) + " thread started!");
        this.thread.start();
	}

	/**
	 * Stops the barber thread.
	 */
	public void stopThread() {
		// Incomplete
	}

    public void run() {

    }

	// Add more methods as needed
}

