package read_input;

import java.util.concurrent.*;

public class BankAccount {
    private static double balance = 1000.0;  // Instance variable: Lưu trong Heap (phần của object)

    // Method không synchronized: Dẫn đến race condition
    public void withdraw(double amount) {
        double temp = balance;  // Đọc từ Heap vào local var (trong Stack)
        if (balance >= amount) {
            try {
                Thread.sleep(10);  // Giả lập thời gian xử lý (tạo cơ hội race condition)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance = balance - amount;  // Ghi lại vào Heap
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount +
                    ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds!");
        }
    }

    // Method synchronized: Giải pháp an toàn
    public synchronized void safeWithdraw(double amount) {
        double temp = balance;
        if (temp >= amount) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance = temp - amount;
            System.out.println(Thread.currentThread().getName() + " safely withdrew " + amount +
                    ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds (safe)!");
        }
    }

    public double getBalance() {
        return balance;  // Đọc từ Heap
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();  // Tạo object trong Heap
        ExecutorService executor = Executors.newFixedThreadPool(3);  // Tạo thread pool

        // Tạo 3 threads rút tiền đồng thời (không synchronized)
        for (int i = 0; i < 3; i++) {
            final double amount = 300.0;
            executor.submit(() -> {
                account.withdraw(amount);  // Gọi method: Tạo frame trong Stack của thread
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final balance (unsafe): " + account.getBalance());  // Có thể < 100 (race condition!)

        // Reset và thử phiên bản safe
        account.balance = 1000.0;  // Reset Heap
        executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            final double amount = 300.0;
            executor.submit(() -> {
                account.safeWithdraw(amount);
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Final balance (safe): " + account.getBalance());  // Luôn = 100
    }
}