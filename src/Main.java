import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao processo de criação de conta!\nInforme seu nome e o valor desejado para depósito inicial");

        String input = "";
        String oldInput = input;
        boolean isInputing = true;

        BankAccount bankAccount = new BankAccount(sc.next(), sc.nextFloat());

        System.out.printf("Olá " + bankAccount.getOwnerName() + " que bom te ver por aqui!\nSeu saldo é de: %.2f" + "\nSeu cheque especial é de: %.2f\n", bankAccount.getBalance(),bankAccount.getSpecialCheck());
        System.out.println("Você tem a liberdade de consultar o seu saldo e seu cheque especial, depositar, sacar, pagar algum boleto, e verificar se a sua conta está usando cheque especial");
        System.out.println("Os comandos são os seguintes: consultar saldo | consultar cheque | depositar | sacar | pagar boleto | verificar cheque");

        while(isInputing) {
            input = sc.next();
            input.toLowerCase();
            isInputing = false;
        }
        if(oldInput != input){
            switch (input){
                case "consultar saldo":
                    bankAccount.checkBalance();
                    isInputing = true;
                    oldInput = input;
                    break;
            }
        }
    }
}