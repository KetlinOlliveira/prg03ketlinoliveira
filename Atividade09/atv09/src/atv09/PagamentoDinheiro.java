/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv09;

import java.awt.BorderLayout;

/**
 *
 * @author ketli
 */
public class PagamentoDinheiro implements Pagamento {
    private Double valor;
    
    public PagamentoDinheiro(Double valor){
        this.valor = valor;
    }
    
    @Override
    public Double calcularTotal(){
        double desconto;
        this.valor = valor;
        desconto = this.valor * 0.10;
        this.valor = this.valor - desconto;
       
        return this.valor;
    }
    @Override
    public String imprimirRecibo(){
       double valorOriginal = this.valor/0.90;
       String textoRecebido = "--------Recibo de Compra--------" + "\n\n" +
               "Valor original: R$" + String.format("%.2f", valorOriginal) + "\n\n" +
               "Desconto: 10%" + "\n" +
               "Valor final: R$" + String.format("%.2f", this.valor) + "\n\n\n" +
               "-----------------------------------------";
       
       return textoRecebido;
    }
    
    public Double getValor(){
        return valor;
    }
    public void setValor(Double valor){
        this.valor = valor;
    }
    
}
