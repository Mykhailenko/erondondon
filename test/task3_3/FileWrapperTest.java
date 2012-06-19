package task3_3;


import java.io.FileNotFoundException;

import org.junit.Test;

public class FileWrapperTest {
	@Test
	public void t(){
		try {
			for(String line : FileWrapper.iterable("filefile")){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
		}
	}
}	

