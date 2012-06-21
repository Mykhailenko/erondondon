package task3_5;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FilterUser {
	public static void main(String[] args) {
		long size;
		String s;
		int x;
		BaseFileFilter filter = null;
		Scanner in = new Scanner(System.in);
		System.out.println("Ищем на рабочем столе?(1/0)");
		x = in.nextInt();
		
		String root = "C:"+File.separator
				+"Users"+File.separator
				+"Hlib_Mykhailenko"+File.separator
				+"Desktop"; 
		if(x == 0){
			System.out.println("Введите корневую директорию:");
			root = in.next(); 
		}
		
		System.out.println("Искать по имени(1/0)?");
		x = in.nextInt();
		if(x == 1){
			System.out.println("Введите имя");
			s = in.next();
			filter = new FileNameFilter(filter).names(s).create();
		}
		
		System.out.println("Искать по расширению(1/0)?");
		x = in.nextInt();
		if(x == 1){
			System.out.println("Введите расширение");
			s = in.next();
			filter = new FileExtensionFilter(filter).names(s).create();
		}
		
		System.out.println("Искать файлы размер которых больше заданного(1/0)?");
		x = in.nextInt();
		if(x == 1){
			System.out.println("Введите размер");
			size = in.nextLong();
			filter = new FileSizeFilter(filter).from(size).create();
		}
		
		if(filter != null){
			FileSearcher searcher = new FileSearcher(filter, root);
			List<File> files = searcher.search();
			for (Iterator<File> it = files.iterator(); it.hasNext();) {
				File file = (File) it.next();
				System.out.println(file);
			}
		}
	}
}
