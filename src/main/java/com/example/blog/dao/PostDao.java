package com.example.blog.dao;

import com.example.blog.entities.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
@Transactional
public class PostDao {
    @PersistenceContext
    EntityManager entityManager;

    public void createPost(Post post) {
        entityManager.persist(post);
    }

    public Post findByDate(LocalDateTime created) {
        return entityManager.find(Post.class, created);
    }

    public Post findByCreator(String creator) {
        return entityManager.find(Post.class, creator);
    }

    public void update(Post post) {
        entityManager.merge(post);
    }

    public void delete(Post post) {
        entityManager.remove(entityManager.contains(post) ? post : entityManager.merge(post));
    }

    public Query getLastFive(){
        return entityManager.createQuery("select p from Post p").setMaxResults(5);
    }
}
