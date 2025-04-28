public class BankAccount {
    private float balance;
    private float specialCheck;
    private final String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public float getSpecialCheck() {
        return specialCheck;
    }

    public float getBalance() {
        return balance;
    }
    public BankAccount(String name, float balance){
        this.balance = balance;
        ownerName = name;
        if(this.balance <= 500) specialCheck = 50;
        else specialCheck = this.balance * (1.0f/2.0f);
    }

    public void checkBalance(){
        System.out.printf("Seu saldo atual é R$ %.2f", balance);
    }


}
