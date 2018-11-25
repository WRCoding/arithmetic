package arithmetic;

import java.util.Scanner;
/*
 * ��Դ���·��
 */
public class Dijkstra {
	private int V,E;//�������ͱ�
	private int[][]c;//��¼ÿ������֮���·��
	private int[]dist;//��¼��Դ��������������֮������·������
	private static final int MAX=1000;//��ʾ�������㲻����
	private String[] paths;
	private boolean[]visited;//�ҵ�һ���������̾��룬�ͼ�¼Ϊtrue,����Ϊfalse
	
	public void DijkstraTest(){
		visited[1]=true;//Դ��Ϊ1
		dist[1]=0;
		for(int i=2;i<=V;i++){
			int temp=MAX;
			int k=-1;
			for(int l=2;l<=V;l++){
				//�ҵ�û�����������·���Ķ���
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
			System.out.println("��1������"+i+"�����·��Ϊ��"+paths[i]);
		}
		System.out.println("-----------------------------------------");
		for(int i=2;i<=V;i++){
			System.out.println("��1��"+i+"����̾����ʣ� "+dist[i]);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Dijkstra d=new Dijkstra();
		Scanner in=new Scanner(System.in);
		System.out.print("�����붥���� V��");
		d.V=in.nextInt();
		System.out.print("������·���� E��");
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
		System.out.println("������"+d.E+"����·����");
		for(int l=1;l<=d.E;l++){
			System.out.print(l+": ");
			int i=in.nextInt();
			int j=in.nextInt();
			int e=in.nextInt();
			//����ͼ
			d.c[i][j]=e;//����i������j��·��Ϊe
			d.c[j][i]=e;
		}
		in.close();
		d.DijkstraTest();
	}
}
