package task1_5;

import java.util.Comparator;

public class CompareByID extends Decorator{

	public CompareByID(Comparator<Base> comparator) {
		super(comparator);
	}
	public CompareByID() {
	}
	@Override
	public int compare(Base a, Base b) {
		return a.getId().compareTo(b.getId());
	}


}
