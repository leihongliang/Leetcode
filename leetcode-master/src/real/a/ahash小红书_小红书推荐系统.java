package real.a;

import java.util.HashMap;
import java.util.Scanner;

public class ahash小红书_小红书推荐系统 {
    public static void main(String[] args) {
        /*
        输入 kou red game red ok who game red karaoke yukari kou red red nani kou can koukou ongakugame game
        输出（出现三次以上的） red game kou*/

        Scanner in = new Scanner(System.in);
        String[] lines = in.nextLine().split(" ");
        HashMap<String, Integer> cnts = new HashMap<>();
        for (String line : lines) {
            cnts.put(line, cnts.getOrDefault(line, 0)  + 1);
        }

        for (String s : cnts.keySet()) {
            if (cnts.get(s) >= 3) {
                System.out.println(s);
            }
        }
    }

}
