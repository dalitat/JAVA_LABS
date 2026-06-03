public class SalesDemo {
    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addSale("Книга", 750);
        tracker.addSale("Тетрадь", 60);
        tracker.addSale("Тетрадь", 60);
        tracker.addSale("Ручка", 30);
        tracker.addSale("Танк", 8000);
        tracker.addSale("Танк", 8000);
        tracker.addSale("Танк", 8000);

    
        tracker.printSales();
        System.out.println("Общая сумма продаж: " + tracker.getTotalSum());
        System.out.println("Популярный товар: " + tracker.getMostPopularProduct());
    }
}
