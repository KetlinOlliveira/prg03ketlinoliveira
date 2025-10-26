/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade10;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author ketli
 */
public class Atividade10 {

    public static void main(String[] args) {
       List<Formas> formas = new ArrayList<>();//cria um array de formas
       
       //definições para teste
       formas.add(new Circulo(5.0));
       formas.add(new Quadrado(6.0));
       formas.add(new Cubo(4.0));
       formas.add(new Esfera(2.0));
       
       System.out.println("Teste de formas\n");
       
       for(Formas formaAtual:  formas){
           System.out.println("\nDescrição: " + formaAtual.toString());//mostra a descrição a principio
           
           if(formaAtual instanceof Bidimensional ){//verifica se a forma é bidimensional
               Bidimensional forma2D = (Bidimensional) formaAtual;//chama a forma especifica com um casting
               System.out.printf("Tipo: Forma Bidimensional\n");
               System.out.printf("Área: %.2f\n", forma2D.obterArea());//exibe sua area
               
           }else if( formaAtual instanceof Tridimensional){//verifica se é tridimensional
               Tridimensional forma3d = (Tridimensional) formaAtual;
                System.out.printf("Tipo: Forma Tridimensional\n");
               System.out.printf("Área: %.2f\n", forma3d.obterArea());//mostra a sua area e volume
               System.out.printf("Volume: %.2f\n", forma3d.obterVolume());
           }
       }
    }
    
}
