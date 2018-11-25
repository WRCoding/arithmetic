package arithmetic;
/*
 * 汉诺塔问题
 */
public class Hanio {
	public void hanio(int dish,String from,String temp,String to){
		 if(dish == 1){
		        System.out.println("将盘子"+dish+"从塔座"+from+"移动到目标塔座"+to);
		    }else{
		        hanio(dish-1,from,to,temp);//A为初始塔座，B为目标塔座，C为中介塔座
		        System.out.println("将盘子"+dish+"从塔座"+from+"移动到目标塔座"+to);
		        hanio(dish-1,temp,from,to);//B为初始塔座，C为目标塔座，A为中介塔座
		    }
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Hanio h=new Hanio();
		h.hanio(3, "A", "B", "C");
	}

}
