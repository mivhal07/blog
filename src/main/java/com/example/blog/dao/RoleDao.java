package com.example.blog.dao;

import com.example.blog.entities.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void createRole(Role role) {
        entityManager.persist(role);
    }

    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }

    public void update(Role role) {
        entityManager.merge(role);
    }

    public void delete(Role role) {
        entityManager.remove(entityManager.contains(role) ? role : entityManager.merge(role));
    }

    public Query getAdmins() {
        return entityManager.createQuery("select r from Role r where r.name='ROLE_ADMIN'");
    }

    public Query getUsers() {
        return entityManager.createQuery("select r from Role r where r.name='ROLE_USER'");
    }
}
