package testPackage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import PPAPRegner.Validator;

public class ValidatorTest {

	Validator v = new Validator();

	@Test
	public void nullInput() {
		String temperatur = null;
		String valg = null;
		assertFalse(v.erGyldig(temperatur, valg));
	}

	@Test
	public void nullTemperatuerInput() {
		String temperatur = null;
		String valg = "CTF";
		assertFalse(v.erGyldig(temperatur, valg));
	}

	@Test
	public void nullValgInput() {
		String temperatur = "32";
		String valg = null;
		assertFalse(v.erGyldig(temperatur, valg));
	}

	@Test
	public void fielTemperaturInput() {
		String temperatur = "32a";
		String valg = "FTC";
		assertFalse(v.erGyldig(temperatur, valg));
	}

	@Test
	public void gyldigInput() {
		assertTrue(v.erGyldig("32", "CTF"));
	}

	@Test
	public void gyldigInputMedMellomrom() {
		String temperatur = "    3   2   ";
		String valg = "FTC";
		assertTrue(v.erGyldig("32", "CTF"));
	}
}
