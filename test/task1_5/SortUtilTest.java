package task1_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SortUtilTest {
	@Test
	public void test1(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(24);
		list.add(883);
		list.add(10);
		list.add(-4);
		list.add(3);
		list.add(21);
		list.add(11);
		SortUtil.sort(list);
		List<Integer> right = new ArrayList<Integer>();
		right.add(-4);
		right.add(3);
		right.add(10);
		right.add(11);
		right.add(21);
		right.add(24);
		right.add(883);
		assertEquals(right, list);
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
}
