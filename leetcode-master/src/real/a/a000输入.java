package real.a;

//import org.junit.Test;
import java.util.*;

public class a000输入 {
    public static void main(String[] args) {

        //输入字符串 存成 字符串数组
        Scanner in = new Scanner(System.in);
        String[] lines = in.nextLine().split(" "); //空格分割
        String[] lines2 = in.nextLine().split(","); //逗号分割


        // 按行读取
        while (in.hasNextLine()) {
            String[] lines3 = in.nextLine().split(",");
            int[] nodes = new int[4];
            for (int i = 0; i < 4; i++) { // 4是确定的
                nodes[i] = Integer.parseInt(lines[i]);
            }
        }
    }

}
