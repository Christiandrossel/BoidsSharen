package Beleg;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;

public class Dreieck extends BewegtesObjekt {
	

	
	    private static int objCounter = 0;
	    private double radius;
	    private double r, g, b;

	    public Dreieck() {						//setze x, y, MAsse, maxSpeed, Radius, r,g,b von B
	        this(0, 0, 5, 5, 0, 255, 0, 0);
	    }

	    public Dreieck(double xPos, double yPos, double masse, double maxSpeed) {
	        this(xPos, yPos, masse, maxSpeed, 0, 255, 0, 0);
	    }

	    public Dreieck(double xPos, double yPos, double masse, double maxSpeed, double radius, double r, double g, double b) {
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
	    

	    @Override
	    public void render() {
	        glColor3d(r, g, b);			//render Farben
	        glBegin(GL_TRIANGLE_FAN);
	        glVertex2d(position.getX(), position.getY());

	        //Rendert Dreiecke:
	        glVertex2d(position.getX() + Math.sin(5) * radius, position.getY() + Math.cos(5) * radius);
	        glVertex2d(position.getX() + Math.sin(10) * radius, position.getY() + Math.cos(10) * radius);
	        glVertex2d(position.getX() + Math.sin(10) * radius, position.getY() + Math.cos(10) * radius);
	        glEnd();
	    }
}