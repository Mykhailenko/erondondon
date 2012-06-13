package task1_5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import task2_1.Pair;
import static org.junit.Assert.assertEquals;

public class SortUtilTest {
	@SuppressWarnings("unchecked")
	@Test
	public void test1(){
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(24);
//		list.add(883);
//		list.add(10);
//		list.add(-4);
//		list.add(3);
//		list.add(21);
//		list.add(11);
//		SortUtil.sort(list);
//		List<Integer> right = new ArrayList<Integer>();
//		right.add(-4);
//		right.add(3);
//		right.add(10);
//		right.add(11);
//		right.add(21);
//		right.add(24);
//		right.add(883);
//		assertEquals(right, list);
		List<Pair> pp = new ArrayList<Pair>();
		pp.add(new Pair("1", "c"));
		pp.add(new Pair("2", "c"));
		pp.add(new Pair("2", "b"));
		pp.add(new Pair("4", "z"));
		pp.add(new Pair("4", "a"));
		Comparator<Pair> compareById = new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				return a.getId().compareTo(b.getId());
			}
		};
		Comparator<Pair> compareByName = new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				return a.getName().compareTo(b.getName());
			}
		};
//		SortUtil.sort(pp, compareByName, compareById);
//		for(Pair p : pp){
//			System.out.println(p);
//		}
//		SortUtil.sort(list, new Comparator<Integer>() {
//			public int compare(Integer o1, Integer o2) {
//				if(o1 % 2 == 0 && o2 % 2 == 1){
//					return 1;
//				}else if(o1 % 2 == 1 && o2 % 2 == 0){
//					return -1;
//				}else{
//					return 0;
//				}
//			};
//		});
	}
	@Test
	public void decorator(){
		List<Base> list = new ArrayList<Base>();
		list.add(new Base("2", "c", "f"));
		list.add(new Base("3", "d", "tb"));
		list.add(new Base("5", "d", "tb"));
		list.add(new Base("6", "a", "zz"));
		list.add(new Base("5", "b", "z"));
		list.add(new Base("4", "d", "ta"));
		list.add(new Base("1", "e", "f"));
//		SortUtil.sort(list, new CompareByTitle(new CompareByID(new CompareByElse())));
//		SortUtil.sort(list, new CompareByTitle(new CompareByElse(new CompareByID())));
//		Collections.sort(list, new CompareByTitle(new CompareByElse(new CompareByID())));
		Collections.sort(list, new ArrCompare(new CompareByTitle(), 
				new CompareByID(),
				new CompareByElse() 
		));
		for(Base b : list){
			System.out.println(b);
		}
	}
}
