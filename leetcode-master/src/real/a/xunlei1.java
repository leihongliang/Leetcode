package real.a;

/*
假设有一位用户想要用迅雷下载一个文件，网络中有n个节点和m条单向通道，每个通道都有不同的带宽。
用户所在的节点t，他需要所有拥有这个文件的节点上下载数据，以获得快的下载速度。
用户有k个下载任务，每个任务顺序执行，每个任务的源文件，存储在y个节点s[x]上。
需要编写一个程序来帮用户计算每个任务的最高速度。

输入描述
请你实现 solution 方法，它的方法签名如下：

func solution(n int, m int, k int, edges [][]int, tasks [][]int) []int {
    // 书写你的代码
}
其中：

n、m、k 是整数，分别表示节点数、边数和任务数。(1≤n, m≤1000, 1≤k≤100)
edges 是一个二维切片，其中每个切片包含三个整数 u, v, c，表示一条从 u 到 v 的带宽为 c 的边。 (1≤u, v≤n, 1≤c≤1000)
tasks 是一个二维切片，包含 k 行，每行包含 y+2 个整数 y,s[0]...s[y-1],t。表示从 y 个源节点 s[0]...s[y-1] 下载数据到节点 t (1≤y,t≤n)
输出描述
对于每个任务，输出一个整数表示下载的最大速度。

输入样例
n = 5, m = 10, k = 2
edges = [
    [3, 5, 10],
    [4, 5, 4],
    [4, 3, 7],
    [2, 3, 3],
    [4, 1, 6],
    [2, 4, 2],
    [4, 2, 9],
    [2, 1, 1],
    [1, 2, 1],
    [2, 5, 3],
]
tasks = [
    [2, 2, 4, 1],
    [2, 1, 2, 4],
]
输出样例
[7, 2]

* */

import java.util.*;

public class xunlei1 {

    static final int INF = Integer.MAX_VALUE;

    // 定义一个类表示边
    static class Edge {
        int from; // 起点
        int to; // 终点
        int capacity; // 容量
        int flow; // 流量

        public Edge(int from, int to, int capacity) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
            this.flow = 0;
        }
    }

    // 定义一个方法实现Ford-Fulkerson算法
    public static int fordFulkerson(List<Edge>[] graph, int s, int t) {
        // 初始化最大流为0
        int maxFlow = 0;
        // 使用一个数组记录路径上的边
        Edge[] path = new Edge[graph.length];
        // 使用一个队列进行广度优先搜索
        Queue<Integer> queue = new LinkedList<>();
        // 循环直到没有增广路径
        while (true) {
            // 清空队列
            queue.clear();
            // 将源点入队
            queue.offer(s);
            // 使用一个数组记录访问过的节点
            boolean[] visited = new boolean[graph.length];
            // 标记源点已访问
            visited[s] = true;
            // 标记是否找到了增广路径
            boolean found = false;
            // 循环直到队列为空或者找到了增广路径
            while (!queue.isEmpty() && !found) {
                // 出队一个节点
                int u = queue.poll();
                // 遍历该节点的所有出边
                for (Edge e : graph[u]) {
                    // 如果该边还有剩余容量，并且终点没有访问过
                    if (e.capacity > e.flow && !visited[e.to]) {
                        // 将终点入队
                        queue.offer(e.to);
                        // 标记终点已访问
                        visited[e.to] = true;
                        // 记录路径上的边
                        path[e.to] = e;
                        // 如果终点是汇点，说明找到了增广路径，跳出循环
                        if (e.to == t) {
                            found = true;
                            break;
                        }
                    }
                }
            }
            // 如果没有找到增广路径，说明已经达到了最大流，跳出循环
            if (!found) break;
            // 初始化路径上的最小剩余容量为无穷大
            int minResidual = INF;
            // 从汇点开始回溯路径上的边，更新最小剩余容量
            for (int v = t; v != s; v = path[v].from) {
                minResidual = Math.min(minResidual, path[v].capacity - path[v].flow);
            }
            // 再次从汇点开始回溯路径上的边，更新流量和反向流量
            for (int v = t; v != s; v = path[v].from) {
                path[v].flow += minResidual; // 增加正向流量
                for (Edge e : graph[path[v].to]) { // 找到反向边
                    if (e.to == path[v].from) {
                        e.flow -= minResidual; // 减少反向流量
                        break;
                    }
                }
            }
            // 累加最大流
            maxFlow += minResidual;
        }
        // 返回最大流
        return maxFlow;
    }

    // 定义一个方法实现题目要求的功能
    public static int[] solution(int n, int m, int k, int[][] edges, int[][] tasks) {
        // 创建一个数组存储答案
        int[] ans = new int[k];
        // 创建一个邻接表表示图
        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        // 遍历所有的边，添加到图中
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];
            // 添加正向边
            graph[u].add(new Edge(u, v, c));
            // 添加反向边，容量为0
            graph[v].add(new Edge(v, u, 0));
        }
        // 遍历所有的任务，计算下载速度
        for (int i = 0; i < k; i++) {
            int[] task = tasks[i];
            int y = task[0]; // 源节点的个数
            int t = task[y + 1]; // 目标节点
            int speed = 0; // 下载速度
            // 遍历所有的源节点，计算从每个源节点到目标节点的最大流，累加到下载速度中
            for (int j = 1; j <= y; j++) {
                int s = task[j]; // 源节点
                speed += fordFulkerson(graph, s, t); // 调用Ford-Fulkerson算法，计算最大流
            }
            // 将下载速度存储到答案数组中
            ans[i] = speed;
        }
        // 返回答案数组
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 10;
        int k = 2;
        int[][] edges = {
                {3, 5, 10},
                {4, 5, 4},
                {4, 3, 7},
                {2, 3, 3},
                {4, 1, 6},
                {2, 4, 2},
                {4, 2, 9},
                {2, 1, 1},
                {1, 2, 1},
                {2, 5, 3}
        };
        int[][] tasks = {
                {2, 2, 4, 1},
                {2, 1, 2, 4}
        };

        int[] result = solution(n, m, k, edges, tasks);
        System.out.println(Arrays.toString(result));
    }

}
