package animalshop;

public class ChineseRuralDog extends  Animal{
    //进价50
    //价格100

    private boolean isVaccineInjected;

    public ChineseRuralDog(String name, int age, String sex, boolean isVaccineInjected){
        super(name,age,sex,100);
        this.isVaccineInjected=isVaccineInjected;
    }

    public boolean isVaccineInjected() {
        return isVaccineInjected;
    }

    public void setVaccineInjected(boolean vaccineInjected) {
        isVaccineInjected = vaccineInjected;
    }
}
