package com.intetm.db.dao;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

public abstract class AbstractDao<Entity, ID> {
    private final Class entryClass;

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public AbstractDao(Class entryClass) {
        this.entryClass = entryClass;
    }

    public void persist(Entity entity) {
        entityManager.persist(entity);
    }

    public void merge(Entity entity) {
        entityManager.merge(entity);
    }

    public void delete(Entity entity) {
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    public CriteriaQuery<Entity> createCriteriaQuery() {
        return this.getCriteriaBuilder().createQuery(entryClass);
    }


    @SuppressWarnings("unchecked")
    public Entity find(ID id) {
        return (Entity) entityManager.find(entryClass, id);
    }

    public List<Entity> find(CriteriaQuery<Entity> criteriaQuery) {
        TypedQuery<Entity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Entity> find(Object... keysAndValues) {
        CriteriaBuilder criteriaBuilder = this.getCriteriaBuilder();
        CriteriaQuery<Entity> criteriaQuery = this.createCriteriaQuery();
        Root root = criteriaQuery.from(entryClass);
        fillQuery(criteriaQuery, keysAndValues, root, criteriaBuilder);
        return find(criteriaQuery);
    }


    public List<Entity> find(Map<String, Object> parameters) {
        Object[] array = toArray(parameters);
        return find(array);
    }

    @SuppressWarnings("unchecked")
    public long count(Object... keysAndValues) {
        CriteriaBuilder criteriaBuilder = this.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Entity> root = criteriaQuery.from(entryClass);
        criteriaQuery.select(criteriaBuilder.count(root));
        fillQuery(criteriaQuery, keysAndValues, root, criteriaBuilder);
        return getEntityManager().createQuery(criteriaQuery).getSingleResult();
    }

    public long count(Map<String, Object> parameters) {
        Object[] array = toArray(parameters);
        return count(array);
    }

    private void fillQuery(CriteriaQuery criteriaQuery, Object[] keysAndValues, Root root, CriteriaBuilder criteriaBuilder) {
        if (keysAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Expected even count argument, receive odd");
        }
        for (int i = 0; i < keysAndValues.length; i += 2) {
            Path parameterPath = root.get((String) keysAndValues[i]);
            Object parameterValue = keysAndValues[i + 1];
            criteriaQuery.where(criteriaBuilder.equal(parameterPath, parameterValue));
        }
    }

    private Object[] toArray(Map<String, Object> parameters) {
        Object[] array = new Object[parameters.size() * 2];
        int i = 0;
        for (Map.Entry<String, Object> parameter : parameters.entrySet()) {
            array[i] = parameter.getKey();
            i++;
            array[i] = parameter.getValue();
            i++;
        }
        return array;
    }


    public List<Entity> selectAll() {
        CriteriaQuery<Entity> criteriaQuery = createCriteriaQuery();
        criteriaQuery.from(entryClass);
        return find(criteriaQuery);
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Object getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return this.entityManager.getCriteriaBuilder();
    }
}
