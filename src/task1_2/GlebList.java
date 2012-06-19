package task1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class GlebList<T> implements AdvancedList<T>{
	private static final int INITIAL_CAPACITY = 100;
	private static final double K = 1.3;
	private Object [] content;
	private int size;
	
	public GlebList() {
		content = new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
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
	public Iterator<T> iterator() {
		return new GlebIter();
	}
	
	private class GlebIter implements Iterator<T>{
		private int cursor;
		protected int lastReturned = -1;
		@Override
		public boolean hasNext() {
			return cursor < size();
		}

		@Override
		public T next() {
			if(cursor >= size()){
				throw new NoSuchElementException();
			}
			lastReturned = cursor;
			++cursor;
			return (T) get(lastReturned);
		}

		@Override
		public void remove() {
			if(lastReturned < 0){
				throw new IllegalStateException();
			}
			GlebList.this.remove(lastReturned);
			cursor = lastReturned;
			lastReturned = -1;
		}
	}
	@Override
	public Object[] toArray() {
		return content.clone();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] paramArrayOfT) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(T e) {
		final int before = size;
		add(size, e);
		return size != before;
	}


	@Override
	public boolean addAll(Collection<? extends T> c) {
		return addAll(size, c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		if(0 <= index && index <= size){
			final Iterator<T> it = (Iterator<T>) c.iterator();
			int i = 0;
			while(it.hasNext()){
				T e = it.next();
				add(index + i, e);
				++i;
			}
			return !c.isEmpty();
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void add(int index, T e) {
		if(0 <= index && index <= size){
			expandIfNeed(size + 1);
			final Object [] shiftArray = Arrays.copyOfRange(content, index, size);
			content[index] = e;
			System.arraycopy(shiftArray, 0, content, index + 1, shiftArray.length);
			++size;
		}else{
			throw new IndexOutOfBoundsException(index + " : " + size);
		}
	}
	
	
	private void expandIfNeed(int needSize){
		assert needSize >= 0;
		if(needSize == content.length){
			if(content.length < Integer.MAX_VALUE / K){
				final int newSize = (int) (content.length * K);
				final Object [] oldContent = content;
				content = new Object[newSize];
				System.arraycopy(oldContent, 0, content, 0, oldContent.length);
			}else{
				throw new OutOfMemoryError();
			}
		}
	}
	private void collapseIfNeed(int needSize){
		assert needSize >= 0;
		if(needSize * K < content.length){
			final Object [] oldContent = content;
			content = new Object[needSize];
			System.arraycopy(oldContent, 0, content, 0, needSize);
		}
	}
	
	@Override
	public boolean remove(Object o) {
		final int index = indexOf(o);
		if(index != -1){
			remove(index);
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean removeAll(Collection<?> с) {
		for(Object o : с){
			int index =  indexOf(o);
			while(index != -1){
				remove(index);
				index = indexOf(o);
			}
		}
		return !с.isEmpty();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		if(0 <= index && index < size && size > 0){
			final Object [] oldContent = content;
			content = new Object[size - 1];
			System.arraycopy(oldContent, 0, content, 0, index);
			System.arraycopy(oldContent, index + 1, content, index, size - index - 1);
			--size;
			collapseIfNeed(size);
			return (T) oldContent[index];
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean retainAll(Collection<?> paramCollection) {
		return false;
	}

	@Override
	public void clear() {
		if(content.length == INITIAL_CAPACITY){
			Arrays.fill(content, null);
		}else{
			content = new Object[INITIAL_CAPACITY]; 
		}
		size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if(0 <= index && index < size){
			return (T) content[index];
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T set(int index, T e) {
		if(0 <= index && index < size){
			final T old = (T) content[index];
			content[index] = e;
			return old;
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
	public int lastIndexOf(Object o) {
		for(int i = content.length-1; i >= 0; --i){
			if(content[i].equals(o)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int paramInt) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		if (fromIndex > 0 && toIndex <= size && fromIndex <= toIndex){
			final Object [] arr = new Object[toIndex-fromIndex];
			System.arraycopy(content, 0, arr, 0, arr.length);
			return new ArrayList(Arrays.asList(arr));
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public Iterator<T> iterator(Predicate predicate) {
		return new FilterIterator(predicate);
	}
	private class FilterIterator implements Iterator<T>{
		final private Predicate predicate;
		private Object nextObject;
		private int currentPosition;
		private int lastReturned;
		private FilterIterator(Predicate predicate) {
			this.predicate = predicate;
			this.nextObject = null;
			this.currentPosition = 0;
			this.lastReturned = -1;
		}
		@Override
		public boolean hasNext() {
			if(nextObject == null){
				for(int i = currentPosition; i < size; ++i){
					Object o = content[i];
					if(predicate.condition(o)){
						nextObject = o;
						currentPosition = i + 1;
						return true;
					}
				}
				return false;
			}else{
				return true;
			}
		}
		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			if(nextObject != null){
				lastReturned = currentPosition - 1;
				final T ret =  (T) nextObject;
				nextObject = null;
				return ret;
			}else{
				throw new IndexOutOfBoundsException();
			}
		}
		@Override
		public void remove() {
			if(lastReturned >= 0){
				GlebList.this.remove(lastReturned);
				++currentPosition;
				lastReturned = -1;
				nextObject = null;
			}else{
				throw new IllegalStateException();
			}
		}
	}
}
