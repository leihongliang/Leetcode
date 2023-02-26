package real.a;
import java.util.*;


public class asimu用友_计算被直线划分区域 {
    public static void main(String[] args) {
        /*
        输入
        1,37,20,4 两个点
        1,7,20,121 两个点
        输出
        4 AB之间的线段不平行于Y轴 */

        Scanner in = new Scanner(System.in);
        List<int[]> edges = new ArrayList<>();
        int res = 1;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            res++;
            String[] lines = in.nextLine().split(",");
            int[] nodes = new int[4];
            for (int i = 0; i < 4; i++) { // 4是确定的
                nodes[i] = Integer.parseInt(lines[i]);
            }
            for (int[] edge : edges) {
                double x = getIntersection(edge[0], edge[1], edge[2],edge[3], nodes[0], nodes[1],nodes[2],nodes[3]);
                if (x > 1 && x < 20) res++;
            }
            edges.add(nodes);
        }
        System.out.println(res);
    }

    static double getIntersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double k1 = (y2 - y1) / (x2 - x1);
        double b1 = y1 - k1 * x1;
        double k2 = (y4 - y3) / (x4 - x3);
        double b2 = y3 - k2 * x3;
        double x = (b2 - b1) / (k1 - k2); //求交点解方程
        return  x;
    }

}
