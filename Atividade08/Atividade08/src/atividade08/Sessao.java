/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade08;

/**
 *
 * @author ketli
 */
public class Sessao {
    private Long id;
    private Usuario usuario;
    private String token;
 
    //construtor de Sessao
    public Sessao(Long id, Usuario usuario, String token){
        this.id = id;
        this.token = token;
        this.usuario = usuario;
    } 
    //getters e setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }
    
    //toString para obter todos os valores e atributos importados do obj
   @Override
    public String toString(){
        return"Sessao {" + "id=" + id + ", token=" + token + ", usuario=" +usuario+ '}';
        
    }
}
