package animalshop;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //初始化MyAnimalShop
        MyAnimalShop msp=new MyAnimalShop();
        //余额为500
        msp.setRestMoney(100);
        //开店
        msp.setCloseShop(false);
        //animalsList
        ArrayList<Animal> animalsList=new ArrayList<Animal>();
        //添加初始动物信息
        animalsList.add(new  ChineseRuralDog("中中",3,"boy",true));
        animalsList.add(new  ChineseRuralDog("华华",6,"girl",true));
        animalsList.add(new  ChineseRuralDog("小白子",5,"boy",true));
        animalsList.add(new Cat("猫子",4,"boy"));
        animalsList.add(new Cat("拽猫",1,"girl"));
        animalsList.add(new Cat("小黑子",2,"boy"));
        animalsList.add(new Husky("美子",4,"girl"));
        animalsList.add(new Husky("黑豹",6,"boy"));
        animalsList.add(new Husky("恩佐",5,"boy"));

        msp.setAnimalsList(animalsList);



        //customersList
        ArrayList<Customer> customersList=new ArrayList<Customer>();
        msp.setCustomers(customersList);



        loop: while (true) {
            System.out.println("---------欢迎来到wp宠物店---------");
            System.out.println("1.买入动物");
            System.out.println("2.招待客户");
            System.out.println("3.歇业");
            System.out.println("4.退出");
            System.out.println("请输入选择:");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> msp.addAnimals(animalsList);
                case "2" -> msp.serviceCustomer(customersList);
                case "3" -> msp.isClosed(msp.isCloseShop());
                case "4" -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }
}
