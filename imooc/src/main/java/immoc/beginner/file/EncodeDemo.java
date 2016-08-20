package immoc.beginner.file;

import java.nio.charset.Charset;

public class EncodeDemo {

	public static void main(String[] args) {
		String s = "Ľ��ABC";
		
		byte[] bytesDeault = s.getBytes(); //ʹ����ĿĬ�ϱ���gbk
		display(bytesDeault);
		
		byte[] bytesGbk = s.getBytes(Charset.forName("gbk")); //����ռ�������ֽ�
		display(bytesGbk);
		
		byte[] bytesUtf8 = s.getBytes(Charset.forName("utf-8")); //����ռ�������ֽ�
		display(bytesUtf8);
		
		// utf-16be�� java�ڴ���Stringʹ�õı��룬���ֺ�Ӣ�Ķ�ռ�������ֽ�
		byte[] bytesUtf16be = s.getBytes(Charset.forName("utf-16be")); 
		display(bytesUtf16be);
		
		
		
	}
	
	public static void display(byte[] a)
	{
		for(byte b: a) {
			System.out.print(String.format("%02X ", b & 0xFF)); //����Ҫ & 0xFF����Ϊ���ֵĶ����Ʊ�ʾ�Ǹ���
		}
		System.out.println();
	}

}
