package read_input;

public class CustomTokenizer {
    private final String input;
    private final int length;
    private int pos = 0;
    private final char[] delimiters;  // Ký tự phân tách (mặc định là khoảng trắng, tab, newline)

    // Constructor với tùy chọn delimiter
    public CustomTokenizer(String input, String delimiters) {
        this.input = input;
        this.length = input.length();
        this.delimiters = delimiters.toCharArray();
    }

    // Constructor mặc định dùng các khoảng trắng, tab, newline làm delimiter
    public CustomTokenizer(String input) {
        this(input, " \t\n\r");
    }

    // Kiểm tra xem còn token không
    public boolean hasNext() {
        skipDelimiters();
        return pos < length;
    }

    // Lấy token tiếp theo
    public String next() {
        skipDelimiters();
        int start = pos;
        while (pos < length && !isDelimiter(input.charAt(pos))) {
            pos++;
        }
        return input.substring(start, pos);
    }

    // Lấy số nguyên tiếp theo
    public int nextInt() {
        return Integer.parseInt(next());
    }

    // Lấy số thực tiếp theo
    public double nextDouble() {
        return Double.parseDouble(next());
    }

    // Bỏ qua các delimiter
    private void skipDelimiters() {
        while (pos < length && isDelimiter(input.charAt(pos))) {
            pos++;
        }
    }

    // Kiểm tra xem ký tự có phải là delimiter không
    private boolean isDelimiter(char ch) {
        for (char delimiter : delimiters) {
            if (ch == delimiter) {
                return true;
            }
        }
        return false;
    }
}
