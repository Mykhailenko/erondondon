package task6_2;

import java.io.File;
import java.util.Scanner;

public class Sequence {
	private static Scanner in = new Scanner(System.in);
	private static MTreadik treadik = new MTreadik();
	public static void main(String[] args) {
		treadik.start();
		while(true){
			System.out.println("Введите имя файла");
			String fileName = in.next();
			long start = System.currentTimeMillis();
			treadik.setFileAndStart(new File(fileName));
			while (true) {
				if(treadik.isDone() || treadik.isError()){
					break;
				}else{
					SequenceHelper.show(treadik.getStatus());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
			SequenceHelper.show(101);
			if(treadik.isDone()){
				System.out.println("Completed! " + (System.currentTimeMillis() - start));
				System.out.println(treadik.getResultAndClear());
			}else{
				System.out.println("some error.");
			}
		}
	}
	
}
