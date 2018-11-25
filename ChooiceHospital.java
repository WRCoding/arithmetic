package arithmetic;

import java.util.Scanner;
/*
 * 医院选址
 */
public class ChooiceHospital {
	private static int V,E;//顶点数和边
	private int[][]c;//记录每个顶点之间的路径	
	private static final int MAX=1000;//表示两个顶点不向连
	private String[] paths;
	private int[]dist;
	private boolean[]visited;
	private int total;//路径之和
	private int  allTotal;
	private int low;//医院的选址点
	public void DijkstraTest(int r){	
		total=0;
		for(int i=1;i<=V;i++){
			//先假设源点到其他顶点的路径就是最短路径，不相邻的为MAX
			dist[i]=c[r][i];
			visited[i]=false;
		}
		visited[r]=true;
		dist[r]=0;
		for(int i=2;i<=V;i++){
			int temp=MAX;
			int k=r;
			for(int l=1;l<=V;l++){
				//寻找最短路径的节点
				if(visited[l]==false&&dist[l]<temp){
					temp=dist[l];
					k=l;
				}
			}
			visited[k]=true;
			//dist[k]=temp;
			for(int j=1;j<=V;j++){
				if(visited[j]==false&&c[k][j]<MAX){//如果相邻，判断是否是最短路径
					if(dist[k]+c[k][j]<dist[j]){
						dist[j]=dist[k]+c[k][j];
					}
					//visited[j]=true;
					paths[j]=paths[k]+"-->"+j;
				}
			}
		}
		/*for(int i=1;i<=V;i++){
			System.out.println("从"+r+"出发到"+i+"的最短路径为："+paths[i]);
		}*/
		System.out.println("-----------------------------------------");
		for(int i=1;i<=V;i++){
			//System.out.println("从"+r+"到"+i+"的最短距离问： "+dist[i]);
			total=total+dist[i];//获得每个顶点的路径之和
		}
		if(total<allTotal){//判断当前顶点的路径之和是否是最短的
			low=r;
		}else{
			allTotal=total;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ChooiceHospital d=new ChooiceHospital();
		Scanner in=new Scanner(System.in);
		System.out.print("请输入顶点数 V：");
		V=in.nextInt();
		System.out.print("请输入路径数 E：");
		E=in.nextInt();
		d.dist=new int[V+1];
		d.c=new int[V+1][V+1];
		d.visited=new boolean[V+1];
		d.paths=new String[V+1];
		
		for(int i=1;i<=V;i++){
			for(int j=1;j<=V;j++){
				if(i==j)
					d.c[i][j]=0;
				else
					d.c[i][j]=MAX;
			}
			d.dist[i]=MAX;
			d.paths[i]=new String("1-->"+i);
		}
		System.out.println("请输入"+E+"条件路径：");
		for(int l=1;l<=E;l++){
			System.out.print(l+": ");
			int i=in.nextInt();
			int j=in.nextInt();
			int e=in.nextInt();
			d.c[i][j]=e;//顶点i到顶点j的路径为e
			d.c[j][i]=e;
		}
		in.close();
		for(int o=1;o<=V;o++){
			d.DijkstraTest(o);
			System.out.println(o+": "+d.total);
		}
		
		 System.out.println("医院应该建在点："+d.low);
	}
}
