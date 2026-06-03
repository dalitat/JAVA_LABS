public class Truck extends Transport {
    private int loadCapacity; // в тоннах
    private boolean hasTrailer;

    public Truck(String model, int speed, int fuel, int loadCapacity, boolean hasTrailer) {
        super(model, speed, fuel);
        this.loadCapacity = loadCapacity;
        this.hasTrailer = hasTrailer;
    }

    public Truck() {
        super("Kamaz", 90, 200);
        this.loadCapacity = 10;
        this.hasTrailer = true;
    }

    // Геттеры и сеттеры
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }

    @Override
    public void showInfo() {
        System.out.println("Грузовик: " + model +
                ", Грузоподъемность: " + loadCapacity + "т" +
                ", Скорость: " + speed +
                ", Прицеп: " + (hasTrailer ? "есть" : "нет"));
    }
}
