package task1_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class MyCollections {
	public static void main(String [] args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(24);
		list.add(883);
		list.add(10);
		list.add(-4);
		list.add(3);
		list.add(21);
		list.add(11);
		for(Integer i : list){
			System.out.print(i + " ");
		}
		System.out.println();
		MyCollections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(o1 % 2 == 0 && o2 % 2 == 1){
					return 1;
				}else if(o1 % 2 == 1 && o2 % 2 == 0){
					return -1;
				}else{
					return 0;
				}
			};
		});
		for(Integer i : list){
			System.out.print(i + " ");
		}
	}
    @SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void sort(List<T> list) {
    	Object [] arr = list.toArray();
    	mergeSort(arr, 0, arr.length - 1);
    	ListIterator<T> it = list.listIterator();
    	for (int j = 0; j < arr.length; ++j) {
    	    it.next();
    	    it.set((T)arr[j]);
    	}
	}
    private static <T extends Comparable<? super T>> void mergeSort(Object [] arr, int from, int to){
    	if(from < to){
    		int middle = from / 2 + to / 2;
    		mergeSort(arr, from, middle);
    		mergeSort(arr, middle + 1, to);
    		mergeSplit(arr, from, middle, to);
    	}
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends Comparable<? super T>> void mergeSplit(Object [] arr, int from, int middle, int to){
    	Object [] first = Arrays.copyOfRange(arr, from, middle + 1);
    	Object [] second = Arrays.copyOfRange(arr, middle + 1, to + 1);
    	int iOriginal = from;
    	int iFirst = 0;
    	int iSecond = 0;
    	for(; iFirst < first.length && iSecond < second.length; ++iOriginal){
    		if(((Comparable)first[iFirst]).compareTo(second[iSecond]) <= 0){
    			arr[iOriginal] = first[iFirst++];
    		}else{
    			arr[iOriginal] = second[iSecond++];
    		}
    	}
    	if(iFirst == first.length){
    		System.arraycopy(second, iSecond, arr, iOriginal, second.length - iSecond);
    	}else{
    		System.arraycopy(first, iFirst, arr, iOriginal, first.length - iFirst);
    	}
    }
    @SuppressWarnings("unchecked")
	public static <T> void sort(List<T> list, Comparator<? super T> c) {
    	Object [] arr = list.toArray();
    	mergeSort(arr, 0, arr.length - 1, c);
    	ListIterator<T> it = list.listIterator();
    	for (int j = 0; j < arr.length; ++j) {
    	    it.next();
    	    it.set((T)arr[j]);
    	}
    }
    private static <T extends Comparable<? super T>> void mergeSort(Object [] arr, int from, int to, Comparator<? super T> c){
    	if(from < to){
    		int middle = from / 2 + to / 2;
    		mergeSort(arr, from, middle, c);
    		mergeSort(arr, middle + 1, to, c);
    		mergeSplit(arr, from, middle, to, c);
    	}
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends Comparable<? super T>> void mergeSplit(Object [] arr, int from, int middle, int to, Comparator c){
    	Object [] first = Arrays.copyOfRange(arr, from, middle + 1);
    	Object [] second = Arrays.copyOfRange(arr, middle + 1, to + 1);
    	int iOriginal = from;
    	int iFirst = 0;
    	int iSecond = 0;
    	for(; iFirst < first.length && iSecond < second.length; ++iOriginal){
    		if(c.compare(first[iFirst], second[iSecond]) <= 0){
    			arr[iOriginal] = first[iFirst++];
    		}else{
    			arr[iOriginal] = second[iSecond++];
    		}
    	}
    	if(iFirst == first.length){
    		System.arraycopy(second, iSecond, arr, iOriginal, second.length - iSecond);
    	}else{
    		System.arraycopy(first, iFirst, arr, iOriginal, first.length - iFirst);
    	}
    }
}
