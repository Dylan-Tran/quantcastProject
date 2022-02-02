package assessment;
import java.util.Arrays;

public class dateTime {
	private int[] date = new int[3]; // {year, month, day}
	private int[] time = new int[3]; // {hour, minute, second}

	/**
	 * Takes a date and convert it into a dataTime object
	 *	@param dateInput, year-month-day
	 */
	public dateTime(String dateInput) {
		String[] dateInputArray = dateInput.split("-");
		if (dateInput.length() != 10 || dateInputArray.length != 3) {
			System.out.println("The date was not in the format YYYY-MM-DD");
		}

		for(int i = 0; i < dateInputArray.length; i++) {
			this.date[i] = Integer.parseInt(dateInputArray[i]);
		}				
	}
	
	/**
	 * Takes a date and time and convert it into a dataTime object
	 *	@param dateInput, year-month-day
	 *			timeInput, HH:MM:SS+XX:XX
	 */
	public dateTime(String dateInput, String timeInput) {
		this(dateInput);
		
		String[] time = timeInput.substring(0, timeInput.indexOf("+")).split(":");
		for(int i = 0; i < time.length; i++) {
			this.time[i] = Integer.parseInt(time[i]);
		}		
	}
	

	public int getYear() {
		return this.date[0];
	}

	public int getMonth() {
		return this.date[1];
	}
	
	public int getDay() {
		return this.date[2];
	}
	
	public String getDate() {
		String str = "";
		for(int i = 0; i < date.length; i++) {
			str += "-" + date[i];
		}
		return str.substring(1);
	}
	
	/**
	 * Returns a unique hashCode for the dateTime object.
	 * @apiNote	objects with the same date but different time will have the same hashcode.
	 */
	public int hashCode() {
		return Arrays.toString(this.date).hashCode();
	}
	
	/**
	 * Returns true if both objects have the same hashCode
	 * @apiNote objects with the same date but different time are consider equal.
	 */
	public boolean equals(Object other) {
		if (other == this) return true;
		if (!(other instanceof dateTime)) return false;

		if (this.hashCode() == other.hashCode()) return true;	
		return false;
	}
	
}
