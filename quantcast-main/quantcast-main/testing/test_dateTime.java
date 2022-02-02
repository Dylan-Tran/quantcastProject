package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import assessment.DateTime;

public class test_dateTime {			
	@Test
	public void testConstructor1() {
		DateTime x = new DateTime("0000-00-00");
		assertTrue(x.getDay() == 0);
		assertTrue(x.getMonth() == 0);
		assertTrue(x.getYear() == 0);
	}
	
	@Test
	public void testConstructor2() {
		DateTime x = new DateTime("2018-05-25");
		assertTrue(x.getDay() == 25);
		assertTrue(x.getMonth() == 5);
		assertTrue(x.getYear() == 2018);
	}
	
	@Test
	public void testConstructor3() {
		DateTime x = new DateTime("0015-17-01");
		assertTrue(x.getDay() == 1);
		assertTrue(x.getMonth() == 17);
		assertTrue(x.getYear() == 15);
	}
	
	@Test
	public void testConstructor4() {
		DateTime x = new DateTime("0000-00-00", "14:19:00+00:00");
		assertTrue(x.getDay() == 0);
		assertTrue(x.getMonth() == 0);
		assertTrue(x.getYear() == 0);
	}
	
	@Test
	public void testConstructor5() {
		DateTime x = new DateTime("2018-05-25", "14:19:00+00:00");
		assertTrue(x.getDay() == 25);
		assertTrue(x.getMonth() == 5);
		assertTrue(x.getYear() == 2018);
	}

	@Test
	public void testHashCode1() {
		DateTime x = new DateTime("2018-05-25");
		DateTime y = new DateTime("2018-05-25");
		DateTime z= new DateTime("2018-05-26");
		
		assertTrue(x.hashCode() == y.hashCode());
		assertTrue(x.hashCode() != z.hashCode());
	}
	
	@Test
	public void testHashCode2() {
		DateTime x = new DateTime("2018-05-25", "14:19:00+00:00");
		DateTime y = new DateTime("2018-05-25", "00:19:00+00:00");
		DateTime z= new DateTime("2018-05-26", "00:19:00+00:00");
		
		assertTrue(x.hashCode() == y.hashCode());
		assertTrue(x.hashCode() != z.hashCode());
	}

}
