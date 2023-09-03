package real.a;



    class A {
        B b = new B();
        public A() {
            System.out.print("A");
        }
    }
    class B {
        public B() {
            System.out.print("B");
        }
    }
    public class C extends A {
        B b = new B();
        public C() {
            System.out.print("C");
        }
        public static void main(String[] args) {
            new C();
        }
    }


