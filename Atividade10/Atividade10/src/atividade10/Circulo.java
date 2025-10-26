/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade10;

/**
 *
 * @author ketli
 */
public class Circulo extends Bidimensional{
    private double raio;
    
    public Circulo(double raio){
        this.raio = raio;
    }
    
    @Override
    public double obterArea(){//deve multiplicar o raio por ele mesmo e por PI para ober a area
        return Math.PI * raio * raio;
    }
    
    @Override
    public String toString(){
        return String.format("Forma bidimensional: circulo com raio %.2f", raio);
    }
    
}
