package read_input;

import java.io.IOException;
import java.io.InputStream;


public class CustomFastReaderWithInputStream {
    private final int BUFFER_SIZE = 1 << 16; // 64KB
    private final byte[] buffer = new byte[BUFFER_SIZE];
    private int bufferPointer = 0, bytesRead = 0;

    private final InputStream stream;

    public CustomFastReaderWithInputStream() {
        stream = System.in;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

    private void fillBuffer() throws IOException {
        bytesRead = stream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) {
            buffer[0] = -1;
        }
    }

    public long nextLong() throws IOException {
        long result = 0;
        byte c = read();

        while (c <= ' ') c = read(); // skip space
        boolean negative = (c == '-');
        if (negative) c = read();

        do {
            result = result * 10 + (c - '0');
            c = read();
        } while (c >= '0' && c <= '9');

        return negative ? -result : result;
    }

    public int nextInt() throws IOException {
        int result = 0;
        byte c = read();

        while (c <= ' ') c = read(); // skip space
        boolean negative = (c == '-');
        if (negative) c = read();

        do {
            result = result * 10 + (c - '0');
            c = read();
        } while (c >= '0' && c <= '9');

        return negative ? -result : result;
    }

    public String next() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();

        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
            c = read();
        } while (c > ' ');

        return sb.toString();
    }
}
