import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord{
	public static int n;
	private static int[][] graph;
	public static void bellmanford(int src){
		int[] dist=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[src]=0;
		for(int i=1;i<n;i++){
			for(int u=0;u<n;u++){
				for(int v=0;v<n;v++){
					if(graph[u][v]!=0&&dist[u]!=Integer.MAX_VALUE&&dist[u]+graph[u][v]<dist[v]){
						dist[v]=dist[u]+graph[u][v];
					}
				}
			}
		}
		for(int u=0;u<n;u++){
			for(int v=0;v<n;v++){
				if(graph[u][v]!=0&&dist[u]!=Integer.MAX_VALUE&&dist[u]+graph[u][v]<dist[v]){
					System.out.println("Negative weight cycle detected");
					return;
				}
			}
		}
		printSolution(dist);
	}
	public static void printSolution(int[] dist){
		System.out.println("Vertex\t Distance from source");
		for(int i=0;i<n;i++)
			System.out.println((i+1)+"\t\t"+dist[i]);
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of vertices:");
		n=sc.nextInt();
		System.out.println("Enter the weight Matrix of Graph");
		graph=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				graph[i][j]=sc.nextInt();
		System.out.print("Enter source vertex:");
		int source=sc.nextInt();
		bellmanford(source-1);
	}
}

