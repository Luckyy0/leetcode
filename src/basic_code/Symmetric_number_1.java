package basic_code;

public class Symmetric_number_1 {
    // So sánh 2 số: 1 số bằng 1/2 nửa trước, 1 số bằng 1/2 nửa sau
    public static boolean isSymmetricNumber(int x) {
        if (x < 0 || (x>0 && x%10==0)) return false;
        int s = 0;
        while (x > s) {
            s = s*10 + x % 10;
            x/=10;
        }
        return x == s || s/10 == x;
    }
    public static void main(String[] args) {
        System.out.println(isSymmetricNumber(100));
    }
}
