package Beleg;

import static org.lwjgl.opengl.GL11.*;
import math.*;

public class SchwarmObjekt extends BewegtesObjekt {
    private static int objCounter = 0;
    private double radius;
    private double r, g, b;

    public SchwarmObjekt() {						//setze x, y, MAsse, maxGeschwindigkeit, Radius, r,g,b von B
        this(0, 0, 5., 5., 0, 255., 0, 0);
    }

    public SchwarmObjekt(double xPos, double yPos, double masse, double maxSpeed) {
        this(xPos, yPos, masse, maxSpeed, 0, 255, 0, 0);
    }

    public SchwarmObjekt(double xPos, double yPos, double masse, double maxSpeed, double radius, double r, double g, double b) {
        super(xPos, yPos, radius * masse, (maxSpeed * (1 / radius)));
        this.radius = radius;
        this.r = r;
        this.g = g;
        this.b = b;
        this.id = ++objCounter;
    }

    public int getId() {			//gib die ObjektID zurück
        return id;
    }

    public double[] getPosition() {		//gib Position zurück
        return position.getPosition();
    }

    public double getRadius () {		//gib Radius zurück
        return radius;
    }
    
    public void triangle() {
    	// direction und size werden in der funktion übergeben. size ist ein float und direction ein Vektor2D
    			double[] right, left, front;
    			try {
    				front = LineareAlgebra.mult(LineareAlgebra.normalize(velocity), radius);
    				right = LineareAlgebra.div(LineareAlgebra.turn(new Vektor2D(front)), 2);
    				left = LineareAlgebra.div(LineareAlgebra.turn(new Vektor2D(front)), 2);
    				    				
    			} catch (Exception e) {
    				front = right = left = new double[] {0,0};
    				e.printStackTrace();
    			}

    			glVertex2d((position.getX() + front[0]), (position.getY() + front[1]));
    			glVertex2d((position.getX() + right[0]), (position.getY() + right[1]));
    			glVertex2d((position.getX() + left[0]), (position.getY() + left[1]));
    			
    			
    }
    

    @Override
    public void render() {
    	glColor3d(r, g, b);			
        glBegin(GL_TRIANGLE_FAN);
        glVertex2d(position.getX(), position.getY());
                
		triangle();	
		
        glEnd();
    	
        
    }

}