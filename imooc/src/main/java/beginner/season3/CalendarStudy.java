package beginner.season3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarStudy {

    public static void main(String[] args) {
		// 创建Canlendar对象
		Calendar c = Calendar.getInstance();
        
		// 将Calendar对象转换为Date对象
		// 因为  public Date(int year, int month, int date, 
		// int hrs, int min, int sec) 方法已经废弃，所以用 getTime() 直接获得Date
		Date date = c.getTime(); 
		// 创建SimpleDateFormat对象，指定目标格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
		// 将日期转换为指定格式的字符串
		String now = sdf.format(date);
		System.out.println("当前时间：" + now);
	}
}
