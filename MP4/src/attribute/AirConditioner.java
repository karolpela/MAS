package attribute;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AirConditioner {
    public static final int MIN_TEMPERATURE = 18;
    public static final int MAX_TEMPERATURE = 23;
    private double temperature;
    private LocalDateTime lastChanged;

    public AirConditioner(double temperature) throws Exception {
        if (!checkTempRange(temperature)) {
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

        if (!checkTempRange(temperature)) {
            System.out.println("The temperature must be between " + MIN_TEMPERATURE
                    + "° and " + MAX_TEMPERATURE + "°");
            return;
        }
        if (lastChanged != null) {
            if (ChronoUnit.HOURS.between(lastChanged, LocalDateTime.now()) < 1) {
                System.out.println("The temperature cannot be changed yet");
                return;
            }
        }

        this.temperature = temperature;
        lastChanged = LocalDateTime.now();
    }

    private static boolean checkTempRange(double temperature) {
        return temperature >= MIN_TEMPERATURE && temperature <= MAX_TEMPERATURE;
    }

    @Override
    public String toString() {
        return "AirConditioner{" +
                "temperature=" + temperature +
                ", lastChanged=" + lastChanged +
                '}';
    }
}
