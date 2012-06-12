package task1_5;

import java.util.Comparator;

abstract public class Decorator implements Comparator<Base>{
	protected Comparator<Base> comparator;

	protected Decorator(Comparator<Base> comparator) {
		super();
		this.comparator = comparator;
	}
	public Decorator() {
	}
	public int comp(Base a, Base b){
		int ret = compare(a, b);
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
