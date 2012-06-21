package task3_3;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class FileWrapperTest {
	@Test
	public void t(){
		try {
			FileIter fi = new FileIter("filefile");
			fi.hasNext();
			System.out.println(fi.next());
			fi.hasNext();
			System.out.println(fi.next());
			FileIter f2 = new FileIter("filefile");
			f2.hasNext();
			System.out.println(f2.next());
		} catch (IOException e) {
		}
	}
}	

