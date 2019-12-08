package math;

import exceptions.InfinityException;
import exceptions.LengthException;
import exceptions.OverflowException;

public class Vektor2D extends Vektor {

    public Vektor2D() {
    	vek = new double[]{0, 0};
    }

    public Vektor2D(Vektor2D input) {
        vek= new double[]{input.getX(), input.getY()};
    }

    public Vektor2D(double[] input) throws Exception {
    	vek = new double[2];
        if (input.length != 2)
            throw new Exception("Vektor konnte nicht erzeugt werden.");
        vek = input.clone();
    }

    public Vektor2D(double x, double y) {
    	vek = new double[]{x, y};
    }


    public void setPosition(double[] input) throws OverflowException, InfinityException, LengthException {
        if (input.length != 2)
            throw new OverflowException("Vektorlaenge stimmt nicht");
        vek = input.clone();
    }

    public void setPosition(double x, double y) {
    	vek[0] = x;
    	vek[1] = y;
    }

    // Adittion
    public void add(double x, double y) throws OverflowException, InfinityException, LengthException {
        super.add(new double[]{x, y});
    }

    // Subtraction
    public void sub(double x, double y) throws OverflowException, InfinityException, LengthException {
        super.sub(new double[]{x, y});
    }

    //Is Equal
    public boolean isEqual(double x, double y) throws OverflowException, InfinityException, LengthException {
        return isEqual(new double[]{x, y});
    }

    //Is Not Equal
    public boolean isNotEqual(double x, double y) throws OverflowException, InfinityException, LengthException {
        return !isEqual(new double[]{x, y});
    }
    
    public Vektor2D turn() throws OverflowException, InfinityException, LengthException{
    	setXPosition(vek[0] * (-0.5) - vek[1] * (0.866));
    	setYPosition(vek[0] * (0.866) + vek[1] * (-0.5));
    	return this;
    }

}
