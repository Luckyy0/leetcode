package leet_code.Problem_641_Medium_Design_Circular_Deque;

/**
 * Implementation of a circular double-ended queue.
 */
public class MyCircularDeque {

    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int k;

    /**
     * Initialize the deque with maximum size k.
     */
    public MyCircularDeque(int k) {
        this.data = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.k = k;
    }

    /**
     * Adds an item at the front of Deque.
     */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        // Move front backward and wrap around
        front = (front - 1 + k) % k;
        data[front] = value;
        size++;
        // If it was the first element, adjust rear to point to next position
        if (size == 1) {
            rear = (front + 1) % k;
        }
        return true;
    }

    /**
     * Adds an item at the rear of Deque.
     */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        data[rear] = value;
        rear = (rear + 1) % k;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque.
     */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        front = (front + 1) % k;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque.
     */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        rear = (rear - 1 + k) % k;
        size--;
        return true;
    }

    /**
     * Get the front item from the Deque.
     */
    public int getFront() {
        if (isEmpty())
            return -1;
        return data[front];
    }

    /**
     * Get the last item from Deque.
     */
    public int getRear() {
        if (isEmpty())
            return -1;
        // Last element is at (rear - 1)
        return data[(rear - 1 + k) % k];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == k;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1)); // true
        System.out.println(deque.insertLast(2)); // true
        System.out.println(deque.insertFront(3)); // true
        System.out.println(deque.insertFront(4)); // false
        System.out.println(deque.getRear()); // 2
        System.out.println(deque.isFull()); // true
        System.out.println(deque.deleteLast()); // true
        System.out.println(deque.insertFront(4)); // true
        System.out.println(deque.getFront()); // 4
    }
}
