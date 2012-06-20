package task6_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


import task1.CellPhone;

public class Simple {
	public static void main(String [] args) throws InterruptedException, ExecutionException{
		int N = 6;
		int SIZE = 10000;
		benchAfterFuture(N, SIZE);
	}

	private static void bench(int N, int SIZE) throws InterruptedException {
		long start = System.nanoTime();
		List<SimpleNumberFinder> threads = new ArrayList<SimpleNumberFinder>();
		List<Integer> synch = Collections.synchronizedList(new LinkedList<Integer>());
		for(int i = 0; i < N; ++i){
			threads.add(new SimpleNumberFinder(SIZE, N , i + 2, synch));
		}
		for(Thread t : threads){
			t.start();
		}
		for(Thread t : threads){
			t.join();
		}
		long time = System.nanoTime() - start;
		System.out.println(time);
	}
	private static void benchAfter(int N, int SIZE) throws InterruptedException {
		long start = System.nanoTime();
		List<SimpleNumberFinder> threads = new ArrayList<SimpleNumberFinder>();
		List<Integer> result = new LinkedList<Integer>();
		for(int i = 0; i < N; ++i){
			threads.add(new SimpleNumberFinder(SIZE, N , i + 2));
		}
		for(Thread t : threads){
			t.start();
		}
		for(Thread t : threads){
			t.join();
		}
		for (Iterator<SimpleNumberFinder> it = threads.iterator(); it.hasNext();) {
			SimpleNumberFinder thread = (SimpleNumberFinder) it.next();
			result.addAll(thread.getSimple());
		}
		long time = System.nanoTime() - start;
		System.out.println(time);
	}
	private static void benchAfterFuture(int N, int SIZE) throws InterruptedException, ExecutionException {
		long start = System.nanoTime();
		ExecutorService executor = Executors.newFixedThreadPool(N);
		List<Future<List<Integer>>> futures = new ArrayList<Future<List<Integer>>>();
		for(int i = 0; i < N; ++i){
			Callable<List<Integer>> s = new SimpleNumberFinder(SIZE, N , i + 2);
			Future<List<Integer>> submit = executor.submit(s);
			futures.add(submit);
		}
		List<Integer> result = new LinkedList<Integer>();
		boolean stop = false;
		while(stop == false){
			for(int i = futures.size() - 1; i >= 0; --i){
				Future<List<Integer>> f = futures.get(i);
				if(f.isDone()){
					result.addAll(f.get());
					futures.remove(i);
				}
			}
			stop = futures.isEmpty();
		}
		long time = System.nanoTime() - start;
		System.out.println(time);
	}
}
