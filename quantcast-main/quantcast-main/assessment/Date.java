package assessment;

import java.util.Arrays;

public class Date {
	private int[] dateArray = new int[3]; // {year, month, day}

	/**
	 * Takes a date and convert it into a dataTime object
	 *	@param dateInput, year-month-day
	 */
	public Date(String dateInput) {
		String[] dateInputArray = dateInput.split("-");
		if (dateInputArray.length != 3) {
			System.out.println("The date was not in the format YYYY-MM-DD");
		}

		for(int i = 0; i < dateInputArray.length; i++) {
			this.dateArray[i] = Integer.parseInt(dateInputArray[i]);
		}				
	}

	public int getYear() {
		return this.dateArray[0];
	}

	public int getMonth() {
		return this.dateArray[1];
	}
	
	public int getDay() {
		return this.dateArray[2];
	}
	
	public String toString() {
		return this.getYear() + "-" + this.getMonth() + "-" + this.getDay();
	}
	
	/**
	 * Returns a unique hashCode for the date object.
	 */
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	/**
	 * Returns true if both objects have the same hashCode
	 */
	public boolean equals(Object other) {
		if (other == this) return true;
		if (!(other instanceof Date)) return false;

		if (this.hashCode() == other.hashCode()) return true;	
		return false;
	}
	
}
