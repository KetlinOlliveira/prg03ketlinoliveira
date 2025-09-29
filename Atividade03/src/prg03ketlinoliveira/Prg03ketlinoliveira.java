/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prg03ketlinoliveira;
import br.com.ifba.atividade03.view.TelaPrincipal;
import javax.swing.*;


/**
 *
 * @author ketli
 */
public class Prg03ketlinoliveira {

   
    public static void main(String[] args) {
        //cria uma nova tel
        TelaPrincipal tela = new TelaPrincipal();
        //a tona visivel
        tela.setVisible(true);
        
        //carrega a imagem da pasta images
        ImageIcon icon = new ImageIcon(
                Prg03ketlinoliveira.class.getResource("/br/com/ifba/atividade03/images/pingu.jpeg")
        
        );
    }
    
}
