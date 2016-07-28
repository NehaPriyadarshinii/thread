package thread;

public class ManyNames {
	public static void main(String[] args) {
		NameRunnable nr = new NameRunnable();
		Thread one = new Thread(nr);
		Thread two = new Thread(nr);
		Thread three = new Thread(nr);
		one.setName("fred");
		two.setName("lucy");
		three.setName("ricky");
		one.start();
		two.start();
		three.start();
	}

}

class NameRunnable implements Runnable {
	public void run() {
		for (int x = 1; x <= 3; x++) {
			System.out.println("run by " + Thread.currentThread().getName() + ",x is " + x);
			try{
				Thread.sleep(1000);
			}
				catch(InterruptedException ex){}
		}
			
		}
	}

