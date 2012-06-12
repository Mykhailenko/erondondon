package task2_2;

import org.junit.Test;

import static  org.junit.Assert.assertEquals;

public class ArticulTest {
	@Test
	public void t0(){
		AbstractArticul art = new Articul0("olololo");
		assertEquals(7, art.hashCode());
	}
	@Test
	public void t1(){
		AbstractArticul art = new Articul1("olololo");
		assertEquals('o'+ 'l' + 'o' + 'l', art.hashCode());
	}
}
