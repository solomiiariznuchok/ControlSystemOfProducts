package com.softserveinc.trainee.dao.Impl;

import com.softserveinc.trainee.dao.EntityDao;
import com.softserveinc.trainee.entity.Entity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("entityDao")
public class EntityDaoImpl implements EntityDao{

    @PersistenceContext
    private EntityManager entityManager;

    public Entity getEntity(String id) {
        return entityManager.find(Entity.class, id);
    }

    @Override
    public Entity addEntity(Entity entity) {
        entityManager.persist(entity);
        return entityManager.find(Entity.class, entity.getId());
    }

    @Override
    public Entity updateEntity(Entity entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void deleteEntity(String id) {
        Entity entity = entityManager.find(Entity.class, id);
        if(entity != null){
            entityManager.remove(entity);
        }
    }
}
