package Main;

public class Account {
    private float maxMoney;
    private float currentMoney;
    private String user;

    public enum Money{
        EUR(1),AUS(1.61);

        double money;
        Money(double money){
            this.money = money;
        }
        public double getValueEURToAUS(double EUR){
        return EUR*1.61;
        }
        public double getValueAUSToEUR(double AUS){
            return AUS*0.61;
        }


    }

    Account(){

    }
    Account(float maxMoney, String user,String currency){
        this.user = user;
        this.maxMoney = maxMoney;

    }
    Account(float maxMoney, float currentMoney, String user, String currency){

        this.currentMoney = currentMoney;
        this.maxMoney = maxMoney;
        this.user = user;
    }

    public float getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(float maxMoney) {
        this.maxMoney = maxMoney;
    }

    public float getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(float currentMoney) {
        this.currentMoney = currentMoney;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
