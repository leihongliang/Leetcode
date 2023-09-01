package real.a;
import java.util.Arrays;

public class BusArrivalTime {
    public static int latestBusTime(int[] buses, int[] passengers, int capacity) {
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

    public static void main(String[] args) {
        int[] buses = {10, 20};
        int[] passengers = {2, 17, 18, 19};
        int capacity = 2;

        int result = latestBusTime(buses, passengers, capacity);
        System.out.println("Latest arrival time at the bus station: " + result);
    }
}
