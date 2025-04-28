public class BankAccount {
    private float balance;
    private float specialCheck;
    private final String ownerName;
    private boolean usingSpecialCheck;

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
        System.out.printf("Seu saldo atual é de R$ %.2f", getBalance());
    }
    public void checkSpecialCheck(){
        System.out.printf("Seu cheque especial atual é de R$ %.2f", getSpecialCheck());
    }
    public void deposit(float quantity){
        changeBalance(quantity);
        System.out.printf("Você depositou um total de R$ %.2f " + " Seu saldo atual é de R$ %.2f",quantity,getBalance());
    }

    public void withdraw(float quantity){
        changeBalance(-quantity);
        System.out.printf("Você sacou um total de R$ %.2f " + " Seu saldo atual é de R$ %.2f",quantity,getBalance());
    }

    public void payBill(float value){
        changeBalance(-value);
        System.out.printf("Você pagou um boleto no total de R$ %.2f " + " Seu saldo atual é de R$ %.2f",value,getBalance());
    }

    private float changeBalance(float value){
        balance += value;
        return balance;
    }

    public void usingSpecialCheck(){
        isUsingSpecialCheck();
        if(usingSpecialCheck) System.out.println("Você está usando o seu cheque especial");
    }

    private void isUsingSpecialCheck(){
        if(getBalance() <= 0 & !usingSpecialCheck){
            usingSpecialCheck = true;
            changeBalance(getSpecialCheck());
        } else usingSpecialCheck = false;
        while(usingSpecialCheck){
            specialCheck = balance;
        }
    }

//    private void isNotUsingSpecialCheck(){
//        if()
//    }

}
