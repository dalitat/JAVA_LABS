import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CyclicBarrier;
 
public class Task3_CyclicBarrierLoaders {

    static class Warehouse { 
        private Queue<Product> products = //оч тов
                new LinkedList<>();
        private int currentWeight = 0; 
        private final int MAX_WEIGHT = 150; 
        public synchronized void addProduct(Product product) { 
            products.add(product);
        }
 
        public synchronized Product takeProduct() {
            if (products.isEmpty()) { //пуст
                return null;
            }
 
            Product product = products.peek(); //берем
            if (currentWeight + product.getWeight()
                    <= MAX_WEIGHT) { 
                currentWeight += product.getWeight();
                return products.poll(); 
            }
 
            return null;
        }
 
        public synchronized int getCurrentWeight() {
            return currentWeight;
        }
 
        public synchronized void resetWeight() {
            currentWeight = 0;
        }
 
        public synchronized boolean isEmpty() {
            return products.isEmpty();
        }
    }
 
    static class Loader extends Thread { //грузчик
        private Warehouse warehouse;
        private CyclicBarrier barrier;
        public Loader(
                String name,
                Warehouse warehouse,
                CyclicBarrier barrier
        ) {
 
            super(name);
            this.warehouse = warehouse;
            this.barrier = barrier;
        }
 
        @Override
        public void run() { 
            try {
 
                while (!warehouse.isEmpty()) { 
                    Product product =
                            warehouse.takeProduct(); 
 
                    if (product != null) {
                        System.out.println(
                                getName()
                                        + " переносит "
                                        + product.getName()
                                        + " ("
                                        + product.getWeight()
                                        + " кг)"
                        );
 
                        Thread.sleep(500); // имитация
                    }
 
                    if (warehouse.getCurrentWeight()
                            >= 150 //ну далее неполное остатки там
                            || warehouse.isEmpty()) {
                        System.out.println(
                                "Партия собрана. вес: "
                                        + warehouse.getCurrentWeight()
                                        + " кг"
                        );
 
                        barrier.await(); 
                        warehouse.resetWeight(); 
                        System.out.println(
                                "Грузчики вернулись на склад"
                        );
                    }
                }
 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
 
        Warehouse warehouse =
                new Warehouse();
 
        warehouse.addProduct( //доб тов
                new Product("Телевизор", 40)
        );
 
        warehouse.addProduct(
                new Product("Холодильник", 60)
        );
 
        warehouse.addProduct(
                new Product("Стиральная машина", 50)
        );
 
        warehouse.addProduct(
                new Product("Микроволновка", 20)
        );
 
        warehouse.addProduct(
                new Product("Стол", 30)
        );
 
        warehouse.addProduct(
                new Product("Диван", 70)
        );
 
        CyclicBarrier barrier =
                new CyclicBarrier(
                        3, 
                        () -> System.out.println(
                                "все грузчики отправились на другой склад"
                        )
                );
 
        Loader loader1 = 
                new Loader(
                        "грузчик 1",
                        warehouse,
                        barrier
                );
 
        Loader loader2 =
                new Loader(
                        "гузчик 2",
                        warehouse,
                        barrier
                );
 
        Loader loader3 =
                new Loader(
                        "грузчик 3",
                        warehouse,
                        barrier
                );
 
        loader1.start(); //запускаем грузчика
 
        loader2.start();
 
        loader3.start();
    }
}
