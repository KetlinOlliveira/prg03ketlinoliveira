
package com.mycompany.prg03ketlingoliveira;
import br.com.ifba.atividade03.view.TelaPrincipal;
import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ketli
 */
public class Prg03ketlingoliveira {

    public static void main(String[] args) {
        
        String dataStr = JOptionPane.showInputDialog(null, "Informe sua data de nascimento(dd/mm/aa):");
        
        
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        
        ImageIcon icon = new ImageIcon(
        Prg03ketlingoliveira.class.getResource("/br/com/ifba/atividade03/images/esquilo.jpeg")
        );
    }
}
