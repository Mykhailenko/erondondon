package task6_1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class SimpleNumberFinder extends Thread implements Callable<List<Integer>>{
	private int high;
	private int step;
	private int from;
	private List<Integer> simple;
	
	
	public SimpleNumberFinder(int high, int step, int from,
			List<Integer> simple) {
		super();
		this.high = high; 
		this.step = step;
		this.from = from;
		this.simple = simple;
	}
	public SimpleNumberFinder(int high, int step, int from) {
		super();
		this.high = high; 
		this.step = step;
		this.from = from;
		this.simple = new LinkedList<Integer>();
	}
	@Override
	public void run() {
		for(int i = from; i < high; i += step){
			if(isSimple(i)){
				simple.add(i);
			}
		}
	}
	public boolean isSimple(int n){
		for(int i = 2; i <= n/2; ++i){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	public List<Integer> getSimple() {
		return simple;
	}
	@Override
	public List<Integer> call() throws Exception {
		run();
//		System.out.println("done!");
		return simple;
	}
}
