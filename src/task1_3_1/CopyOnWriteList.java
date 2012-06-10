package task1_3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CopyOnWriteList<E> implements List<E>{
	private Object [] content;

	public CopyOnWriteList() {
		content = new Object[0];
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(content);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof List))
			return false;
		Iterator<E> e1 = iterator();
		Iterator e2 = ((List) o).iterator();
		while (e1.hasNext() && e2.hasNext()) {
			E o1 = e1.next();
			Object o2 = e2.next();
			if (!(o1 == null ? o2 == null : o1.equals(o2)))
				return false;
		}
		return !(e1.hasNext() || e2.hasNext());
	}
	@Override
	public boolean add(E e) {
		int before = content.length;
		add(content.length, e);
		return content.length != before;
	}

	@Override
	public synchronized void add(int index, E element) {
		if(0 <= index && index <= content.length){
			Object [] oldContent = content;
			content = new Object[content.length+1];
			System.arraycopy(oldContent, 0, content, 0, index);
			content[index] = element;
			System.arraycopy(oldContent, index, content, index+1, oldContent.length-index);
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(E e : c){
			add(e);
		}
		return !c.isEmpty();
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		Iterator<E> it = (Iterator<E>) c.iterator();
		int i = 0;
		while(it.hasNext()){
			E e = it.next();
			add(index + i, e);
			++i;
		}
		return !c.isEmpty();

	}

	@Override
	public void clear() {
		for(int i = 0; i < content.length; ++i){
			content[i] = null;
		}
	}

	@Override
	public boolean contains(Object o) {
		for(int i = 0; i < content.length; ++i){
			if(content[i].equals(o)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o : c){
			if(!contains(o)){
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(0 <= index && index < content.length){
			return (E) content[index];
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(Object o) {
		for(int i = 0; i < content.length; ++i){
			if(content[i].equals(o)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return content.length == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iter(content);
	}
	private class Iter implements Iterator<E>{
		private int cursor;
		private int lastReturned;
		private Object [] content;
		public Iter(Object [] content) {
			this.content = content;
			cursor = 0;
			lastReturned = -1;
		}
		
		@Override
		public boolean hasNext() {
			return cursor != content.length;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if(cursor >= content.length){
				throw new NoSuchElementException();
			}
			lastReturned = cursor;
			++cursor;
			return (E) content[lastReturned];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	@Override
	public int lastIndexOf(Object o) {
		for(int i = content.length-1; i >= 0; --i){
			if(content[i].equals(o)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if(index != -1){
			remove(index);
			return true;
		}else{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if(0 <= index && index < content.length && content.length > 0){
			Object [] oldContent = content;
			content = new Object[content.length - 1];
			System.arraycopy(oldContent, 0, content, 0, index);
			System.arraycopy(oldContent, index + 1, content, index, oldContent.length - index - 1);
			return (E) oldContent[index];
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object o : c){
			int index =  indexOf(o);
			while(index != -1){
				remove(index);
				index = indexOf(o);
			}
		}
		return !c.isEmpty();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized E set(int index, E element) {
		if(0 <= index && index < content.length){
			Object [] oldContent = content;
			content = Arrays.copyOf(oldContent, oldContent.length);
			E e = (E) content[index];
			content[index] = element;
			return e;
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return content.length;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		Object [] arr = new Object[toIndex-fromIndex];
		System.arraycopy(content, 0, arr, 0, arr.length);
		return new ArrayList(Arrays.asList(arr));
	}

	@Override
	public Object[] toArray() {
		return content.clone();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}
}
