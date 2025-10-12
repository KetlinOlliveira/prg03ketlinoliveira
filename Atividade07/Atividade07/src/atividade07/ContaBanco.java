/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade07;

/**
 *
 * @author ketli
 */
public class ContaBanco {
    //define os atributos privados para encapsulamento
    public int numConta;
    private String tipo;
    private String nome;
    private boolean status;
    private float saldo;
    
    //define um construtor
    public ContaBanco(){
        this.saldo = 0; //ja define o saldo 0
        this.status = false;//e o status para falso
    }
    
    //getters e setters de todas os atributos
    public int getNumConta(){
       return numConta;
    }
    public void setNumConta(int numConta){
        this.numConta = numConta;
    }
    public String getTipo(){
       return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public float getSaldo(){
        return saldo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
   
    //método para abrir a conta
    public void abrirConta(String t){
        this.setTipo(t);
        
        if(this.getStatus()){//verifica se o status da conta já não está aberta
            System.out.println("Erro, a conta" + this.getNumConta() + " já está aberta!");
            return;
        }
   
        if(t.equalsIgnoreCase("cc")){ //caso o usuario informe Conta Corrente
            this.setStatus(true);//torna o status true porque está aberta
            this.setSaldo(50f);
            System.out.println("Conta aberta com sucesso, vc recebeu um presente de 50$");//recebe um presente
        }
        else if(t.equalsIgnoreCase("cp")){//faz o mesmo com Conta Poupança
            this.setStatus(true);
            this.setSaldo(150f);
            System.out.println("Conta aberta com sucesso, vc recebeu um presente de 150$");//recebe presente
        }else{
            System.out.println("Falha ao abrir conta, por favor informe o tipo de conta válido (cc ou cp). Conta nao aberta");
            this.setStatus(false);
        }
    }
    
    
    public void fecharConta(){
        if(!getStatus()){//faz a verificação do status
            System.out.println("Falha ao fechar, conta inexistente.");
        }
        
        if(this.getSaldo()>0){//se for maior que 0, da erro pois não pode existir saldo na conta
            System.out.println("Erro ao fechar conta, voce ainda tem "+ this.getSaldo() +" na conta");
        }if(this.getSaldo() <0){//Verifica se há depitos pendentes
            System.out.println("Erro ao fechar conta, voce está com débito pendente");
        }else {//se não, fecha a conta e define o status para false
             this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
           
        }
    }
    
    public void depositar( float novoDeposito){
        if(!getStatus()){
            System.out.println("Erro, conta fechada!");
            return; //verifica se há conta
        }else{
            this.setSaldo(this.getSaldo() + novoDeposito);//recebe o valor informado e acrescenta.
            System.out.println("Deposito de $"+ novoDeposito+ " realizado com sucesso!\nSaldo atual:" + this.getSaldo());
        
        }     
    }
    public void sacar(float valor){
        if(!getStatus()){
            System.out.println("Erro, conta está fechada!");
            return;//verificação
        }
        if(getSaldo()< valor){// verifica se há saldo disponivel para sacar
            System.out.println("Saldo indispinivel para saque!");
        }else{
            this.setSaldo(this.getSaldo() - valor);//se tiver, faz o saque
            System.out.println("O valor $"+valor+" foi sacado com sucesso da conta "+ this.getNumConta());
        }
        
    }
    
    public void pagarMensal(){
        if(!getStatus()){
            System.out.println("Erro, conta está fechada!");
            return;//verificação
        }
        
        float mensalidade;
        
        //define o tipo de mensalidade a ser cobrada
        if(this.getTipo().equalsIgnoreCase("cc")){
            mensalidade = 12;
        }
        if(this.getTipo().equalsIgnoreCase("cp")){
            mensalidade = 20;
        }
        else{
           System.out.println("Erro, tipo de conta não definido");
           return;
        }
        //a depender do tipo de conta, faz a cobrança.
        if(this.getSaldo() >= mensalidade){//se há saldo suficiente faz a cobrança normalmente
            this.setSaldo(this.getSaldo() - mensalidade);
            System.out.println("Mensalidade de $" + mensalidade +"cobrada com sucesso da conta"+ this.getNumConta());
        }else{
            this.setSaldo(this.getSaldo() - mensalidade);//se não, faz a cobrança e deixa o saldo negativo
            System.out.println("Saldo negativo!\nMensalidade de $" + mensalidade +"cobrada com sucesso, saldo atual: " +this.getSaldo());
        }
        
        
    }

}
