package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import assessment.Date;

public class test_DateTime {			
	@Test
	public void testConstructor1() {
		Date x = new Date("0000-00-00");
		String correctDate = "0-0-0";
		
		System.out.println(x.toString());
		assertEquals(x.toString(), correctDate);
		assertTrue(x.getDay() == 0);
		assertTrue(x.getMonth() == 0);
		assertTrue(x.getYear() == 0);
	}
	
	@Test
	public void testConstructor2() {
		Date x = new Date("2018-05-25");
		String correctDate = "2018-5-25";
		
		assertEquals(x.toString(), correctDate);
		assertTrue(x.getDay() == 25);
		assertTrue(x.getMonth() == 5);
		assertTrue(x.getYear() == 2018);
	}
	
	@Test
	public void testConstructor3() {
		Date x = new Date("0015-17-01");
		String correctDate = "15-17-1";
		
		assertEquals(x.toString(), correctDate);
		assertTrue(x.getDay() == 1);
		assertTrue(x.getMonth() == 17);
		assertTrue(x.getYear() == 15);
	}
	

	@Test
	public void testHashCode() {
		Date x = new Date("2018-05-25");
		Date y = new Date("2018-05-25");
		Date z= new Date("2018-05-26");
		String correctDate = "2018-5-25";
		String correctDate2 = "2018-5-26";
		

		assertEquals(x.toString(), correctDate);
		assertEquals(y.toString(), correctDate);
		assertEquals(z.toString(), correctDate2);
		
		assertTrue(x.hashCode() == y.hashCode());
		assertTrue(x.hashCode() != z.hashCode());
		assertTrue(y.hashCode() != z.hashCode());
	}
	

}
