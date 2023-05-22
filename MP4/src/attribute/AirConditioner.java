package attribute;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AirConditioner {
    public static final int MIN_TEMPERATURE = 18;
    public static final int MAX_TEMPERATURE = 23;
    public static final int TEMP_CHANGE_COOLDOWN_MINUTES = 60;
    private double temperature;
    private LocalDateTime lastChanged;

    public AirConditioner(double temperature) throws Exception {
        if (!checkTempInRange(temperature)) {
            throw new Exception("The temperature must be between " + MIN_TEMPERATURE
                    + "° and " + MAX_TEMPERATURE + "°");
        }
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        // This method does not throw exceptions, instead it prints a message and returns.
        // This is because it is considered a normal situation that someone might want to
        // set a temperature out of permitted range, or change the temperature too quickly.

        if (!checkTempInRange(temperature)) {
            System.out.println("The temperature must be between " + MIN_TEMPERATURE
                    + "° and " + MAX_TEMPERATURE + "°");
            return;
        }
        if (lastChanged != null) {
            if (ChronoUnit.MINUTES.between(lastChanged, LocalDateTime.now()) < TEMP_CHANGE_COOLDOWN_MINUTES) {
                System.out.println("The temperature can be changed in "
                        + (TEMP_CHANGE_COOLDOWN_MINUTES - ChronoUnit.MINUTES.between(lastChanged, LocalDateTime.now()))
                        + " minutes.");
                return;
            }
        }

        this.temperature = temperature;
        lastChanged = LocalDateTime.now();
    }

    private static boolean checkTempInRange(double temperature) {
        return temperature >= MIN_TEMPERATURE && temperature <= MAX_TEMPERATURE;
    }

    @Override
    public String toString() {
        return "AirConditioner{" +
                "temperature=" + getTemperature() +
                ", lastChanged=" + lastChanged +
                '}';
    }
}
