public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private boolean chequeEspecialAtivo;

    public ContaCorrente(int numeroConta, Cliente cliente, double saldoInicial, double chequeEspecial) {
        super(numeroConta, cliente, saldoInicial);
        this.chequeEspecial = chequeEspecial;
        this.chequeEspecialAtivo = false;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public boolean isChequeEspecialAtivo() {
        return chequeEspecialAtivo;
    }

    /**
     * Utiliza o cheque especial somente quando o saldo está zerado.
     * O valor sacado vem do limite do cheque especial.
     */
    public boolean utilizarChequeEspecial(double valor) {
        if (getSaldo() > 0) {
            System.out.println("Cheque especial só pode ser utilizado quando o saldo está zerado.");
            return false;
        }
        if (valor <= 0) {
            System.out.println("Valor inválido para cheque especial.");
            return false;
        }
        if (valor > chequeEspecial) {
            System.out.printf("Valor supera o limite do cheque especial (R$ %.2f).%n", chequeEspecial);
            return false;
        }
        chequeEspecial -= valor;
        chequeEspecialAtivo = true;
        System.out.printf("Cheque especial utilizado: R$ %.2f | Limite restante: R$ %.2f%n", valor, chequeEspecial);
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Corrente | Cheque Especial: R$ %.2f%s",
                chequeEspecial, chequeEspecialAtivo ? " (ATIVO)" : "");
    }
}