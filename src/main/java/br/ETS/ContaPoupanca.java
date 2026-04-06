package br.ETS;

public class ContaPoupanca extends Conta {
    private double taxaRentabilidade; // em porcentagem, ex: 0.5 = 0.5%

    public ContaPoupanca(int numeroConta, Cliente cliente, double saldoInicial, double taxaRentabilidade) {
        super(numeroConta, cliente, saldoInicial);
        this.taxaRentabilidade = taxaRentabilidade;
    }

    public double getTaxaRentabilidade() {
        return taxaRentabilidade;
    }

    //Aplica a taxa de rentabilidade sobre o saldo atual
    public void rentabilizar() {
        double rendimento = getSaldo() * (taxaRentabilidade / 100);
        setSaldo(getSaldo() + rendimento);
        System.out.printf("Rentabilização aplicada: +R$ %.2f (%.2f%%) | Novo saldo: R$ %.2f%n",
                rendimento, taxaRentabilidade, getSaldo());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Poupança | Taxa: %.2f%%", taxaRentabilidade);
    }
}