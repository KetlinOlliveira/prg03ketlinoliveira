/*
 * Comentários automáticos do NetBeans.
 */
package br.com.ifba.curso.dao; // Define o pacote onde a classe está localizada (camada de Acesso a Dados).

// Importações do JPA (Jakarta Persistence API)
import br.com.ifba.curso.entity.Curso; // Importa a classe de Entidade (o objeto que representa a tabela no banco).
import jakarta.persistence.EntityManager; // Interface principal para interagir com o contexto de persistência.
import jakarta.persistence.EntityManagerFactory; // Usado para criar instâncias de EntityManager.
import jakarta.persistence.Persistence; // Classe utilitária para obter a EntityManagerFactory.
import java.util.List; // Importa a classe List para retornar coleções de objetos.

/**
 * Classe de Acesso a Dados (DAO) para a entidade Curso.
 * Contém a lógica de persistência (CRUD).
 * @author ketli
 */
public class CursoDAO {

    // 1. Inicialização do JPA
    // EntityManagerFactory é um recurso pesado e deve ser criado apenas uma vez (singleton).
    // O argumento "desafio-crud" deve corresponder ao 'persistence-unit' name no arquivo persistence.xml.
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafio-crud");

    // 2. Método Salvar (Inserir ou Atualizar)
    /**
     * Salva (persiste) um novo objeto Curso ou atualiza um existente.
     * @param curso O objeto Curso a ser salvo ou atualizado.
     */
    public void salvar(Curso curso){
        // Cria um novo EntityManager para a operação.
        EntityManager em = emf.createEntityManager();
        // Inicia uma transação de banco de dados.
        em.getTransaction().begin();

        try{
            // Lógica para decidir entre persistir (novo) ou atualizar (merge).
            if(curso.getId() == null){
                // Se o ID é nulo, é um novo registro.               
                em.persist(curso); // Linha CORRETA deveria ser: em.persist(curso);
            }else{
                // Se o ID existe, é uma atualização.          
                em.merge(curso); // Linha CORRETA deveria ser: em.merge(curso);
            }
            
            // Confirma (commit) a transação no banco de dados.
            em.getTransaction().commit();
        }catch(Exception e){
            // Em caso de erro, desfaz (rollback) a transação para evitar dados inconsistentes.
            em.getTransaction().rollback();
            // Imprime o rastreamento da pilha para debug.
            e.printStackTrace();

        }finally{
            // O EntityManager deve SEMPRE ser fechado para liberar recursos.
            em.close();
        }
    }
    
    public Curso atualizar(Curso curso){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Curso atualizado = em.merge(curso);
            em.getTransaction().commit();
            return atualizado;   
        }catch(RuntimeException e){
           if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }finally{
            em.close();
        }
    }
    
    public void remover(Long id){
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            Curso c = em.find(Curso.class, id);
            if(c == null){
                throw new IllegalArgumentException("Curso com id " + id + " não encontrado");
            }
            em.remove(c);
            em.getTransaction().commit();
        }catch(RuntimeException e){
             if (em.getTransaction().isActive()) em.getTransaction().rollback();
             throw e;
        }finally{
            em.close();
        }   
    }
    
    public Curso buscarId(Long id){
        EntityManager em = emf.createEntityManager();
        
        try{
            return em.find(Curso.class, id);
        }finally{
            em.close();   
        }
        
    }
    
    public List<Curso> buscarPorNome(String nome) {
    EntityManager em = emf.createEntityManager();
    try {
        return em.createQuery("SELECT c FROM Curso c WHERE LOWER(c.nome) LIKE LOWER(:nome)", Curso.class)
                 .setParameter("nome", "%" + nome + "%")
                 .getResultList();
    } finally {
        em.close();
    }
}


   
    public List<Curso> listarTodos(){
        // Cria um novo EntityManager para a operação de consulta.
        EntityManager em = emf.createEntityManager();

        // Executa uma consulta JPQL (Java Persistence Query Language).
        // "SELECT c FROM Curso c" seleciona todos os objetos da Entidade Curso.
        List<Curso> cursos = em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();

        // Fecha o EntityManager.
        em.close();
        // Retorna a lista de resultados.
        return cursos;
    }
}