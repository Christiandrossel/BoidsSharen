package frame;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import exceptions.*;

public abstract class BasisFenster {
   private int width, height;
   private String title;
   
   public BasisFenster() {
      this("BasisFenster", 1024, 768);
   }
   
   public BasisFenster(String title, int width, int height) {
      this.setWidth(width);
      this.setHeight(height);
      this.title  = title;
   }
   
   public void initDisplay() {
      try {
         Display.setDisplayMode(new DisplayMode(getWidth(), getHeight()));
         Display.setTitle(title);
         Display.create();
      } catch (LWJGLException e) {
         e.printStackTrace();
      }      
   }
   
   public abstract void renderLoop()throws OverflowException, InfinityException, LengthException;
   
   public void start()  throws OverflowException, InfinityException, LengthException {     
      initDisplay();
      renderLoop();
      Display.destroy();
      System.exit(0);
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }
}

