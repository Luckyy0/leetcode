package leet_code.Problem_604_Easy_Design_Compressed_String_Iterator;

public class StringIterator {

    private String data;
    private int ptr;
    private char currentChar;
    private int remainingCount;

    /**
     * Initializes the iterator with the compressed string.
     */
    public StringIterator(String compressedString) {
        this.data = compressedString;
        this.ptr = 0;
        this.remainingCount = 0;
        this.currentChar = ' ';
    }

    /**
     * Returns the next character in the uncompressed string.
     */
    public char next() {
        if (!hasNext()) {
            return ' ';
        }

        // If we exhausted the current character group, parse the next one
        if (remainingCount == 0) {
            currentChar = data.charAt(ptr++);

            // Parse the multi-digit number following the character
            long count = 0;
            while (ptr < data.length() && Character.isDigit(data.charAt(ptr))) {
                count = count * 10 + (data.charAt(ptr++) - '0');
            }
            // Constraint says total length fits in long, but next() calls fit in int range
            remainingCount = (int) count;
        }

        remainingCount--;
        return currentChar;
    }

    /**
     * Checks if there are more characters left to iterate.
     */
    public boolean hasNext() {
        return remainingCount > 0 || ptr < data.length();
    }

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(iterator.next()); // L
        System.out.println(iterator.next()); // e
        System.out.println(iterator.next()); // e
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next()); // t
    }
}
