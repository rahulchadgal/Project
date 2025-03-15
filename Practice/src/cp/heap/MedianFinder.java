package cp.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
	Queue<Integer> maxx;
	Queue<Integer> minn;

	public MedianFinder() {
		maxx = new PriorityQueue<>(Comparator.reverseOrder());
		minn = new PriorityQueue<>();

	}

	public void addNum(int num) {
		maxx.add(num);
		minn.add(maxx.poll());
		if (minn.size() > maxx.size())
			maxx.add(minn.poll());

	}

	public double findMedian() {
		if (maxx.size() == minn.size()) {
			System.out.println((double) (maxx.peek() + minn.peek()) / 2.0);
			return (double) (maxx.peek() + minn.peek()) / 2.0;
		}
		System.out.println(maxx.peek());
		return maxx.peek();
	}

	public static void main(String[] args) {
		MedianFinder obj = new MedianFinder();
		obj.addNum(1);
		double param_2 = obj.findMedian();
	}

}
