package task1_6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import task1_2.GlebList;



public class ListBanchmark {
	@SuppressWarnings("unchecked")
	public static void main(String [] args){
		new ListBanchmark((Class<? extends List<Integer>>) GlebList.class);
		new ListBanchmark((Class<? extends List<Integer>>) ArrayList.class);
//		new ListBanchmark((Class<? extends List<Integer>>) LinkedList.class);
		
	}
	private void printTime(long time){
		System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName() + " : " + time);
	}
	private Class<? extends List<Integer>> cls;
	public ListBanchmark(Class<? extends List<Integer>> cls) {
		this.cls = cls;
		makeBenchmark();
	}
	private void makeBenchmark(){
		System.out.println("\tBenchmark for " + cls.getSimpleName());
		makeBenchmark(10, 100);
		makeBenchmark(10, 10000);
		makeBenchmark(10, 1000000);
		makeBenchmark(10, 5000000);
	}
	private void makeBenchmark(int times, int startSize){
		System.out.println("   Start size : " + startSize);
		addToStart(times, startSize);
		addToMiddle(times, startSize);
		addToEnd(times, startSize);
//		createByAddToStart(startSize);
//		createByAddToMiddle(startSize);
		createByAddToEnd(startSize);
		removeFromStart(times, startSize);
		removeFromMiddle(times, startSize);
		removeFromEnd(times, startSize);
		getFromStart(times, startSize);
		getFromMiddle(times, startSize);
		getFromEnd(times, startSize);
		subList(startSize);
		iterateThrowList(startSize);
	}
	private void subList(int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		int subListSize = startSize / 3;
		int from = startSize / 4;
		long start = System.nanoTime();
		list.subList(from, from + subListSize);
		long time = System.nanoTime() - start;
		printTime(time);
	}
	private void addToStart(int times, int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		long start = System.nanoTime();
		for(int i = 0; i < times; ++i){
			list.add(0, i);
		}
		long time = System.nanoTime() - start;
		printTime((time / times));
		
	}
	private void addToMiddle(int times, int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		int middleIndex = startSize / 2;
		long start = System.nanoTime();
		for(int i = 0; i < times; ++i){
			list.add(middleIndex, i);
		}
		long time = System.nanoTime() - start;
		printTime((time / times));
	}
	private void addToEnd(int times, int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		long start = System.nanoTime();
		for(int i = 0; i < times; ++i){
			list.add(i);
		}
		long time = System.nanoTime() - start;
		printTime((time / times));
	}
	@SuppressWarnings("unused")
	private void createByAddToStart(int finalSize){
		List<Integer> list = createAndFillTheList(0);
		long start = System.nanoTime();
		for(int i = 0; i < finalSize; ++i){
			list.add(0, i);
		}
		long time = System.nanoTime() - start;
		printTime(time);
	}
	@SuppressWarnings("unused")
	private void createByAddToMiddle(int finalSize){
		List<Integer> list = createAndFillTheList(0);
		long start = System.nanoTime();
		for(int i = 0; i < finalSize; ++i){
			list.add(list.size()/2, i);
		}
		long time = System.nanoTime() - start;
		printTime(time);
	}
	private void createByAddToEnd(int finalSize){
		List<Integer> list = createAndFillTheList(0);
		long start = System.nanoTime();
		for(int i = 0; i < finalSize; ++i){
			list.add(i);
		}
		long time = System.nanoTime() - start;
		printTime(time);
	}
	private void removeFromStart(int times, int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		long start = System.nanoTime();
		for(int i = 0; i < times; ++i){
			list.remove(0);
		}
		long time = System.nanoTime() - start;
		printTime((time / times));
	}
	private void removeFromMiddle(int times, int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		int middleIndex = startSize / 2;
		long start = System.nanoTime();
		for(int i = 0; i < times; ++i){
			list.remove(middleIndex);
		}
		long time = System.nanoTime() - start;
		printTime((time / times));
	}
	private void removeFromEnd(int times, int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		long start = System.nanoTime();
		for(int i = 0; i < times; ++i){
			list.remove(list.size() - 1);
		}
		long time = System.nanoTime() - start;
		printTime((time / times));
	}
	private void getFromStart(int times, int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		long start = System.nanoTime();
		for(int i = 0; i < times; ++i){
			list.get(0);
		}
		long time = System.nanoTime() - start;
		printTime((time / times));
	}
	private void getFromMiddle(int times, int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		int middleIndex = startSize / 2;
		long start = System.nanoTime();
		for(int i = 0; i < times; ++i){
			list.get(middleIndex);
		}
		long time = System.nanoTime() - start;
		printTime((time / times));
	}
	private void getFromEnd(int times, int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		long start = System.nanoTime();
		for(int i = 0; i < times; ++i){
			list.get(list.size() - 1);
		}
		long time = System.nanoTime() - start;
		printTime((time / times));
	
	}
	private void iterateThrowList(int startSize){
		List<Integer> list = createAndFillTheList(startSize);
		long start = System.nanoTime();
		for(Iterator<Integer> it = list.iterator(); 
				it.hasNext(); it.next());
		long time = System.nanoTime() - start;
		printTime(time);
	}
	private List<Integer> createAndFillTheList(int size){
		List<Integer> result = null;
		try {
			result = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < size; ++i){
			result.add(i);
		}
		return result;
	}
	
}
