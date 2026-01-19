package read_input;

import java.util.Scanner;

public class ReadWithScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            for (String token : tokens) {
                System.out.println(token);
            }
        }
    }
}
