package Beleg;

import math.LineareAlgebra;
import math.Vektor2D;
import exceptions.InfinityException;
import exceptions.LengthException;
import exceptions.OverflowException;
import org.lwjgl.input.Mouse;


public class SchwarmVerhalten implements Verhalten {
    private SchwarmObjekt schwarmObjekt;
    private ObjectManager manager = ObjectManager.getExemplar();
    private SchwarmObjekt tmpObj;
    private Vektor2D kraft = new Vektor2D(0, 0);

    private double sep = 100;																		//setze Seperation
    private double ang = 300;																		// setze angleichen

    public SchwarmVerhalten(SchwarmObjekt schwarmObjekt) {											// setze das Schwarmobjekt 
        this.schwarmObjekt = schwarmObjekt;
    }

    public Vektor2D seperation() throws OverflowException, InfinityException, LengthException {
        Vektor2D steeringForce = new Vektor2D(0, 0);															//Lenkung
        Vektor2D help = new Vektor2D();
        double length;
        for (int i = 1; i <= manager.getSchwarmobjektSize(); i++) {									//Überprüfe jedes Schwarmobjekt im Obj.Manager ob es existiert bzw die ID besitzt
            if (schwarmObjekt.getId() == i) {
                continue;
            }

            tmpObj = manager.getSchwarmObjekt(i);													//setze das Schwarmobj auf ein temp obj
            if (LineareAlgebra.euklSqrtDistance(tmpObj.getPosition(), schwarmObjekt.getPosition()) < (schwarmObjekt.getRadius() * sep)) {		// Überprüfe und berechne die distance ob sie kleiner ist als die des objektesradius mal den angegeben sep wertes
                if (schwarmObjekt.position.isNotEqual(tmpObj.position)) {																		//wenn ja Überprüfe ob die position ungleich der des anderen objektes
                    help.setPosition(LineareAlgebra.sub(schwarmObjekt.position, tmpObj.position));												// Berechne das ausweichverhalten und gebe es zurück
                    length = help.length();
                    help.normalize();
                    help.div(length);
                    steeringForce.add(help);
                }
            }
        }
        return steeringForce;
    }

    public Vektor2D angleichen() throws OverflowException, InfinityException, LengthException {
        Vektor2D steeringForce = new Vektor2D(0, 0);
        int counter = 0;
        for (int i = 1; i <= manager.getSchwarmobjektSize(); i++) {																	// gehe die Schwarmobjekte im obj manager durch
            if (schwarmObjekt.getId() == i) {																						// wenn gesetzte objekt das obj im objManager ist mache weiter
                continue;
            }
            tmpObj = manager.getSchwarmObjekt(i);																					// setze dieses Objekt auf ein temp obj
            if (LineareAlgebra.euklSqrtDistance(tmpObj.getPosition(), schwarmObjekt.getPosition()) < ang * ang) {					// wenn die berechnung der distance kleiner als die des gesetztes angleich wertes ^2 ist
                steeringForce.add(tmpObj.getVelocityObj());																			// dann addiere zu dem vektor die geschwindigkeit des tempobjektes
                counter++;																											// zähle counter hoch
            }

        }
        if (counter > 0) {																											//wenn der counter größer 0 ist
            steeringForce.div(counter);																								// dann dividiere den vektor durch den counter
            steeringForce.sub(schwarmObjekt.getVelocityObj());																		//subtrahiere den vektor mit der geschwindigkeit des umliegenden schwarmobjektes
        }
        return steeringForce;																										//gib den berechneten vektor zurück
    }

    public Vektor2D zusammenhalten() throws OverflowException, InfinityException, LengthException {
        Vektor2D steeringForce = new Vektor2D(1000, 1000);
        int counter = 0;
        double lenght;
        double[] tmp;
        for (int i = 1; i <= manager.getSchwarmobjektSize(); i++) {
            if (schwarmObjekt.getId() == i) {
                continue;
            }
            tmpObj = manager.getSchwarmObjekt(i);	//
            tmp = tmpObj.getPosition();
            lenght = LineareAlgebra.length(tmp);
            LineareAlgebra.mult(tmp, (1 / (lenght * schwarmObjekt.getMasse())));
            steeringForce.add(tmp);
            counter++;
        }
        if (counter > 0) {
            steeringForce.div(counter);
            steeringForce.sub(schwarmObjekt.getPosition());
        }

        return steeringForce;
    }

    public Vektor2D mouseSeperation(int richtung, int radius, int height) throws OverflowException, InfinityException, LengthException {
        double length;
        Vektor2D steeringForce = new Vektor2D(0, 0);
        Vektor2D helpVec = new Vektor2D();
        double[] mousePos = new double[]{Mouse.getX(), height - Mouse.getY()};
        
        if (LineareAlgebra.euklDistance(schwarmObjekt.getPosition(), mousePos) < radius) {
            if (schwarmObjekt.position.isNotEqual(mousePos)) {
                helpVec.setPosition(LineareAlgebra.sub(schwarmObjekt.position, mousePos));
                length = helpVec.length();
                helpVec.normalize();
                helpVec.mult(richtung * length);
                steeringForce.add(helpVec);
            }
        }
        return steeringForce;
    }

    @Override
    public void update(int width, int height) throws OverflowException, InfinityException, LengthException {

        kraft.add(LineareAlgebra.mult(seperation(), 10000));
        kraft.add(LineareAlgebra.mult(angleichen(), 80));
        kraft.add(LineareAlgebra.mult(zusammenhalten(), (0.2)));
        if (Mouse.isButtonDown(0)) {
            kraft.add(mouseSeperation(-5, 500, height));
        }
        if (Mouse.isButtonDown(1)) {
            kraft.add(mouseSeperation(5, 200, height));
        }
        kraft.round();
        kraft.div(schwarmObjekt.getMasse());
        schwarmObjekt.getVelocityObj().add(kraft);
        schwarmObjekt.getVelocityObj().kuerzen(schwarmObjekt.getMaxGeschwindigkeit());
        schwarmObjekt.position.add(schwarmObjekt.getVelocityObj());

        schwarmObjekt.position.setXPosition((schwarmObjekt.position.getX() + width) % width);
        schwarmObjekt.position.setYPosition((schwarmObjekt.position.getY() + height) % height);
    }
}
