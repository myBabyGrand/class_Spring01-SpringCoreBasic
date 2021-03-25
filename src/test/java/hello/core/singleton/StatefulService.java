package hello.core.singleton;

public class StatefulService {

//    private int price;// 상태를 유지(stateful)하는 필드

//    public void order(String name, int price){
    public int order(String name, int price){//지역변수 사용
        System.out.println("name = " + name + "price = "+ price);
//        this.price = price;
        return price;
    }


//    public int getPrice(){
//      return price;
//    }
}
