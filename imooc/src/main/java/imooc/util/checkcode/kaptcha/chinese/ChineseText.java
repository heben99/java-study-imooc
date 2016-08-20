package imooc.util.checkcode.kaptcha.chinese;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.google.code.kaptcha.text.TextProducer;
import com.google.code.kaptcha.util.Configurable;

public class ChineseText extends Configurable implements TextProducer {

	private int len = 4;
	
	/**
	 * ����������� ԭ���ǴӺ�����λ���ҵ����� �ں�����λ���зָ�λ���λ�� �����м������з��壬λ��Խǰ���ɵĺ��ַ���Ļ���Խ��
	 * �ڱ����и�λ��171ȡ����λ��161ȡ�� ȥ���󲿷ֵķ������Ƨ�֣�����Ȼ���У���
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getRandomJianHan(int len) {
		String ret = "";
		for (int i = 0; i < len; i++) {
			String str = null;
			int hightPos, lowPos; // ����ߵ�λ
			Random random = new Random();
			hightPos = (176 + Math.abs(random.nextInt(39))); // ��ȡ��λֵ
			lowPos = (161 + Math.abs(random.nextInt(93))); // ��ȡ��λֵ
			byte[] b = new byte[2];
			b[0] = (new Integer(hightPos).byteValue());
			b[1] = (new Integer(lowPos).byteValue());
			try {
				str = new String(b, "GBK"); // ת������
			} catch (UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}
			ret += str;
		}
		return ret;
	}

	@Override
	public String getText() {
		return getRandomJianHan(len);
	}

}
