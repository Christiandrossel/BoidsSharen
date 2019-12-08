package math;

import exceptions.InfinityException;
import exceptions.LengthException;
import exceptions.OverflowException;

public abstract class Vektor {
    double[] vek;

    public double getX() {
        return vek[0];
    }

    public double getY() {
        return vek[1];
    }

    public double[] getPosition() {
        return vek;
    }

    public void setXPosition(double input) {
    	vek[0] = input;
    }

    public void setYPosition(double input) {
    	vek[1] = input;
    }
    
    // Setzte Position
    public abstract void setPosition(double[] input) throws OverflowException, InfinityException, LengthException;

    public boolean isNullVektor() {
        for (int i = 0; i < vek.length; i++) {
            if (vek[i] != 0)
                return false;
        }
        return true;
    }

    public boolean isNotNullVektor() {
        return !isNullVektor();
    }

    // Addition
    public void add(double[] input) throws OverflowException, InfinityException, LengthException {
        if (input.length == vek.length) {			// Länge der Vektoren vergleichen 
            for (int i = 0; i < vek.length; i++) {
            	vek[i] = ÜberprüfeÜberlauf.add(vek[i], input[i]);
            }
        } else {
            throw new LengthException("Vektor muss gleiche Laenge haben.");
        }
    }
    
    
    public void add(Vektor input) throws OverflowException, InfinityException, LengthException {
        add(input.getPosition());
    }

    // Subtraction
    public void sub(double[] input) throws OverflowException, InfinityException, LengthException {
        if (input.length == vek.length) {
            for (int i = 0; i < vek.length; i++) {
            	vek[i] = ÜberprüfeÜberlauf.sub(vek[i], input[i]);
            }
        } else {
            throw new LengthException();
        }
    }

    public void sub(Vektor input) throws OverflowException, InfinityException, LengthException {
        sub(input.getPosition());
    }

    public void mult(double input) throws OverflowException, InfinityException {
        for (int i = 0; i < vek.length; i++) {
        	vek[i] = ÜberprüfeÜberlauf.mult(vek[i], input);

        }
    }

    // Division
    public void div(double input) throws OverflowException, InfinityException {
        for (int i = 0; i < vek.length; i++) {
        	vek[i] = ÜberprüfeÜberlauf.div(vek[i], input);
        }
    }

    // Is Equal
    public boolean isEqual(double[] input) throws LengthException {
        if (input.length == vek.length) {
            for (int i = 0; i < vek.length; i++) {
                if (input[i] != vek[i])
                    return false;
            }
        } else {
            throw new LengthException();
        }
        return true;
    }

    public boolean isEqual(Vektor input) throws LengthException {
        return isEqual(input.getPosition());
    }

    // Is Not Equal
    public boolean isNotEqual(Vektor input) throws LengthException {
        return !isEqual(input.getPosition());
    }

    public boolean isNotEqual(double[] input) throws LengthException {
        return !isEqual(input);
    }

    // Length
    public double length() throws OverflowException, InfinityException {
        double tmp = 0;
        for (int i = 0; i < vek.length; i++) {
            tmp = ÜberprüfeÜberlauf.add(tmp, ÜberprüfeÜberlauf.mult(vek[i], vek[i]));
        }
        return Math.sqrt(tmp);
    }

    // Normalize
    public void normalize() throws OverflowException, InfinityException {
        div(length());
    }

    // Zusatz Kuerzen
    public Vektor kuerzen(double max) throws OverflowException, InfinityException {
        if (length() > max) {
            normalize();
            mult(max);
        }
        return this;
    }
    
    // Round
    public void round() {
        for (int i = 0; i < vek.length; i++){
        	vek[i] = Math.round(vek[i] * 100000) / 100000;
        }
    }
    
    public Vektor turnRight() throws OverflowException, InfinityException, LengthException{
    	setXPosition(vek[0] * (-0.5) - vek[1] * (0.866));
    	setYPosition(vek[0] * (0.866) + vek[1] * (-0.5));
    	return this;
    }
    
    public Vektor turnLeft() throws OverflowException, InfinityException, LengthException{
    	setPosition(new double[] {vek[0] * (-0.5) - vek[1] * (0.866), vek[0] * (0.866) + vek[1] * (-0.5)});
    	return this;
    }
}
