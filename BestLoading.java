package arithmetic;

import java.util.Arrays;

/*
 * ����װ������
 */
public class BestLoading {
	public void Loading(int x[],int w[],int c,int n){
		int [] t=new int[n+1];//��ż�װ���λ��
		sort(w,t,n);//����װ����λ�ã���ķ���ǰ��
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
	private void sort(int[] w, int[] t, int n) {//����t��ŵ�����ļ�װ���λ��
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		BestLoading b=new BestLoading();
		int[]w={8,5,3,1,9};
		int[]t=new int[w.length];
		int[]x=new int[w.length];
		b.Loading(x, w, 4, 5);
	}

}
