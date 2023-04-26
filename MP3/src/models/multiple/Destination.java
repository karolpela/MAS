package models.multiple;

public class Destination {
    private String name;
    private double x, y;
    private DestinationType type;

    public Destination(String name, double x, double y, DestinationType type) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public DestinationType getType() {
        return type;
    }

    public double calculateDistance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", type=" + type +
                '}';
    }
}
