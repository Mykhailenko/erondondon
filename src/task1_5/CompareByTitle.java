package task1_5;

import java.util.Comparator;

public class CompareByTitle extends Decorator{

	public CompareByTitle(Comparator<Base> comparator) {
		super(comparator);
	}
	public CompareByTitle() {
	}
	@Override
	public int compare(Base a, Base b) {
		return a.getTitle().compareTo(b.getTitle());
	}

}
