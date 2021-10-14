package testPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import PPAPRegner.Regner;

public class RegnerTest {
	
	Regner r = new Regner();
	
	@Test
	public void testRoud() {
		assertEquals(3.9, r.round(3.94,  1));
	}
	
	@Test
	public void testRoud2() {
		assertEquals(4, r.round(3.98938, 1));
	}
	
	/**
	 * Tester Celsius til Fahrenheit
	 */
	@Test
	public void CTF() {
		assertEquals(33.8, r.CTF(1));
	}
	
	/**
	 * Tester Fahrenheit til Celsius
	 */
	@Test
	public void FTC() {
		assertEquals(-17.2, r.FTC(1));
	}

}
