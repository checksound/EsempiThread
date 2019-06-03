package examples.thread;

public class TimerTest {

	public static void main(String[] args) {
		
		final TimerTask t1 = new TimerTask() { // Task 1: print "boom"
			public void run() {
				System.out.println("boom");
			}
		};
		
		final TimerTask t2 = new TimerTask() { // Task 2: print "BOOM"
			public void run() {
				System.out.println("\tBOOM");
			}
		};
		
		final TimerTask t3 = new TimerTask() { // Task 3: cancel the tasks
			public void run() {
				System.out.println("RUN CANCEL");
				t1.cancel();
				t2.cancel();
			}
		};

		// Create a timer, and schedule some tasks
		final Timer timer = new Timer();
		timer.schedule(t1, 0, 500); // boom every .5sec starting now
		timer.schedule(t2, 2000, 2000); // BOOM every 2s, starting in 2s
		timer.schedule(t3, 5000); // Stop them after 5 seconds

		// Schedule a final task: starting in 5 seconds, count
		// down from 5, then destroy the timer, which, since it is
		// the only remaining thread, will cause the program to exit.
		timer.scheduleAtFixedRate(new TimerTask() {
			public int times = 5;

			public void run() {
				System.out.println(times--);
				if (times == 0)
					timer.cancel();
			}
		}, 5000, 500);
	}

}
