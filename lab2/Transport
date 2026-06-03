public abstract class Transport {
    
    protected String model;
    protected int speed;
    protected int fuel;
    protected static int count = 0;

    public Transport(String model, int speed, int fuel) {
        this.model = model;
        this.speed = speed;
        this.fuel = fuel;
        count++; 
    }

    public Transport() {
        this("Unknown", 50, 10);
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFuel() {
        return fuel;
    }

    public static int getCount() {
        return count;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    // Абстрактный метод - каждый наследник должен показать себя
    public abstract void showInfo();

    // Метод move с одним параметром
    public void move(int distance) {
        fuel -= distance / 10; // Условный расход топлива
        System.out.println(model + " проехал " + distance + " км. Остаток топлива: " + fuel);
    }

    // Перегруженная версия метода move (с другим набором параметров)
    public void move(int distance, boolean isFast) {
        if (isFast) {
            System.out.println(model + " едет очень быстро!");
            fuel -= distance / 5; 
        } else {
            move(distance); 
        }
    }
}
