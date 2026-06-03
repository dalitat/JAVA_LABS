public class Motorcycle extends Transport {
    private String handlebarType; 
    private boolean hasSidecar;

    public Motorcycle(String model, int speed, int fuel, String handlebarType, boolean hasSidecar) {
        super(model, speed, fuel);
        this.handlebarType = handlebarType;
        this.hasSidecar = hasSidecar;
    }

    public Motorcycle() {
        super("Harley", 180, 15);
        this.handlebarType = "Sport";
        this.hasSidecar = false;
    }

    // Геттеры и сеттеры
    public String getHandlebarType() {
        return handlebarType;
    }

    public void setHandlebarType(String handlebarType) {
        this.handlebarType = handlebarType;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void showInfo() {
        System.out.println("Мотоцикл: " + model +
                ", Тип руля: " + handlebarType +
                ", Скорость: " + speed +
                ", Коляска: " + (hasSidecar ? "есть" : "нет"));
    }
}
