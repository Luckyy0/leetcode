package leetcode.P2166_DesignBitset;

public class Bitset {
    private boolean[] bits;
    private int size;
    private int count; // Count of logical 1s
    private boolean flipped;

    public Bitset(int size) {
        this.size = size;
        this.bits = new boolean[size];
        this.count = 0;
        this.flipped = false;
    }

    public void fix(int idx) {
        if (!flipped) {
            // Logical 1 is Physical 1
            if (!bits[idx]) {
                bits[idx] = true;
                count++;
            }
        } else {
            // Logical 1 is Physical 0
            // We want to set logical to 1, so physical to 0
            if (bits[idx]) {
                bits[idx] = false;
                count++;
            }
        }
    }

    public void unfix(int idx) {
        if (!flipped) {
            // Logical 0 is Physical 0
            if (bits[idx]) {
                bits[idx] = false;
                count--;
            }
        } else {
            // Logical 0 is Physical 1
            if (!bits[idx]) {
                bits[idx] = true;
                count--;
            }
        }
    }

    public void flip() {
        flipped = !flipped;
        count = size - count;
    }

    public boolean all() {
        return count == size;
    }

    public boolean one() {
        return count > 0;
    }

    public int count() {
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            // If flipped, 1 implies 0 (false), 0 implies 1 (true)
            // Logical Val = (bits[i] XOR flipped) ? 0 : 1?
            // Wait.
            // If not flipped: true -> '1', false -> '0'.
            // If flipped: true -> '0', false -> '1'.
            // So logical '1' if (bits[i] != flipped). Wait.
            // flp=F, b=T -> '1'. (b != F -> T).
            // flp=T, b=F -> '1'. (b != T -> T).
            // flp=T, b=T -> '0'.

            if (flipped) {
                sb.append(bits[i] ? '0' : '1');
            } else {
                sb.append(bits[i] ? '1' : '0');
            }
        }
        return sb.toString();
    }
}
