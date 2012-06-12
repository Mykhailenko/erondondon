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
		list.get(1).setId("1");
		assertEquals(list.get(0), list.get(1));
	}
	
}

class Pair {
	private String id;
	private  String name;
	public Pair(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}