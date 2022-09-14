package src.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {

   //#region atributo
    protected String agencia; 
    protected String conta;
    protected Integer digito;
    protected Double saldo;
    protected Double VALOR_MINIMO_DEPOSITO =10.0;
    protected Date dataAbertura;
    protected ArrayList<Movimentacao> movimentacoes;
//#endregion
    
    //#region Construtores
    
    public ContaBancaria() {
    }
    public ContaBancaria(String agencia, String conta, Integer digito, Double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoInicial;
        this.dataAbertura = new Date();
        //deve ser instanciado, caso contrario não entra e dará nullpointException
        this.movimentacoes = new ArrayList<Movimentacao>();
        Movimentacao movimentacao = new Movimentacao("Abertura de contra", saldoInicial);
        this.movimentacoes.add(movimentacao);
    }
    
    //#endregion
    
    //#region Get e Setters
    
    
    
    
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = conta;
    }
    public Integer getDigito() {
        return digito;
    }
    public void setDigito(Integer digito) {
        this.digito = digito;
    }
    public Double getSaldo() {
        return saldo;
    }
    public Date getDataAbertura() {
        return dataAbertura;
    }
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    
    
//#endregion

//#region metodos

public void despositar(Double valor){
    if(valor>VALOR_MINIMO_DEPOSITO){
        
        this.saldo += valor;
    }else{
        throw new InputMismatchException("valor de deposito é muito baixo!! R$10.0 ");
    }
    // extrato
    Movimentacao movimentacao= new Movimentacao("Deposito", valor);
    this.movimentacoes.add(movimentacao);
}

public Double sacar(Double valor){
    
    // verifica se o saldo é menor que o valor retirado
    if(valor>this.saldo){
        // caso seja menor tras a execessão abaixo throw new
        throw new InputMismatchException("Saque indisponivel, por não ter valor em conta!!");
    }else{
        // caso a operação seja valida da o resultado da operação e traz o valor novamente
        this.saldo -=valor;
        
    }
        Movimentacao movimentacao= new Movimentacao("sacar", valor);
        this.movimentacoes.add(movimentacao);

        return valor;
        

}

public void transferir(Double valor, ContaBancaria contaDestino){
//efetua um saque na conta atual
    this.sacar(valor);

// efetuar um deposito na conta destino
    contaDestino.despositar(valor);

}

public void imprimirExtrato() {
    // TODO Auto-generated method stub
    
}




//#endregion
}
