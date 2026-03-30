package br.ETS;

public abstract class Conta {
    protected double saldo;
    protected Cliente cliente;
    protected int numeroConta;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) return false;

        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }
}