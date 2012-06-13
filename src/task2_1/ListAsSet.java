package task2_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.ListIterator;
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
		int beforeSize = size();
		for(Object  o : c){
			add((E) o);
		}
		return beforeSize != size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		int sizeBefore = size();
		int i = 0;
		for(Object o : c){
			if(!contains(o)){
				super.add(index + i, (E) o);
				++i;
			}
		}
		return size() != sizeBefore;
	}
	@Override
	public ListIterator<E> listIterator() {
		return new ListIter();
	}
	@Override
	public ListIterator<E> listIterator(int paramInt) {
		return new ListIter(paramInt);
	}
	private class ListIter implements ListIterator<E>{
		ListIterator<E> it;
		protected ListIter() {
			it = ListAsSet.this.listIterator();
		}
		protected ListIter(int index) {
			it = ListAsSet.this.listIterator(index);
		}
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public E next() {
			return it.next();
		}

		@Override
		public boolean hasPrevious() {
			return it.hasPrevious();
		}

		@Override
		public E previous() {
			return it.previous();
		}

		@Override
		public int nextIndex() {
			return it.nextIndex();
		}

		@Override
		public int previousIndex() {
			return it.previousIndex();
		}

		@Override
		public void remove() {
			it.remove();
		}

		@Override
		public void set(E e) {
			if(!contains(e)){
				it.set(e);
			}
		}

		@Override
		public void add(E e) {
			if(!contains(e)){
				it.add(e);
			}
		}
	}
	
	@Override
	public E set(int paramInt, E e) {
		if(!contains(e)){
			return super.set(paramInt, e);
		}else{
			return get(paramInt);
		}
	}
}
