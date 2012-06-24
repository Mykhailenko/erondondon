package task6_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TreadikLog extends Thread{
	private volatile File file = null;
	private volatile int status = 0;
	private volatile SeqResult result = null;
	private byte [] bs = null;
	private volatile boolean error;
	public TreadikLog() {
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
			halfDivisionSearch();
		} catch (IOException e) {
			error = true;
		}
	}
	private void halfDivisionSearch(){
		final int MAX_SIZE = bs.length/2;
		final int MIN_SIZE = 2;
		findSizeBetween(MIN_SIZE, MAX_SIZE);
	}
	
	private void findSizeBetween(int minSize, int maxSize) {
		if(minSize != maxSize){
			int middle = minSize + (minSize + maxSize) / 2;
			SeqResult temp = getResultForSize(middle);
			if(temp == null){
				findSizeBetween(minSize, middle - 1);
			}else{
				if(middle < maxSize){
					
				}
				findSizeBetween(middle + 1, maxSize);
			}
		}else{
			result = getResultForSize(minSize);
		}
	}


	private SeqResult getResultForSize(int minSize) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<SeqResult> future = service.submit((Callable<SeqResult>)new LittleTreadik(minSize, 0));
		try {
			return future.get();
		} catch (Exception e) {
			return null;
		}
	}



	private class LittleTreadik implements Callable<SeqResult>, Runnable{
		private int lsize;
		private int i;
		private SeqResult seqResult;
		public LittleTreadik(int size, int i) {
			super();
			this.lsize = size;
			this.i = i;
			this.seqResult = null;
		}
		@Override
		public void run() {
			for (; i < bs.length; ++i) {
				for (int j = i + lsize; j < bs.length - lsize; j++) {
					if(compareArr(bs, i, bs, j, lsize)){
						seqResult = new SeqResult(lsize, i, j, new String(Arrays.copyOfRange(bs, i, i + lsize)));
						return;
					}
				}
			}
		}
		@Override
		public SeqResult call() throws Exception {
			run();
			return seqResult;
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
