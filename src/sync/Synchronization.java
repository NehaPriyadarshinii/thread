package sync;

import java.util.ArrayList;

public class Synchronization {
	ArrayList<Integer> array = new ArrayList<>();

	public static void main(String[] args) {
		OperateArray oper = new OperateArray();
		Adding ad = new Adding(oper);
		Thread adder = new Thread(ad);
		Removing rm = new Removing(oper);
		Thread remover = new Thread(rm);
		adder.start();
		remover.start();
	}
}

class OperateArray {
	ArrayList<Integer> array = new ArrayList<>();

	public synchronized void addToList(int value) {
		array.add(value);
		if (array.contains(value)) {
			notify();
		}
		System.out.println(array);
	}

	public synchronized void removeFromList() {
		if (!array.isEmpty()) {
			array.remove(0);
			System.out.println(array);
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Adding implements Runnable {
	OperateArray oa;

	public Adding(OperateArray op) {
		super();
		this.oa = op;
	}

	@Override
	public void run() {
		for (int iter = 0; iter < 10; iter++) {
			oa.addToList(iter);
		}
	}

}

class Removing implements Runnable {
	OperateArray ob;

	public Removing(OperateArray op) {
		super();
		this.ob = op;
	}

	@Override
	public void run() {
		for (int iter = 0; iter < 10; iter++) {
			ob.removeFromList();
		}

	}
}
