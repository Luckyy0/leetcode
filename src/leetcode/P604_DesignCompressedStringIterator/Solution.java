package leetcode.P604_DesignCompressedStringIterator;

class StringIterator {
    private String compressedString;
    private int ptr;
    private char currentChar;
    private int currentCount;

    public StringIterator(String compressedString) {
        this.compressedString = compressedString;
        this.ptr = 0;
        this.currentCount = 0;
        this.currentChar = ' ';
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }

        if (currentCount == 0) {
            // Need to parse next segment
            // Cần phân tích đoạn tiếp theo
            currentChar = compressedString.charAt(ptr++);

            // Parse number
            // Phân tích số
            int nextPtr = ptr;
            while (nextPtr < compressedString.length() && Character.isDigit(compressedString.charAt(nextPtr))) {
                nextPtr++;
            }

            try {
                currentCount = Integer.parseInt(compressedString.substring(ptr, nextPtr));
            } catch (NumberFormatException e) {
                // Should technically not happen given problem constraints
                currentCount = 0;
            }
            ptr = nextPtr;
        }

        currentCount--;
        return currentChar;
    }

    public boolean hasNext() {
        return currentCount > 0 || ptr < compressedString.length();
    }
}
