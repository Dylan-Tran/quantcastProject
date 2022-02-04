package testing;

import assessment.CookiesList;
import static org.junit.Assert.*;

import org.junit.Test;

public class test_CookiesList {

	@Test
	public void test_constructor() {
		CookiesList x = new CookiesList("A");
		
		assertEquals(x.getHead(), x.getTail());
	}

	@Test
	public void test_insertCookie() {
		CookiesList x = new CookiesList("A");
		x.insertCookie("B");
		
		String str = x.toString();
		String correctString = "[A, 1] [B, 1]";
		assertNotEquals(x.getHead(), x.getTail());		
		assertEquals(x.getCookie("A"), x.getHead());
		assertEquals(x.getCookie("B"), x.getTail());
		assertEquals(str, correctString);
	}
	
	@Test
	public void test_insertCookie2() {
		CookiesList x = new CookiesList("A");
		x.insertCookie("B");
		x.insertCookie("A");
		x.insertCookie("B");
		x.insertCookie("C");
		x.insertCookie("A");
		x.insertCookie("D");		
		x.insertCookie("D");
		x.insertCookie("A");		

		String str = x.toString();
		String correctString = "[A, 4] [B, 2] [C, 1] [D, 2]";

		assertNotEquals(x.getHead(), x.getTail());
		assertEquals(str, correctString);
	}
	
	@Test
	public void test_contains() {
		CookiesList x = new CookiesList("A");
		x.insertCookie("B");
		x.insertCookie("A");
		x.insertCookie("B");
		x.insertCookie("C");
		x.insertCookie("A");
		x.insertCookie("D");		
		x.insertCookie("D");
		x.insertCookie("A");		
		
		assertTrue(x.containsCookie("A"));
		assertTrue(x.containsCookie("B"));
		assertTrue(x.containsCookie("C"));
		assertTrue(x.containsCookie("D"));
		assertFalse(x.containsCookie("Z"));
		assertFalse(x.containsCookie("Q"));
	}
	
	@Test
	public void test_mostActiveCookies() {
		CookiesList x = new CookiesList("A");
		
		String ans = x.mostActiveCookies();
		String correctAnswer = "A";
		assertEquals(ans, correctAnswer);
	}

	@Test
	public void test_mostActiveCookies2() {
		CookiesList x = new CookiesList("A");
		x.insertCookie("B");
		x.insertCookie("A");
		x.insertCookie("B");
		x.insertCookie("C");
		x.insertCookie("A");
		x.insertCookie("D");		
		x.insertCookie("D");
		x.insertCookie("A");
		
		String ans = x.mostActiveCookies();
		String correctAnswer = "A";
		assertEquals(ans, correctAnswer);
	}

	@Test
	public void test_mostActiveCookies3() {
		CookiesList x = new CookiesList("A");
		x.insertCookie("B");
		x.insertCookie("A");
		x.insertCookie("B");
		x.insertCookie("C");
		x.insertCookie("A");
		x.insertCookie("D");		
		x.insertCookie("D");
		x.insertCookie("B");
		x.insertCookie("D");
		
		String ans = x.mostActiveCookies();
		String correctAnswer = "A\nB\nD";
		assertEquals(ans, correctAnswer);
	}
}
