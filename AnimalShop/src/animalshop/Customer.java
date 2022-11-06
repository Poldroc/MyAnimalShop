package animalshop;

import java.time.LocalDateTime;

public class Customer {
    private String name;
    private int buyNum;
    private LocalDateTime buyTime;


    public Customer() {
    }

    public Customer(String name, int buyNum, LocalDateTime buyTime) {
        this.name = name;
        this.buyNum = buyNum;
        this.buyTime = buyTime;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return buyNum
     */
    public int getBuyNum() {
        return buyNum;
    }

    /**
     * 设置
     * @param buyNum
     */
    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    /**
     * 获取
     * @return buyTime
     */
    public LocalDateTime getBuyTime() {
        return buyTime;
    }

    /**
     * 设置
     * @param buyTime
     */
    public void setBuyTime(LocalDateTime buyTime) {
        this.buyTime = buyTime;
    }
  @Override
    public String toString() {
        return "Customer{name = " + name + ", buyNum = " + buyNum + ", buyTime = " + buyTime + "}";
    }
}
