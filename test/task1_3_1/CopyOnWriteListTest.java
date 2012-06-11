package task1_3_1;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CopyOnWriteListTest {
	private List<String> list;
	
	@Before
	public void init(){
		list = new CopyOnWriteList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
	}
	
	@Test
	public void t(){
		Iterator<String> it = list.iterator();
		assertEquals("1", it.next());
		assertEquals("2", it.next());
		Iterator<String> it1 = list.iterator();
		list.remove(2);
		Iterator<String> it2 = list.iterator();
		assertEquals("3", it.next());
		assertEquals("4", it.next());
		assertEquals("5", it.next());
		
		list.add("6");
		Iterator<String> it3 = list.iterator();
		assertEquals("1", it3.next());
		assertEquals("2", it3.next());
		assertEquals("4", it3.next());
		assertEquals("5", it3.next());
		assertEquals("6", it3.next());
		
		assertEquals("1", it1.next());
		assertEquals("2", it1.next());
		assertEquals("3", it1.next());
		assertEquals("4", it1.next());
		assertEquals("5", it1.next());
		
		assertEquals("1", it2.next());
		assertEquals("2", it2.next());
		assertEquals("4", it2.next());
		assertEquals("5", it2.next());
		
		
	}
}
