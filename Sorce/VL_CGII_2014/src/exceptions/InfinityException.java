package exceptions;

public class InfinityException extends Exception {



	/**
	 * Fängt den Unendlichkeitsfaktor ab
	 */
	private static final long serialVersionUID = -2018336938383657828L;

	public InfinityException() {
        super("InfinityException");
    }

    public InfinityException(String message) {
        super(message);
    }


}
