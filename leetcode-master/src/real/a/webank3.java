package real.a;

import java.util.*;

public class webank3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] initialPlaylist = new int[n];

        for (int i = 0; i < n; i++) {
            initialPlaylist[i] = scanner.nextInt();
        }

        int[] finalPlaylist = shufflePlaylist(initialPlaylist);

        for (int i = 0; i < n; i++) {
            System.out.print(finalPlaylist[i] + " ");
        }

        scanner.close();
    }

    public static int[] shufflePlaylist(int[] initialPlaylist) {
        int n = initialPlaylist.length;
        int[] finalPlaylist = new int[n];
        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            queue.add(initialPlaylist[i]);
        }

        for (int i = 0; i < n; i++) {
            finalPlaylist[i] = queue.poll();
            if (!queue.isEmpty()) {
                int nextSong = queue.poll();
                queue.add(nextSong);
            }
        }

        return finalPlaylist;
    }

}



