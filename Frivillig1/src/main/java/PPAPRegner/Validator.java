package PPAPRegner;

public class Validator {
	
	public static boolean erGyldig(String temeratur, String valg) {
		return temeratur != null && valg != null
				&& temeratur.matches("^-?\\d+(,\\d+)*(\\.\\d+)?$");
	}

}
