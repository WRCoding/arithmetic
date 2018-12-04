package backtracking;

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;

/*
回溯算法-n皇后问题
 */
public class Nqueen {
    private int n;
    private int[]queen;
    public void tracking(int t){//递归算法
        if(t>n){
            for(int i=1;i<queen.length;i++){
                System.out.printf("%3d",queen[i]);
            }
            System.out.println("");
            return;
        }
        else{
            for(int i=1;i<=n;i++){
                queen[t]=i;
                if(checkd(t))
                    tracking(t+1);
            }
        }

    /* 迭代算法
    queen[1]=0;
      int k=1;
      while (k>0){
          queen[k]+=1;
          //如果同一列，同一行或者同一斜线就不继续往下搜索,往后一格
          while(queen[k]<=n&&!checkd(k))
              queen[k]+=1;
          if(queen[k]<=n){
              if(k==n){
                  for(int i=1;i<queen.length;i++){
                      System.out.printf("%3d",queen[i]);
                  }
                  System.out.println("");
              }else{
                  k++;
                  queen[k]=0;
              }
          }else{//如果K这一行都不成功，则K--，上面一行重新比较
              k--;
          }
      }*/
    }

    private boolean checkd(int t) {
        for(int i=1;i<t;i++){
            if(queen[i]==queen[t]||Math.abs(t-i)==Math.abs(queen[i]-queen[t]))//如果同一列，同一行或者同一斜线就不继续往下搜索
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Nqueen nQueen=new Nqueen();
        nQueen.n=4;
        nQueen.queen=new int[nQueen.n+1];
        nQueen.tracking(1);
    }
}
