package task6_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;

import com.sun.org.apache.bcel.internal.generic.GOTO;

public class Treadik extends Thread{
	private volatile File file = null;
	private volatile int status = 0;
	private volatile SeqResult result = null;
	private byte [] bs = null;
	private volatile boolean error;
	public Treadik() {
		this.file = null;
		this.status = 0;
		this.result = null;
		this.bs = null;
	}
	@Override
	public void run() {
		while(true){
			waitForFile();
			work();
			clear();
		}
	}
	private void clear() {
		this.file = null;
		this.bs = null;
		this.status = 0;
	}
	private void work() {
		try {
			bs = getBytesFromFile(file);
			int percent = (bs.length/2 - 2) / 100 ;
			percent = percent == 0 ? 1 : percent;
			for (int size = bs.length/2; size >= 2; --size) {
				status = (bs.length/2 - size) / percent;
				for (int i = 0; i < bs.length; ++i) {
					for (int j = i + size; j < bs.length - size; j++) {
						if(compareArr(bs, i, bs, j, size)){
							result = new SeqResult(size, i, j, new String(Arrays.copyOfRange(bs, i, i + size)));
							return;
						}
					}
				}
			}
			result = new SeqResult(0, 0, 0, "0");
		} catch (IOException e) {
			error = true;
		}
	}
	public synchronized boolean setFileAndStart(File file){
		if(this.file == null){
			initWithFile(file);
			notify();
			return true;
		}else{
			return false;
		}
	}

	private void initWithFile(File file) {
		this.file = file;
		result = null;
		status = 0;
		bs = null;
		error = false;
	}
	public synchronized int getStatus(){
		return status;
	}
	public synchronized boolean isDone(){
		return result != null;
	}
	public synchronized boolean isError(){
		return error;
	}
	public synchronized SeqResult getResultAndClear(){
		clear();
		SeqResult old = this.result;
		this.result = null;
		return old;
	}
	private synchronized void waitForFile(){
		while(file == null){
			try {
				wait();
			} catch (InterruptedException e) {	}
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
	private byte[] getBytesFromFile(File file) throws IOException {
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
}
