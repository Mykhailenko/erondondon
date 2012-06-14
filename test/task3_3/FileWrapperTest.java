package task3_3;


import org.junit.Test;

public class FileWrapperTest {
	@Test
	public void t(){
		for(String line : FileWrapper.iterable("filefile")){
			System.out.println(line);
		}
	}
}	

