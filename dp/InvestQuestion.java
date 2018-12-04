package dp;

import java.util.Scanner;

/*
 算法-投资问题
 */
public class InvestQuestion {
    public void invest(int m,int n,int[][]f,int[][]g,int[][]b){
        for(int i=0;i<=m;i++){
            f[1][i]=g[1][i];
            b[1][i]=i;
        }
        for(int j=2;j<=n;j++){
            for(int i=0;i<=m;i++){
                f[j][i]=0;
                for(int k=0;k<=i;k++){
                    int s=f[j-1][i-k]+g[j][k];
                    if(s>f[j][i]){
                        f[j][i]=s;
                        b[j][i]=k;
                    }
                }
            }
        }
        System.out.println("投资最大收益为："+f[n][m]+"(十万)元");

    }
    public void bestInvest(int m,int n,int[]k,int[][]b){
        int s=m; k[n]=b[n][m];
        for(int i=n-1;i>0;i--){
            s=s-k[i+1];
            k[i]=b[i][s];
        }
        for (int i : k) {
            System.out.printf("%3d",i);
        }
    }
    public static void main(String[] args) {
        InvestQuestion invest=new InvestQuestion();
        Scanner in=new Scanner(System.in);
        System.out.print("请输入投资总和m:(单位：十万元) ");
        int m=in.nextInt();
        System.out.print("请输入投资项目总数n:  ");
        int n=in.nextInt();
        int[] k=new int[n+1];
        int[][]g=new int[n+1][m+1];
        int[][]f=new int[n+1][m+1];
        int[][]b=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            System.out.println("请输入第"+i+"个项目按照每增加十万投资后的收益值: ");
            for(int j=1;j<=m;j++){
                int a=in.nextInt();
                g[i][j]=a;
            }
        }
        invest.invest(m,n,f,g,b);
        invest.bestInvest(m,n,k,b);
    }
}
