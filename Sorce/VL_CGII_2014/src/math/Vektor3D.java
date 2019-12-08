package math;

import exceptions.InfinityException;
import exceptions.LengthException;
import exceptions.OverflowException;

public class Vektor3D extends Vektor {

    public Vektor3D() {
    	vek = new double[]{0, 0, 0};
    }

    public Vektor3D(Vektor3D input) {
    	vek = new double[]{input.getX(), input.getY(), input.getZ()};
    }

    public Vektor3D(double[] input) throws Exception {
    	vek = new double[3];
        if (input.length != 3)
            throw new Exception("Vektor konnte nicht erzeugt werden.");
        vek = input.clone();
    }

    public Vektor3D(double x, double y, double z) {
    	vek = new double[]{x, y, z};
    }

    public double getZ() {
        return vek[2];
    }

    public void setPosition(double[] input) throws OverflowException, InfinityException, LengthException {
        if (input.length != 3)
            throw new OverflowException("Vektorlaenge stimmt nicht");
        vek = input.clone();
    }

    public void setPosition(double x, double y, double z) {
    	vek[0] = x;
    	vek[1] = y;
    	vek[2] = z;
    }


    public void setZPosition(double input) {
    	vek[2] = input;
    }

    //Addition
    public void add(double x, double y, double z) throws OverflowException, InfinityException, LengthException {
        add(new double[]{x, y, z});
    }

    // Subtraktion
    public void sub(double x, double y, double z) throws OverflowException, InfinityException, LengthException {
        sub(new double[]{x, y, z});
    }

    // Is Equal
    public boolean isEqual(double x, double y, double z) throws OverflowException, InfinityException, LengthException {
        return isEqual(new double[]{x, y, z});
    }

    // Is Not Equal
    public boolean isNotEqual(double x, double y, double z) throws OverflowException, InfinityException, LengthException {
        return !isEqual(new double[]{x, y, z});
    }

}
