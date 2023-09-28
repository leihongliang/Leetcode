package test;

public class LazySingle {
    private static LazySingle instance = null;

    public static LazySingle getInstance() {
        if (instance == null) {
            instance = new LazySingle();
        }
        return instance;
    }


}
