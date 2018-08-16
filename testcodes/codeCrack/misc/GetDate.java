package misc;

import java.util.Calendar;
import java.util.Date;

public class GetDate {

	public static Date lastUpdatedTime;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal1 = null;
		cal1 = cal1.getInstance();
		Calendar cal2 = Calendar.getInstance();

		cal2.add(Calendar.MINUTE, -2);

		long difference = cal1.getTimeInMillis() - cal2.getTimeInMillis();
		difference = (difference / (60 * 1000));

		System.out.println(" difference " + difference);
		System.out.println(" cal1 " + cal1.getTime() + " cal2 " + cal2.getTime());

	}

}
