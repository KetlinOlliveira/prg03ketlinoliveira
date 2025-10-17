/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade08;
import java.time.LocalDateTime;

/**
 *
 * @author ketli
 */
public class LogAuditoria {
    private Long id;
    private Usuario usuario;
    private String acao;
    private LocalDateTime dataHora;
    private String ip;
    //construtor da classe LogAuditoria
    public LogAuditoria(Long id, Usuario usuario, String acao,LocalDateTime dataHora, String ip){
        this.id = id;
        this.usuario = usuario;
        this.acao = acao;
        this.dataHora = dataHora;
        this.ip = ip;
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
    public String getAcao(){
        return acao;
    }
    public void setAcao(String acao){
        this.acao = acao;
    }
    public String getIp(){
        return ip;
    }
    public void setIp(String ip){
        this.ip = ip;
    }
    
    //tostring para recolher todas as informações
    @Override
    public String toString(){
        return "LogAuditoria {" + "id=" + id + ", usuario=" + usuario + ", acao=" + acao + ", ip=" + ip + '}';
    }
}

