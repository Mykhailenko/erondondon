package task6_2.sequence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public abstract class Utility {
	/**
	 * Get bytes from file.
	 * @param file
	 * @return representaion file in byte
	 * @throws IOException if file too large or could not completely read the file
	 */
	public static byte[] getBytesFromFile(File file) throws IOException {
		if(!file.exists()){
			throw new FileNotFoundException();
		}
	    InputStream is = new FileInputStream(file);
	    long length = file.length();

	    if (length > Integer.MAX_VALUE) {
	    	throw new IOException("too large file");
	    }

	    byte[] bytes = new byte[(int)length];

	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    is.close();
	    return bytes;
	}
	
	/**
	 * Compare first <code>size</code> byte array <code>arr0</code> from index <code>startIndex0</code> with byte array <code>arr1</code>
	 * from index <code>startIndex1</code>.
	 * @param arr0
	 * @param startIndex0
	 * @param arr1
	 * @param startIndex1
	 * @param size
	 * @return
	 */
	public static boolean compareArrays(byte[] arr0, 
			int startIndex0, 
			byte[] arr1, 
			int startIndex1, 
			int size){
		for (int i = 0; i < size; i++) {
			if(arr0[startIndex0 + i] != arr1[startIndex1 + i]){
				return false;
			}
		}
		return true;
	}
}
