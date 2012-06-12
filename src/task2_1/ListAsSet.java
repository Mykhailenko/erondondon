package task2_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListAsSet<E> extends ArrayList<E> {
	private static final long serialVersionUID = -8257913880706490301L;

	@Override
	public boolean add(E e) {
		final int before = size();
		add(before, e);
		return before != size();
	}

	@Override
	public void add(int index, E element) {
		if(!contains(element)){
			super.add(index, element);
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return addAll(size(), c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		Iterator<E> it = (Iterator<E>) c.iterator();
		for(int i = 0; it.hasNext(); ++i){
			add(i + index, it.next());
		}
		return !c.isEmpty();
	}

}
