package read_input;

import java.util.Stack;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class Test {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Làm việc...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Bị interrupt nhưng vẫn tiếp tục");
                }
            }
        });
 new Stack();
        t.start();

        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        t.interrupt(); // báo hiệu interrupt
    }
}
