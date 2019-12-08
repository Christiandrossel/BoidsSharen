package frame;

import math.Vektor2D;
import org.lwjgl.opengl.GL20;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glDeleteShader;


public abstract class ShaderFenster extends BasisFenster{
	private int progID;
	private int vertexID;
	private int fragmentID;
	
	public ShaderFenster(String text, int width, int height) {
		super(text, width, height);
	}
	
	public void initShader() {
		
		progID = glCreateProgram();													//erstellt ein Programmobjekt -> ist ein Containerobjekt an dem Shaderobjekte gebunden werden k�nnen
		vertexID = glCreateShader(GL_VERTEX_SHADER);								//erstellt ein Shaderobjekt -> soll Quellcode verwalten -> GL_VERTEX_SHADER: l�uft auf Vertex prozessor ersetzt Vertexbearbeitung
		fragmentID = glCreateShader(GL_FRAGMENT_SHADER);							// GL_FRAGMENT_SHADER: l�uft auf Fragment Prozessor und ersetzt Fragmentbearbeitung
		
		String vertexCode = "uniform vec2 position;" +
                "varying vec3 color;" +
                "void main() {" +
                "gl_Position = ftransform();" +
                "float r = position.x - int(position.x);" +						//Hier wird die RGB Farben berechnet
                "float g = position.y - int(position.x);" +
                "float b = ( r + g ) / 2;" +
                "color.xyz = vec3(r,g,b);" +
                "}";
        String fragmentCode = "varying vec3 color;" +
                "void main() {" +
                "gl_FragColor = vec4(color, 1);" +
                "}";
		
		glShaderSource(vertexID, vertexCode);										//ersetzt den Quellcode eines Shaderobjektes -> �bergabe der Parameter mit Quellcode
        glCompileShader(vertexID);													//kompilliert den Quellcode bsz den Shader (Vertex Shader)
        glShaderSource(fragmentID, fragmentCode);									//ersetzt den Quellcode eines ShaderObjektes mit den die angegeben wurden
        glCompileShader(fragmentID);												// Kompeliert das Shader objekt (Fragment Shader)
        glAttachShader(progID, vertexID);											//h�ngt den vertex Shader an das Programobjekt
        glAttachShader(progID, fragmentID);											//h�ngt den fragment Shader an das Programobjekt
        glLinkProgram(progID);														//f�hrt die Shader aus
        glValidateProgram(progID);													//�berpr�ft das Objekt							
        glUseProgram(progID);														//aktiviert die Shader im Objekt
        
	}
	
	public void deleteShader() {													//L�schen der Shader und des ProgramObjektes
        glDetachShader(progID, vertexID);
        glDetachShader(progID, fragmentID);
        glDeleteProgram(progID);
        glDeleteShader(vertexID);
        glDeleteShader(fragmentID);
    }

    public void setVar(Vektor2D position) {
        int pos = GL20.glGetUniformLocation(progID, "position");											// Liefert ein Ablageort der uniform Variable
        GL20.glUniform2f(pos, (float) Math.abs(position.getX()), (float) Math.abs(position.getY()));		
    }
	
}
