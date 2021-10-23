package Frivillig5Packe;

public class Validator {
	
	public static final String ANY_LETTER = "[A-Za-zÊ¯Â∆ÿ≈]";
	public static final String ANY_LETTER_OR_DIGIT = "[A-Za-zÊ¯Â∆ÿ≈\\d]";
	public static final String THREE_OR_MORE_TIMES = "{3,}";

    /**
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     *
     * Et gyldig brukernavn best√•r av 4 eller flere tegn. Lovlige tegn
     * er bokstaver (sm√• og store) inkl. de norske bokstavene, og tall.
     * Brukernavnet kan ikke begynne med et tall.
     */
    public static boolean isGyldigUsername(String username) {
    	
    	if (username == null) {
    		return false;
    	}
    	return username.matches("^" 
    			+ ANY_LETTER 
    			+ ANY_LETTER_OR_DIGIT + THREE_OR_MORE_TIMES
    			+ "$");
    }
}
