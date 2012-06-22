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

public class MTreadik extends Thread{
	private static final int THREAD_NUMBER = 2;
	private volatile File file = null;
	private volatile int status = 0;
	private volatile SeqResult result = null;
	private byte [] bs = null;
	private volatile boolean error;
	public MTreadik() {
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
				List<Future<SeqResult>> futures = new ArrayList<Future<SeqResult>>();
				ExecutorService service = Executors.newFixedThreadPool(THREAD_NUMBER);
				int childWorkPeace = bs.length / THREAD_NUMBER;
				for (int i = 0; i < THREAD_NUMBER; ++i) {
					Future<SeqResult> future = service.submit(new LittleTreadik(size, i * childWorkPeace));
					futures.add(future);
				}
				while(true){
					for (int f = 0; f < futures.size(); f++) {
						Future<SeqResult> future = futures.get(f);
						if(future.isDone()){
							SeqResult sresult = null;
							try {
								sresult = future.get();
							} catch (InterruptedException e) {
							} catch (ExecutionException e) {
							}
							if(sresult != null){
								this.result = sresult;
								return;
							}else{
								futures.remove(f);
							}
						}
					}
					if(futures.isEmpty()){
						break;
					}
				}
			}
		} catch (IOException e) {
			error = true;
		}
	}
	private class LittleTreadik implements Callable<SeqResult>{
		private int lsize;
		private int i;
		
		public LittleTreadik(int size, int i) {
			super();
			this.lsize = size;
			this.i = i;
		}
		@Override
		public SeqResult call() throws Exception {
			for (; i < bs.length; ++i) {
				for (int j = i + lsize; j < bs.length - lsize; j++) {
					if(compareArr(bs, i, bs, j, lsize)){
						return new SeqResult(lsize, i, j, new String(Arrays.copyOfRange(bs, i, i + lsize)));
					}
				}
			}
			return null;
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
