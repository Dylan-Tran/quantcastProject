package assessment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *  CookiesLog is a data structure that will save cookies based on its timestamp.
 */
public class CookiesLog {
	/* cookieHistory a hashMap where the key is the date and its value is a list of nodes that stores
	 * information about the cookie
	 */
	private HashMap<dateTime, Node> cookieHistory = new HashMap<>();
	
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
				this.insert(new dateTime(timestamp[0].strip(), timestamp[1].strip()), data[0]);
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
	public void insert(dateTime date, String cookie) {
		if (!this.cookieHistory.containsKey(date)) {
			this.cookieHistory.put(date, new Node(cookie));
			return;
		}

		/* If the cookie has already been seen update the frequency,
		 * else add a new node to the linkedList. 
		 */
		Node root = this.cookieHistory.get(date);
		if (root.contains(cookie)) {
			Node curr = root;
			while(!curr.getCookie().equals(cookie)) {
				curr = curr.next;
			}
			curr.incrementFrequency();
		} else {
			Node last = root;
			while(last.next != null) {
				last = last.next;
			}			
			last.next = new Node(cookie);
		}
	}
	
	/**
	 * Print a list of cookies that showed up the most on a particular day
	 */
	public String getMostActiveCookies(dateTime date) {
		if (!this.cookieHistory.containsKey(date)) {
			return "No cookies were found for that day";
		}
		
		int maxFreq = Integer.MIN_VALUE;
		String listMostActivesCookies = "";
				
		Node curr = this.cookieHistory.get(date);
		while(curr != null) {
			if (curr.getFrequency() < maxFreq) {
				curr = curr.next;
				continue;
			}
			
			if (curr.getFrequency() == maxFreq) {
				listMostActivesCookies = listMostActivesCookies + "\n" + curr.getCookie(); 
				curr = curr.next;
				continue;
			}

			maxFreq = curr.getFrequency();
			listMostActivesCookies = curr.getCookie();
			curr = curr.next;
		}
		
		return listMostActivesCookies;
	}

	/**
	 *	Prints the table representation of the cookiesHistory
	 */
	public String toString() {
		String str = "";
		for (dateTime key: this.cookieHistory.keySet()) {
			str += key.getDate() + ":";

			Node curr = this.cookieHistory.get(key);
			while (curr != null) {
				str += " " + curr.toString();
				curr = curr.next;
			}			
			str += "\n";
		}
		
		return str;
	}
	
	/**
	 * An implementation of a LinkedList object where the node stores the value of the
	 * cookie and its frequency. 
	 */
	private class Node {
		private String cookieName;
		private int frequency = 1; 
		public Node next;
		
		public Node(String inputCookieName) {
			this.cookieName = inputCookieName;
			this.next = null;
		}
		
		public String getCookie() {
			return this.cookieName;
		}
		
		public int getFrequency() {
			return this.frequency;
		}
		
		public void incrementFrequency() {
			this.frequency++;
		}
		
		/**
		 * Returns true if the current Node or any of its children represent the input cookie.
		 * @param cookie, the cookie name
		 */
		public boolean contains(String cookie) {
			Node curr = this;
			while(curr != null) {
				if (curr.getCookie().equals(cookie)) return true;
				curr = curr.next;
			}
			return false;
		}
		
		public String toString() {
			return "[" + this.cookieName + ", " + this.frequency + "]";
		}
	}
}
