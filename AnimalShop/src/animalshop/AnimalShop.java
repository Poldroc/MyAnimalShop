package animalshop;

import java.util.ArrayList;

public interface AnimalShop {
    //买入动物
    public  void addAnimals(ArrayList<Animal> animalsList);

    //招待客户
    public  void serviceCustomer(ArrayList<Customer> customerslist);

    //歇业
    public void isClosed(boolean b);
}
