package src.model;

import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {

   //#region atributo
    private String agencia; 
    private String conta;
    private Integer digito;
    private Double saldo;
    private Double VALOR_MINIMO_DEPOSITO =10.0;
    private Date dataAbertura;

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
}

public void sacar(Double valor){
    
    // verifica se o saldo é menor que o valor retirado
    if(valor>this.saldo){
        // caso seja menor tras a execessão abaixo throw new
        throw new InputMismatchException("Saque indisponivel, por não ter valor em conta!!");
    }else{
        // caso a operação seja valida da o resultado da operação e traz o valor novamente
        this.saldo -=valor;
        
    }


}

public void transferir(Double valor, ContaBancaria contaDestino){
//efetua um saque na conta atual
    this.sacar(valor);

// efetuar um deposito na conta destino
    contaDestino.despositar(valor);

}



//#endregion
}
