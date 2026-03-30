package br.ETS;

public class ContaCorrente extends Conta {

    private double ChequeEspecial;

    public ContaCorrente(Cliente cliente, double ChequeEspecial) {
        super(cliente);
        this.ChequeEspecial = ChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        double taxa = 2.0;
        double valorTotal = valor + taxa;

        if (saldo + ChequeEspecial >= valorTotal) {
            saldo -= valorTotal;
            return true;
        }

        return false;
    }
}