package assessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *  CookiesLog is a data structure that organized cookies based on their date.
 */
public class CookiesLog {
	private HashMap<DateTime, CookiesList> cookieHistory = new HashMap<>();
	
	/**
	 * Reads in a file and stores the information in a table.
	 * @param fileName, the fileName of the csv or absolute path of the file
	 */
	public CookiesLog(String fileName) throws IOException {
		File csvFile = new File(fileName);
		if (csvFile.isFile()) {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			// The data should come in the form of cookies,timestamp
			String row = reader.readLine();
			while( (row = reader.readLine()) != null) {
				String[] data = row.split(",");
				String[] timestamp = data[1].split("T");
				String date = timestamp[0].strip();
				String time = timestamp[1].strip();
				this.insert(new DateTime(date, time), data[0]);
			}
			
			reader.close();
		} else {
			System.out.println("CSV file was not found");
		}
	}
	
	/**
	 * Inserts a cookie into the cookieHistory according to the date.
	 * @param date, the day of the cookie
	 * 		  cookie, the name of the cookie
	 */
	public void insert(DateTime date, String cookie) {
		if (!this.cookieHistory.containsKey(date)) {
			this.cookieHistory.put(date, new CookiesList(cookie));
		} else {
			CookiesList chain = this.cookieHistory.get(date);;
			chain.insert(cookie);	
		}
	}
	
	/**
	 * Print a list of cookies that showed up the most on a particular day.
	 */
	public String getMostActiveCookies(DateTime date) {
		if (!this.cookieHistory.containsKey(date)) {
			return "No cookies were found for that day";
		} else {
			CookiesList list = this.cookieHistory.get(date);
			return list.getMostActivesCookies();
		}
	}

	/**
	 *	Prints the table representation of the cookiesHistory.
	 *	Note: the printing is not in order. This can quickly be fixed by having an
	 *		arrayList of dates and sorting them!
	 */
	public String toString() {
		String str = "";
		for (DateTime key: this.cookieHistory.keySet()) {
			str += key.getDate() + ":" + this.cookieHistory.get(key).toString() + "\n";
		}		
		return str;
	}
}
