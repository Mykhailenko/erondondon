package task1_4_1;

import java.lang.reflect.Array;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class WeirdList<E> implements List<E>{
	private final List<E> unmodifiableList;
	private final List<E> modifiableList;
	private final int unmodifiableListSize;
	
	public WeirdList(List<E> unmodifiableList,	List<E> modifiableList	) {
		super();
		this.unmodifiableList = unmodifiableList;
		this.modifiableList = modifiableList;
		if(this.unmodifiableList == null ||
				this.modifiableList == null){
			throw new IllegalArgumentException();
		}
		this.unmodifiableListSize = unmodifiableList.size();
	}

	@Override
	public boolean add(E arg0) {
		return modifiableList.add(arg0);
	}

	@Override
	public void add(int index, E obj) {
		if(0 <= index && index < size()){
			if(index >= unmodifiableListSize){
				modifiableList.add(index - unmodifiableListSize, obj);
			}else{
				throw new ReadOnlyBufferException();
			}
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		return modifiableList.addAll(arg0);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> obj) {
		if(0 <= index && index < size()){
			if(index >= unmodifiableListSize){
				return modifiableList.addAll(index - unmodifiableListSize, obj);
			}else{
				throw new ReadOnlyBufferException();
			}
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void clear() {
		modifiableList.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		return indexOf(arg0) >= 0;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		 for (Object e : arg0){
			  if (!contains(e)){
				  return false;
			  }
		 }
		 return true;
	}

	@Override
	public E get(int index) {
		if(0 <= index && index < size()){
			if(index < unmodifiableListSize){
				return unmodifiableList.get(index);
			}else{
				return modifiableList.get(index - unmodifiableListSize);
			}
		}else{
			throw new IndexOutOfBoundsException("Index: " + index);
		}
	}

	@Override
	public int indexOf(Object arg0) {
		final int indexUnmod = unmodifiableList.indexOf(arg0);
		if(indexUnmod >= 0){
			return indexUnmod;
		}
		final int indexMod = modifiableList.indexOf(arg0);
		if(indexMod >= 0){
			return indexMod + unmodifiableListSize;
		}else{
			return -1;
		}
	}

	@Override
	public boolean isEmpty() {
		return unmodifiableList.isEmpty() && modifiableList.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iter();
	}

	@Override
	public int lastIndexOf(Object arg0) {
		final int indexMod = modifiableList.lastIndexOf(arg0);
		if(indexMod >= 0){
			return indexMod + unmodifiableListSize;
		}
		final int indexUnmod = unmodifiableList.lastIndexOf(arg0);
		if(indexUnmod >= 0){
			return indexUnmod;
		}else{
			return -1;
		}
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ListIter(0);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new ListIter(index);
	}

	@Override
	public boolean remove(Object obj) {
		if(!unmodifiableList.contains(obj)){
			return modifiableList.remove(obj);
		}else{
			throw new ReadOnlyBufferException();
		}
	}

	@Override
	public E remove(int index) {
		if(0 <= index && index < size()){
			if(index >= unmodifiableListSize){
				return modifiableList.remove(index - unmodifiableListSize);
			}else{
				throw new ReadOnlyBufferException();
			}
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean noOneInUnmodifiableList = true;
		for(Object o : c){
			if(unmodifiableList.contains(o)){
				noOneInUnmodifiableList = false;
				break;
			}
		}
		if(noOneInUnmodifiableList){
			final int sizeBefore = size();
			for(Object o : c){
				while(modifiableList.contains(o)){
					modifiableList.remove(o);
				}
			}
			final int sizeAfter = size();
			return sizeBefore != sizeAfter;
		}else{
			throw new ReadOnlyBufferException();
		}
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if(c.containsAll(unmodifiableList)){
			final int sizeBefore = size();
			for(int i = modifiableList.size()-1; i >= 0; --i){
				if(!c.contains(modifiableList.get(i))){
					modifiableList.remove(i);
				}
			}
			final int sizeAfter = size();
			return sizeBefore != sizeAfter;
		}else{
			throw new ReadOnlyBufferException();
		}
	}

	@Override
	public E set(int index, E obj) {
		if(index >= unmodifiableListSize){
			return modifiableList.set(index - unmodifiableListSize, obj);
		}else{
			throw new ReadOnlyBufferException();
		}
	}

	@Override
	public int size() {
		return unmodifiableListSize +  modifiableList.size();
	}

	@Override
	public List<E> subList(int from, int to) {
		final List<E> newList = new ArrayList<E>();
		for(int index = from; index < to; ++index){
			newList.add(get(index));
		}
		return newList;
	}
	
	@Override
	public Object[] toArray() {
		final int size = size();
		final Object [] result = new Object[size];
		copyContentToArray(result);
		return result;
	}
	private void copyContentToArray(Object [] arr){
		final int size = size();
		for(int i = 0; i < size; ++i){
			arr[i] = get(i);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] arr) {
		final int size = size();
		if(arr.length == size){
			copyContentToArray(arr);
			return arr;
		}else if(arr.length > size){
			copyContentToArray(arr);
			Arrays.fill(arr, size, arr.length, null);
			return arr;
		}else{
			final T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), size);
			copyContentToArray(newArr);
			return newArr;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((modifiableList == null) ? 0 : modifiableList.hashCode());
		result = prime
				* result
				+ ((unmodifiableList == null) ? 0 : unmodifiableList.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof List))
			return false;
		final ListIterator<E> e1 = listIterator();
		final ListIterator e2 = ((List) o).listIterator();
		while (e1.hasNext() && e2.hasNext()) {
			E o1 = e1.next();
			Object o2 = e2.next();
			if (!(o1 == null ? o2 == null : o1.equals(o2)))
				return false;
		}
		return !(e1.hasNext() || e2.hasNext());
	}
	private class Iter implements Iterator<E>{
		protected int cursor;
		protected int lastReturned = -1;
		@Override
		public boolean hasNext() {
			return cursor < size();
		}

		@Override
		public E next() {
			if(cursor >= size()){
				throw new NoSuchElementException();
			}
			lastReturned = cursor;
			++cursor;
			return (E) get(lastReturned);
		}

		@Override
		public void remove() {
			if(lastReturned < 0){
				throw new IllegalStateException();
			}
			WeirdList.this.remove(lastReturned);
			cursor = lastReturned;
			lastReturned = -1;
		}
	}
	private class ListIter extends Iter implements ListIterator<E>{
		private ListIter(int index) {
			super();
			cursor = index;
		}

		@Override
		public void add(E e) {
			WeirdList.this.add(cursor, e);
			lastReturned = -1;
			++cursor;
		}

		@Override
		public boolean hasPrevious() {
			return cursor > 0;
		}

		@Override
		public int nextIndex() {
			return cursor;
		}

		@Override
		public E previous() {
			if(cursor == 0){
				throw new NoSuchElementException();
			}
			--cursor;
			lastReturned = cursor;
			return get(lastReturned);
		}

		@Override
		public int previousIndex() {
			return cursor - 1;
		}

		@Override
		public void set(E e) {
			if(lastReturned < 0){
				throw new IllegalStateException();
			}
			WeirdList.this.set(lastReturned, e);
		}
		
	}
}
