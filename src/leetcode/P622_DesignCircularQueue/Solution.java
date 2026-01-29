package leetcode.P622_DesignCircularQueue;

class MyCircularQueue {
    private int[] data;
    private int head;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
        this.head = 0;
        this.count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        int tail = (head + count) % capacity;
        data[tail] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        head = (head + 1) % capacity;
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return data[head];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        int tail = (head + count - 1) % capacity;
        return data[tail];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
