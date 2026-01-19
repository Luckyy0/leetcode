package read_input;

import java.io.*;
import java.util.StringTokenizer;


public class CustomFastReaderWithDataInputStream {
    final private int BUFFER_SIZE = 1 << 16; // 65536 bytes (64KB)
    // DataInputStream để đọc dữ liệu từ System.in
    private DataInputStream din;
    // Mảng byte để lưu dữ liệu được đọc từ luồng
    private byte[] buffer;
    // Con trỏ chỉ vị trí hiện tại trong buffer
    private int bufferPointer, bytesRead;

    // Constructor để đọc từ System.in
    public CustomFastReaderWithDataInputStream() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = 0;
        bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[1024];  // giả sử một dòng không vượt quá 1024 byte
        int cnt = 0;
        byte c;
        // Đọc từng byte cho đến khi gặp ký tự xuống dòng hoặc EOF (-1)
        while ((c = read()) != -1) {
            if (c == '\n') break;
            buf[cnt++] = c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {  // bỏ qua các ký tự trắng
            c = read();
        }

        // Kiểm tra nếu số âm, nếu có thì thiết lập flag và đọc tiếp ký tự kế
        boolean neg = (c == '-');
        if (neg) c = read();
        // Chuyển các ký tự số thành số nguyên
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return neg ? -ret : ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10L + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return neg ? -ret : ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret = ret + (c - '0') / (div *= 10);
            }
        }
        return neg ? -ret : ret;
    }

    // Hàm đọc 1 byte từ buffer. Nếu buffer hết, sẽ refill buffer.
    private byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

    // Nạp dữ liệu mới từ DataInputStream vào buffer. Đặt lại bufferPointer sau khi nạp.
    private void fillBuffer() throws IOException {
        // đọc tiếp dữ liệu mới từ luồng đầu vào và ghi đè lên toàn bộ mảng => Dữ liệu đã được đọc trước đó không được lưu lại
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) {
            buffer[0] = -1;
        }
    }

    // Đóng DataInputStream
    public void close() throws IOException {
        if (din == null) return;
        din.close();
    }
}
