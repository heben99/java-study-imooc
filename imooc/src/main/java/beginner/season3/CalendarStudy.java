package beginner.season3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarStudy {

    public static void main(String[] args) {
		// ����Canlendar����
		Calendar c = Calendar.getInstance();
        
		// ��Calendar����ת��ΪDate����
		// ��Ϊ  public Date(int year, int month, int date, 
		// int hrs, int min, int sec) �����Ѿ������������� getTime() ֱ�ӻ��Date
		Date date = c.getTime(); 
		// ����SimpleDateFormat����ָ��Ŀ���ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
		// ������ת��Ϊָ����ʽ���ַ���
		String now = sdf.format(date);
		System.out.println("��ǰʱ�䣺" + now);
	}
}
