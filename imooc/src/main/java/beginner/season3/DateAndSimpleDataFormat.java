package beginner.season3;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndSimpleDataFormat {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
		// Use new Date() to get current date and time
        Date now = new Date();
        
        // Use format() to format display
		System.out.println(sdf1.format(now));
		System.out.println(sdf2.format(now));
		System.out.println(sdf3.format(now));

		
		String d = "2014-6-1 21:05:36";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
         // Use parse() to convert String to Date
		Date date = null;
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		if(null != date) {
			System.out.println(date);
		}
	}
}
