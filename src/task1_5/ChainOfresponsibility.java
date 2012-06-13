package task1_5;

import java.util.Comparator;

abstract public class ChainOfresponsibility<E> implements Comparator<E>{
	protected Comparator<E> comparator;

	protected ChainOfresponsibility(Comparator<E> comparator) {
		super();
		this.comparator = comparator;
	}
	public ChainOfresponsibility() {
	}
	protected abstract int comp(E a, E b);
	
	public int compare(E a, E b){
		int ret = comp(a, b);
		if(ret != 0){
			return ret;
		}else{
			if(comparator != null){
				return comparator.compare(a, b);
			}else{
				return ret;
			}
		}
	}
}
