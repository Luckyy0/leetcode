import java.io.*;

public class Main {

        public static boolean isPalindrome(int x) {
            if (x < 0) return false;
            String res = "";
            while (x > 0) {
                res += x % 10;
                x/=10;
            }
            int i=0, j=res.length()-1;
            while(i<j) {
                if (res.charAt(i) != res.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }


    public static void main(String[] args) throws IOException {
        System.out.println(isPalindrome(100));
    }
}