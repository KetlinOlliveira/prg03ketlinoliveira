/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade08;
import java.util.Arrays;

/**
 *
 * @author ketli
 */
public class Atividade08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      PerfilUsuario admin = new PerfilUsuario(1L, 
              "Administrador",//cria um novo perfil usuario chamado "administrador"
              Arrays.asList("CRIAR_USUARIO", //define um array declarando as acçoes que o adm pode executar
                      "EDITAR PERFIL", 
                      "EXCLUIR DADOS"));
      
      Usuario userAdm = new Usuario(//cria um usuario com o perfil de administrador
              101L, 
              admin, 
              "Ketlin.admin", 
              "ketlin@gmail.com",
              "senha123", 
              true);
      
      
        //imprimir na tela o usuario criado
        System.out.println("Usuario criado:\n " +userAdm.toString());
        System.out.println("_________________________________________\n");
        //verifica se a senha esta correta
        System.out.println("Tentativa de Login(sucesso): "+ userAdm.logar("senha123"));
        Sessao sessao1 = userAdm.criarSessao();
        //mostra os logs
        System.out.println("Log de Auditoria mais recente(do usuario):");
        System.out.println(userAdm.getLogs().get(0).toString());
        System.out.println("horario: " + userAdm.getHora());
        //a sessão criada
        System.out.println("Sessão criada:\n");
        System.out.println(sessao1.toString());
        //mostra o perfil do usuario
        System.out.println("Perfil do usuario:");
        System.out.println(userAdm.getPerfil().toString());
      
      
      
      
      
    }

}
