package algorithm_03_hashtable;

import java.util.HashSet;

public class e202_快乐数 {
    public static boolean isHappy0(int n) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        while ( res != 1 || !set.contains(n)) {
            res = 0;
            while ( n > 0 ) {
                res += (n % 10)*(n % 10);
                n = n / 10;
            }
            if ( set.contains(res) ) {
                return false;
            }
            set.add(res);
            n = res;
        }
        return true;
    }
    public static boolean isHappy2(int n) {
        HashSet<Integer> set = new HashSet<>();
        while ( n != 1 && !set.contains(n)) {
            set.add(n);
            n = squareSum(n);
        }
        return n == 1;
    }
    private static int squareSum(int n) {
        int res = 0;
        while ( n > 0 ) {
            res += (n % 10)*(n % 10);
            n = n / 10;
        }
        return  res;
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int tmp = 0;
            int res = 0;
            while(n != 0) {
                tmp = n % 10;
                res += tmp * tmp;
                n = n / 10;
            }
            if (set.contains(res)) {
                return false;
            }else if(res == 1){
                return true;
            }else {
                set.add(res);
                n =res;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(isHappy2(2));
    }
}
