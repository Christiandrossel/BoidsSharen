package math;

import exceptions.InfinityException;
import exceptions.LengthException;
import exceptions.OverflowException;

public class LineareAlgebra {

    private LineareAlgebra() {
    }

    public static double[] add(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        if (va.length == vb.length) {
            double[] tmp = new double[va.length];
            for (int i = 0; i < vb.length; i++) {
                tmp[i] = ÜberprüfeÜberlauf.add(va[i], vb[i]);
            }
            return tmp;
        }
        throw new LengthException();
    }

    public static double[] add(Vektor va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return add(va.getPosition(), vb.getPosition());
    }

    public static double[] add(Vektor va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return add(va.getPosition(), vb);
    }

    public static double[] add(double[] va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return add(va, vb.getPosition());
    }

    /**
     * Sutrahiert zwei Vektoren
     *
     * @param va
     * @param vb
     * @return double[]
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double[] sub(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        if (va.length == vb.length) {
            double[] tmp = new double[va.length];
            for (int i = 0; i < vb.length; i++) {
                tmp[i] = ÜberprüfeÜberlauf.sub(va[i], vb[i]);
            }
            return tmp;
        }
        throw new LengthException();
    }

    public static double[] sub(Vektor va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return sub(va.getPosition(), vb.getPosition());
    }

    public static double[] sub(Vektor va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return sub(va.getPosition(), vb);
    }

    public static double[] sub(double[] va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return sub(va, vb.getPosition());
    }

    /**
     * Multipliziert einen Vektor mit einem Skalar
     *
     * @param vektor
     * @param d
     * @return double[]
     * @throws OverflowException
     * @throws InfinityException
     */
    public static double[] mult(double[] vektor, double d) throws OverflowException, InfinityException {
        double[] tmp = new double[vektor.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = ÜberprüfeÜberlauf.mult(vektor[i], d);
        }
        return tmp;
    }

    public static double[] mult(double d, double[] v) throws OverflowException, InfinityException {
        return mult(v, d);
    }

    public static double[] mult(Vektor v, double d) throws OverflowException, InfinityException {
        return mult(v.getPosition(), d);
    }

    public static double[] mult(double d, Vektor v) throws OverflowException, InfinityException {
        return mult(v.getPosition(), d);
    }
        
    /**
     * Dividiert ein Skalar von einem Vektor
     *
     * @param vektor
     * @param d
     * @return
     * @throws OverflowException
     * @throws InfinityException
     */
    public static double[] div(double[] vektor, double d) throws OverflowException, InfinityException {
        double[] tmp = new double[vektor.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = ÜberprüfeÜberlauf.div(vektor[i], d);
        }
        return tmp;
    }

    public static double[] div(double d, double[] v) throws OverflowException, InfinityException {
        return div(v, d);
    }

    public static double[] div(Vektor v, double d) throws OverflowException, InfinityException {
        return div(v.getPosition(), d);
    }

    public static double[] div(double d, Vektor v) throws OverflowException, InfinityException {
        return div(v.getPosition(), d);
    }

    /**
     * Vegleicht zwei Vektoren auf gleichheit
     *
     * @param va
     * @param vb
     * @return boolean
     * @throws LengthException
     */
    public static boolean isEqual(Vektor va, Vektor vb) throws LengthException {
        return va.isEqual(vb);
    }

    public static boolean isEqual(Vektor v, double[] d) throws LengthException {
        return v.isEqual(d);
    }

    public static boolean isEqual(double[] d, Vektor v) throws LengthException {
        return v.isEqual(d);
    }

    public static boolean isEqual(double[] va, double[] vb) throws LengthException {
        if (va.length == vb.length) {
            for (int i = 0; i < va.length; i++) {
                if (va[i] != vb[i]) return false;
            }
            return true;
        } else {
            throw new LengthException();
        }
    }

    /**
     * Vegleicht zwei Vektoren auf ungleichheit
     *
     * @param va
     * @param vb
     * @return boolean
     * @throws LengthException
     */
    public static boolean isNotEqual(Vektor va, Vektor vb) throws LengthException {
        return !va.isEqual(vb);
    }

    public static boolean isNotEqual(Vektor v, double[] d) throws LengthException {
        return !v.isEqual(d);
    }

    public static boolean isNotEqual(double[] d, Vektor v) throws LengthException {
        return !v.isEqual(d);
    }

    public static boolean isNotEqual(double[] va, double[] vb) throws LengthException {
        return !isEqual(va, vb);
    }

    /**
     * Berechnet die Laenge eines Vektors.
     *
     * @param v
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     */
    public static double length(Vektor v) throws OverflowException, InfinityException {
        return v.length();
    }

    public static double length(double[] d) throws OverflowException, InfinityException {
        double tmp = 0;
        for (int i = 0; i < d.length; i++) {
            tmp = ÜberprüfeÜberlauf.add(ÜberprüfeÜberlauf.mult(d[i], d[i]), tmp);
        }
        return Math.sqrt(tmp);
    }

    /**
     * Normalisiert einen Vektor
     *
     * @param v
     * @return
     * @throws OverflowException
     * @throws InfinityException
     */
    public static double[] normalize(Vektor v) throws OverflowException, InfinityException {
        return normalize(v.getPosition());
    }

    public static double[] normalize(double[] v) throws OverflowException, InfinityException {
        return div(v, length(v));
    }

    public static double euklSqrtDistance(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        double[] tmp = sub(va, vb);
        double tmpAdd = 0;
        for (int i = 0; i < tmp.length; i++) {
            tmpAdd += ÜberprüfeÜberlauf.add(ÜberprüfeÜberlauf.mult(tmp[i], tmp[i]), tmpAdd);
        }
        return tmpAdd;
    }

    /**
     * Berechnet die ... eines Vektors
     *
     * @param va
     * @param vb
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double euklDistance(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return Math.sqrt(euklSqrtDistance(va, vb));
    }

    public static double euklDistance(Vektor va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return euklDistance(va.getPosition(), vb.getPosition());
    }

    public static double euklDistance(Vektor va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return euklDistance(va.getPosition(), vb);
    }

    public static double euklDistance(double[] va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return euklDistance(va, vb.getPosition());
    }

    /**
     * Berechnet die Manhattan Distance eines Vektors
     *
     * @param va
     * @param vb
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double manhattanDistance(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        double[] tmp = sub(va, vb);
        double tmpAdd = 0;
        for (int i = 0; i < tmp.length; i++) {
            tmpAdd = ÜberprüfeÜberlauf.add(tmpAdd, Math.abs(tmp[i]));
        }
        return tmpAdd;
    }

    public static double manhattanDistance(Vektor va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return manhattanDistance(va.getPosition(), vb.getPosition());
    }

    public static double manhattanDistance(Vektor va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return manhattanDistance(va.getPosition(), vb);
    }

    public static double manhattanDistance(double[] va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return manhattanDistance(va, vb.getPosition());
    }

    /**
     * Berechnet Kreuzprodukt zweier Vektoren
     *
     * @param va
     * @param vb
     * @return double[]
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double[] crossProduct(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        double[] tmp = new double[3];
        if (va.length == 3 && vb.length == 3) {
            tmp[0] = ÜberprüfeÜberlauf.sub(ÜberprüfeÜberlauf.mult(va[1], vb[2]), ÜberprüfeÜberlauf.mult(va[2], vb[1]));
            tmp[1] = ÜberprüfeÜberlauf.sub(ÜberprüfeÜberlauf.mult(va[2], vb[0]), ÜberprüfeÜberlauf.mult(va[0], vb[2]));
            tmp[2] = ÜberprüfeÜberlauf.sub(ÜberprüfeÜberlauf.mult(va[0], vb[1]), ÜberprüfeÜberlauf.mult(va[1], vb[0]));
            return tmp;
        }
        throw new LengthException("Nur Vektoren mit laenge 3 erlaubt");
    }

    public static double[] crossProduct(Vektor3D va, Vektor3D vb) throws OverflowException, InfinityException, LengthException {
        return crossProduct(va.getPosition(), vb.getPosition());
    }

    public static double[] crossProduct(double[] va, Vektor3D vb) throws OverflowException, InfinityException, LengthException {
        return crossProduct(va, vb.getPosition());
    }

    public static double[] crossProduct(Vektor3D va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return crossProduct(va.getPosition(), vb);
    }

    /**
     * Berechnet das Skalarprodukt zweier Vektoren
     *
     * @param va
     * @param vb
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double dotProduct(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        double tmp = 0;
        if (va.length == vb.length) {
            for (int i = 0; i < va.length; i++) {
                tmp = ÜberprüfeÜberlauf.add(ÜberprüfeÜberlauf.mult(va[i], vb[i]), tmp);
            }
            return tmp;
        }
        throw new LengthException("Vektoren muessen gleich laenge haben.");
    }

    public static double dotProduct(Vektor va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return dotProduct(va.getPosition(), vb.getPosition());
    }

    public static double dotProduct(Vektor va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return dotProduct(va.getPosition(), vb);
    }

    public static double dotProduct(double[] va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return dotProduct(va, vb.getPosition());
    }

    /**
     * Berechnet den Cosinus zweier Vektoren
     *
     * @param va
     * @param vb
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double cosEquation(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return ÜberprüfeÜberlauf.div(dotProduct(va, vb), ÜberprüfeÜberlauf.mult(length(va), length(vb)));
    }

    public static double cosEquation(Vektor va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return cosEquation(va.getPosition(), vb.getPosition());
    }

    public static double cosEquation(Vektor va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return cosEquation(va.getPosition(), vb);
    }

    public static double cosEquation(double[] va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return cosEquation(va, vb.getPosition());
    }

    /**
     * Berechnet den Sinus zweier Vektoren
     *
     * @param va
     * @param vb
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double sinEquation(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return ÜberprüfeÜberlauf.div(length(crossProduct(va, vb)), ÜberprüfeÜberlauf.mult(length(va), length(vb)));
    }

    public static double sinEquation(Vektor va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return sinEquation(va.getPosition(), vb.getPosition());
    }

    public static double sinEquation(Vektor va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return sinEquation(va.getPosition(), vb);
    }

    public static double sinEquation(double[] va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return sinEquation(va, vb.getPosition());
    }

    /**
     * Berechnet das Bogenmas zweier Vektoren
     *
     * @param va
     * @param vb
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double angleRad(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return Math.acos(cosEquation(va, vb));
    }

    public static double angleRad(Vektor va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return Math.acos(cosEquation(va, vb));
    }

    public static double angleRad(Vektor va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return Math.acos(cosEquation(va, vb));
    }

    public static double angleRad(double[] va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return Math.acos(cosEquation(va, vb));
    }

    /**
     * Gibt Winkel zweier Vektoren in Grad aus
     *
     * @param va
     * @param vb
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double angleDegree(Vektor va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return radToDegree(angleRad(va, vb));
    }

    public static double angleDegree(double[] va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return radToDegree(angleRad(va, vb));
    }

    public static double angleDegree(Vektor va, double[] vb) throws OverflowException, InfinityException, LengthException {
        return radToDegree(angleRad(va, vb));
    }

    public static double angleDegree(double[] va, Vektor vb) throws OverflowException, InfinityException, LengthException {
        return radToDegree(angleRad(va, vb));
    }

    /**
     * Rechnet Bogenmaß in Gradmaß um
     *
     * @param d
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     */
    public static double radToDegree(double d) throws OverflowException, InfinityException {
        return ÜberprüfeÜberlauf.mult(360 / (2 * Math.PI), d);
    }

    /**
     * Rechnet Gradmaß in Bogenmaß um
     *
     * @param d
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     */
    public static double degreeToRad(double d) throws OverflowException, InfinityException {
        return ÜberprüfeÜberlauf.mult(((2 * Math.PI) / 360), d);
    }

    /**
     * Berechnet die Determinante von drei Dreidimensionaler Vektoren
     *
     * @param va
     * @param vb
     * @param vc
     * @return double
     * @throws OverflowException
     * @throws InfinityException
     * @throws LengthException
     */
    public static double determinante(double[] va, double[] vb, double[] vc) throws OverflowException, InfinityException, LengthException {
        if (va.length == 3 && vb.length == 3 && vc.length == 3) {
            double tmp = 0;
            tmp = ÜberprüfeÜberlauf.mult(va[0], ÜberprüfeÜberlauf.mult(vb[1], vc[2]));
            tmp = ÜberprüfeÜberlauf.add(tmp, ÜberprüfeÜberlauf.mult(vb[0], ÜberprüfeÜberlauf.mult(vc[1], va[2])));
            tmp = ÜberprüfeÜberlauf.add(tmp, ÜberprüfeÜberlauf.mult(vc[0], ÜberprüfeÜberlauf.mult(va[1], vb[2])));
            tmp = ÜberprüfeÜberlauf.sub(tmp, ÜberprüfeÜberlauf.mult(vc[0], ÜberprüfeÜberlauf.mult(vb[1], va[2])));
            tmp = ÜberprüfeÜberlauf.sub(tmp, ÜberprüfeÜberlauf.mult(vb[0], ÜberprüfeÜberlauf.mult(va[1], vc[2])));
            tmp = ÜberprüfeÜberlauf.sub(tmp, ÜberprüfeÜberlauf.mult(va[0], ÜberprüfeÜberlauf.mult(vc[1], vb[2])));
            return tmp;
        } else {
            throw new LengthException("Die Vektoren muessen eine Laenge von 3 haben.");
        }
    }

    public static double determinante(Vektor3D va, Vektor3D vb, Vektor3D vc) throws OverflowException, InfinityException, LengthException {
        return determinante(va.getPosition(), vb.getPosition(), vc.getPosition());
    }

    /**
     * Bildet den Betrag der einzelnen Vektorwerte
     *
     * @param v
     * @return double[]
     */
    public static double[] abs(double[] v) {
        double[] tmp = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            tmp[i] = Math.abs(v[i]);
        }
        return tmp;
    }
    public static Vektor2D turn(Vektor2D vec) throws OverflowException, InfinityException, LengthException{
    	return vec.turn();
    }
}