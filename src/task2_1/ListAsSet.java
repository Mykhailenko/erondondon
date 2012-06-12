package task2_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ListAsSet<E> extends ArrayList<E> {
	private static final long serialVersionUID = -8257913880706490301L;

	@Override
	public boolean add(E e) {
		if(!contains(e)){
			return super.add(e);
		}else{
			return false;
		}
	}

	@Override
	public void add(int index, E element) {
		if(!contains(element)){
			super.add(index, element);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends E> c) {
		Set<E> set = new HashSet<E>(); 
		for(Object o : c){
			if(!contains(o)){
				set.add((E) o);
			}
		}
		return super.addAll(set);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		Set<E> set = new HashSet<E>(); 
		for(Object o : c){
			if(!contains(o)){
				set.add((E) o);
			}
		}
		return super.addAll(index, set);
	}

}
