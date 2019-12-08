package Beleg;

import math.Vektor2D;
import exceptions.InfinityException;
import exceptions.LengthException;
import exceptions.OverflowException;

public abstract class BewegtesObjekt extends BasisObjekt {

    protected double maxGeschwindigkeit;
    protected double masse;
    protected Vektor2D velocity = new Vektor2D();
    protected Verhalten verhalten = null;

    public BewegtesObjekt() {						//alles 0 setzen
        super(0, 0);
        this.maxGeschwindigkeit = 0;
        this.masse = 0;        
        velocity.setPosition(0, 0);
    }

    public BewegtesObjekt(Vektor2D position, Vektor2D velocity) {			//setze Position und Geschwindigkeit
        super(position);
        this.velocity = new Vektor2D(velocity);
     }
        
    
    public BewegtesObjekt(double xPos, double yPos, double masse, double maxGeschwindigkeit) {		//setze Positionen, Masse max.Geschwindigkeit
        super(xPos, yPos);
        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.masse = masse;        
    }

    public Vektor2D getVelocityObj() {				//gib Geschwindigkeit zurück
        return velocity;
    }

    public double getMaxGeschwindigkeit() {			// gib maxGeschwindigkeit zurück
        return maxGeschwindigkeit;
    }

    public double getMasse() {
        return masse;
    }

    public void setVelocity(Vektor2D vec) {
    	this.velocity.setPosition(vec.getX(), vec.getY());
    }
    public void setVerhalten(Verhalten verhalten) {		//setze Verhalten
        this.verhalten = verhalten;
    }

    public void update(int width, int height) throws OverflowException, InfinityException, LengthException {		// update verhalten
        if (verhalten != null)
            verhalten.update(width, height);
    }


}
