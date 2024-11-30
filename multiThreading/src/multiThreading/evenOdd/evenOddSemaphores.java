package multiThreading.evenOdd;

import java.util.concurrent.Semaphore;

public class evenOddSemaphores {

	private static final int max =50;
	private static final Semaphore odd = new Semaphore(1);
	private static final Semaphore even = new Semaphore(0);
	
	public static void main(String[] args) {
		Thread odd = new Thread(() -> oddNumbers());
		Thread even = new Thread(() -> evenNumbers());

		odd.start();
		even.start();
	}

	private static Object evenNumbers() {
		for(int i= 1 ;i <=max ; i+=2) {
			try {
				odd.acquire();
				System.out.println(i);
				even.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

	private static Object oddNumbers() {
		for(int i= 2 ;i <=max ; i+=2) {
			try {
				even.acquire();
				System.out.println(i);
				odd.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
}
