package arithmetic;
/*
 * 最长公共子序列
 */
public class LCSL {
	public void LCSLength(int[][]c,int m,int n,int[][]b,String X,String Y){
		for(int i=1;i<=m;i++)
			c[i][0]=0;
		for(int j=1;j<=n;j++)
			c[0][j]=0;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(X.charAt(i-1)==Y.charAt(j-1)){
					c[i][j]=c[j-1][i-1]+1;
					b[i][j]=1;
				}else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]=2;
				}else{
					c[i][j]=c[i][j-1];
					b[i][j]=3;
				}
			}
		}
		
		System.out.print("最长公共子序列为(不唯一)：");
		LCSConstruct(X.length(),Y.length(), X, b);
		System.out.print(" 长度为："+c[m][n]);
	}
	public  void LCSConstruct(int m,int n,String X,int[][]b){
		if(m==0||n==0)return;
		if(b[m][n]==1){
			LCSConstruct(m-1, n-1, X, b);
			System.out.print(X.charAt(n-1));
		}else if(b[m][n]==2){
			LCSConstruct(m-1, n, X, b);
		}else{
			LCSConstruct(m, n-1, X, b);
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		LCSL lcsl=new LCSL();
		String X="BDABCA";
		String Y="DBACBA";
		int[][]c=new int[Y.length()+1][X.length()+1];
		int[][]b=new int[Y.length()+1][X.length()+1];
		lcsl.LCSLength(c,X.length() , Y.length(), b, X, Y);
		//System.out.println(c[Y.length()][X.length()]);
//		for(int[]i:b){
//			for(int j:i){
//				System.out.printf("%3d",j);
//			}
//			System.out.println("");
//		}
		
	}

}
