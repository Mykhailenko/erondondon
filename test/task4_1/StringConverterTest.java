package task4_1;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringConverterTest {
	
	@Test
	public void boooring(){
		try {
			FileOutputStream fos = new FileOutputStream("cp.txt");
			String cp1251 = StringConverter.convertUTF16toCP1251("йц");
			fos.write(cp1251.getBytes("UTF-16LE"));
			fos.close();
			
		} catch (UnsupportedEncodingException e) {
			assertTrue(false);
		} catch (IOException e) {
			assertTrue(false);
		}
		assertTrue(true);
	}
	@Test
	public void bb(){
		try {
			FileInputStream fis = new FileInputStream("cp.txt");
			List<Byte> bytes = new ArrayList<Byte>();
			int b;
			while((b = fis.read()) != -1){
				bytes.add((byte) b);
			}
			byte [] arr = new byte[bytes.size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = bytes.get(i);
			}
			String cp1251 = new String(arr, "UTF-16LE");
			System.out.println(cp1251);
			String utf16 = StringConverter.convertCP1251toUTF16(cp1251);
			System.out.println(utf16);
			fis.close();
			
		} catch (UnsupportedEncodingException e) {
			assertTrue(false);
		} catch (IOException e) {
			assertTrue(false);
		}
		assertTrue(true);
	}
}
