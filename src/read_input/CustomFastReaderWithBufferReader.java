package read_input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class CustomFastReader {
    private final BufferedReader reader;
    private StringTokenizer tokenizer;

    // Constructor: read by stdin
    public CustomFastReader() {
        reader = new BufferedReader(new java.io.InputStreamReader(System.in));
    }

    // Constructor: read by file
    public CustomFastReader(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Thread close (nên gọi khi đọc xong nếu dùng trong file)
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Read line
    public String nextLine() {
        try {
            tokenizer = null;  // reset tokenizer
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // check EOF (dành cho input không rõ kích thước)
    public boolean hasNext() {
        try {
            if (tokenizer != null && tokenizer.hasMoreTokens()) return true;
            reader.mark(1); // đánh dấu vị trí hiện tại của luồng
            int c = reader.read(); // đọc 1 ký tự
            if (c == -1) return false; // EOF
            reader.reset(); // quay lại vị trí đã mark
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                String line = reader.readLine();
                if (line == null) return null;  // EOF
                tokenizer = new StringTokenizer(line.trim());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();
        return arr;
    }

    public long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nextLong();
        return arr;
    }

    public double[] nextDoubleArray(int n) {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) arr[i] = nextDouble();
        return arr;
    }
}
