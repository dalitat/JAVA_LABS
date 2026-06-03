public class Task1_SumArray{

    static int sum1 = 0; 
    static int sum2 = 0; 

    public static void main(String[] args) throws InterruptedException { //искл если возникнет ошибка
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Thread thread1 = new Thread(() -> { 
            for (int i = 0; i < numbers.length / 2; i++) { 
                sum1 += numbers[i]; 
            }
        });

        Thread thread2 = new Thread(() -> { 
            for (int i = numbers.length / 2; i < numbers.length; i++) {
                sum2 += numbers[i];
            }
        });

        thread1.start(); 
        thread2.start();

        thread1.join(); 
        thread2.join();

        System.out.println("Сумма 1 половины: " + sum1);
        System.out.println("Сумма 2 половины: " + sum2);
        System.out.println("Общ сумма: " + (sum1 + sum2));
    }
}
