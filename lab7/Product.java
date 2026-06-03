public class Product {
    private String name; 
    private int weight;
 
    public Product(String name, int weight) { //констр создание товара
        this.name = name;
        this.weight = weight;
    }
 
    public String getName() {
        return name;
    }
 
    public int getWeight() {
        return weight;
    }
}
