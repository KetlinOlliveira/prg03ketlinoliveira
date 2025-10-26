/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade10;

/**
 *
 * @author ketli
 */
public class Piramide extends Tridimensional{
    private double base;
    private double altura;
    private double lado;
    
    public Piramide(double base, double altura, double lado){
        this.base = base;
        this.altura = altura;
        this.lado = lado;
    }
    
    @Override//Formula: Soma de todos os lados e da sua base
    public double obterArea(){
        return lado + lado + lado + base;
    }
    
    @Override//formula: multiplica altura e base, e divite por 3
    public double obterVolume(){
        return altura * base / 3;
    }
    
    @Override
    public String toString(){
        return String.format("Forma Tridimencinal: base %.2f altura %.2f lado %.2f", base, altura, lado);
    }
    
}
