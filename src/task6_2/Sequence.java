package task6_2;

import java.io.File;
import java.util.Scanner;

import task6_2.sequence.HalfDivisionSequenceSearcher;
import task6_2.sequence.SequnceSearcher;

public class Sequence {
	private static Scanner in = new Scanner(System.in);
	private static HalfDivisionSequenceSearcher treadik = new HalfDivisionSequenceSearcher();
	public static void main(String[] args) {
		treadik.start();
		while(true){
			System.out.println("Введите имя файла");
			String fileName = in.next();
			long start = System.currentTimeMillis();
			treadik.setupFileAndStartSearch(new File(fileName));
			while (true) {
				if(treadik.isDone() || treadik.isErrorOccurred()){
					break;
				}else{
					SequenceHelper.show(treadik.getProgressStatus());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
			SequenceHelper.show(101);
			if(treadik.isDone()){
				System.out.println("Completed! " + (System.currentTimeMillis() - start));
				System.out.println(treadik.getResultOfSearchAndResetSearcher());
			}else{
				System.out.println("some error.");
			}
		}
	}
	
}
