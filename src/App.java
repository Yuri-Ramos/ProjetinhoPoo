package src;

import src.model.ContaCorrente;
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

        DataUtil util = new DataUtil();
        var formatado = util.converterDateParaDataEHora(conta2.getDataAbertura());
        System.out.println(formatado);
        
    }
}
