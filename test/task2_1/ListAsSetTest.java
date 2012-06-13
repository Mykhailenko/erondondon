package task2_1;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListAsSetTest {
	@Test
	public void ololo(){
		List<String> list = new ListAsSet<String>();
		list.add("one");
		list.add("two");
		list.add("one");
		assertEquals(2, list.size());
	}
	@Test
	public void tricky(){
		List<Pair> list = new ListAsSet<Pair>();
		Pair p0 = new Pair("1", "ololoev");
		Pair p1 = new Pair("2", "ololoev");
		list.add(p0);
		list.add(p1);
		assertEquals(2, list.size());
		p1.setId("1");
		assertEquals(list.get(0), list.get(1));
	}
	
}