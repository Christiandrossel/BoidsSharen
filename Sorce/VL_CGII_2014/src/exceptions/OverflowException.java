package exceptions;

public class OverflowException extends Exception {
	
	/**
	 * F�ngt den �berlauf ab
	 */
	private static final long serialVersionUID = -9167408816983158770L;

	public OverflowException() {
        super("Ueberlauf eingetreten");
    }

    public OverflowException(String message) {
        super(message);
    }
}
