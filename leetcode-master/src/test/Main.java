package test;

public class Main {
    public static int f(int n) {
        if (n <= 3) {
            return 1;
        } else {
            return f(n - 2) + f(n - 4) + 1;
        }
    }

    public static void main(String[] args) {
        int a =3;
        int b=6;
        int c= 5;

        System.out.println();
    }
}
