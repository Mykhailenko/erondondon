package task3_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FileIter implements Iterator<String>{
	BufferedReader br ;
	String future = null;
	public FileIter(String fileName) throws IOException {
		this.fileName = fileName;
		br = new BufferedReader(new FileReader(fileName));
		future = string();
	}
	String fileName;
	public void reset() throws IOException{
		br.close();
		br = new BufferedReader(new FileReader(fileName));
		future = string();
	}
	@Override
	public boolean hasNext() {
		if( future != null){
			return true;
		}else{
			try {
				br.close();
			} catch (IOException e) {
			}
			return false;
		}
	}

	@Override
	public String next() {
		String ret = future;
		try {
			future = string();
		} catch (IOException e) {
			throw new NoSuchElementException();
		}
		return ret;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	private String string() throws IOException{
		return br.readLine();
	}
	public static void main(String[] args) throws IOException {
		for (Iterator<String> iterator = new FileIter("file"); iterator.hasNext();) {
			String type = (String) iterator.next();
			System.out.println(type);
		}
	}
}
