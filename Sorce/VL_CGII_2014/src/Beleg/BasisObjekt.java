package Beleg;

import math.Vektor2D;

public abstract class BasisObjekt {
    public int id;
    public Vektor2D position = new Vektor2D();

    protected BasisObjekt() {			//setze die Position auf 0, 0
        position.setPosition(0, 0);
    }

    protected BasisObjekt(double xPos, double yPos) {		//setze die Position auf x, y
        position.setPosition(xPos, yPos);
    }

    public BasisObjekt(Vektor2D position) {				//setze die Position = die des Vektor2D
        this.position = new Vektor2D(position);
     }
    
    public abstract void render();
}
