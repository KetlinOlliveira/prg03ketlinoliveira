/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade10;

/**
 *
 * @author ketli
 */
public class Esfera extends Tridimensional{
    private double raio;
    
    public Esfera(double raio){
        this.raio = raio;
    }
    
    @Override
    public double obterArea(){//Formula: raio² e multiplica por 4 e PI (3,14...)
        return Math.PI * (raio*raio) * 4;
    }
    
    @Override//Formula volume: raio³ e multiplica por PI, depois divide por 3
    public double obterVolume(){
        return raio* raio *raio * Math.PI/3;
        
    }
    
    @Override
    public String toString(){
        return String.format("Forma tridimensional: Esfera com raio %.2f", raio);
    }
}
