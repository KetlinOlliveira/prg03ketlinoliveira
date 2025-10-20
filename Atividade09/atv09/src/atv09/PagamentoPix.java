/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv09;

/**
 *
 * @author ketli
 */
public class PagamentoPix implements Pagamento{
      private double valor;
    
    public PagamentoPix(double valor){
        this.valor = valor;
    }
    
    @Override
    public Double calcularTotal(){
       double cashback;
       cashback = this.valor * 0.02;
       this.valor = this.valor - cashback;  
       return this.valor;
    }
    @Override
    public String imprimirRecibo(){
        double valorOriginal = this.valor/0.98;
       String textoRecebido = "-----Recibo de Compra-----" + "\n" +
               "Valor original: R$" + String.format("%.2f", valorOriginal) + "\n" +
               "Cashback 2%" + "\n" +
               "Valor final: R$" + String.format("%.2f", this.valor) + "\n" +
               "------------------------------------";
       
       return textoRecebido;
    
    }
    public double getValor(){
        return valor;
    }
    public void setValor(double valor){
        this.valor = valor;
    }

}
