package interfaces;

import models.multiple.Destination;

public interface Sailable {
    int getTurbineCount();

    public void sailTo(Destination destination) throws Exception;
}
