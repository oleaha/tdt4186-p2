/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman implements Runnable {

	private CustomerQueue queue;
	private Gui gui;
	private Thread thread;
	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */
	public Doorman(CustomerQueue queue, Gui gui) { 
		this.queue = queue;
		this.gui = gui;
		this.thread = new Thread(this, "Doorman");

		this.gui.println("Doorman created!");
	}

	public void run() {

		while(true) {
			this.addCustomer();
            this.doormanSleep();
		}
	}

	private void addCustomer() {
		this.gui.println("Try to add new customer to queue");
		Customer cust = new Customer();
		this.queue.enqueue(cust);
		this.gui.println("Customer #" + Integer.toString(cust.getCustomerID()) + " added to queue");
		this.gui.fillLoungeChair(this.queue.getNumberOfCustomersInQueue() - 1, cust);
	}

    private void doormanSleep() {
        try {
            this.gui.println("Doorman is sleeping");
            Thread.sleep(Globals.doormanSleep);
        } catch (InterruptedException e) {

        }
    }

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
		this.gui.println("Doorman thread started");
		this.thread.start();
	}

	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
		// Incomplete
	}



	// Add more methods as needed
}
