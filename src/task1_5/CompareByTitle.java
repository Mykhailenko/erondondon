package task1_5;

import java.util.Comparator;

public class CompareByTitle<E> extends ChainOfresponsibility<E>{

	public CompareByTitle(Comparator<E> comparator) {
		super(comparator);
	}
	public CompareByTitle() {
	}
	@Override
	protected int comp(Object a, Object b) {
		return ((Base)a).getTitle().compareTo(((Base)b).getTitle());
	}

}
