package br.ETS;

import java.util.ArrayList;
import java.util.List;

public class ContaService {
    private List<Conta> contas;

    public ContaService(){
        this.contas = new ArrayList<>();
    }

    public void adcicionarConta(Conta conta){
        contas.add(conta);
    }

    public List<Conta> listarContas(){
        return contas;
    }

    public Conta buscarConta(String numero){
        for (Conta c : contas){
            if (c.getNumero().equals(numero)){
                return c;
            }
        }
        return null;
    }

    public boolean atualizarSaldo(String numero, double novoSaldo){
        Conta conta = buscarConta(numero);
        if (conta != null){
            conta.setSaldo(novoSaldo);
            return true;
        }
        return false;
    }

    public boolean removerConta(String numero){
        Conta conta = buscarConta(numero);
        if (conta != null){
            contas.remove(conta);
            return true;
        }
        return false;
    }
}