package task1_3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CopyOnWriteList<E> implements List<E>{
	private Object [] content;
	public CopyOnWriteList() {
		content = new Object[0];
	}

	@Override
	public boolean add(E e) {
		int before = content.length;
		add(content.length -1 , e);
		return content.length != before;
	}

	@Override
	public synchronized void add(int index, E element) {
		Object [] oldContent = content;
		content = new Object[content.length+1];
		System.arraycopy(oldContent, 0, content, 0, index);
		content[index] = element;
		System.arraycopy(oldContent, index, content, index+1, oldContent.length-index);
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
		return (E) content[index];
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
		return null;
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

	@Override
	public E remove(int index) {
		return null;
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
	public E set(int index, E element) {
		E e = (E) content[index];
		content[index] = element;
		return e;
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
