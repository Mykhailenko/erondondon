package task1_5;

import java.util.Comparator;

public class CompareByElse extends Decorator{

	public CompareByElse(Comparator<Base> comparator) {
		super(comparator);
	}
	public CompareByElse() {
	}
	@Override
	public int compare(Base a, Base b) {
		return a.getSomeelse().compareTo(b.getSomeelse());
	}

}
