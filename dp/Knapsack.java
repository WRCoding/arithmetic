package dp;

/*
算法 0-1背包问题
 */
public class Knapsack {
    public void backpack(int[]v,int[]w,int c,int n,int[][]m){
        int max=Math.min(w[n]-1,c);
        for(int i=0;i<=max;i++){
            m[n][i]=0;
        }
        for(int i=w[n];i<=c;i++){
            m[n][i]=v[n];
        }
        for(int i=n-1;i>0;i--){
            max=Math.min(w[i]-1,c);
            for(int j=0;j<=max;j++)
                m[i][j]=m[i+1][j];
            for(int j=w[i];j<=c;j++)
                m[i][j]=Math.max(m[i+1][j],m[i+1][j-w[i]]+v[i]);
        }
        m[1][c]=m[2][c];
        if(c>=w[1])
            m[1][c]=Math.max(m[1][c],m[2][c-w[1]]+v[1]);
        System.out.println("最大价值为："+m[1][c]);
    }
    public static void main(String[] args) {
        Knapsack knapsack=new Knapsack();
        int n=5;
        int c=10;
        int[]w={0,2,2,6,5,4};
        int[]v={0,6,3,5,4,6};
        int[][]m=new int[n+1][c+1];
        knapsack.backpack(v,w,c,n,m);
    }
}
