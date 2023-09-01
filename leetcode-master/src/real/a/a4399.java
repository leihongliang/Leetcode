package real.a;

import java.util.Arrays;
import java.util.Scanner;

public class a4399 {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        String string = scanner.next();
        char[] books = string.toCharArray();

        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int result = 0;

        while (right < books.length) {
            count[books[right] - 'A']++;
            while (count[books[right] - 'A'] > cnt) {
                count[books[left] - 'A']--;
                left++;
            }
            result += right - left + 1;
            right++;
        }
        System.out.println(result);
    }

}
