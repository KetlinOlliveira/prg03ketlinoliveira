/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.ifba.atividade06.view;
import br.com.ifba.atividade06.view.TelaPrincipal;

/**
 *
 * @author ketli
 */
public class Prg06ketlinoliveira {
//precisei criar atributos de instancia para nao perder os valores armazenados
     private int numeroAFatorar; 
   private int resultadoFatorial;
   
    public void setValor(int valor) {
        //recebe o valor que vai ser fatorado
        this.numeroAFatorar = valor;
               
    }
    public String getFormula(){
        //variavel para multiplicar o valor
        int fator =1;
        String formula = "";//inicia a string que irá guardar a formula
        
     for(int cont = numeroAFatorar; cont >=1; cont--){
         //decrementa de acordo com o número escolhido e faz a multiplicação
          fator *=cont;   
          
          formula +=cont; //guarda os valores de cont na string
          if(cont >1){
              formula += " x ";  //adiciona um x entre cada numero
          }  
        }
     resultadoFatorial = fator; //recebe o resultado final
     return formula;//retorna a string
    }
        
     public int getFatorial(){
         return resultadoFatorial;//retorna o resultado da fatoração
        
    }
     
     public static void main(String[] args) {
        TelaPrincipal tela = new TelaPrincipal();//cria um obj para a tela e a deixa visivel
        tela.setVisible(true);
    }
}
