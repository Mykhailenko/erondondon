package task3_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;

public class FileWrapper {
	private static final Logger LOGGER = Logger.getRootLogger();
	public static Iterable<String> iterable(String fileName) {
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
		} catch (FileNotFoundException e1) {
			LOGGER.error(e1);
		}
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
						String old = line;
						line = getStrnig();
						return old;
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
