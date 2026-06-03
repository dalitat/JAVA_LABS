public class Stack<T> {
    
    private T[] data;
    private int size;
    
    @SuppressWarnings("unchecked")
    public Stack(int capacity) { 
        data = (T[]) new Object[capacity];
        size = 0;
    }
    
    
    public void push(T element) {
        if (size == data.length) {
            throw new IllegalStateException("Ошибка: Стек переполнен!");
        }
        data[size] = element; 
        size++;
    }
    
    
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Ошибка: Стек пуст!");
        }
        size--;
        T element = data[size];
        data[size] = null;
        return element;
    }
    
    
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Ошибка: Стек пуст! Нечего просматривать.");
        }
        return data[size - 1];
    }
    
    public int size() {
        return size;
    }
    
    //пуст ли стек
    public boolean isEmpty() {
        return size == 0;
    }
    
    //заполнен ли стек
    public boolean isFull() {
        return size == data.length;
    }

    public void setData(T[] data) {
        this.data = data;
    }
}
