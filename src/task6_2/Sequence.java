package task6_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sequence {
	
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		byte [] bs = getBytesFromFile(new File("LICENSE"));
		ExecutorService executor = Executors.newSingleThreadExecutor();
		SequSearcher ss = new SequSearcher(bs);
		Future<SeqResult> future = executor.submit(ss);
		while(true){
			if(future.isDone()){
				break;
			}else{
				SequenceHelper.show(ss.getStatus());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.err.println(e);
				}
			}
		}
		SequenceHelper.show(101);
		SeqResult sr = future.get();
		System.out.println(sr);
		String f = new String(Arrays.copyOfRange(bs, sr.getFirstIndex(), sr.getFirstIndex() + sr.getSize()));
		String s = new String(Arrays.copyOfRange(bs, sr.getSecondIndex(), sr.getSecondIndex() + sr.getSize()));
		System.out.println(f);
		System.out.println(s);
		
	}
	
}
