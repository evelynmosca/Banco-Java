package br.ETS;

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    public ContaPoupanca(Cliente cliente, double taxaRendimento) {
        super(cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public void render() {
        saldo += saldo * taxaRendimento;
    }
}