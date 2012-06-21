package task4_1;

import java.io.UnsupportedEncodingException;

public class StringConverter {
	public static String convertUTF16toCP1251(String str)
			throws UnsupportedEncodingException {
		return new String(str.getBytes("cp1251"), "UTF-16LE");
	}

	public static String convertCP1251toUTF16(String str)
			throws UnsupportedEncodingException {
//		return new String(str.getBytes("cp1251"), "UTF-16LE");
		return new String(str.getBytes("UTF-16LE"), "cp1251");
	}
}