import java.util.Scanner;

public class Aplicacao {
    private ContaService contaService;
    private Scanner scanner;

    public Aplicacao() {
        this.contaService = new ContaService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opção: ");
            System.out.println();
            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> contaService.exibirContas();
                case 3 -> sacar();
                case 4 -> depositar();
                case 5 -> transferir();
                case 6 -> utilizarChequeEspecial();
                case 7 -> rentabilizar();
                case 8 -> encerrarConta();
                case 0 -> System.out.println("Encerrando sistema. Até logo!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         SISTEMA BANCÁRIO             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Criar conta                      ║");
        System.out.println("║  2. Exibir contas                    ║");
        System.out.println("║  3. Sacar                            ║");
        System.out.println("║  4. Depositar                        ║");
        System.out.println("║  5. Transferir                       ║");
        System.out.println("║  6. Utilizar Cheque Especial         ║");
        System.out.println("║  7. Rentabilizar Poupança            ║");
        System.out.println("║  8. Encerrar conta                   ║");
        System.out.println("║  0. Sair                             ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    private void criarConta() {
        System.out.println("Tipo de conta:");
        System.out.println("  1. Conta Corrente");
        System.out.println("  2. Conta Poupança");
        int tipo = lerInt("Escolha: ");

        System.out.println("\nDados do Cliente");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);

        double saldoInicial = lerDouble("Saldo inicial: R$ ");

        if (tipo == 1) {
            double chequeEspecial = lerDouble("Limite do Cheque Especial: R$ ");
            contaService.criarContaCorrente(cliente, saldoInicial, chequeEspecial);
        } else if (tipo == 2) {
            double taxa = lerDouble("Taxa de Rentabilidade (%): ");
            contaService.criarContaPoupanca(cliente, saldoInicial, taxa);
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private void sacar() {
        int numero = lerInt("Número da conta: ");
        double valor = lerDouble("Valor do saque: R$ ");
        contaService.sacar(numero, valor);
    }

    private void depositar() {
        int numero = lerInt("Número da conta: ");
        double valor = lerDouble("Valor do depósito: R$ ");
        contaService.depositar(numero, valor);
    }

    private void transferir() {
        int origem = lerInt("Número da conta de origem: ");
        int destino = lerInt("Número da conta de destino: ");
        double valor = lerDouble("Valor da transferência: R$ ");
        contaService.transferir(origem, destino, valor);
    }

    private void utilizarChequeEspecial() {
        int numero = lerInt("Número da conta corrente: ");
        double valor = lerDouble("Valor a utilizar do cheque especial: R$ ");
        contaService.utilizarChequeEspecial(numero, valor);
    }

    private void rentabilizar() {
        int numero = lerInt("Número da conta poupança: ");
        contaService.rentabilizar(numero);
    }

    private void encerrarConta() {
        int numero = lerInt("Número da conta a encerrar: ");
        contaService.encerrarConta(numero);
    }

    private int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número inteiro válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Digite um valor numérico válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}