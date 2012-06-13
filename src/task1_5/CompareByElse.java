package task1_5;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class CompareByElse extends ChainOfresponsibility{

	public CompareByElse(Comparator<Base> comparator) {
		super(comparator);
	}
	public CompareByElse() {
	}
	@Override
	public int comp(Object a, Object b) {
		return ((Base)a).getSomeelse().compareTo(((Base)b).getSomeelse());
	}

}
