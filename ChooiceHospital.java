package arithmetic;

import java.util.Scanner;
/*
 * ҽԺѡַ
 */
public class ChooiceHospital {
	private static int V,E;//�������ͱ�
	private int[][]c;//��¼ÿ������֮���·��	
	private static final int MAX=1000;//��ʾ�������㲻����
	private String[] paths;
	private int[]dist;
	private boolean[]visited;
	private int total;//·��֮��
	private int  allTotal;
	private int low;//ҽԺ��ѡַ��
	public void DijkstraTest(int r){	
		total=0;
		for(int i=1;i<=V;i++){
			//�ȼ���Դ�㵽���������·���������·���������ڵ�ΪMAX
			dist[i]=c[r][i];
			visited[i]=false;
		}
		visited[r]=true;
		dist[r]=0;
		for(int i=2;i<=V;i++){
			int temp=MAX;
			int k=r;
			for(int l=1;l<=V;l++){
				//Ѱ�����·���Ľڵ�
				if(visited[l]==false&&dist[l]<temp){
					temp=dist[l];
					k=l;
				}
			}
			visited[k]=true;
			//dist[k]=temp;
			for(int j=1;j<=V;j++){
				if(visited[j]==false&&c[k][j]<MAX){//������ڣ��ж��Ƿ������·��
					if(dist[k]+c[k][j]<dist[j]){
						dist[j]=dist[k]+c[k][j];
					}
					//visited[j]=true;
					paths[j]=paths[k]+"-->"+j;
				}
			}
		}
		/*for(int i=1;i<=V;i++){
			System.out.println("��"+r+"������"+i+"�����·��Ϊ��"+paths[i]);
		}*/
		System.out.println("-----------------------------------------");
		for(int i=1;i<=V;i++){
			//System.out.println("��"+r+"��"+i+"����̾����ʣ� "+dist[i]);
			total=total+dist[i];//���ÿ�������·��֮��
		}
		if(total<allTotal){//�жϵ�ǰ�����·��֮���Ƿ�����̵�
			low=r;
		}else{
			allTotal=total;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ChooiceHospital d=new ChooiceHospital();
		Scanner in=new Scanner(System.in);
		System.out.print("�����붥���� V��");
		V=in.nextInt();
		System.out.print("������·���� E��");
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
		System.out.println("������"+E+"����·����");
		for(int l=1;l<=E;l++){
			System.out.print(l+": ");
			int i=in.nextInt();
			int j=in.nextInt();
			int e=in.nextInt();
			d.c[i][j]=e;//����i������j��·��Ϊe
			d.c[j][i]=e;
		}
		in.close();
		for(int o=1;o<=V;o++){
			d.DijkstraTest(o);
			System.out.println(o+": "+d.total);
		}
		
		 System.out.println("ҽԺӦ�ý��ڵ㣺"+d.low);
	}
}
