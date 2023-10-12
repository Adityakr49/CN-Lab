import java.util.*;

class Graph {
    private int v;
    private List<int[]> vertices;

    public Graph(int v) {
        this.v = v;
        this.vertices = new ArrayList<>();
    }

    public void addEdge(int s, int d, int w) {
        vertices.add(new int[] {s, d, w});
    }

    public void printDistance(int[] dist) {
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < v; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public void bellmanFord(int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < v - 1; i++) {
            for (int[] edge : vertices) {
                int s = edge[0];
                int d = edge[1];
                int w = edge[2];
                if (dist[s] != Integer.MAX_VALUE && dist[d] > dist[s] + w) {
                    dist[d] = dist[s] + w;
                }
            }
        }

        for (int[] edge : vertices) {
            int s = edge[0];
            int d = edge[1];
            int w = edge[2];
            if (dist[s] != Integer.MAX_VALUE && dist[d] > dist[s] + w) {
                System.out.println("Graph has a negative cycle");
                return;
            }
        }

        printDistance(dist);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int nv = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int ne = scanner.nextInt();

        Graph g = new Graph(nv);

        System.out.println("Enter source, destination, and weights of edges:");
        for (int i = 0; i < ne; i++) {
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            g.addEdge(s, d, w);
        }

        System.out.print("Enter the source node: ");
        int src = scanner.nextInt();

        g.bellmanFord(src);
    }
}

