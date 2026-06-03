import java.util.concurrent.ConcurrentHashMap; //потокобезопасная карта

public class SalesTracker { //учет продаж
    private final ConcurrentHashMap<String, ProductSales> sales = new ConcurrentHashMap<>();

    public void addSale(String name, double price) {
        sales.putIfAbsent(name, new ProductSales(name, price));
        sales.get(name).increaseCount();
    }

    public void printSales() {
        System.out.println("Проданные товары:");

        for (ProductSales product : sales.values()) {
            System.out.println(product.getName() +
                    " цена: " + product.getPrice() +
                    " продано: " + product.getCount() +
                    " сумма: " + product.getSum());
        }
    }

    public double getTotalSum() {
        double total = 0;

        for (ProductSales product : sales.values()) {
            total = total + product.getSum();
        }

        return total;
    }

    public String getMostPopularProduct() {
        String bestName = "";
        int bestCount = -1;

        for (ProductSales product : sales.values()) {
            if (product.getCount() > bestCount) {
                bestCount = product.getCount();
                bestName = product.getName();
            }
        }

        return bestName + " (продано: " + bestCount + ")";
    }
}
