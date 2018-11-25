package arithmetic;

import java.util.Arrays;

/*
 * 最优装载问题
 */
public class BestLoading {
	public void Loading(int x[],int w[],int c,int n){
		int [] t=new int[n+1];//存放集装箱的位置
		sort(w,t,n);//给集装箱排位置，轻的放在前面
		for(int i=0;i<n;i++){
			x[i]=0;
		}
		for(int i=0;i<n&&w[t[i]]<=c;i++){
			x[t[i]]=1;
			c=c-w[t[i]];
		}
		for(int i:x){
			System.out.print(" "+i);
		}
	}
	private void sort(int[] w, int[] t, int n) {//数组t存放的是轻的集装箱的位置
		// TODO 自动生成的方法存根
		int temp = 0;
		int[] l=Arrays.copyOf(w, w.length);
		Arrays.sort(l);
		for(int i=0;i<w.length;i++){
			for(int j=0;j<w.length;j++){
				if(l[i]==w[j]){
					temp=j;
				}
			}
			t[i]=temp;
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BestLoading b=new BestLoading();
		int[]w={8,5,3,1,9};
		int[]t=new int[w.length];
		int[]x=new int[w.length];
		b.Loading(x, w, 4, 5);
	}

}
