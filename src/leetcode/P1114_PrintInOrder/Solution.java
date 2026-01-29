package leetcode.P1114_PrintInOrder;

import java.util.concurrent.CountDownLatch;

class Foo {
    private CountDownLatch l2;
    private CountDownLatch l3;

    public Foo() {
        l2 = new CountDownLatch(1);
        l3 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        l2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        l2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        l3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        l3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
