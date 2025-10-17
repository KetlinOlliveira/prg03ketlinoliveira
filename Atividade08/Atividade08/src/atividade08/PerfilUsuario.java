/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade08;
import java.util.List;

/**
 *
 * @author ketli
 */
public class PerfilUsuario {
    private Long id;
    private String descricao;
    private List<String> permissoes;
    
    //construtor de Perfil usuario
    public PerfilUsuario(Long id, String descricao, List<String> permissoes){
        this.id = id;
        this.descricao = descricao;
        this.permissoes = permissoes;
    }
    //getters e setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    } 
    public List<String> getpermissoes(){
        return permissoes;
    }
    public void setpermissoes(List<String> permissoes){
        this.permissoes = permissoes;
    }
    
    //toString para ver todos os valores e atributos do objeto
    @Override
     public String toString(){
      return "PerfilUsuario {"+ "id=" + id + ", descricao='"+ descricao +'\''+ ",permissoes="+ permissoes + '}';
     }
   
}
