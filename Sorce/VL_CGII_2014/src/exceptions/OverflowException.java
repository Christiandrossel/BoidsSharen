package exceptions;

public class OverflowException extends Exception {
	
	/**
	 * Fängt den Überlauf ab
	 */
	private static final long serialVersionUID = -9167408816983158770L;

	public OverflowException() {
        super("Ueberlauf eingetreten");
    }

    public OverflowException(String message) {
        super(message);
    }
}
