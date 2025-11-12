/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;


import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;

import java.util.List;

/**
 *
 * @author ketli
 */
@SuppressWarnings("unchecked")
public class GenericDao <Entity extends PersistenceEntity> implements GenericIDao<Entity> {
    // Classe genérica que lida com qualquer entidade (Entity) que herde de PersistenceEntity (que tem o ID).
    // Implementa GenericIDao, garantindo os métodos CRUD.
    private static EntityManagerFactory factory;
    protected EntityManager entityManager;
    
    static{
    try {
        factory = Persistence.createEntityManagerFactory("poo_dao");
    } catch (Exception e) {
        // Imprime o erro no console para que você possa ver a causa real
        System.err.println("ERRO FATAL NA INICIALIZAÇÃO DO JPA. A tela não aparecerá.");
        e.printStackTrace();
        
        // Relança o erro para interromper a execução.
        throw new RuntimeException("Falha ao inicializar o JPA. Verifique o persistence.xml e dependências.", e);
    }
}
    public GenericDao(){
        this.entityManager = factory.createEntityManager();// Cria um novo EntityManager (conexão de sessão) para cada instância do DAO.
    }
    
    @Override
    public Entity save(Entity entity){
        try{
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
        }catch(Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao salvar" + e.getMessage(), e);
        }
    }
    
    @Override
    public Entity update(Entity entity){
        try{
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
        }catch(Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao fazer update" + e.getMessage(), e);       
        }
    }
    @Override
    public void delete(Entity entity){
        
        try{
        entity = findById(entity.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        }catch(Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();              
            }
            throw new RuntimeException("Erro ao deletar" + e.getMessage(), e);           
        }
    }
    
    @Override
    public List<Entity> findAll(){
        return entityManager.createQuery(("from " + getTypeClass().getName())).getResultList();       
    }
    
    @Override
    public Entity findById(Long id){
        return (Entity) entityManager.find(getTypeClass(), id);
    }
    
    protected Class<Entity> getTypeClass(){
      return (Class<Entity>) ((ParameterizedType) getClass()
              .getGenericSuperclass())
              .getActualTypeArguments()[0];
    }
}