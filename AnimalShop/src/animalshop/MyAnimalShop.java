package animalshop;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public  class MyAnimalShop implements AnimalShop{
    int CRDSoldNum=0;
    int CatSoldNum=0;
    int HskSoldNum=0;
    private double restMoney;
    private ArrayList<Animal> animalsList;
    private ArrayList<Customer> customers;
    private boolean isCloseShop;

    public double getRestMoney() {
        return restMoney;
    }

    public void setRestMoney(double restMoney) {
        if (restMoney<0){
            throw new InsufficientBalanceException("宠物店余额不足!!!");
        }

        this.restMoney = restMoney;
    }

    public ArrayList<Animal> getAnimalsList() {
        return animalsList;
    }

    public void setAnimalsList(ArrayList<Animal> animalsList) {
        this.animalsList = animalsList;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public boolean isCloseShop() {
        return isCloseShop;
    }

    public void setCloseShop(boolean closeShop) {
        isCloseShop = closeShop;
    }
    //买入动物
    @Override
    public void addAnimals(ArrayList<Animal> animalsList) {
        while (true) {
            System.out.println("---------买入动物---------");
            System.out.println("1.买入中华田园犬(50元)");
            System.out.println("2.买入猫(100元)");
            System.out.println("3.买入哈士奇(150元)");
            System.out.println("4.退出");
            System.out.println("请输入你的选择:");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1": {
                    setRestMoney(restMoney-50);
                    break;
                }
                case "2" :{
                    setRestMoney(restMoney-100);
                    break;
                }
                case "3":{
                    setRestMoney(restMoney-150);
                    break;
                }
            }
            if (choose.equals("4")){
                System.out.println("退出");
                break ;
            }
            System.out.println("给动物取名");
            String name= sc.next();
            System.out.println("动物的年龄");
            int age= sc.nextInt();
            System.out.println("动物的性别(boy?  girl?)");
            String sex= sc.next();
            switch (choose) {
                case "1": {
                    System.out.println("是否接种疫苗(true?  false?)");
                    boolean isVaccineInjected= sc.nextBoolean();
                    setRestMoney(restMoney-50);
                    ChineseRuralDog csr=new ChineseRuralDog(name,age,sex,isVaccineInjected);
                    animalsList.add(csr);
                    break;
                }
                case "2" :{
                    setRestMoney(restMoney-100);
                    Cat c=new Cat(name,age,sex);
                    animalsList.add(c);
                    break;
                }
                case "3":{
                    setRestMoney(restMoney-150);
                    Husky h=new Husky(name,age,sex);
                    animalsList.add(h);
                    break;
                }

            }
    }

 }





    //招待
    @Override
    public void serviceCustomer(ArrayList<Customer> customerslist) {
        System.out.println("------输入客户信息------");
        Scanner sc=new Scanner(System.in);
        System.out.println("输入客户姓名");
        String name=sc.next();
        System.out.println("输入客户到店次数");
        int num=sc.nextInt();
        LocalDate time=LocalDate.now();
       LocalDateTime localDateTime = time.atTime(LocalTime.now());


        Customer c=new Customer(name,num,localDateTime);
        customerslist.add(c);
        if(animalsList.isEmpty()){
            throw new AnimalNotFoundException("店内没有动物!!!");
        }
        //打印动物列表
        System.out.println(getAnimalsList().toString());

        System.out.println("输入想购买动物的序号(1? 2? 3? ......)");
        int index= sc.nextInt();
        animalsList.remove(index-1);

        if(animalsList.get(index - 1) instanceof ChineseRuralDog) {
            CRDSoldNum++;
            setRestMoney(restMoney + 100);
        }
        if (animalsList.get(index - 1) instanceof Cat){
            CatSoldNum++;
            setRestMoney(restMoney + 200);
        }
        if (animalsList.get(index - 1) instanceof Husky){
            HskSoldNum++;
            setRestMoney(restMoney + 250);
        }

    }
    //歇业
    @Override
    public void isClosed( boolean isCloseShop) {

        //获取当前时间
        LocalDateTime nowTime= LocalDateTime.now();

        //获取歇业时间
        Scanner sc=new Scanner(System.in);
        System.out.println("输入歇业时间 ?点 ?分");
        LocalDate time=LocalDate.now();
        int h=sc.nextInt();
        int m=sc.nextInt();
        LocalDateTime endtime = time.atTime(h,m);

        if(nowTime.isAfter(endtime)){
            setCloseShop(true);
        }


        if (isCloseShop()){
            System.out.println("歇业,当前时间为:"+nowTime);
            System.out.println("当天光顾客户信息");
            System.out.println(getCustomers().toString());
            System.out.println();
            System.out.println("当日利润为:"+ (CRDSoldNum*50+CatSoldNum*100+HskSoldNum*100)+ "元");
        }else {
            System.out.println("当前正在营业期间,当前时间为"+nowTime);
        }

    }
}
