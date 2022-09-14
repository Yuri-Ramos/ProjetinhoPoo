package src;

import src.model.ContaCorrente;
import src.model.Movimentacao;
import src.utils.DataUtil;

public class App {
    public static void main(String[] args) {
        System.out.println("criando nosso banco digital");
        System.out.println();


        ContaCorrente conta = new ContaCorrente("0001", "7542", 5, 100.0);
        System.out.println("O saldo é de R$ "+ conta.getSaldo()+ " reais ");
        System.out.println();
        
        conta.despositar(50.0);
        System.out.println("O saldo é de R$ "+ conta.getSaldo()+ " reais ");
        System.out.println();
        
       conta.sacar(15.0);
       System.out.println("O saldo é de R$ "+ conta.getSaldo()+ " reais ");
        System.out.println();
        
        ContaCorrente conta2 = new ContaCorrente("0001", "7654", 6, 200.0);
        conta2.transferir(25.0, conta);
        System.out.println("O saldo é de R$ "+ conta.getSaldo()+ " reais ");
        System.out.println("resta  R$ "+ conta2.getSaldo()+ " reais ");
        
        System.out.println(conta2.getDataAbertura());

        
        var f1 = DataUtil.converterDateParaDataEHora(conta2.getDataAbertura());
        var f2 = DataUtil.converterDateParaData(conta2.getDataAbertura());
        var f3 = DataUtil.converterDateParaHora(conta2.getDataAbertura());
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        

        Movimentacao m = new Movimentacao("saque", 100.0);
        System.out.println(m);

        conta.imprimirExtrato();
    }
}
