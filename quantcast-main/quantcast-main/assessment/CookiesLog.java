package assessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *  CookiesLog is a data structure that organized cookies based on their date.
 *  	For each date, we keep track of cookies and their frequency that showed
 *  	up on that date. 
 */
public class CookiesLog {
	private HashMap<Date, CookiesList> cookieHistory = new HashMap<>();
	
	/**
	 * Constructor takes in a fileName and populates the data structure with 
	 * the relative information.
	 * @param fileName, the fileName of the csv or absolute path of the file
	 */
	public CookiesLog(String fileName) throws IOException {
		this.addInformationFromCSV(fileName);
	}
	
	/**
	 * @param fileName, the fileName of the csv or absolute path of the file,
	 * 					the csv file should be organized as cookiesName,timestamp
	 * 					where the timestamp is (DATE)T(TIME)
	 */
	public void addInformationFromCSV(String fileName) throws IOException{
		File csvFile = new File(fileName);
		if (csvFile.isFile()) {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String row = reader.readLine();
			while( (row = reader.readLine()) != null) {
				String[] data = row.split(",");
				String[] timestamp = data[1].split("T");
				
				String cookieName = data[0].strip();
				String cookieDate = timestamp[0].strip();
				String cookieTime = timestamp[1].strip();
				
				Date key = new Date(cookieDate);
	
				this.insertEntry(key, cookieName);
			}
			reader.close();
		} else {
			System.out.println("CSV file was not found");
		}
	}
	
	/**
	 * Returns true if the date has already been seen before
	 */
	public boolean dateExist(Date date) {
		return this.cookieHistory.containsKey(date);		
	}
	
	/**
	 * Searches the cookieHistory for the date and return a CookiesList object
	 * which contains a list of cookies seen that day
	 * @param date
	 */
	public CookiesList retrieveDate(Date date) {
		return this.cookieHistory.get(date);
	}
	
	/**
	 * Inserts a cookie into the cookieHistory according to the date.
	 * @param date, the day of the cookie
	 * 		  cookie, the name of the cookie
	 */
	public void insertEntry(Date date, String cookieName) {
		if (this.dateExist(date)) {
			CookiesList dateCookies = this.retrieveDate(date);;
			dateCookies.insertCookie(cookieName);	
		} else {
			this.cookieHistory.put(date, new CookiesList(cookieName));
		}
	}
	
	/**
	 * Print a list of cookies that showed up the most on a particular day.
	 */
	public String getMostActiveCookies(Date date) {
		String ERROR_MSG = "No cookies existed on that day";
		if (!this.dateExist(date)) {
			return ERROR_MSG;
		} else {
			CookiesList dateCookies = this.retrieveDate(date);
			return dateCookies.mostActiveCookies();
		}
	}

	/**
	 *	Prints the table representation of the cookiesHistory.
	 *	Note: the printing is not in order. This can quickly be fixed by having an
	 *		arrayList of dates and sorting them!
	 */
	public String toString() {
		String str = "";
		for (Date date: this.cookieHistory.keySet()) {
			str += date.toString() + ": " + this.retrieveDate(date).toString() + "\n";
		}		
		return str;
	}
}
