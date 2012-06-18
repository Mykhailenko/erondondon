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
/*
idea : cannot find symbol class
I have a simple java project in Eclipse and I have decided to try Intellij IDEA 11.

I imported project from github. And then I compiled it and recieved a lot of error in my unit tests. 

All it was sush as "cannot find symbol class %class_which_are_in_some_packege_in_src_folder%".

What did I do wrong?
*/