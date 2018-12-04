package backtracking;

public class Knap {
    private static int capacity;//背包容量
    private static int amount;//物品数量
    private static int [] weight;//物品重量
    private static int [] wealth;//物品价值
    private static int  nowCapacity;//当前容量
    private static int nowWealth;//当前价值
    private static int bestWealth;//最有价值
    public void Backtrack(int i){
        if(i>amount){
            bestWealth=nowWealth;
            return;
        }
        if(nowCapacity+weight[i]<=capacity){
            nowCapacity+=weight[i];
            nowWealth+=wealth[i];
            Backtrack(i+1);
            nowCapacity-=weight[i];
            nowWealth-=wealth[i];
        }
        if(Bound(i+1)>bestWealth){
            Backtrack(i+1);
        }
    }

    private int Bound(int i) {
        int restCapacity=capacity-nowCapacity;
        int b=nowWealth;
        while(i<=amount&&weight[i]<=restCapacity){
            b+=wealth[i];
            restCapacity-=weight[i];
            i++;
        }
        if(i<=amount){
            b+=wealth[i]*restCapacity/weight[i];
        }
        return b;
    }

    public static void main(String[] args) {
        Knap knap = new Knap();
        capacity=100;
        amount=5;
        weight=new int[]{0,30,20,20,50,40};
        wealth=new int[]{0,65,40,30,60,40};
        knap.Backtrack(1);
        System.out.println("最大价值为："+bestWealth);
    }
}
