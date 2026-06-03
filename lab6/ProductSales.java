import java.util.concurrent.atomic.AtomicInteger;

public class ProductSales {
    private final String name; 
    private final double price; 
    private final AtomicInteger count; 

    public ProductSales(String name, double price) { 
        this.name = name;
        this.price = price; 
        this.count = new AtomicInteger(0); 
    }

    public void increaseCount() {
        count.incrementAndGet(); 
    }

    public String getName() {
        return name; 
    }

    public double getPrice() {
        return price; 
    }

    public int getCount() {
        return count.get(); 
    }

    public double getSum() {
        return price * getCount();
    }
}
