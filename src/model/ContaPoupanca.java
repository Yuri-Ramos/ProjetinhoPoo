package src.model;

import java.util.Date;

import src.utils.DataUtil;

public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca() {
    }

    public ContaPoupanca(String agencia, String conta, Integer digito, Double saldoInicial) {
        super(agencia, conta, digito, saldoInicial);
    }
    

    @Override
public void imprimirExtrato() {
    
    System.out.println();
    System.out.println("************************************************");
    System.out.println("*********  Extrato Bancario Poupança ***********");
    System.out.println("************************************************");
    System.out.println();
    System.out.println("Gerado em : " + DataUtil.converterDateParaDataEHora(new Date()));

    // para cada movimentação dentro de movimentações fará
    for (Movimentacao movimentacao : this.movimentacoes) {
        System.out.println(movimentacao);  
        System.out.println();     
    }
    System.out.println();
    System.out.println("************************************************");
    System.out.println("************************************************");
    System.out.println("************************************************");
    System.out.println();
}

}