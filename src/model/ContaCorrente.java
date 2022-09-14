package src.model;

import java.util.Date;

import src.utils.DataUtil;

public class ContaCorrente extends ContaBancaria{

public ContaCorrente(String agencia,String conta, Integer digito, Double saldoInicial){
    super(agencia, conta, digito, saldoInicial);
}

@Override
public void imprimirExtrato() {
    
    System.out.println();
    System.out.println("************************************************");
    System.out.println("**************  Extrato Bancario ***************");
    System.out.println("************************************************");
    System.out.println();
    System.out.println("      gerado em : " + DataUtil.converterDateParaDataEHora(new Date()));
    System.out.println();

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
    

