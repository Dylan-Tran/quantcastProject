import assessment.*;
import java.io.IOException;

public class most_active_cookie {
	public static void main(String args[]) throws IOException {
		if (args.length != 3) {
			System.out.println("Not enough input");
		} else {
			String fileName = args[0];
			String timeZone = args[1];
			String retrive = args[2];
			
			CookiesLog log = new CookiesLog(fileName);
			System.out.println(log.getMostActiveCookies(new dateTime(retrive)));
		}		
	}
}
