package immoc.beginner.radix.convert;

public class RadixConvert {
	public static void main(String[] args) {
		//十进制转其他
		int x = 15;
		System.out.println(Integer.toHexString(x));
		System.out.println(Integer.toOctalString(x));
		System.out.println(Integer.toBinaryString(x));
		
		//其他转十进制
		System.out.println(Integer.valueOf("FFFF", 16));
		System.out.println(Integer.valueOf("17", 8));
		System.out.println(Integer.valueOf("1001", 2));
		
		//异常处理
		try {
			System.out.println(Integer.valueOf("FFF",2));
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException occured when radix convert:" + e.getMessage());
		}
	}
}
