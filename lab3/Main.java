public class Main {
    public static void main(String[] args) {

        System.out.println("=== Задание 1. Собственная HashTable ===");
        HashTable<String, Integer> table = new HashTable<>(16);

        table.put("apple", 5);
        table.put("banana", 3);
        table.put("orange", 7);

        System.out.println("Размер таблицы: " + table.size());
        System.out.println("Значение по ключу banana: " + table.get("banana"));

        table.put("banana", 10);
        System.out.println("Обновленное значение banana: " + table.get("banana"));

        System.out.println("Удалено значение по ключу apple: " + table.remove("apple"));
        System.out.println("Размер таблицы после удаления: " + table.size());
        System.out.println("Пуста ли таблица? " + table.isEmpty());

        System.out.println("\n=== Задание 2. HashMap для автопарка (вариант 9) ===");
        CarFleet fleet = new CarFleet();

        fleet.addCar("A111AA06", new Car("Toyota", "Camry", 2020));
        fleet.addCar("B222BB06", new Car("BMW", "X5", 2021));
        fleet.addCar("C333CC06", new Car("Lada", "Vesta", 2023));

        System.out.println("Все автомобили в автопарке:");
        fleet.printAllCars();

        System.out.println("\nПоиск автомобиля B222BB06:");
        System.out.println(fleet.findCar("B222BB06"));

        System.out.println("\nУдаление автомобиля A111AA06:");
        System.out.println(fleet.removeCar("A111AA06"));

        System.out.println("\nАвтопарк после удаления:");
        fleet.printAllCars();
    }
}
