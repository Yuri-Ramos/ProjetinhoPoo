package src;

import src.model.ContaBancaria;
import src.model.ContaCorrente;

public class App {
    public static void main(String[] args) {
        System.out.println("criando nosso banco digital");
        System.out.println();


        ContaCorrente conta = new ContaCorrente("0001", "7542", 5, 100.0);
        System.out.println("O saldo é de R$ "+ conta.getSaldo()+ " reais ");
        System.out.println();

        conta.despositar(250.0);
        System.out.println("O saldo é de R$ "+ conta.getSaldo()+ " reais ");
        System.out.println();

       conta.sacar(150.0);
        System.out.println("O saldo é de R$ "+ conta.getSaldo()+ " reais ");
        System.out.println();

        ContaBancaria conta2 = new ContaBancaria("0001", "7654", 6, 200.0);
        conta2.transferir(345.0, conta);
        System.out.println("O saldo é de R$ "+ conta.getSaldo()+ " reais ");
        System.out.println("resta  R$ "+ conta2.getSaldo()+ " reais ");


    }
}
