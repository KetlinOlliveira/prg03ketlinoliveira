/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade10;

/**
 *
 * @author ketli
 */
public class Cubo extends Tridimensional{
    private double lado;
    
    public Cubo(double lado){
        this.lado = lado;
    }
    
    @Override
    public double obterArea(){ //formula: multiplica os lados com as 6 faces de um Cubo
        return 6 * lado *lado;
    }
    
    @Override //o volume é lado ao cubo: lado³
    public double obterVolume(){
        return lado *lado * lado;
    }
    
    @Override
    public String toString(){
        return String.format("Forma tridimensional: Cubo com lado %.2f", lado);
    }
    
}
