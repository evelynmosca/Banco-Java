package br.ETS;

import java.util.ArrayList;

public class ContaService {
    private ArrayList<ContaCorrente> contasCorrente;
    private ArrayList<ContaPoupanca> contasPoupanca;
    private int proximoNumero;

    public ContaService() {
        this.contasCorrente = new ArrayList<>();
        this.contasPoupanca = new ArrayList<>();
        this.proximoNumero = 1001;
    }

    // Criar conta
    public ContaCorrente criarContaCorrente(Cliente cliente, double saldoInicial, double chequeEspecial) {
        ContaCorrente conta = new ContaCorrente(proximoNumero++, cliente, saldoInicial, chequeEspecial);
        contasCorrente.add(conta);
        System.out.println("Conta Corrente criada com sucesso! " + conta);
        return conta;
    }

    public ContaPoupanca criarContaPoupanca(Cliente cliente, double saldoInicial, double taxaRentabilidade) {
        ContaPoupanca conta = new ContaPoupanca(proximoNumero++, cliente, saldoInicial, taxaRentabilidade);
        contasPoupanca.add(conta);
        System.out.println("Conta Poupança criada com sucesso! " + conta);
        return conta;
    }

    // Exibir conta
    public void exibirContas() {
        System.out.println("\nConta Correntes");
        if (contasCorrente.isEmpty()) {
            System.out.println("Nenhuma conta corrente cadastrada.");
        } else {
            for (ContaCorrente c : contasCorrente) {
                System.out.println(c);
            }
        }

        System.out.println("\nConta Poupança");
        if (contasPoupanca.isEmpty()) {
            System.out.println("Nenhuma conta poupança cadastrada.");
        } else {
            for (ContaPoupanca c : contasPoupanca) {
                System.out.println(c);
            }
        }
        System.out.println();
    }

    // Buscar conta por número
    public Conta buscarConta(int numeroConta) {
        for (ContaCorrente c : contasCorrente) {
            if (c.getNumeroConta() == numeroConta) return c;
        }
        for (ContaPoupanca c : contasPoupanca) {
            if (c.getNumeroConta() == numeroConta) return c;
        }
        return null;
    }

    // Operações bancárias
    public void sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        conta.sacar(valor);
    }

    public void depositar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        conta.depositar(valor);
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor) {
        Conta origem = buscarConta(numeroOrigem);
        Conta destino = buscarConta(numeroDestino);

        if (origem == null || destino == null) {
            System.out.println("Uma ou mais contas não encontradas.");
            return;
        }
        origem.transferir(destino, valor);
    }

    // Cheque especial (apenas ContaCorrente, e só com saldo zerado)

    public void utilizarChequeEspecial(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        if (!(conta instanceof ContaCorrente)) {
            System.out.println("Cheque especial disponível apenas para Conta Corrente.");
            return;
        }
        ((ContaCorrente) conta).utilizarChequeEspecial(valor);
    }

    // Rentabilizar (apenas ContaPoupanca)
    public void rentabilizar(int numeroConta) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        if (!(conta instanceof ContaPoupanca)) {
            System.out.println("Rentabilização disponível apenas para Conta Poupança.");
            return;
        }
        ((ContaPoupanca) conta).rentabilizar();
    }

    // Encerrar conta
    public void encerrarConta(int numeroConta) {
        for (int i = 0; i < contasCorrente.size(); i++) {
            if (contasCorrente.get(i).getNumeroConta() == numeroConta) {
                System.out.println("Conta encerrada: " + contasCorrente.get(i));
                contasCorrente.remove(i);
                return;
            }
        }
        for (int i = 0; i < contasPoupanca.size(); i++) {
            if (contasPoupanca.get(i).getNumeroConta() == numeroConta) {
                System.out.println("Conta encerrada: " + contasPoupanca.get(i));
                contasPoupanca.remove(i);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}