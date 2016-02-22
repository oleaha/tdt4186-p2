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

        while(true) {
            int pos = this.queue.dequeue();
            Customer cust = this.queue.getLastCustomer();


            if(pos >= 0) {
                this.gui.println("Remove customer from chair");

                this.gui.emptyLoungeChair(pos);

                this.gui.fillBarberChair(this.pos, cust);

            }

            try {
                int random_work = Globals.MIN_BARBER_WORK + (int)(Math.random()*(Globals.MAX_BARBER_WORK-Globals.MIN_BARBER_WORK +1));
                int random_sleep = Globals.MIN_BARBER_SLEEP + (int)(Math.random()*(Globals.MAX_BARBER_SLEEP-Globals.MIN_BARBER_SLEEP +1));

                this.gui.barberIsAwake(this.pos);
                Thread.sleep(random_work);

                this.gui.emptyBarberChair(this.pos);

                this.gui.barberIsSleeping(this.pos);
                Thread.sleep(random_sleep);

            } catch (InterruptedException e) {

            }


        }
    }

        /**
         * 1: Check queue
         * 2: Remove customer from queue and into barber chair
         * 3: Barber works for a time
         * 4: Barber is done with customer, remove customer from chair
         * 5: Barber daydreams
         */

}



