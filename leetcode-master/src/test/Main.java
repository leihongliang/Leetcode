package test;

import java.util.*;

public class Main {


        public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                }
                int minOperations = Integer.MAX_VALUE;
                for (int i = 0; i < n - 1; i++) {
                    if (Math.abs(a[i] - a[i + 1]) < minOperations) {
                        minOperations = Math.abs(a[i] - a[i + 1]);
                    }
                }
                System.out.println(minOperations);
            }
        }




