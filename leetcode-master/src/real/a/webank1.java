package real.a;
import java.util.*;

public class webank1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        sc.close();
        int[] order = new int[n];
        int index = 0;
        while (!list.isEmpty()) {
            order[index] = list.removeFirst();
            index++;
            if (!list.isEmpty()) {
                list.addLast(list.removeFirst());
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(order[i] + " ");
        }
    }



}



