package arithmetic;
/*
 * ��ŵ������
 */
public class Hanio {
	public void hanio(int dish,String from,String temp,String to){
		 if(dish == 1){
		        System.out.println("������"+dish+"������"+from+"�ƶ���Ŀ������"+to);
		    }else{
		        hanio(dish-1,from,to,temp);//AΪ��ʼ������BΪĿ��������CΪ�н�����
		        System.out.println("������"+dish+"������"+from+"�ƶ���Ŀ������"+to);
		        hanio(dish-1,temp,from,to);//BΪ��ʼ������CΪĿ��������AΪ�н�����
		    }
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Hanio h=new Hanio();
		h.hanio(3, "A", "B", "C");
	}

}
