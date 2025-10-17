/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade08;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author ketli
 */
public class Usuario {
    private Long id;
    private PerfilUsuario perfil;
    private String nomeUsuario;
    private String email;
    private String senha;
    private LocalDateTime ultimoLogin;
    private Boolean ativo;
    
    //cria uma lista para as sessoes
    private List<Sessao> sessoes;
    //faz o mesmo para os Logs
    private List<LogAuditoria> logsAuditoria;
    //constructor de Usuario
    public Usuario(Long id, PerfilUsuario perfil,String nomeUsuario, String email, String senha , Boolean ativo){
        this.ativo = ativo;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.id = id;
        this.perfil = perfil;       
        this.senha = senha;
        this.ativo = true;
        this.sessoes = new ArrayList<>();
        this.logsAuditoria = new ArrayList<>();  
    }
    //método para logar
    public Boolean logar(String senha){
        String acao;
        Boolean sucesso;
        //verifica se a senha é equivalente a senha da conta
        if(this.senha.equals(senha)){
            sucesso = true;
            this.ultimoLogin = LocalDateTime.now();
            acao = "Login bem-sucedido. Ultimo login atualizado";
        }else{
            sucesso = false;
            acao = "Falha ao fazer login(Senha incorreta)";
        }
       //cria um obj de LogAuditoria passando os valores obtidos
        LogAuditoria log = new LogAuditoria(null, this, acao, LocalDateTime.now(), "11111");
        
        this.logsAuditoria.add(log);//adiciona o novo log
        return sucesso;
    }
    
    //método para criar a sessão
    public Sessao criarSessao(){
        String tokenGerado = UUID.randomUUID().toString();//gera o token aleatorio
        
        Sessao novaSessao = new Sessao(null, this, tokenGerado);//cria um novo obj
        
        this.sessoes.add(novaSessao);//adioiona em novaSessao
        return novaSessao;
    }
 //getters e setters
    public void adicionarLog(LogAuditoria log){
        this.logsAuditoria.add(log);
    }
    public void adicionarSessao(Sessao sessao){
        this.sessoes.add(sessao);
    }
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public PerfilUsuario getPerfil(){
        return perfil;
    }
    public void setPerfil(PerfilUsuario perfil){
        this.perfil = perfil;
    }
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public Boolean getAtivo(){
        return ativo;
    }
    public void setAtivo(Boolean ativo){
        this.ativo = ativo;
    }
    
    public List<Sessao> getSessoes(){
        return sessoes;
    }
    public void setSessoes(List<Sessao> sessoes){
        this.sessoes = sessoes;
    }
    
    public List<LogAuditoria> getLogs(){
        return logsAuditoria;
    }
    public void setLogs(List<LogAuditoria> logsAuditoria){
        this.logsAuditoria = logsAuditoria;
    }
    public LocalDateTime getHora(){
        return ultimoLogin;
    }
    
     //toString para obter todos os valores e atributos importados do obj
    @Override
    public String toString(){
        return "Usuario {" + "id=" + id + ", perfil=" + perfil + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ",ativo=" +ativo+ '}';
    }
    
   
    
}
