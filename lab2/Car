public class Car extends Transport {

    private String bodyType;
    private int doors;

    public Car(String model, int speed, int fuel, String bodyType, int doors) {
        super(model, speed, fuel); 
        this.bodyType = bodyType;
        this.doors = doors;
    }

    public Car() {
        super("Toyota", 150, 40);
        this.bodyType = "Sedan";
        this.doors = 4;
    }

    // геттеры
    public String getBodyType() {
        return bodyType;
    }

    public int getDoors() {
        return doors;
    }

    // сеттеры
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    // переопределяем абстрактный метод (ПОЛИМОРФИЗМ)
    @Override
    public void showInfo() {
        System.out.println("Автомобиль: " + model +
                ", Кузов: " + bodyType +
                ", Скорость: " + speed +
                ", Дверей: " + doors);
    }
}
