package task1_2;

import java.util.Iterator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class GlebListTest {
	@Test
	public void addTest(){
		final GlebList<String> list = new GlebList<String>();
		list.add("ololo");
		list.add("eee");
		assertFalse(list.isEmpty());
		assertEquals(2, list.size());
		assertEquals("ololo", list.get(0));
		assertEquals("eee", list.get(1));
	}
	
	@Test
	public void addTest1(){
		final GlebList<String> list = new GlebList<String>();
		list.add(0, "ololo");
		list.add(1, "eee");
		list.add(0, "ttt");
		assertFalse(list.isEmpty());
		assertEquals(3, list.size());
		assertEquals("ttt", list.get(0));
		assertEquals("ololo", list.get(1));
		assertEquals("eee", list.get(2));
	}	
	@Test(expected=IndexOutOfBoundsException.class)
	public void addTest2(){
		GlebList<String> list = new GlebList<String>();
		assertTrue(list.isEmpty());
		list.add(1, "ololo");
	}
	
	@Test
	public void removeTest(){
		GlebList<String> list = new GlebList<String>();
		list.add(0, "ololo");
		list.add(1, "eee");
		list.add(2, "ttt");
		list.remove(1);
		assertFalse(list.isEmpty());
		assertEquals(2, list.size());
		assertEquals("ololo", list.get(0));
		assertEquals("ttt", list.get(1));
	}
	
	@Test
	public void removeTest1(){
		GlebList<String> list = new GlebList<String>();
		list.add(0, "ololo");
		list.add(1, "eee");
		list.add(2, "ttt");
		list.remove("ttt");
		assertFalse(list.isEmpty());
		assertEquals(2, list.size());
		assertEquals("ololo", list.get(0));
		assertEquals("eee", list.get(1));
	}
	@Test 
	public void filter(){
		AdvancedList<String> list = new GlebList<String>();
		list.add("ololo");
		list.add("eee");
		list.add("ttt");
		list.add("ee");
		list.add("rrr");
		list.add("e");
		list.add("www");
		Predicate predicate = new Predicate() {
			@Override
			public boolean condition(Object o) {
				if(!(o instanceof String)){
					return false;
				}
				String s = (String) o;
				if(s.length() > 0){
					char ch = s.charAt(0);
					return ch != 'e';
				}else{
					return true;
				}
			}
		};
		Iterator<String> it = list.iterator(predicate);
		it.hasNext();
		assertEquals("ololo", it.next());
		it.hasNext();
		assertEquals("ttt", it.next());
		it.remove();
		it = list.iterator(predicate);
		it.hasNext();
		assertEquals("ololo", it.next());
		it.hasNext();
		assertEquals("rrr", it.next());
		it.hasNext();
		assertEquals("www", it.next());
		
		
	}		
}
