package testing;

import assessment.*;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.Test;

public class test_cookiesLog {
	static String PATH = "C:\\Users\\Viabl\\git\\testing\\quantcast-main\\quantcast-main\\testing_data";

	/**
	 * Checks that the cookiesLog works for one date
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException {
		CookiesLog x = new CookiesLog(test_cookiesLog.PATH + "\\test_case1.csv");
		String answer = x.getMostActiveCookies(new DateTime("2022-01-31"));
		String correctAnswer = "A";
		assertEquals(answer, correctAnswer);
	}
	
	/**
	 * Checks that the cookiesLog works for unique cookies for multiple days
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		CookiesLog x = new CookiesLog(test_cookiesLog.PATH + "\\test_case2.csv");
		String answer = x.getMostActiveCookies(new DateTime("2022-01-31"));
		String correctAnswer = "A\nB\nC";
		assertEquals(answer, correctAnswer);
		
		String answer2 = x.getMostActiveCookies(new DateTime("2022-01-30"));
		String correctAnswer2 = "D\nE";
		assertEquals(answer2, correctAnswer2);
		
		String answer3 = x.getMostActiveCookies(new DateTime("2022-01-29"));
		String correctAnswer3 = "F";
		assertEquals(answer3, correctAnswer3);
	}
	
	/**
	 * Check that the cookiesLog works for a single day where cookies appear for
	 * different frequencies.
	 * @throws IOException
	 */
	@Test
	public void test3() throws IOException {
		CookiesLog x = new CookiesLog(test_cookiesLog.PATH + "\\test_case3.csv");
		String answer = x.getMostActiveCookies(new DateTime("2022-01-31"));
		String correctAnswer = "A";	
		assertEquals(answer, correctAnswer);
	}

	/**
	 * Check that the cookiesLog works for multiples day where cookies can appear
	 * in more than one day
	 * @throws IOException
	 */
	@Test
	public void test4() throws IOException {
		CookiesLog x = new CookiesLog(test_cookiesLog.PATH + "\\test_case4.csv");
		String answer = x.getMostActiveCookies(new DateTime("2022-01-31"));
		String correctAnswer = "A";	
		assertEquals(answer, correctAnswer);
		
		String answer2 = x.getMostActiveCookies(new DateTime("2022-01-30"));
		String correctAnswer2 = "C";	
		assertEquals(answer2, correctAnswer2);
		
		String answer3 = x.getMostActiveCookies(new DateTime("2022-01-29"));
		String correctAnswer3 = "B\nA\nC";	
		assertEquals(answer3, correctAnswer3);		
	}
}
