package Beleg;

import exceptions.InfinityException;
import exceptions.LengthException;
import exceptions.OverflowException;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
//import schwarm.ObjectManager;
//import schwarm.SchwarmObjekt;
//import schwarm.SchwarmVerhalten;
import frame.ShaderFenster;
//import schwarm.SchwarmVerhalten2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.lwjgl.opengl.GL11.*;

import math.*;

public class DerSchwarm extends ShaderFenster {
    private ObjectManager objManager;
    private int width, height;

    //Fenstergröße
    public DerSchwarm() throws LWJGLException {
        this(1024, 768);
    }

    public DerSchwarm(int width, int height) throws LWJGLException {
        super("Der Schwarm", width, height);
        this.width = width;
        this.height = height;
        objManager = ObjectManager.getExemplar();			
        erzeugeSchwarmObjekt(50);
    }

    private void erzeugeSchwarmObjekt(int anz) {		//Schwarmobjekte erzeugen
    	Random rand = ThreadLocalRandom.current();
        for (int i = 0; i < anz; i++) {
            SchwarmObjekt so = new SchwarmObjekt(		// PosX, PosY, Masse, maxSpeed, Radius, r,g,b
                    (double) rand.nextInt(width),		// Randomwert der nur zwischen 0 und dem anangegeben Wert liegen darf 
                    (double) rand.nextInt(height),
                    200,50,(double) 20 + rand.nextInt(20),		
                    0,200,0
                    );
            so.setVelocity(new Vektor2D(10,10));
            so.setVerhalten(new SchwarmVerhalten(so));
            objManager.insertSchwarmObjekt(so);				//Den Objektmanager die erzeugten objekte übergeben
        }
    }

    @Override
    public void renderLoop() throws OverflowException, InfinityException, LengthException {
        while (!Display.isCloseRequested()) {
            glClearColor(0.1f, 0.4f, 0.4f, 1);				//Hintergrundfarbe (dunkles Grün)
            glClear(GL_COLOR_BUFFER_BIT);					//alter Standort Löschen/ aufräuumen
            glMatrixMode(GL_PROJECTION);					//setzt die aktuelle Matrix auf die Einheitsmatrix / Initialisierung der Projektionsmatrix
            glLoadIdentity();								// Ersetzt die aktuelle Matrix durch die Einheitsmatrix
            glOrtho(0, (double) width, (double) height, 0, 0, 1);	// Aktiviert einen orthonogalen RenderModus
            glMatrixMode(GL_MODELVIEW);						// legt fest weche Matrix aktiv ist, kann vier Werte annehmen, in diesem Fall wendet es Nachfolgende Matrix-Operationen auf den Modelview-Matrix-Stack an
            glDisable(GL_DEPTH_TEST);						//deaktiviert
            initShader();
            for (int i = 1; i <= objManager.getSchwarmobjektSize(); i++) {			//gehe jedes SchwarmObjekt durch
                SchwarmObjekt schwarmObj = objManager.getSchwarmObjekt(i);			//setze das Schwarmobjekt aus dem Obj.Manager auf ein Schwarmobjekt
                setVar(schwarmObj.getVelocityObj());							// Erzeugt das Blinken der Objekte   getvelocity gibt ein 2D Vektor zurück
                schwarmObj.render();											//rendert das Schwarmobjekt -> siehe SchwarmObjekt
                schwarmObj.update(width, height);								

            }
            deleteShader();
            Display.update();
            Display.sync(60);
        }


    }

    public static void main(String[] args) {

        try {
            new DerSchwarm().start();
        } catch (OverflowException e) {
            e.printStackTrace();
        } catch (InfinityException e) {
            e.printStackTrace();
        } catch (LengthException e) {
            e.printStackTrace();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }
}