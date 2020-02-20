package io.checksound.concurrency.prodcons;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<E> {

	private List<E> queue = new LinkedList<E>();
	private int limit;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(E item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		this.queue.add(item);
		if (this.queue.size() == 1) {
			notifyAll();
		}
	}

	public synchronized E dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

}