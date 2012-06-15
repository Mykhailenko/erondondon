package task6_1;

import java.util.ArrayList;
import java.util.List;

public class SimpleNumberFinder extends Thread{
	private int [] numbers;
	private int step;
	private int from;
	private List<Integer> simple = new ArrayList<Integer>();
	
	
	public SimpleNumberFinder(int[] numbers, int step, int from,
			List<Integer> simple) {
		super();
		this.numbers = numbers;
		this.step = step;
		this.from = from;
		this.simple = simple;
	}
	@Override
	public void run() {
		for(int i = from; i < numbers.length; i += step){
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
}
