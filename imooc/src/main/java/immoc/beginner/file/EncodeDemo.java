package immoc.beginner.file;

import java.nio.charset.Charset;

public class EncodeDemo {

	public static void main(String[] args) {
		String s = "慕课ABC";
		
		byte[] bytesDeault = s.getBytes(); //使用项目默认编码gbk
		display(bytesDeault);
		
		byte[] bytesGbk = s.getBytes(Charset.forName("gbk")); //汉字占用两个字节
		display(bytesGbk);
		
		byte[] bytesUtf8 = s.getBytes(Charset.forName("utf-8")); //汉字占用三个字节
		display(bytesUtf8);
		
		// utf-16be： java内存中String使用的编码，汉字和英文都占用两个字节
		byte[] bytesUtf16be = s.getBytes(Charset.forName("utf-16be")); 
		display(bytesUtf16be);
		
		
		
	}
	
	public static void display(byte[] a)
	{
		for(byte b: a) {
			System.out.print(String.format("%02X ", b & 0xFF)); //必须要 & 0xFF，因为汉字的二进制表示是负数
		}
		System.out.println();
	}

}
