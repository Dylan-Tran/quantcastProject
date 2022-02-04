package assessment;

/**
 * An implementation of a LinkedList object where the node stores the cookie's name
 * 	and its frequency. 
 */
public class CookiesList {
	private CookieNode head;
	private CookieNode tail;

	public CookiesList(String cookieName) {
		this.head = new CookieNode(cookieName);;
		this.tail = this.head;
	}
	
	public CookieNode getHead() {
		return this.head;
	}
	
	public CookieNode getTail() {
		return this.tail;
	}
	
	public void setTail(CookieNode newTail) {
		this.tail.next = newTail;
		this.tail = this.tail.next;
	}

	/**
	 * Returns true if the CookiesList contains the cookie
	 * @param cookie, the cookie name
	 */
	public boolean containsCookie(String cookieName) {
		CookieNode curr = this.head;
		while(curr != null) {
			if (curr.getCookie().equals(cookieName)) return true;
			curr = curr.next;
		}
		return false;
	}
	
	/**
	 * @return a CookieNode that has the same name as the input string
	 * @apiNote this method should only be called after checking with containsCookie()
	 */
	public CookieNode getCookie(String cookieName) {
		if(!this.containsCookie(cookieName)) {
			return null;
		}
		
		CookieNode curr = this.head;
		while(!curr.getCookie().equals(cookieName)) {
			curr = curr.next;
		}
		return curr;		
	}
	
	/** If the cookie is already in the list, update the cookie's node frequency,
	 * else a new cookie node is added to the end of the list.
	 */
	public void insertCookie(String cookieName) {
		if (this.containsCookie(cookieName)) {
			this.getCookie(cookieName).incrementFrequency();
		} else {
			this.setTail(new CookieNode(cookieName));
		}
	}
	
	/**
	 * @return a string of the most active cookies on the chain separated by "\n"
	 */
	public String mostActiveCookies() {
		CookieNode curr = this.head;
		int maxFreq = Integer.MIN_VALUE;
		String listMostActivesCookies = "";

		while(curr != null) {
			if (curr.getFrequency() == maxFreq) {
				listMostActivesCookies = listMostActivesCookies + "\n" + curr.getCookie(); 
			} else if (curr.getFrequency() > maxFreq){
				listMostActivesCookies = curr.getCookie();
				maxFreq = curr.getFrequency();
			}
			
			curr = curr.next;
		}
		return listMostActivesCookies;
	}

	/**
	 * Returns the string representation of the linkedList with the [cookieName, frequency]
	 */
	public String toString() {
		CookieNode cookie = this.head;
		String str = cookie.toString();
		cookie = cookie.next;
		
		while (cookie!= null) {
			str = str + " " + cookie.toString();
			cookie = cookie.next;
		}					
		return str;
	}

	/**
	 * The node class that contains information about the a cookie's name and frequency
	 */
	private class CookieNode {
		private String cookieName;
		private int frequency = 1; 
		private CookieNode next = null;
		
		public CookieNode(String inputCookieName) {
			this.cookieName = inputCookieName;
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
		
		public String toString() {
			return "[" + this.cookieName + ", " + this.frequency + "]";
		}
	}
}
