package task6_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class SequSearcher implements Runnable{
	volatile private int status;
	private byte [] bs;
	private volatile SeqResult seqResult;
	public SequSearcher(byte[] bs) {
		super();
		this.status = 0;
		this.bs = bs;
		this.seqResult = null;
	}
	public int getStatus(){
		return status;
	}
 
	@Override
	public void run() {
		while(true){
			int percent = (bs.length/2 - 2) / 100;
			for (int size = bs.length/2; size >= 2; --size) {
				status = (bs.length/2 - size) / percent;
				for (int i = 0; i < bs.length; ++i) {
					for (int j = i + size; j < bs.length - size; j++) {
						if(compareArr(bs, i, bs, j, size)){
							seqResult = new SeqResult(size, i, j);
						}
					}
				}
			}
		}
	}
	private boolean compareArr(byte[] arr, int start_arr, byte[] brr, int start_brr, int size){
		for (int i = 0; i < size; i++) {
			if(arr[start_arr + i] != brr[start_brr + i]){
				return false;
			}
		}
		return true;
	}
	public byte[] getBytesFromFile(File file) throws IOException {
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

}
