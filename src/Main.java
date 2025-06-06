import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println("Bem vindo ao processo de criação de conta!\nInforme seu nome e o valor desejado para depósito inicial");

        String input = "";
        boolean isInputing = true;
        String name = sc.next();
        float inicialDeposit = sc.nextFloat();

        BankAccount bankAccount = new BankAccount(name, inicialDeposit);

        System.out.printf("Olá " + bankAccount.getOwnerName() + " que bom te ver por aqui!\nSeu saldo é de: R$ %.2f" + "\nSeu cheque especial é de: R$ %.2f\n", bankAccount.getBalance(),bankAccount.getSpecialCheck());
        System.out.println("Você tem a liberdade de consultar o seu saldo e seu cheque especial, depositar, sacar, pagar algum boleto, e verificar se a sua conta está usando cheque especial");


        while(isInputing) {
            System.out.println("\nOs comandos são os seguintes:\n| consultar saldo | consultar cheque | depositar |\n| sacar | pagar boleto | verificar cheque |\n| sair |");
            input = sc.next();
            input.toLowerCase();
            isInputing = false;
            switch (input) {
                case "consultar saldo":
                    bankAccount.checkBalance();
                    isInputing = true;
                    break;
                case "consultar cheque":
                    bankAccount.checkSpecialCheck();
                    isInputing = true;
                    break;
                case "depositar":
                    System.out.println("Insira o valor a depositar");
                    float value = sc.nextFloat();
                    bankAccount.deposit(value);
                    isInputing = true;
                    break;
                case "sacar":
                    System.out.println("Insira o valor a sacar");
                    float value1 = sc.nextFloat();
                    bankAccount.withdraw(value1);
                    isInputing = true;
                    break;
                case "pagar boleto":
                    System.out.println("Insira o valor do boleto");
                    float value2 = sc.nextFloat();
                    bankAccount.payBill(value2);
                    isInputing = true;

                    break;
                case "verificar cheque":
                    bankAccount.usingSpecialCheck();
                    isInputing = true;
                    break;
                case "sair":
                    break;
                default:
                    System.out.println("Comando não entendido, repita por favor");
                    isInputing = true;
        }
        }
    }
}