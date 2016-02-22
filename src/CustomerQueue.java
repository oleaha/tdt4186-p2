import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {

	private int queueLength;
	private Gui gui;
    private LinkedList<Customer> customers;
    private int headOfQueue;


	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
    public CustomerQueue(int queueLength, Gui gui) {
		this.queueLength = queueLength;
		this.gui = gui;
        this.customers = new LinkedList<>();
	}

	/**
	 * Add customer to queue
 	 * @param customer
     * @retur The position of the customer in the queue
	 */
	public synchronized void enqueue(Customer customer) {

        while(true) {

            if(this.customers.size() < Globals.NOF_CHAIRS) {
                this.customers.add(customer);
                return;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }

            }
        }
	}

    public int getNumberOfCustomersInQueue() {
        return this.customers.size();
    }

	/**
	 * Remove customer from queue
	 * @param customer
	 */
	public synchronized void dequeue(Customer customer) {

	}
}
