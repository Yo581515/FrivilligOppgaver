package Frivillig4Packe;

public class Validator {

	public static final String LETTERS = "[A-Za-z]*";

	public static boolean erGyldig(String forNavn, String etterNavn) {
		if (forNavn == null || forNavn == "" || etterNavn == null || etterNavn == "") {
			return false;
		}
		return forNavn.matches("^" + LETTERS + "$") && etterNavn.matches("^" + LETTERS + "$");
	}

}
