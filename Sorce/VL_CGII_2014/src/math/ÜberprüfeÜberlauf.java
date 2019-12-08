package math;

import exceptions.InfinityException;
import exceptions.OverflowException;

import java.lang.Math;

public class ÜberprüfeÜberlauf {

    private ÜberprüfeÜberlauf() {
    }

    // Überprüfung des Überlaufs bei Addition
    public static void addValueOverflow(double i, double j) throws OverflowException, InfinityException {

        if (Double.MAX_VALUE - i - j < 0 || Double.MAX_VALUE - j - i < 0) {
            throw new OverflowException("Ueberlauf bei Addition im possitiven Bereich.");
        }
        if (-Double.MAX_VALUE + i + j > 0 || -Double.MAX_VALUE + j + i > 0) {
            throw new OverflowException("Ueberlauf bei Addition im negativen Bereich.");
        }

        if (Double.POSITIVE_INFINITY == i + j || Double.NEGATIVE_INFINITY == i + j)
            throw new InfinityException("Infinity Overflow");
    }

    public static double add(double i, double j) throws OverflowException, InfinityException {
        addValueOverflow(i, j);
        return i + j;
    }

    // Überprüfung des Überlaufs bei Subtraktion
    public static void subValueOverflow(double i, double j) throws OverflowException, InfinityException {
        if (Double.MAX_VALUE - i + j < 0) {
            throw new OverflowException("Ueberlauf bei Subtraktion im positiven Bereich.");
        }
        if (Double.MAX_VALUE + i - j < 0) {
            throw new OverflowException("Ueberlauf bei Subtraktion im negativen Bereich.");
        }
        if (Double.POSITIVE_INFINITY == i - j || Double.NEGATIVE_INFINITY == i - j)
            throw new InfinityException("Infinity Overflow");
    }

    public static double sub(double i, double j) throws OverflowException, InfinityException {
        subValueOverflow(i, j);
        return i - j;
    }

    // Überprüfung des Überlaufs bei Multiplikation
    public static void multValueOverflow(double i, double j) throws OverflowException, InfinityException {
        if (Double.MAX_VALUE / Math.abs(i) - Math.abs(j) < 0) {
            throw new OverflowException("Ueberlauf bei Multiplikation/Division im Vorkommabereich.");
        }
        if (Math.abs(i - (int) i) != 0 && Math.abs(j - (int) j) != 0 ) {
            if (Double.MIN_VALUE / (Math.abs(i - (int) i)) > (Math.abs(j - (int) j))) {
                throw new OverflowException("Ueberlauf bei Multiplikation/Division im Nachkommabereich.");
            }
        }

        if (Double.POSITIVE_INFINITY == Math.abs(i) * Math.abs(j))
            throw new InfinityException("Infinity Overflow");
    }

    public static double mult(double i, double j) throws OverflowException, InfinityException {
        multValueOverflow(i, j);
        return i * j;
    }

    // Überprüfe ob bei Division nicht durch 0 geteilt wird
    public static void divValueOverflow(double i, double j) throws OverflowException, InfinityException {
        if (j == 0) {
            throw new OverflowException("Nulldivision");
        }
    }

    public static double div(double i, double j) throws OverflowException, InfinityException {
        divValueOverflow(i, j);
        return mult(i, 1 / j);
    }
}
