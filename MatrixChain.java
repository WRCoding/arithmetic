package arithmetic;
/*
 * 动态规划，矩阵连乘问题
 */
public class MatrixChain {
	public void matrixChain(int[]p,int[][] m,int[][]s,int n){
		for(int i=1;i<=n;i++){//初始化i->j的最短次序为0
			m[i][i]=0;
		}
		for(int r=2;r<=n;r++){//从矩阵链长度为2开始计算
			for(int i=1;i<=n-r+1;i++){
				int j=i+r-1;
				m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];
				s[i][j]=i;
				for(int k=i+1;k<j;k++){
					int min=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(min<m[i][j]){
						m[i][j]=min;
						s[i][j]=k;
					}
				}
			}
		}
	}
	public void Traceback(int i, int j,int[][]s,String[] str){
		if(i==j){
			System.out.print(str[i]);
			return;
		}
		System.out.print("(");
		Traceback(i, s[i][j], s, str);
		Traceback(s[i][j]+1,j,s, str);
		System.out.print(")");
	}
	public static void main(String[] args) {
		MatrixChain mc=new MatrixChain();
		int[]p={30,35,15,5,10,20,25};
		int n=6;
		int[][]m=new int[n+1][n+1];
		int[][]s=new int[n+1][n+1];
		String[] str={" ","A1","A2","A3","A4","A5","A6"};
		mc.matrixChain(p, m, s, n);
		for(int i=1;i<n+1;i++){
			for(int j=1;j<n+1;j++){
				System.out.print("\t"+m[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println("最优计算次序是：");
		mc.Traceback(1, 6, s, str);
	}
}
