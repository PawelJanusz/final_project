package pl.sda.final_project.weather;



public class Wind {

    private double speed;
    private double deg;

    @Override
    public String toString() {
        return "speed=" + speed +
                ", deg=" + deg ;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }
}
