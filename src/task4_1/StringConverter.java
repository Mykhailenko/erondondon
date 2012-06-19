package task4_1;

import java.io.UnsupportedEncodingException;

public class StringConverter {
	public static byte [] convertUTF8toCP1251(String str) {
		try {
			return str.getBytes("cp1251");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	public String convertCP1251toUTF8(byte [] bs) {
		try {
			return new String(bs, "cp1251");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
