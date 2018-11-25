package arithmetic;

import java.util.Scanner;
/*
 * 单源最短路径
 */
public class Dijkstra {
	private int V,E;//顶点数和边
	private int[][]c;//记录每个顶点之间的路径
	private int[]dist;//记录从源到所有其他顶点之间的最短路径长度
	private static final int MAX=1000;//表示两个顶点不向连
	private String[] paths;
	private boolean[]visited;//找到一个顶点的最短距离，就记录为true,否则为false
	
	public void DijkstraTest(){
		visited[1]=true;//源点为1
		dist[1]=0;
		for(int i=2;i<=V;i++){
			int temp=MAX;
			int k=-1;
			for(int l=2;l<=V;l++){
				//找到没遍历且是最短路径的顶点
				if(visited[l]==false&&c[1][l]<temp){
					temp=c[1][l];
					k=l;
				}
			}
			visited[k]=true;
			dist[k]=temp;
			for(int j=2;j<=V;j++){
				if(visited[j]==false&&c[1][k]+c[k][j]<c[1][j]){
					c[1][j]=c[1][k]+c[k][j];
					//visited[j]=true;
					paths[j]=paths[k]+"-->"+j;
				}
			}
		}
		for(int i=2;i<=V;i++){
			System.out.println("从1出发到"+i+"的最短路径为："+paths[i]);
		}
		System.out.println("-----------------------------------------");
		for(int i=2;i<=V;i++){
			System.out.println("从1到"+i+"的最短距离问： "+dist[i]);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Dijkstra d=new Dijkstra();
		Scanner in=new Scanner(System.in);
		System.out.print("请输入顶点数 V：");
		d.V=in.nextInt();
		System.out.print("请输入路径数 E：");
		d.E=in.nextInt();
		d.dist=new int[d.V+1];
		d.c=new int[d.V+1][d.V+1];
		d.visited=new boolean[d.V+1];
		d.paths=new String[d.V+1];
		for(int i=1;i<=d.V;i++){
			for(int j=1;j<=d.V;j++){
				if(i==j)
					d.c[i][j]=0;
				else
					d.c[i][j]=MAX;
			}
			d.dist[i]=MAX;
			d.paths[i]=new String("1-->"+i);
		}
		System.out.println("请输入"+d.E+"条件路径：");
		for(int l=1;l<=d.E;l++){
			System.out.print(l+": ");
			int i=in.nextInt();
			int j=in.nextInt();
			int e=in.nextInt();
			//无向图
			d.c[i][j]=e;//顶点i到顶点j的路径为e
			d.c[j][i]=e;
		}
		in.close();
		d.DijkstraTest();
	}
}
