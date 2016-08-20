package imooc.util.checkcode.kaptcha.chinese;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.google.code.kaptcha.text.TextProducer;
import com.google.code.kaptcha.util.Configurable;

public class ChineseText extends Configurable implements TextProducer {

	private int len = 4;
	
	/**
	 * 生成随机汉字 原理是从汉字区位码找到汉字 在汉字区位码中分高位与底位， 其中有简体又有繁体，位数越前生成的汉字繁体的机率越大。
	 * 在本例中高位从171取，底位从161取， 去掉大部分的繁体和生僻字，但仍然会有！！
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getRandomJianHan(int len) {
		String ret = "";
		for (int i = 0; i < len; i++) {
			String str = null;
			int hightPos, lowPos; // 定义高低位
			Random random = new Random();
			hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
			lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
			byte[] b = new byte[2];
			b[0] = (new Integer(hightPos).byteValue());
			b[1] = (new Integer(lowPos).byteValue());
			try {
				str = new String(b, "GBK"); // 转成中文
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
