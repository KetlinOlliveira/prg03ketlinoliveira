/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade10;

/**
 *
 * @author ketli
 */
public class Quadrado extends Bidimensional {
    private double lado;
    
    public Quadrado(double lado){
        this.lado = lado;
    }
    
    @Override //formula: multiplica seus dois lados
    public double obterArea(){
        return lado * lado;
    }
    @Override
    public String toString(){
        return String.format("Forma Bidimensional: Quadrado com lado: %.2f", lado);
    }
    
}
