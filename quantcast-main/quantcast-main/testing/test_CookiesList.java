package testing;

import assessment.CookiesList;
import static org.junit.Assert.*;

import org.junit.Test;

public class test_CookiesList {

	@Test
	public void test_constructor() {
		CookiesList x = new CookiesList("A");
		
		assertEquals(x.getHead().getCookie(), "A");
		assertEquals(x.getTail().getCookie(), "A");
		assertEquals(x.getHead().getFrequency(), 1);
		assertEquals(x.getHead(), x.getTail());
	}

	@Test
	public void test_insert() {
		CookiesList x = new CookiesList("A");
		x.insert("B");
		
		assertEquals(x.getHead().getCookie(), "A");
		assertEquals(x.getTail().getCookie(), "B");
		assertEquals(x.getHead().getFrequency(), 1);
		assertEquals(x.getTail().getFrequency(), 1);
		
		assertEquals(x.get("A"), x.getHead());
		assertEquals(x.get("B"), x.getTail());				
	}
	
	@Test
	public void test_insert2() {
		CookiesList x = new CookiesList("A");
		x.insert("B");
		x.insert("A");
		x.insert("B");
		x.insert("C");
		x.insert("A");
		x.insert("D");		
		x.insert("D");
		x.insert("A");		
		
		assertEquals(x.getHead().getCookie(), "A");
		assertEquals(x.getTail().getCookie(), "D");
		assertEquals(x.get("A").getFrequency(), 4);
		assertEquals(x.get("B").getFrequency(), 2);
		assertEquals(x.get("C").getFrequency(), 1);
		assertEquals(x.get("D").getFrequency(), 2);
	}
	
	@Test
	public void test_contains() {
		CookiesList x = new CookiesList("A");
		x.insert("B");
		x.insert("A");
		x.insert("B");
		x.insert("C");
		x.insert("A");
		x.insert("D");		
		x.insert("D");
		x.insert("A");		
		
		assertTrue(x.contains("A"));
		assertTrue(x.contains("B"));
		assertTrue(x.contains("C"));
		assertTrue(x.contains("D"));
		
		assertFalse(x.contains("Z"));
		assertFalse(x.contains("Q"));
	}
	
	@Test
	public void test_mostActiveCookies() {
		CookiesList x = new CookiesList("A");
		
		String ans = x.getMostActivesCookies();
		String correctAnswer = "A";
		assertEquals(ans, correctAnswer);
	}

	@Test
	public void test_mostActiveCookies2() {
		CookiesList x = new CookiesList("A");
		x.insert("B");
		x.insert("A");
		x.insert("B");
		x.insert("C");
		x.insert("A");
		x.insert("D");		
		x.insert("D");
		x.insert("A");
		
		String ans = x.getMostActivesCookies();
		String correctAnswer = "A";
		assertEquals(ans, correctAnswer);
	}

	@Test
	public void test_mostActiveCookies3() {
		CookiesList x = new CookiesList("A");
		x.insert("B");
		x.insert("A");
		x.insert("B");
		x.insert("C");
		x.insert("A");
		x.insert("D");		
		x.insert("D");
		x.insert("B");
		x.insert("D");
		
		String ans = x.getMostActivesCookies();
		String correctAnswer = "A\nB\nD";
		System.out.println(ans);
		assertEquals(ans, correctAnswer);
	}
}
