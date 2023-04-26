package interfaces;

import models.multiple.Destination;
import models.multiple.DestinationType;

public interface Sailable {
    int getTurbineCount();

    public void sailTo(Destination destination) throws Exception;
}
