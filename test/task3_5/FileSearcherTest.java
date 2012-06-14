package task3_5;

import java.io.File;

import org.junit.Test;

public class FileSearcherTest {
	@Test
	public void t(){
		FileSearcher searcher = new FileSearcher(
				new FileExtensionFilter(
						new FileSizeFilter().fromTo(28*1024, 30*1024).create()
						).names("doc").create(), "D:\\tasks");
		for(File file : searcher.search()){
			System.out.println(file + " : " + file.length() / 1024);
		}
	}
}
