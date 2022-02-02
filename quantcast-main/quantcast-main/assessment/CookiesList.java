package assessment;

/**
 * An implementation of a LinkedList object where the node stores the value of the
 * cookie and its frequency. 
 */
public class CookiesList {
	private CookieNode head;
	private CookieNode tail;

	public CookiesList(String cookie) {
		CookieNode node = new CookieNode(cookie);
		this.head = node;
		this.tail = node;
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
	 * Returns true if the linkedList contains the cookie
	 * @param cookie, the cookie name
	 */
	public boolean contains(String cookie) {
		CookieNode curr = this.head;
		while(curr != null) {
			if (curr.getCookie().equals(cookie)) return true;
			curr = curr.next;
		}
		return false;
	}
	
	/**
	 * @return a CookieNode that has the same name as the input string
	 * @apiNote this method should only be called after checking with contains()
	 */
	public CookieNode get(String cookie) {
		if(!this.contains(cookie)) {
			return null;
		}
		
		CookieNode curr = this.head;
		while(!curr.getCookie().equals(cookie)) {
			curr = curr.next;
		}
		return curr;		
	}
	
	/** If the cookie has already been seen update the frequency,
	 * else add a new node to the linkedList. 
	 */
	public void insert(String cookie) {
		if (!this.contains(cookie)) {
			this.setTail(new CookieNode(cookie));
		} else {
			CookieNode curr = this.get(cookie);
			curr.incrementFrequency();
		}
	}
	
	/**
	 * @return a string of the most active cookies on the chain separated by "\n"
	 */
	public String getMostActivesCookies() {
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
	 * @return the string representation of the linkedList with the [cookieName, frequency]
	 */
	public String toString() {
		String str = "";
		
		CookieNode curr = this.head;
		while (curr != null) {
			str += " " + curr.toString();
			curr = curr.next;
		}					
		return str;
	}

	/**
	 * The node class that contains information about the cookie's name and frequency
	 */
	public class CookieNode {
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
