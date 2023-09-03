package real.a;

class Main {
    public static void main(String[] args) {
        int a = sum(12);
        System.out.println(a);
    }
    static int sum(int n)
    {
        if (n == 1|| n == 2)
        {
            return 1;
        }
        else
        {
            return sum(n-1)+ sum(n-2);
        }
    }


}