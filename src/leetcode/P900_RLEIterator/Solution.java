package leetcode.P900_RLEIterator;

class RLEIterator {
    int[] encoding;
    int ptr;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.ptr = 0;
    }

    public int next(int n) {
        while (ptr < encoding.length) {
            if (encoding[ptr] >= n) {
                encoding[ptr] -= n;
                return encoding[ptr + 1];
            } else {
                n -= encoding[ptr];
                encoding[ptr] = 0;
                ptr += 2;
            }
        }
        return -1;
    }
}
