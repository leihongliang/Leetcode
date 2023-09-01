package real.a;

import java.util.Arrays;
import java.util.Scanner;

public class a4399_2 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity  = 2;
        String firstLine = scanner.nextLine();
        int[] buses = convertToIntArray(firstLine);
        String secondLine = scanner.nextLine();
        int[] passengers = convertToIntArray(secondLine);
        System.out.println(busCatch(buses, passengers, capacity));
    }
    public static int[] convertToIntArray(String line) {
        String[] numberStrings = line.split(" ");
        int[] numbers = new int[numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }

        return numbers;
    }
    public static int busCatch(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0;
        for (int j = 0; j < buses.length; j++) {
            int count = 0;
            while (i < passengers.length && passengers[i] <= buses[j] && count < capacity) {
                i++;
                count++;
            }
            if (count == 0) {
                continue;
            }
            if (i == passengers.length) {
                return buses[j];
            }
        }
        return -1;
    }

}
