public class BankAccount {
    private float balance, specialCheck, accumulatedSpecialCheck;
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
        System.out.printf("Seu cheque especial atual é de R$ %.2f\n", getSpecialCheck());
    }

    public void deposit(float quantity){
        changeBalance(quantity);
        System.out.printf("Você depositou um total de R$ %.2f " + " Seu saldo atual é de R$ %.2f\n",quantity,getBalance());
        if(usingSpecialCheck) {
            payYourDebt(quantity);
            System.out.println("Você estava utilizando o cheque especial, será descontado 20% do total usado do que foi depositado agora!\n Seu saldo agora é de " + getBalance());
            usingSpecialCheck = false;

        }
    }

    public void withdraw(float quantity){
        if((getBalance() - quantity) <= 0 | usingSpecialCheck) System.out.println("Você não tem saldo o suficiente ou está utilizando o valor do cheque especial");
        else {
            changeBalance(-quantity);
            System.out.printf("Você sacou um total de R$ %.2f " + " Seu saldo atual é de R$ %.2f\n", quantity, getBalance());
        }
    }

    public void payBill(float value){
        if((getBalance() - value) < 0 | usingSpecialCheck){
            System.out.println("Você não tem saldo o suficiente, porém agora utilizaremos o cheque especial!");
            if((getBalance() - value) < 0 & usingSpecialCheck){
                System.out.println("O seu saldo atual, mesmo junto ao cheque especial, não paga o valor do boleto, sinto muito!");
            } else{

                if(getBalance() - value < 0) debt(value - getBalance());
                else debt(value);

                changeBalance(-value);

                if(!usingSpecialCheck) isUsingSpecialCheck();

                System.out.printf("Você pagou um boleto no total de R$ %.2f " + " Seu saldo atual é de R$ %.2f\n",value,getBalance());
            }
        } else{
            changeBalance(-value);
            System.out.printf("Você pagou um boleto no total de R$ %.2f " + " Seu saldo atual é de R$ %.2f\n",value,getBalance());
            }
    }

    private void changeBalance(float value){
        balance += value;
    }

    public void usingSpecialCheck(){
        if(usingSpecialCheck) System.out.println("Você está usando o seu cheque especial");
        else System.out.println("Você não está usando o seu cheque especial");
    }

    private void isUsingSpecialCheck(){
        if(getBalance() < 0 & !usingSpecialCheck){
            usingSpecialCheck = true;
            changeBalance(getSpecialCheck());
            specialCheck = balance;
            System.out.println("AVISO! A PARTIR DE AGORA VOCÊ ESTARÁ USANDO O CHEQUE ESPECIAL, LOGO, ASSIM QUE VOCÊ DEPOSITAR ALGUM DINHEIRO, SERÁ COBRADO 20% DO VALOR QUE VOCÊ UTILIZOU DO CHEQUE ESPECIAL");
        } else usingSpecialCheck = false;
    }

    private void debt(float value){
        accumulatedSpecialCheck += value;
    }

    private void payYourDebt(float value){
        if(getBalance() + value >= accumulatedSpecialCheck){
            changeBalance(-(accumulatedSpecialCheck*0.2f));
        }
    }

}
