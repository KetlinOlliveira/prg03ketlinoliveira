/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade10;

/**
 *
 * @author ketli
 */
public class Triangulo extends Bidimensional {
    private double altura;
    private double base;
    
    public Triangulo(double altura, double base){
        this.altura = altura;
        this.base = base;
    }
    
    @Override//formula: multiplica a base e altura, dps divide por 2
    public double obterArea(){
        return (altura * base)/2;
    }
    
    @Override
    public String toString(){
        return String.format("Forma bidimensional, triangulo com altura %.2f e base %.2f", altura, base);
    }
    
}
