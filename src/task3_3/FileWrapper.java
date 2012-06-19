package task3_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

public class FileWrapper {
	private static final Logger LOGGER = Logger.getRootLogger();
	public static Iterable<String> iterable(String fileName) throws FileNotFoundException {
		FileReader fr = null;
		fr = new FileReader(fileName);
    	final BufferedReader br = new BufferedReader(fr);
    	
    	return new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				return new Iterator<String>() {
					private String line = getStrnig();
					@Override
					public boolean hasNext() {
						return line != null;
					}
					@Override
					public String next() {
						if(line != null){
							String old = line;
							line = getStrnig();
							return old;
						}else{
							throw new NoSuchElementException();
						}
					}
					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
					private String getStrnig(){
						String s = null;
						try {
							s = br.readLine();
						} catch (IOException e) {
							s = null;
						}
						return s;
					}
				};
			}
		};
		
	}
	
}
