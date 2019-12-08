package Beleg;

import java.util.HashMap;


/*
*	Objectmanager mit Schwarmobject (Kugeln)
*/

public class ObjectManager {

    private HashMap<Integer, SchwarmObjekt> schwarmObjekt;
    private static ObjectManager exemplar = new ObjectManager();

    private ObjectManager() {
        schwarmObjekt = new HashMap<Integer, SchwarmObjekt>();
    }

    public static ObjectManager getExemplar() {
        return exemplar;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clonen ist nicht erlaubt");
    }

    public void insertSchwarmObjekt(SchwarmObjekt obj) {
        schwarmObjekt.put(new Integer(obj.id), obj);
    }

    public void entferneSchwarmObjekt(SchwarmObjekt obj) {
        schwarmObjekt.remove(obj);
    }

    public SchwarmObjekt getSchwarmObjekt(int objID) {
        return schwarmObjekt.get(new Integer(objID));
    }

    public HashMap<Integer, SchwarmObjekt> getSchwarmObjektMap() {
        return schwarmObjekt;
    }

    public int getSchwarmobjektSize() {
        return schwarmObjekt.size();
    }

}