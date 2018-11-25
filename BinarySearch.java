package arithmetic;
/*
 * 二分查找
 */
public class BinarySearch {
	//非递归的二分查找
	public int Search(int[] array,int key){
		int low=0;
		int height=array.length-1;
		int mid=(low+height)/2;
		while(low<height){
			if(array[mid]==key)
				return mid;
			if(array[mid]<key){
				low=mid+1;
				mid=(low+height)/2;
			}
			if(array[mid]>key){
				height=mid-1;
				mid=(low+height)/2;
			}
		}
		return -1;
	}
	//递归的二分查找，速度比非递归慢
	public int Search2(int[]array,int low,int height,int key){
		int mid=(low+height)/2;
		if(array[mid]==key){
			return mid;
		}
		if(array[mid]<key){
			return Search2(array,mid+1,height,key);
		}
		if(array[mid]>key){
			return Search2(array, low, mid-1, key);
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BinarySearch bs=new BinarySearch();
		int[]array={1,2,3,4,5,6,7,8};		
		int a=bs.Search2(array,0,array.length,7);
		System.out.println(a);
	}

}
