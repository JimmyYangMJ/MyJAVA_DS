
import java.util.Arrays;
import java.util.Scanner;

/**
 * 有权图的单元最短路径算法<br>
 * 实现----Dijkstra <br>
 * 案例----旅游规划问题
 */
public class Main {

    static Scanner cin  = new Scanner(System.in);

    /** 点数， 边数*/
    static int Nv, Ne;
    /** 起点和终点 */
    static int start, end;
    /** 邻接矩阵存储图 城市的编号为0~(N?1)*/
    static int[][] G; // 旅游长度


    /** 建图, 邻接矩阵 */
    static void BuildGraph(){
        G = new int[Nv+1][Nv+1];
        /** 一开始图不连通 */
        for (int i = 1; i <= Nv; i++) {
            Arrays.fill(G[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= Ne; i++){
            int v1 = cin.nextInt(), v2  = cin.nextInt();
            int l = cin.nextInt();
            /** 无向图*/
            G[v1][v2] = l;   G[v2][v1] = l;

        }
    }

    /** 核心算法 */
    static boolean dijkstra(){
        boolean[] visited = new boolean[Nv+1];
        /** 第一种权重 收录最短路径*/
        int[] dist = new int[Nv+1];
        /** 记录顶点的上一个顶点*/
        int[] path = new int[Nv+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1); // -1 表示起点
        /** 对起点进行初始化*/
        visited[start] = true;
        dist[start] = 0; /* 起点到自己的最短路径为 0 */
        for (int v = 1; v <= Nv; v++){ /* 扫描起点的邻接点*/
            dist[v] = G[start][v];
            if(G[start][v] < Integer.MAX_VALUE) { /* 是邻接点*/
                path[v] = start;
            }else{
                path[v] = -1;
            }
        }

        /** 进入dijkstra 算法*/
        while(true){
            int v = distMin(dist, visited); /** 未收录的顶点dist最小者*/
            if(v == -1){
                break; /* 这样的顶点不存在*/
            }
            visited[v] = true;
            for(int w = 1; w <= Nv; w++){ /* 对v的每一个邻接点访问*/
                if(visited[w] == false && G[v][w] < Integer.MAX_VALUE){
                    if(G[v][w] < 0){ /*存在负边*/
                        return false;
                    }
                    if(dist[v] + G[v][w] < dist[w]){  /* 路径更短*/
                        dist[w] = dist[v] + G[v][w];
                        path[w] = v;

                    }
                }
            }

        }

        System.out.println(dist[end]);

        return true;

    }
    /**
     * @return --dist最小的下标
     */
    public static int distMin(int[] dist, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minV = 0; /* 存储下标*/
        for(int v = 1; v <= Nv; v++){
            if(visited[v] == false && dist[v] < min){
                min = dist[v];
                minV = v;
            }
        }
        if(min < Integer.MAX_VALUE){
            return minV;
        }else {
            return -1; /* 这样的顶点不存在*/
        }
    }

    public static void main(String[] args) {
        /** 初始化 */
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        start = cin.nextInt();
        end = cin.nextInt();
        BuildGraph();
        dijkstra();
    }
}