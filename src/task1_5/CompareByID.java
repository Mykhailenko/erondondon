package task1_5;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class CompareByID extends ChainOfresponsibility{

	@SuppressWarnings("unchecked")
	public CompareByID(Comparator<Base> comparator) {
		super(comparator);
	}
	public CompareByID() {
	}

	@Override
	protected int comp(Object a, Object b) {
		return ((Base)a).getId().compareTo(((Base)b).getId());
	}


}
