public class ContaBancaria {
    private float saldo;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void consultarSaldo(){
        System.out.printf("Seu saldo atual é R$ %.2f", saldo);
    }
}
