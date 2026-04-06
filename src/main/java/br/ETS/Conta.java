package br.ETS;

public abstract class Conta {
    private int numeroConta;
    private Cliente cliente;
    private double saldo;

    public Conta(int numeroConta, Cliente cliente, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return false;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }
        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
        return true;
    }

    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.printf("Transferência de R$ %.2f para conta %d concluída.%n", valor, destino.getNumeroConta());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Conta #%d | Titular: %s | Saldo: R$ %.2f",
                numeroConta, cliente.getNome(), saldo);
    }
}