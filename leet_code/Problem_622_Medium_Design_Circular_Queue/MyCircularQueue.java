package leet_code.Problem_622_Medium_Design_Circular_Queue;

public class MyCircularQueue {

    private int[] queue;
    private int head;
    private int count;
    private int capacity;

    /**
     * Initializes the circular queue with a fixed size k.
     */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.head = 0;
        this.count = 0;
    }

    /**
     * Inserts an element into the circular queue.
     * Strategy: Calculate tail index based on head and count.
     */
    public boolean enQueue(int value) {
        if (isFull())
            return false;

        // Find the next available position
        int tail = (head + count) % capacity;
        queue[tail] = value;
        count++;
        return true;
    }

    /**
     * Deletes an element from the circular queue.
     * Strategy: Move the head pointer forward.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;

        // Move head and decrease active element count
        head = (head + 1) % capacity;
        count--;
        return true;
    }

    /**
     * Gets the first item in the queue.
     */
    public int Front() {
        if (isEmpty())
            return -1;
        return queue[head];
    }

    /**
     * Gets the last item in the queue.
     */
    public int Rear() {
        if (isEmpty())
            return -1;
        // The last element is at (head + count - 1) position
        int index = (head + count - 1) % capacity;
        return queue[index];
    }

    /**
     * Checks if the queue is empty.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks if the queue is full.
     */
    public boolean isFull() {
        return count == capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear()); // return 3
        System.out.println(myCircularQueue.isFull()); // return True
        System.out.println(myCircularQueue.deQueue()); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear()); // return 4
    }
}
