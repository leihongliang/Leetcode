package real.a;

import java.util.*;


public class bytedance3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取节点数和边数
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 读取节点颜色
        String colors = sc.next();
        // 用一个数组存储每个节点的颜色，R为1，W为0
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            color[i] = colors.charAt(i - 1) == 'R' ? 1 : 0;
        }
        // 用一个邻接表存储无向图的边
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        // 读取边并加入邻接表
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        sc.close();
        // 用一个数组存储每个节点所属的连通块编号，初始为-1
        int[] block = new int[n + 1];
        Arrays.fill(block, -1);
        // 用一个变量记录当前的连通块编号，从0开始
        int blockId = 0;
        // 用一个队列进行广度优先搜索
        Queue<Integer> queue = new LinkedList<>();
        // 遍历所有节点，如果是红色且未被访问过，就进行广度优先搜索，标记连通块编号
        for (int i = 1; i <= n; i++) {
            if (color[i] == 1 && block[i] == -1) {
                queue.offer(i);
                block[i] = blockId;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next : adj[cur]) {
                        if (color[next] == 1 && block[next] == -1) {
                            queue.offer(next);
                            block[next] = blockId;
                        }
                    }
                }
                blockId++;
            }
        }
        // 输出每个节点染红后的连通块数量，如果本身是红色，就输出当前的连通块数量，否则就判断其相邻的红色节点是否属于同一个连通块，如果不是，就减去相应的数量
        for (int i = 1; i <= n; i++) {
            if (color[i] == 1) {
                System.out.println(blockId);
            } else {
                HashSet<Integer> set = new HashSet<>();
                for (int next : adj[i]) {
                    if (color[next] == 1) {
                        set.add(block[next]);
                    }
                }
                System.out.println(blockId - set.size() + 1);
            }
        }
    }



}



