package thread;

public class NameThread {

	public static void main(String[] args) {
		MyRunnable nr=new MyRunnable();
		Thread t=new Thread(nr);
		t.setName("fred");
		t.start();
		System.out.println("thread is"+Thread.currentThread().getName() );
	}

}
class MyRunnable implements Runnable
{
	public void run()
	{
		System.out.println("run by"+Thread.currentThread().getName());
	}
}
