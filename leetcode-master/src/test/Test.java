package test;

class Test {
    private int num;
    private static Test main;

    public Test(int num) {
        this.num = ++num;
    }

    static {
        int num = 17;
        main = new Test(--num);
        ++main.num;
    }

    public static void main(String[] args) {
        main = new Test(14);
        System.out.println(main.num--);
    }
}
