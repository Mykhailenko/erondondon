package task6_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simple {
	public static void main(String [] args) throws InterruptedException{
		long start = System.nanoTime();
		int N = 6;
		int SIZE = 10000;
		int [] numbers = new int[SIZE];
		for(int i = 0; i < SIZE; ++i){
			numbers[i] = i + 2;
		}
		List<SimpleNumberFinder> threads = new ArrayList<SimpleNumberFinder>();
		List<Integer> synch = Collections.synchronizedList(new ArrayList<Integer>());
		for(int i = 0; i < N; ++i){
			threads.add(new SimpleNumberFinder(numbers, N , i + 2, synch));
		}
		for(Thread t : threads){
			t.start();
		}
		for(Thread t : threads){
			t.join();
		}
		List<Integer> result = new ArrayList<Integer>();
//		for(SimpleNumberFinder s : threads){
//			result.addAll(s.getSimple());
//		}
		Collections.sort(result);
		long time = System.nanoTime() - start;
		System.out.println(time);
//		for(int i = 0; i < 100; ++i){
//			System.out.println(result.get(i));
//		}
	}
}
