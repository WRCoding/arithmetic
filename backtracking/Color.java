package backtracking;


import java.util.Scanner;

/*
    回溯算法-着色问题
 */
public class Color {
    private static int v;//顶点个数
    private static int e;//边数
    private static int m;//数字表示颜色，有m种颜色
    private static int[][]a;//二维数组表示无向图
    private static int[]x;//x[i]表示第i个顶点着了x[i]的颜色
    private static int sum;//解决个数
    //递归算法
    /*public void Colortracking(int t){
        if(t>v)
            sum++;
        else{
            for(int i=1;i<=m;i++){
                x[t]=i;
                if(Check(t))
                    Colortracking(t+1);
                x[t]=0;//赋值为0是为回溯上去后，重新开始计算
            }
        }
    }*/
    //迭代算法
    public void Colortracking(){
        x[1]=0;
        int t=1;
        while (t>0){
            x[t]+=1;
            while(x[t]<=m&&!Check(t))
                x[t]+=1;
            if(x[t]<=m){
                if(t==v)
                    sum++;
                else{
                    t++;
                    x[t]=0;
                }
            }else{
                x[t]=0;
                t--;
            }
        }
    }
    private boolean Check(int t) {
        for(int i=1;i<=v;i++){
            if(a[t][i]==1&&x[i]==x[t])
                return false;
        }
        return true;
    }



    public void init(){
        Scanner in=new Scanner(System.in);
        System.out.print("输入顶点数：");
        v=in.nextInt();
        System.out.print("输入边数：");
        e=in.nextInt();
        System.out.print("输入颜色数：");
        m=in.nextInt();
        a=new int[v+1][v+1];
        x=new int[v+1];
        for(int i=1;i<=e;i++){
            System.out.print("边"+i+": ");
            int x=in.nextInt();
            int y=in.nextInt();
            a[x][y]=1;
            a[y][x]=1;
        }
    }
    public static void main(String[] args) {
        Color color=new Color();
        color.init();
        color.Colortracking();
        System.out.println(sum);
    }
}
