package multiThreading.evenOdd;

public class EvenOdd {

	private static boolean isOdd = true;
	private static final Object lock = new Object();

	public static void main(String[] args) {
		int max =50;
		Thread odd = new Thread(() -> oddNumbers(max));
		Thread even = new Thread(() -> evenNumbers(max));

		odd.start();
		even.start();
	}

	private static Object evenNumbers(int max) {
		for(int i =1 ;i <= max ; i+=2) {
			synchronized(lock){
				while(!isOdd) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(i);
				isOdd = false;
				lock.notify();
			}
		}
		return null;
	}

	private static Object oddNumbers(int max) {
		for(int i = 2;i <= max ; i+=2) {
			synchronized(lock){
				while(isOdd) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(i);
				isOdd = true;
				lock.notify();
			}
		}
		return null;
	}

}
