package task1_2;

import java.util.Iterator;
import java.util.List;

public interface AdvancedList<T> extends List<T> {
	Iterator<T> iterator(Predicate predicate);
}
