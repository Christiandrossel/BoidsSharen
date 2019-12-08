package Beleg;

import exceptions.InfinityException;
import exceptions.LengthException;
import exceptions.OverflowException;

public interface Verhalten {
    public void update(int width, int height) throws OverflowException, InfinityException, LengthException;
}