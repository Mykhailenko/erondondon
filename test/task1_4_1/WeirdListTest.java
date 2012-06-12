package task1_4_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class WeirdListTest {
	private List<String> modifiableList;
	private List<String> unmodifiableList;
	private List<String> justList;
	private List<String> weirdList;
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	@Before
	public void init() {
		unmodifiableList = new ArrayList();
		unmodifiableList.add("nessesary_service_0");
		unmodifiableList.add("nessesary_service_1");
		unmodifiableList.add("nessesary_service_2");
		
		modifiableList = new ArrayList();
		modifiableList.add("waste_money_service_0");
		modifiableList.add("waste_money_service_1");
		modifiableList.add("waste_money_service_2");
		modifiableList.add("waste_money_service_0");
		
		weirdList = new StrangeList(unmodifiableList, modifiableList);
		
		justList = new ArrayList<String>();
		justList.add("olololo_0");
		justList.add("olololo_1");
	}
	@Test
	public void addTest() {
		String s = "new";
		weirdList.add(s);
		assertEquals(s, weirdList.get(weirdList.size()-1));
	}

	@Test
	public void addTest1() {
		String s = "AddtoStartModifiableList";
		weirdList.add(3, s);
		assertEquals(s, weirdList.get(3));
	}
	
	@Test(expected=ReadOnlyContentException.class)
	public void addTest2() {
		String s = "AddtoStartModifiableList";
		weirdList.add(2, s);
	}
	@Test
	public void addAllTest() {
		weirdList.addAll(justList);
		assertEquals("olololo_1", weirdList.get(8));
		assertEquals(9, weirdList.size());
	}

	@Test
	public void addAllTest1() {
		weirdList.addAll(3, justList);
		assertEquals("olololo_1", weirdList.get(4));
		assertEquals(9, weirdList.size());
	}
	
	@Test(expected=ReadOnlyContentException.class)
	public void addAllTest2() {
		weirdList.addAll(2, justList);
	}
	
	@Test
	public void clearTest() {
		weirdList.clear();
		assertEquals(unmodifiableList.size(), weirdList.size());
	}

	@Test
	public void containsTest() {
		assertTrue(weirdList.contains("waste_money_service_2"));
	}
	
	@Test
	public void containsTest2() {
		assertTrue(weirdList.contains("nessesary_service_1"));
	}

	@Test
	public void containsTest3() {
		assertFalse(weirdList.contains("<><><><><><><>"));
	}
	@Test
	public void containsAllTest() {
		assertTrue(weirdList.containsAll(modifiableList));
	}
	@Test
	public void containsAllTest1() {
		assertFalse(weirdList.containsAll(justList));
	}

	@Test
	public void getTest() {
		assertEquals("nessesary_service_2", weirdList.get(2));
	}

	@Test
	public void getTest1() {
		assertEquals("waste_money_service_2", weirdList.get(5));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void getTest2() {
		weirdList.get(7);
	}
	
	@Test
	public void indexOfTest() {
		assertEquals(1, weirdList.indexOf("nessesary_service_1"));
	}

	@Test
	public void indexOfTest1() {
		assertEquals(5, weirdList.indexOf("waste_money_service_2"));
	}
	
	@Test
	public void indexOfTest2() {
		assertEquals(-1, weirdList.indexOf("//[][][]///][][][]"));
	}
	
	@Test
	public void isEmptyTest() {
		assertFalse(weirdList.isEmpty());
	}
	
	@Test
	public void isEmptyTest1() {
		WeirdList<?> w = new WeirdList<Object>(Collections.emptyList(), Collections.emptyList());
		assertTrue(w.isEmpty());
	}

	@Test(expected=ReadOnlyContentException.class)
	public void iteratorTest11() {
		Iterator<String> it = weirdList.iterator();
		it.hasNext();
		it.next();
		it.hasNext();
		it.next();
		it.remove();
	}
	@Test
	public void iteratorTest() {
		List<String> couple = new ArrayList<String>();
		couple.addAll(unmodifiableList);
		couple.addAll(modifiableList);
		assertEquals(weirdList.size(), couple.size());
		Iterator<String> ita = couple.iterator();
		Iterator<String> itb = weirdList.iterator();
//		while(ita.hasNext()){
//			System.out.println(ita.next());
//		}
//		while(itb.hasNext()){
//			System.out.println(itb.next());
//		}
		for(int i = 0; i < weirdList.size(); ++i){
//			System.out.println(i);
			ita.hasNext();
			itb.hasNext();
			assertEquals(ita.next(), itb.next());
		}
//		assertFalse(ita.hasNext());
//		assertFalse(itb.hasNext());
	}

	@Test
	public void lastIndexOfTest() {
		assertEquals(6, weirdList.lastIndexOf("waste_money_service_0"));
	}

	@Test
	public void listIteratorTest() {
		ListIterator<String> it = weirdList.listIterator();
		assertTrue(it.hasNext());
		assertFalse(it.hasPrevious());
		assertEquals("nessesary_service_0", it.next());
		assertEquals("nessesary_service_1", it.next());
		assertEquals("nessesary_service_2", it.next());
		it.add("OLOLO");
		it.hasNext();
		assertEquals("waste_money_service_0", it.next());
		assertEquals("waste_money_service_0", it.previous());
		assertEquals("OLOLO", it.previous());
		it.remove();
		it.hasNext();
		assertEquals("waste_money_service_0", it.next());
		assertEquals(4, it.nextIndex());
		it.set("yeah");
		assertEquals("yeah", weirdList.get(3));
		it.next();
		it.next();
		it.next();
		assertFalse(it.hasNext());
	}

	@Test(expected=ReadOnlyContentException.class)
	public void listIteratorTest1() {
		ListIterator<String> it = weirdList.listIterator();
		it.next();
		it.set("asdfasd");
	}

	@Test(expected=ReadOnlyContentException.class)
	public void listIteratorTest2() {
		ListIterator<String> it = weirdList.listIterator();
		it.next();
		it.add("asdfasd");
	}
	@Test(expected=ReadOnlyContentException.class)
	public void listIteratorTest3() {
		ListIterator<String> it = weirdList.listIterator();
		it.next();
		it.remove();
	}
	
	@Test
	public void listIteratorWithIndexTest(){
		ListIterator<String> it = weirdList.listIterator(3);
		it.hasNext();
		assertEquals("waste_money_service_0", it.next());
		it.remove();
		assertEquals(true, it.hasPrevious());
		assertEquals("nessesary_service_2", it.previous());
	}
	
	@Test
	public void removeTest() {
		weirdList.remove(3);
		assertEquals(6, weirdList.size());
		assertEquals("waste_money_service_1", weirdList.get(3));
	}

	@Test(expected=ReadOnlyContentException.class)
	public void removeTest1() {
		weirdList.remove(2);
	}
	
	@Test
	public void removeTest2() {
		weirdList.remove("waste_money_service_2");
		assertEquals(6, weirdList.size());
		assertEquals("waste_money_service_0", weirdList.get(5));
	}

	@Test(expected=ReadOnlyContentException.class)
	public void removeTest3() {
		weirdList.remove("nessesary_service_1");
	}

	@Test
	public void removeAllTest() {
		List<String> lst = new ArrayList<String>();
		lst.add("waste_money_service_2");
		lst.add("waste_money_service_0");
		weirdList.removeAll(lst);
		assertEquals(4, weirdList.size());
		assertEquals("waste_money_service_1", weirdList.get(3));
	}
	@Test(expected=ReadOnlyContentException.class)
	public void removeAllTest1() {
		List<String> lst = new ArrayList<String>();
		lst.add("waste_money_service_0");
		lst.add("nessesary_service_1");
		lst.add("waste_money_service_2");
		weirdList.removeAll(lst);
	}
	
	@Test
	public void removeAllTest2() {
		List<String> lst = new ArrayList<String>();
		lst.add("waste_money_service_0");
		lst.add("nessesary_service_1");
		lst.add("waste_money_service_2");
		try{
			weirdList.removeAll(lst);
		}
		catch(ReadOnlyContentException r){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		assertEquals(7, weirdList.size());
	}
	@Test
	public void retainAllTest() {
		List<String> lst = new ArrayList<String>();
		lst.add("nessesary_service_0");
		lst.add("nessesary_service_1");
		lst.add("nessesary_service_2");
		weirdList.retainAll(lst);
		assertEquals(3, weirdList.size());
		assertTrue(weirdList.equals(unmodifiableList));
	}
	@Test
	public void retainAllTest1() {
		List<String> lst = new ArrayList<String>();
		lst.add("nessesary_service_0");
		lst.add("nessesary_service_1");
		lst.add("nessesary_service_2");
		lst.add("waste_money_service_2");
		weirdList.retainAll(lst);
		assertEquals(4, weirdList.size());
		assertTrue(weirdList.equals(lst));
		
	}

	@Test(expected=ReadOnlyContentException.class)
	public void retainAllTest2() {
		List<String> lst = new ArrayList<String>();
		lst.add("nessesary_service_0");
		lst.add("nessesary_service_1");
		lst.add("waste_money_service_2");
		lst.add("waste_money_service_0");
		weirdList.retainAll(lst);
	}
	@Test
	public void retainAllTest3() {
		List<String> lst = new ArrayList<String>();
		lst.add("nessesary_service_0");
		lst.add("nessesary_service_1");
		lst.add("waste_money_service_2");
		lst.add("waste_money_service_0");
		try{
			weirdList.retainAll(lst);
		}catch(ReadOnlyContentException r){
			assertTrue(true);
		}catch (Exception e) {
			assertTrue(false);
		}
		assertEquals(7, weirdList.size());
	}

	@Test
	public void setTest() {
		assertEquals("waste_money_service_0", weirdList.set(3, "zigazaga"));
		assertEquals(7, weirdList.size());
		assertEquals("zigazaga", weirdList.get(3));
	}

	@Test
	public void sizeTest() {
		int real = unmodifiableList.size() +  modifiableList.size();
		int weHave = weirdList.size();
		assertEquals(real, weHave);
	}

	@Test
	public void subListTest() {
		List<String> lst = weirdList.subList(2, 5);
		List<String> expected = Arrays.asList("nessesary_service_2",
				"waste_money_service_0", "waste_money_service_1");
		assertTrue(expected.equals(lst));
	}

	@Test
	public void toArrayTest() {
		Object [] arr = weirdList.toArray();
		assertEquals("waste_money_service_2", arr[5]);
		assertEquals(7, arr.length);
	}

	@Test
	public void toArrayTest1() {
		String [] arr = (String[]) weirdList.toArray(new String[0]);
		assertEquals("waste_money_service_2", arr[5]);
		assertEquals(7, arr.length);
	}
	@Test
	public void toArrayTest2() {
		String [] sa = new String[8];
		weirdList.toArray(sa);
		assertEquals(null, sa[7]);
		assertEquals(8, sa.length);
		Object [] arr = weirdList.toArray();
		assertEquals(7, arr.length);
		for(int i = 0; i < 7; ++i){
			assertEquals(sa[i], arr[i]);
		}
	}

}
