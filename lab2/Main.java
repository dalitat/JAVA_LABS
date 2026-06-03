public class Main {
    public static void main(String[] args) {

        System.out.println("--- Создание объектов ---");
        Car car1 = new Car("BMW", 200, 50, "Coupe", 2); 
        Truck truck1 = new Truck(); 
        Motorcycle bike1 = new Motorcycle("Ducati", 220, 17, "Sport", false);

        car1.showInfo();
        truck1.showInfo();
        bike1.showInfo();

        System.out.println("\n--- Геттеры ---");
        System.out.println("Модель машины: " + car1.getModel());
        System.out.println("Скорость грузовика: " + truck1.getSpeed());
        System.out.println("У мотоцикла есть коляска? " + bike1.isHasSidecar());

        System.out.println("\n--- Сеттеры ---");
        car1.setModel("Audi");
        System.out.println("Новая модель машины: " + car1.getModel());

        System.out.println("\n--- Перегрузка методов (полиморфизм) ---");
        car1.move(100);          
        car1.move(200, true);    
        
        System.out.println("\n--- Полиморфизм (массив Transport) ---");
        Transport[] transports = {car1, truck1, bike1};
        for (Transport t : transports) {
            t.showInfo(); 
        }

        Car car2 = new Car("Lada", 120, 30, "Sedan", 4);
        car2.showInfo();
        System.out.println("\n--- Статическое поле count ---");
        System.out.println("Всего создано объектов транспорта: " + Transport.getCount());
        
    }
}
