package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MST {
    static int n;
    static int m;
    static int[] parent;
    static BufferedReader br;
    static StringTokenizer st;
    static Edge[] edges;
    static int minCost = 0;

    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        edges = new Edge[m];
        parent = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        br.close();

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        for (int i = 0; i < m; i++) {
            int rootX = findRoot(edges[i].x);
            int rootY = findRoot(edges[i].y);

            if(rootX == rootY) continue;
            else{
                parent[rootX] = rootY;
                minCost = minCost + edges[i].cost;
            }
        }
        System.out.println(minCost);
    }

    private static int findRoot(int x ){
        if(x == parent[x]){
            return x;
        }else{
            parent[x] = findRoot(parent[x]);
            return parent[x];
        }
    }

    static class Edge{
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
