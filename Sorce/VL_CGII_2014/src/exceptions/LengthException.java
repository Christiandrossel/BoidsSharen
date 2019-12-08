package exceptions;

public class LengthException extends Exception {

	/**
	 * F�ngt falsche L�ngenangaben ab
	 */
	private static final long serialVersionUID = 4931235819993999925L;

	public LengthException () {
        super("Laenge der Vektoren stimmen nicht ueberein.");
    }

    public LengthException (String message) {
        super(message);
    }
}
