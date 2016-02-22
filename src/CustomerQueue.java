import java.util.*;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {

	private int queueLength;
	private Gui gui;
    private LinkedList<Customer> customers;
    private LinkedList<Integer> seatPosition;
    private Customer lastCustomer;
    //private int seatPosition;


	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
    public CustomerQueue(int queueLength, Gui gui) {
		this.queueLength = queueLength;
		this.gui = gui;
        this.customers = new LinkedList<>();
        this.seatPosition = new LinkedList<>();
        this.lastCustomer = null;
	}

	/**
	 * Add customer to queue
 	 * @param customer
     * @retur The position of the customer in the queue
	 */
	public synchronized void enqueue(Customer customer, int pos) {

        while(true) {
            if(this.customers.size() < this.queueLength) {
                this.customers.add(customer);
                this.seatPosition.add(pos);
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

	/**
	 * Remove customer from queue
	 */
	public synchronized int dequeue() {
        if(this.customers.size() > 0) {
            this.lastCustomer = this.customers.poll();
            int pos = this.seatPosition.poll();
            notifyAll();
            return pos;
        }
        return -1;
	}

    public Customer getLastCustomer() {
        return this.lastCustomer;
    }

}
