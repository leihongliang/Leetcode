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

public class xunlei11 {
    public static void main(String[] args) {
        int n = 5, m = 10, k = 2;
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
                {2, 5, 3},
        };
        int[][] tasks = {
                {2, 2, 4, 1},
                {2, 1, 2, 4},
        };

        int[] result = solution(n, m, k, edges, tasks);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int n, int m, int k, int[][] edges, int[][] tasks) {
        // Build the adjacency list representation of the graph
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Edge(v, c));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int y = tasks[i][0];
            int[] sourceNodes = Arrays.copyOfRange(tasks[i], 1, y + 1);
            int targetNode = tasks[i][y + 1];

            // Calculate the maximum speed using Dijkstra's algorithm
            int[] maxSpeeds = dijkstra(graph, n, sourceNodes, targetNode);
            result[i] = maxSpeeds[targetNode];
        }

        return result;
    }

    public static int[] dijkstra(Map<Integer, List<Edge>> graph, int n, int[] sourceNodes, int targetNode) {
        int[] maxSpeeds = new int[n + 1];
        Arrays.fill(maxSpeeds, Integer.MIN_VALUE);
        maxSpeeds[targetNode] = Integer.MAX_VALUE;

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.speed, a.speed));

        for (int sourceNode : sourceNodes) {
            pq.offer(new Node(sourceNode, maxSpeeds[sourceNode]));
        }

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int u = currNode.node;
            int speed = currNode.speed;

            if (visited.contains(u)) {
                continue;
            }
            visited.add(u);

            if (speed <= maxSpeeds[u]) {
                continue;
            }
            maxSpeeds[u] = speed;

            List<Edge> neighbors = graph.getOrDefault(u, new ArrayList<>());
            for (Edge neighbor : neighbors) {
                int v = neighbor.node;
                int c = neighbor.speed;
                pq.offer(new Node(v, Math.min(speed, c)));
            }
        }

        return maxSpeeds;
    }

    static class Edge {
        int node;
        int speed;

        public Edge(int node, int speed) {
            this.node = node;
            this.speed = speed;
        }
    }

    static class Node {
        int node;
        int speed;

        public Node(int node, int speed) {
            this.node = node;
            this.speed = speed;
        }
    }

}
